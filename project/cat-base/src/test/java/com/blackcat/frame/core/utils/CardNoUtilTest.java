package com.blackcat.frame.core.utils;

import java.io.File;
import java.io.FileWriter;

import org.junit.Test;

public class CardNoUtilTest {
	
	@Test
	public void test1() throws Throwable {
		File file = new File("C:\\Users\\darren\\Desktop\\廊坊\\cardno1.txt");
		FileWriter wr = new FileWriter(file);
		int total = 10000;
		int count = 0;		
		StringBuilder sb = new StringBuilder();
		while(count < total) {
			count++;
			String cardno = "6230731" + StrUtil.l_pad(count+"", '0', 9);
			sb.append(cardno + CardNoUtil.calVerfNo(cardno)).append("\r\n");
			if(count % 500 ==0 ) {
				wr.write(sb.toString());
				sb.setLength(0);
			}
		}
		wr.write(sb.toString());
		wr.close();
	}
	
	@Test
	public void test2() throws Throwable {
		File file = new File("C:\\Users\\darren\\Desktop\\廊坊\\id.txt");
		FileWriter wr = new FileWriter(file);
			
		String[] dates = {"19900101","19900102","19900103","19900104","19900105","19900106","19900107",
				"19900108","19900109","19900110","19900110"};
		for(String d:dates) {
			StringBuilder sb = new StringBuilder();
			int count = 1;	
			while(count < 1000) {
				String cardno = "131001" + d + StrUtil.l_pad(count+"", '0', 3);
				sb.append(cardno + genId(cardno)).append("\r\n");
				count++;
			}
			wr.write(sb.toString());
		}
		wr.close();
	}
	
	/**
	 * 身份证验证规则： 第十八位数字（校验码）的计算方法为： 
	 * 1.将前面的身份证号码17位数分别乘以不同的系数。从第一位到第十七位的系数分别为：7 9 10 5 8 4 2 1 6 3 7 9 10 5 8 4 2
	 * 2.将这17位数字和系数相乘的结果相加。 
	 * 3.用加出来和除以11，看余数是多少？
	 * 4.余数只可能有0 1 2 3 4 5 6 7 8 9 10这11个数字。其分别对应的最后一位身份证的号码为1 0 X 9 8 7 6 5 4 3 2。
	 * 5.通过上面得知如果余数是2，就会在身份证的第18位数字上出现罗马数字的Ⅹ。如果余数是10，身份证的最后一位号码就是2。
	 * 
	 */
	public String genId(String cardNo) {
		//String cardNo = "360481197512040035"; // 36900119751204003X // 360481197512040035
		// 1.将身份证号码前面的17位数分别乘以不同的系数。从第一位到第十七位的系数分别为：7 9 10 5 8 4 2 1 6 3 7 9 10 5 8 4 2
		int[] intArr = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 };
		int sum = 0;
		for (int i = 0; i < intArr.length; i++) {
			// 2.将这17位数字和系数相乘的结果相加。
			sum += Character.digit(cardNo.charAt(i), 10) * intArr[i];
			// System.out.println((cardNo.charAt(i) - '0') + " x " + intArr[i] + " = " + (cardNo.charAt(i) - '0') *
			// intArr[i]);
		}
		//System.out.println("Totally sum：" + sum);
		// 3.用加出来和除以11，看余数是多少？
		int mod = sum % 11;
		//System.out.println("Totally sum%11 = " + mod);
		// 4.余数只可能有0 1 2 3 4 5 6 7 8 9 10这11个数字。其分别对应的最后一位身份证的号码为1 0 X 9 8 7 6 5 4 3 2。
		int[] intArr2 = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int[] intArr3 = { 1, 0, 'X', 9, 8, 7, 6, 5, 4, 3, 2 };
		String matchDigit = "";
		for (int i = 0; i < intArr2.length; i++) {
			int j = intArr2[i];
			if (j == mod) {
				matchDigit = String.valueOf(intArr3[i]);
				if (intArr3[i] > 57) {
					matchDigit = String.valueOf((char) intArr3[i]);
				}
			}
		}

		return matchDigit;
		// 5.通过上面得知如果余数是2，就会在身份证的第18位数字上出现罗马数字的Ⅹ。如果余数是10，身份证的最后一位号码就是2。
	}
		
}
