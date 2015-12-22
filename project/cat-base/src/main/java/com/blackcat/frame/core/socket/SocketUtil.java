package com.blackcat.frame.core.socket;

import java.io.UnsupportedEncodingException;

import com.blackcat.frame.core.utils.StrUtil;

public class SocketUtil {
	
	public static byte[] prepareMsg(String msg, int HEAD_LEN, String ENCODING) throws UnsupportedEncodingException {
		byte[] b = msg.getBytes(ENCODING);			
		String head = StrUtil.l_pad(b.length + "", '0', HEAD_LEN);
		byte[] h = head.getBytes(ENCODING);		
		byte[] ret = new byte[HEAD_LEN + b.length];
		System.arraycopy(h, 0, ret, 0, HEAD_LEN);
		System.arraycopy(b, 0, ret, HEAD_LEN, b.length);
		return ret;
	}
}
