package com.blackcat.frame.core.socket;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.stream.ChunkedWriteHandler;
import io.netty.util.concurrent.GlobalEventExecutor;

public class WebSocketServer {

	private final int port;

	public WebSocketServer(int port) {
		this.port = port;
	}

	public void run() throws Exception {
		EventLoopGroup bossGroup = new NioEventLoopGroup(1);
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		ChannelGroup allChannels =
		         new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
		try {
			ServerBootstrap b = new ServerBootstrap();
			b.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
			.childHandler(new ChannelInitializer<SocketChannel>() { // (4)
                @Override
                public void initChannel(SocketChannel ch) throws Exception {
                	
               	 	ch.pipeline().addLast("http-codec", new HttpServerCodec());
               	 	ch.pipeline().addLast("aggregator", new HttpObjectAggregator(65536));
                    ch.pipeline().addLast("http-chunked", new ChunkedWriteHandler());
                    ch.pipeline().addLast("handler", new WebSocketServerHandler(allChannels));

                }
            });
			Channel ch = b.bind(port).sync().channel();
			allChannels.add(ch);
			System.out.println("Web socket server started at port " + port + '.');
			System.out.println("Open your browser and navigate to ws://localhost:" + port + '/');
			ch.closeFuture().sync();
		     // Close the serverChannel and then all accepted connections.
		} finally {
			allChannels.close().awaitUninterruptibly();
			bossGroup.shutdownGracefully();
			workerGroup.shutdownGracefully();
		}
	}
	
	public static void main(String[] args) throws Exception {
        int port;
        if (args.length > 0) {
            port = Integer.parseInt(args[0]);
        } else {
            port = 9998;
        }
        new WebSocketServer(port).run();
    }
	
}