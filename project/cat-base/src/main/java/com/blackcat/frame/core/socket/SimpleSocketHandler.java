package com.blackcat.frame.core.socket;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

class SimpleSocketHandler implements Runnable {
	private static Log log = LogFactory.getLog(SimpleSocketHandler.class);
	private static final String ENCODING = "UTF-8";
	private static final int HEAD_LEN = 8;

	private Socket socket;
	
	public SimpleSocketHandler(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		InputStream is = null; //用于接收client 字节
		OutputStream os = null;//用于向客户端返回数据
		ByteArrayOutputStream bos = null;
		try {
			is = socket.getInputStream();
			os = socket.getOutputStream();
			
			//
			byte[] head = new byte[HEAD_LEN];
			is.read(head);
			int body_len = Integer.valueOf(new String(head,ENCODING));
			
			bos = new ByteArrayOutputStream();
			int count = 0;
			int i = 0;
			byte[] body = new byte[1024];
			while(i != -1) {
				i = is.read(body);
				count+=i;
				bos.write(body,0, i);
				if(count >= body_len) {
					break;
				}
			}
			bos.flush();
			String inputs = new String(bos.toByteArray(),ENCODING);
			log.info("Received from client:" + inputs);			
			String outputs = "接收完毕";
			os.write(SocketUtil.prepareMsg(outputs, HEAD_LEN, ENCODING));
			os.flush();
		} catch (Throwable t) {
			log.error("SimpleSockeHandler error:" + t.getMessage());
		} finally {
			log.info("SimpleSockeHandler closed");

			if(is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}					
			}
			
			if(os != null) {
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}					
			}
			if(bos != null) {
				try {
					bos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			socket = null;
		}
	}
}
