package com.blackcat.frame.core.socket;

import com.blackcat.frame.core.model.SysUser;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class NettyObjectSocketHandler extends ChannelHandlerAdapter { // (1)
	
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) { // (2)
    	SysUser user = (SysUser) msg;
        System.out.println(user.getUserid());		
        user.setEmail("7777@qq.com");
		ctx.writeAndFlush(user);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) { // (4)
        // Close the connection when an exception is raised.
        cause.printStackTrace();
        ctx.close();
    }
}