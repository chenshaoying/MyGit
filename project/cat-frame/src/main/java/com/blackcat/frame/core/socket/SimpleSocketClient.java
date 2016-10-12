package com.blackcat.frame.core.socket;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SimpleSocketClient {
	private static final String ENCODING = "UTF-8";
	private static final int HEAD_LEN = 8;

	private static Log log = LogFactory.getLog(SimpleSocketClient.class);

	private String address;
	private int port;
	public SimpleSocketClient(String address, int port) {
		this.address = address;
		this.port = port;
	}
	
	
	public byte[] send(String msg) throws IOException {
		Socket socket = null;
		InputStream is = null;
		OutputStream os = null;
		ByteArrayOutputStream bos = null;
		try {
			socket = new Socket(address,port);
			os = socket.getOutputStream();	
			os.write(SocketUtil.prepareMsg(msg, HEAD_LEN, ENCODING));
			os.flush();
			
			is = socket.getInputStream();
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
			log.info("receive from server:" + new String(bos.toByteArray(), ENCODING));
			return bos.toByteArray();		
		} finally {
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
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		String msg = "";
		SimpleSocketClient client = new SimpleSocketClient("127.0.0.1", 9999);
		client.send(msg);		
	}
	
	
}
