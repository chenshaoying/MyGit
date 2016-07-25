package com.blackcat.frame.core.socket;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

public class NettySocketServer {
	
	 private int port;

	    public NettySocketServer(int port) {
	        this.port = port;
	    }

	    public void run() throws Exception {
	        EventLoopGroup bossGroup = new NioEventLoopGroup(); // (1) 服务端接受客户端请求
	        EventLoopGroup workerGroup = new NioEventLoopGroup();   //进行SockeChannel的网络读写
	        try {
	            ServerBootstrap b = new ServerBootstrap(); // (2)
	            b.group(bossGroup, workerGroup)
	             .channel(NioServerSocketChannel.class) // (3)
	             .childHandler(new ChannelInitializer<SocketChannel>() { // (4)
	                 @Override
	                 public void initChannel(SocketChannel ch) throws Exception {
	                	 ch.pipeline().addLast(new LineBasedFrameDecoder(1024));
	                	 ch.pipeline().addLast(new StringDecoder());
	                     ch.pipeline().addLast(new NettySocketHandler());
	                 }
	             })
	             .option(ChannelOption.SO_BACKLOG, 128)          // 包含已通过的最大连接数，当超过128时，再次发起连接将被拒绝
	             .childOption(ChannelOption.SO_KEEPALIVE, true); // (6)

	            // Bind and start to accept incoming connections.
	            ChannelFuture f = b.bind(port).sync(); // (7)

	            // Wait until the server socket is closed.
	            // In this example, this does not happen, but you can do that to gracefully
	            // shut down your server.
	            f.channel().closeFuture().sync();
	        } finally {
	        	//优雅退出，释放线程池资源
	        	bossGroup.shutdownGracefully();
	            workerGroup.shutdownGracefully();
	        }
	    }

	    public static void main(String[] args) throws Exception {
	        int port;
	        if (args.length > 0) {
	            port = Integer.parseInt(args[0]);
	        } else {
	            port = 9999;
	        }
	        new NettySocketServer(port).run();
	    }
}
