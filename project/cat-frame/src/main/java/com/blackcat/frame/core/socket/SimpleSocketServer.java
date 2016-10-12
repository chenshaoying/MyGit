package com.blackcat.frame.core.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SimpleSocketServer {
	private static Log log = LogFactory.getLog(SimpleSocketServer.class);
	private ServerSocket server;
	
	/*public SimpleSocketServer(int port) {
		server = new ServerSocket(port);
	}*/
	
	public SimpleSocketServer createServer(int port) throws IOException {
		log.info("SimpleSocketServer start at port:" + port);
		server = new ServerSocket(port);
		return this;
	}
	
	public void startServer() {
//		ServerSocket server = null;
		try {
//			server = new ServerSocket(port);
			Socket socket = null;
			while(server != null) {
				socket = server.accept();
				new Thread(new SimpleSocketHandler(socket)).start();
			}			
		} catch (Throwable t) {
			log.error("SimpleSocketServer error:" + t.getMessage());
			log.error("SimpleSocketServer is going to stop:");
		} finally {
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
	}
	
	public void stopServer() {
		log.info("SimpleSocketServer stop at port:" + server.getLocalPort());
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

