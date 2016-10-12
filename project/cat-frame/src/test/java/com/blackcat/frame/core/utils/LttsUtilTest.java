package com.blackcat.frame.core.utils;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.SocketTimeoutException;

import org.junit.Test;
public class LttsUtilTest {
	@Test
	public void test() {
		String str = "12345";
		InputStream in = new ByteArrayInputStream(str.getBytes());
		int i = readPkgLen(in);
		System.out.println(i);
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
