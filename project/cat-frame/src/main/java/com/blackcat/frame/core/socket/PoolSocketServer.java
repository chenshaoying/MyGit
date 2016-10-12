package com.blackcat.frame.core.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PoolSocketServer {
	private static Log log = LogFactory.getLog(PoolSocketServer.class);
	private ServerSocket server;
	
	public PoolSocketServer createServer(int port) throws IOException {
		server = new ServerSocket(port);
		return this;
	}
	
	public void startServer(){
		try {
			SockePoolExecutor pool = new SockePoolExecutor(10,1000);			
			Socket socket = null;
			while(server != null) {
				socket = server.accept();
				pool.execute(new SimpleSocketHandler(socket));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(server != null) {
				try {
					server.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public void stopServer() {
		log.info("PoolSocketServer stop at port:" + server.getLocalPort());
		if( server != null) {
			try {
				server.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		server = null;
	}
	
	public static void main(String[] args) throws IOException {
		SimpleSocketServer server = new SimpleSocketServer().createServer(9999);
		server.startServer();
	}
}
