package com.blackcat.frame.core.socket;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpHeaderUtil;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.handler.codec.http.websocketx.CloseWebSocketFrame;
import io.netty.handler.codec.http.websocketx.PingWebSocketFrame;
import io.netty.handler.codec.http.websocketx.PongWebSocketFrame;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker;
import io.netty.handler.codec.http.websocketx.WebSocketServerHandshakerFactory;
import io.netty.util.CharsetUtil;

public class WebSocketServerHandler extends SimpleChannelInboundHandler<Object> { 
	
	private static final Log log = LogFactory.getLog(WebSocketServerHandler.class);
	private WebSocketServerHandshaker handshaker;
	
	private ChannelGroup group;
	
	public WebSocketServerHandler(ChannelGroup group) {
		super();
		this.group = group;
	}
	
    @Override
    public void messageReceived(ChannelHandlerContext ctx, Object msg) throws Exception {
    	group.add(ctx.channel());

    	log.info("channel id:" + ctx.channel().id());
    	log.info("group size:" + group.size());
    	if(msg instanceof FullHttpRequest) {
    		handleHttpRequest(ctx, (FullHttpRequest) msg);
    	} else if(msg instanceof WebSocketFrame){
    		handleWebSocketFrame(ctx, (WebSocketFrame) msg);
    	}
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        // Close the connection when an exception is raised.
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
    	ctx.flush();
    }
	
    private void handleHttpRequest(ChannelHandlerContext ctx, FullHttpRequest req) throws Exception {
    	//如果http解码失败，返回http异常
    	if(req.decoderResult().isFailure() || (!"websocket".equals(req.headers().get("Upgrade")))) {
    		sendHttpResponse(ctx, req, new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.BAD_REQUEST));
    		return;
    	}
    	
    	//
    	WebSocketServerHandshakerFactory wsFactory = new WebSocketServerHandshakerFactory("ws://127.0.0.1:9998/text", null, false);
    	handshaker = wsFactory.newHandshaker(req);
    	if(handshaker == null) {
    		WebSocketServerHandshakerFactory.sendUnsupportedVersionResponse(ctx.channel());
    	} else {
    		handshaker.handshake(ctx.channel(), req);
    	}
    }
    
    private void handleWebSocketFrame(ChannelHandlerContext ctx, WebSocketFrame frame) throws Exception {
    	//判断是否是关闭链路指令
    	if(frame instanceof CloseWebSocketFrame) {
    		handshaker.close(ctx.channel(), (CloseWebSocketFrame) frame.retain());
    		return;
    	} 	
    	//判断是否是ping命令
    	if(frame instanceof PingWebSocketFrame) {
    		ctx.channel().write(new PongWebSocketFrame(frame.content().retain()));
    		return;
    	}
    	//
    	if(!(frame instanceof TextWebSocketFrame)) {
    		throw new UnsupportedOperationException(String.format("%s frame type not supported.", frame.getClass().getName()));
    	}
    	
    	String request = ((TextWebSocketFrame) frame).text();
    	
    	if(log.isInfoEnabled()) {
    		log.info("received message:" + request);
    	}
    	group.writeAndFlush(new TextWebSocketFrame(request));
    }
    
    private void sendHttpResponse(ChannelHandlerContext ctx, FullHttpRequest req, FullHttpResponse res) {
    	//返回应答给客户端
    	if(res.status().code() != 200) {
    		ByteBuf buf = Unpooled.copiedBuffer(res.status().code() + "", CharsetUtil.UTF_8);
    		res.content().writeBytes(buf);
    		buf.release();
    		HttpHeaderUtil.setContentLength(res, res.content().readableBytes());
    	}
    	
    	ChannelFuture f = ctx.channel().writeAndFlush(res);
    	if(!isKeepAlive(req) || res.status().code() != 200) {
    		f.addListener(ChannelFutureListener.CLOSE);
    	}
    }
    
    //
    private static boolean isKeepAlive(FullHttpRequest req) {
		return HttpHeaderUtil.isKeepAlive(req);
	}
        
}