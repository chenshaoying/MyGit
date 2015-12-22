package com.blackcat.frame.core.socket;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class NettySocketHandler extends ChannelHandlerAdapter { // (1)
	private static int count;
	
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) { // (2)
        String bb = (String) msg;
       
        count++;
		System.out.println(bb + ":" +count);
		String ret = "我也是" + count + "\n";
		ByteBuf b = Unpooled.copiedBuffer(ret.getBytes());
		ctx.writeAndFlush(b);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) { // (4)
        // Close the connection when an exception is raised.
        cause.printStackTrace();
        ctx.close();
    }
}