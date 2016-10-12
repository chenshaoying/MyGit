package com.blackcat.frame.core.socket;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.CharsetUtil;

public class NettyLengthSocketClientHandler extends ChannelHandlerAdapter { // (1)
	
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) { // (2)
    	ByteBuf msg0 = (ByteBuf) msg;
    	
        System.out.println(msg0.readInt());		
        System.out.println(msg0.toString(CharsetUtil.UTF_8));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) { // (4)
        // Close the connection when an exception is raised.
        cause.printStackTrace();
        ctx.close();
    }
    
    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        String str = "日了狗111111111";
    	ctx.write(Unpooled.copiedBuffer(str, CharsetUtil.UTF_8));
    	ctx.flush();
    }
}