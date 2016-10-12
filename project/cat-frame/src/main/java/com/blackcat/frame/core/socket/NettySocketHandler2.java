package com.blackcat.frame.core.socket;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class NettySocketHandler2 extends ChannelHandlerAdapter { // (1)
	private ExecutorService executor = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(),
			128,120L,TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(1024)); 
			
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) { // (2)
        
		executor.submit(new Runnable(){

			@Override
			public void run() {
				String bb = (String) msg;			       
				System.out.println(bb + ":" );
				String ret = "我也是"  + "\n";
				//Unpooled.copiedBuffer(ret.getBytes());
				//ctx.write(Unpooled.copiedBuffer(ret.getBytes()));
				/*try {
					TimeUnit.MILLISECONDS.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
				ctx.writeAndFlush(ret).addListener(ChannelFutureListener.CLOSE);				
			}			
		});
    }

	
    
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) { // (4)
        // Close the connection when an exception is raised.
        cause.printStackTrace();
        ctx.close();
    }
}