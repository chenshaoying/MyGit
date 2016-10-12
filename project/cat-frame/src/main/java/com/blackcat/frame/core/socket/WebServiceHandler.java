package com.blackcat.frame.core.socket;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.DefaultHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpHeaderUtil;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.util.CharsetUtil;

public class WebServiceHandler extends SimpleChannelInboundHandler<FullHttpRequest> {

	@Override
	protected void messageReceived(ChannelHandlerContext ctx, FullHttpRequest msg) throws Exception {
		// TODO Auto-generated method stub
		if(msg.decoderResult().isFailure()) {
			DefaultHttpResponse res = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.BAD_REQUEST);
			ctx.writeAndFlush(res);
			return;
		} 
		System.out.println("--------------" + msg.content().toString(CharsetUtil.UTF_8));
		System.out.println("--------------------1");
		FullHttpResponse res = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.ACCEPTED);
		String str = "fuck";
		ByteBuf buf = Unpooled.copiedBuffer(str, CharsetUtil.UTF_8);
		res.content().writeBytes(buf);
		buf.release();
	
		res.headers().set("Content-Type", "application/soap+xml;charset=UTF-8");
		res.headers().setInt("Content-Length",
				res.content().readableBytes());
		res.headers().set("Connection", "Keep-Alive");  
	        
		
		ctx.writeAndFlush(res).addListener(ChannelFutureListener.CLOSE);
	//	ctx.channel().writeAndFlush(res).addListener(ChannelFutureListener.CLOSE);


		 /*String res = "I am OK";
         FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1,
        		 HttpResponseStatus.OK, Unpooled.wrappedBuffer(res.getBytes("UTF-8")));
         response.headers().set("CONTENT_TYPE", "application/soap+xml;charset=UTF-8");
         response.headers().setInt("CONTENT_LENGTH",
                 response.content().readableBytes());
         if (HttpHeaders.isKeepAlive(request)) {
             response.headers().set(CONNECTION, Values.KEEP_ALIVE);
         }
         ctx.write(response);
         ctx.flush();*/
	} 
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		// TODO Auto-generated method stub
		super.exceptionCaught(ctx, cause);
	}
	
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		// TODO Auto-generated method stub
		super.channelActive(ctx);
	}
}