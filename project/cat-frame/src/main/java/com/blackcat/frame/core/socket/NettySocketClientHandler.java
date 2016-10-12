package com.blackcat.frame.core.socket;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.CharsetUtil;

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
    	ctx.write(Unpooled.copiedBuffer(str, CharsetUtil.UTF_8));
    	ctx.flush();
    	
    }
}