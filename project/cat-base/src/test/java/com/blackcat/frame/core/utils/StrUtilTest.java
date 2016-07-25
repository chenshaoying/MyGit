package com.blackcat.frame.core.utils;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

import javax.xml.stream.XMLStreamException;

import org.junit.Test;

import com.google.common.base.CharMatcher;
public class StrUtilTest {
	@Test
	public void l_padTest() {
		String msg = "1111我日";
		System.out.println(StrUtil.l_pad(msg, '我', 20));	
	}
	
	@Test
	public void overrideTest() {
		
	}
	
	@Test
	public void l_padfixed() {
		String msg = "我日";
		System.out.println(StrUtil.l_pad_fixed_byte(msg, '1', 21, "UTF-8"));	

	}
	
	public <T> void testGeneric(T t) {
		
	}
	
	volatile int count = 0;
	
	public static void main(String[] args) {
		//(new StrUtilTest()).testThread();
		System.out.println(1/10 + "");
	}
	public void testThread() {
		
		Thread a = new Thread(new Runnable() {
			@Override
			public void run() {
				count++;
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					print( 1);			
			}
		});
		
		Thread b = new Thread(new Runnable() {
			@Override
			public void run() {
				count++;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("111111");
				print( 2);	
			}
		});
		a.start();
		b.start();
	}
	
	private  void print(int i) {
		
		System.out.println(Thread.currentThread().getName() + ":" + i + ":" + (count));			
	}
	@Test
	public void replaceTest() {
		String ss = "'status'";
		String s1 = ss.replaceAll("'", "\"");
		String s2 = ss.replaceAll("'", "\\\\'");
		System.out.println(ss);
		System.out.println(s1);
		System.out.println(s2);

	}
	
	@Test
	public void testCountAndSay() {
		System.out.println(countAndSay(2));
	}
	
	 public String countAndSay(int n) {
        if(n == 1) {
            return "1";
        }
        String pre = countAndSay(n-1);
        StringBuffer sb = new StringBuffer();
        int i=1;
        int count=0;
        if(pre.length() > 0) {
            
            char c = pre.charAt(0);
            
            while(i<pre.length()) {
                if(c == pre.charAt(i)) {
                    count++;
                } else {
                    sb.append(count).append(c);
                    c=pre.charAt(i);
                    count=0;
                }
                i++;
            }
            return sb.toString();
        } else {
            return "";
        }
    }
	 
	@Test
	public void test5() {
		String ss = "00000181<?xml version=\"1.0\" encoding=\"utf-8\"?><Envelope><Header><ProcessCode>0001</ProcessCode></Header><Body><EntityType>TOKEN_PAN</EntityType><Value>00000001</Value></Body></Envelope>";
		byte[] b = null;
		try {
			b = ss.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(b.length);
	}
	
	@Test
	public void test2() {
		String s = "ss";
		s = s + "11";
		append(s);
		System.out.println(s);
		
		StringBuffer sb = new StringBuffer();
		sb.append("1");
		append(sb);
		System.out.println(sb.toString());

		int i = 0;
		incr(i);
		System.out.println(i);
	}
	
	private void append(String s) {
		s = s + "sss";
	}
	
	private void append(StringBuffer s) {
		s.append("1111");
	}
	
	private void incr(int i) {
		i++;
	}
	
	
	@Test
	public void testxx() throws IOException {
		//File file = new File("XIB-HB-PBOCMP20160406_000105100.dp");
		InputStream in = null;
		in = new FileInputStream(StrUtilTest.class.getResource("/").getPath() + "XIB-HB-PBOCMP20160406_000105100.dp");
		
		byte[] tempbytes = new byte[100];
        int byteread = 0;
    
        // 读入多个字节到字节数组中，byteread为一次读入的字节数
        StringBuffer sb = new StringBuffer();
        while ((byteread = in.read(tempbytes)) != -1) {
            sb.append(ICUtil.hex2bcd(tempbytes));
        }
        System.out.println(sb.length());
        System.out.println(sb);
	}
	
	@Test
	public void testxx1() throws IOException {
		String str = "0111111111111111";
		
		//System.out.println("1111111111111111".getBytes().length);
		byte[] b = ICUtil.bcd2hex(str);
		
		System.out.println(ICUtil.bcd2hex(str).length);
	}
	
	@Test
	public void testx() {
		int start = 1;
		int end = Integer.MAX_VALUE;
        int mid1 = start + (end - start)/2;
        int mid2 = (end + start)/2;
        System.out.println(mid1 + ":" + mid2);
	}
	
	@Test
	public void testx2() {
		System.out.println(Math.pow(10, 5));
        System.out.println('1' - 48);
        System.out.println('0');
        System.out.println((char)('1' + '0'));
        System.out.println((char)('1' + '0' + '1' + - 96 ));
        System.out.println((char)(97));
        System.out.println((char)(1));

	}
	
	@Test
	public void isValidParentheses() {
		String s1 = "";
		String s2 = "(44)(4444)()";
		String s3 = "{[()]}";
		String s4 = "{[}]";
		String s5 = "][]";
		System.out.println(StrUtil.isValidParentheses(s1));
		System.out.println(StrUtil.isValidParentheses(s2));
		System.out.println(StrUtil.isValidParentheses(s3));
		System.out.println(StrUtil.isValidParentheses(s4));
		System.out.println(StrUtil.isValidParentheses(s5));

	}
	
	@Test
	public void binaryAdd() {
		String s1 = "1010";
		String s2 = "1011";
		System.out.println(StrUtil.binaryAdd(s1, s2));
	}
	@Test
	public void convertDateTest() {
		String s1 = "1999-12-10+8:00";
		String s2 = "19991210";
		System.out.println(convertDate(s1));
		System.out.println(convertDate(s2));
		

	}
	
	//yyyy-MM-dd+8:00 转yyyyMMdd
	private String convertDate(String cupDate) {
		if(StrUtil.isEmptyTrim(cupDate) || cupDate.length() < 10) {
			return cupDate;
		}
		String str = cupDate.substring(0,10);
		String newDate = str.replaceAll("-", "");
		return newDate;
	}
	@Test
	public void tt() throws XMLStreamException {
		String streamEncoding = "UTF-8";
		String encoding = "utf-8";
		if ((streamEncoding != null) && (!streamEncoding.equalsIgnoreCase(encoding)))
	      {
	        boolean foundAlias = false;
	        Set aliases = Charset.forName(encoding).aliases();
	        for (Iterator it = aliases.iterator(); (!foundAlias) && (it.hasNext()); ) {
	          if (streamEncoding.equalsIgnoreCase((String)it.next())) {
	            foundAlias = true;
	          }
	        }

	        if (!foundAlias) {
	          throw new XMLStreamException("Underlying stream encoding '" + streamEncoding + "' and input paramter for writeStartDocument() method '" + encoding + "' do not match.");
	        }

	      }
	}
	
	@Test
	public void tt1() {
		System.out.println(1 << 30);
		System.out.println(Math.pow(2, 30));
		System.out.println(2 << 1);
	}
	
	
	@Test
	public void testRemoveWhiteSpace() {
		String tabsAndSpaces = "String with spaces and  	tabs";
		String expected = "String with spaces and tabs";
		String scrubbed = CharMatcher.WHITESPACE.collapseFrom(tabsAndSpaces, ' ');
		assertEquals(expected, scrubbed);
	}
	
	@Test
	public void test111() {
		String sl = " ";
		System.out.println("".equals(sl.trim()) ? 0 : Integer.parseInt(sl));
		//Integer.parseInt(" ");
	}
 }
