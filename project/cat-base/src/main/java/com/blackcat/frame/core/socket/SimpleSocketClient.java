package com.blackcat.frame.core.socket;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.blackcat.frame.core.utils.StrUtil;

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
			os.write(prepareMsg(msg));
			os.flush();
			
			is = socket.getInputStream();
			byte[] r = new byte[1024];
			bos = new ByteArrayOutputStream();
			while((is.read(r)) != -1) {
				bos.write(r);
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
		String msg = "我日了狗了";
		SimpleSocketClient client = new SimpleSocketClient("127.0.0.1", 9999);
		client.send(msg);
		
	}
	
	private byte[] prepareMsg(String msg) throws UnsupportedEncodingException {
		byte[] b = msg.getBytes(ENCODING);			
		String head = StrUtil.l_pad(b.length + "", '0', HEAD_LEN);
		byte[] h = head.getBytes(ENCODING);
		
		byte[] ret = new byte[HEAD_LEN + b.length];
		System.arraycopy(h, 0, ret, 0, HEAD_LEN);
		System.arraycopy(b, 0, ret, HEAD_LEN, b.length);
		return ret;
	}
	
}
