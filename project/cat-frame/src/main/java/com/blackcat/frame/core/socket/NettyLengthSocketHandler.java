package com.blackcat.frame.core.socket;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.CharsetUtil;

public class NettyLengthSocketHandler extends ChannelHandlerAdapter { // (1)
	private ExecutorService executor = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(),
			128,120L,TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(1024)); 
			
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) { // (2)
		//System.out.println( (String) msg);
    	/*ByteBuf b = (ByteBuf) msg;
    	System.out.print(b.readableBytes());
    	byte[] bs = new byte[8];
		b.getBytes(0, bs);
		ctx.writeAndFlush("wori".getBytes()).addListener(ChannelFutureListener.CLOSE);	*/		
		/*byte[] bs = new byte[8];
		b.getBytes(0, bs);
		System.out.println()
		System.out.println(new String(bs));*/
		//System.out.println(b.readableBytes());
    	//System.out.println(b.getLong(1));
		/*executor.submit(new Runnable(){

			@Override
			public void run() {
				String bb = (String) msg;			       
				System.out.println(bb + ":" );
				String ret = "我也是"  + "\n";
				ctx.writeAndFlush(ret).addListener(ChannelFutureListener.CLOSE);				
			}			
		});*/
    	ByteBuf msg0 = (ByteBuf) msg;
    //	System.out.println(msg0.readInt());
    	byte[] b = new byte[4];
    	msg0.readBytes(b);
    //	System.out.println(msg0.toString(CharsetUtil.UTF_8));
    	System.out.println(new String(b));
    	ctx.channel().eventLoop().execute(new Runnable() {

			@Override
			public void run() {
				ctx.writeAndFlush(Unpooled.copiedBuffer("fuck you", CharsetUtil.UTF_8)).addListener(ChannelFutureListener.CLOSE);		
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