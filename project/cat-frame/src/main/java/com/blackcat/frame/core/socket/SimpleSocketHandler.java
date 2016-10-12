package com.blackcat.frame.core.socket;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

class SimpleSocketHandler implements Runnable {
	private static Log log = LogFactory.getLog(SimpleSocketHandler.class);
	private static final String ENCODING = "UTF-8";
	private static final int HEAD_LEN = 8;

	private Socket socket;
	
	public SimpleSocketHandler(Socket socket) throws SocketException {
		this.socket = socket;
		socket.setSoTimeout(10000);

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
			/*byte[] head = new byte[HEAD_LEN];
			is.read(head);
			int body_len = Integer.valueOf(new String(head,ENCODING));*/
			int body_len = readPkgLen(is);
			System.out.println("----" + body_len);
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
			String outputs = "XXXX";
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
	
	/**
     * 读取6字节的包长度.
     * 包长度为整数的字符串，右对齐前补0
     * 
     * @param in
     * @return
     */
    public static int readPkgLen(InputStream in) {
        int len2read = 0;
        int flag = -1; 	//计算器用来标识是否为空
        byte[] buf = new byte[6];
        try {
            //read len
            len2read = buf.length;
            while (len2read > 0) {
                int rc = in.read(buf, buf.length - len2read, len2read);
                if (rc != -1 && rc < len2read){
                	return -1; //报文长度少于报文制定长度
                }
                flag ++;
                if(flag ==0 &&rc == -1)
                	 return 0; //接收到空报文
                else {	
                	len2read -= rc;
                }
            }
            String slen = new String(buf, "UTF-8");
            return Integer.parseInt(slen.trim());
        } catch (NumberFormatException e) {
            throw new RuntimeException("读取LTTS包长度失败,非法数字字符,buf=" + new String(buf) + ",len2read=" + len2read, e);
        } catch (SocketTimeoutException e) {
            throw new RuntimeException("读取LTTS包长度超时,len2read=" + len2read, e);
        } catch (Throwable e) {
            throw new RuntimeException("读取LTTS包长度失败,buf=" + new String(buf) + ",len2read=" + len2read, e);
        }
    }
}
