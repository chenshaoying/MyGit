package com.blackcat.frame.core.socket;

import java.io.UnsupportedEncodingException;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class NettySocketClientHandler extends ChannelHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        String m = (String) msg; // (1)
        System.out.println(m);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
    
    @Override
    public void channelActive(ChannelHandlerContext ctx) {
    	String str = "日了狗\n";
    	ByteBuf msg = null;
    	byte[] req = null;
		try {
			req = str.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
    	for(int i=0; i<10; i++) {
    		msg = Unpooled.buffer(req.length);
    		msg.writeBytes(req);
    		ctx.write(msg);
    	}
    	ctx.flush();
    	
    }
}