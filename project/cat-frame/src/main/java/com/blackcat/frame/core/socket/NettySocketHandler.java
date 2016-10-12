package com.blackcat.frame.core.socket;

import java.util.concurrent.TimeUnit;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class NettySocketHandler extends ChannelHandlerAdapter { // (1)
	
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) { // (2)
        String bb = (String) msg;
       
		System.out.println(bb + ":" );
		String ret = "我也是"  + "\n";
		//Unpooled.copiedBuffer(ret.getBytes());
		//ctx.write(Unpooled.copiedBuffer(ret.getBytes()));
		try {
			TimeUnit.MILLISECONDS.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ctx.write(ret);
    }

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		//返回数据后，关闭channel
		ctx.writeAndFlush(Unpooled.EMPTY_BUFFER).addListener(ChannelFutureListener.CLOSE);
	};
    
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) { // (4)
        // Close the connection when an exception is raised.
        cause.printStackTrace();
        ctx.close();
    }
}