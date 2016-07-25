/**
 * 
 */
package com.blackcat.frame.core.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 用于计算卡号
 * 
 * @author jollyja
 *
 */
public class CardNoUtil {

	/**
	 * 计算校验位
	 * 
	 * @param cardno 不带校验位的卡号
	 * @return 校验位
	 */
	public static String calVerfNo(String cardno) {
		//步骤1：从右边第1个数字（低序）开始每隔一位乘以2。
		//步骤2：把在步骤1中获得的乘积的各位数字与原号码中未乘2的各位数字相加。
		//步骤3：从邻近的较高的一个以0结尾的数中减去步骤2中所得到的总和[这相当于求这个总和的低位数字（个位数）的“10的补数”]。
		//如果在步骤2得到的总和是以零结尾的数（如30、40等等），则校验数字就是零。
		boolean mutli = true;
		int sum = 0;
		for (int i = cardno.length() - 1; i >= 0; i--) {
			int tmp = Integer.valueOf(cardno.substring(i, i+1));
			tmp = mutli ? tmp * 2 : tmp;
			sum += (tmp % 10 + tmp / 10);
			mutli = mutli ? false : true;
		}
		return (sum % 10 == 0) ? "0" : String.valueOf((10 - sum % 10));
	}
	
	/**
	 * 计算校验位
	 * 
	 * @param cardno 不带校验位的卡号
	 * @return 校验位
	 */
	public static List<String> calVerfNo(List<String> cardnos) {
		if (cardnos == null || cardnos.size() <= 0) {
			return cardnos;
		}
		List<String> list = new ArrayList<String>();
		for (String cardno : cardnos) {
			list.add(calVerfNo(cardno));
		}
		return list;
	}

	/**
	 * 计算卡号校验位并返回完整的卡号
	 * @param cardno 不带校验位的卡号
	 * @return 带校验位的卡号
	 */
	public static String getCardNo(String cardno) {
		return cardno + calVerfNo(cardno);
	}
	
	/**
	 * 计算卡号校验位并返回完整的卡号
	 * @param cardno 不带校验位的卡号
	 * @return 带校验位的卡号
	 */
	public static List<String> getCardNo(List<String> cardnos) {
		if (cardnos == null || cardnos.size() <= 0) {
			return cardnos;
		}
		List<String> list = new ArrayList<String>();
		for (String cardno : cardnos) {
			list.add(getCardNo(cardno));
		}
		return list;
	}
	
	/**
	 * 根据卡号模式获取一组卡号
	 * 模式中以*作为通配符
	 * 例如（19位卡号为例） *号表示替换任意数字，前提是必须满足校验位规则
	 * 621460****888888888
	 * 62146088**8888**888
	 * 62146088**8888**88*
	 * 621460888888888888*
	 * 6214608888888888888
	 * 
	 * 目前建议通配符不超过6个（10万个）
	 * 
	 * @param pattern 卡号模式
	 * @return 符合卡号模式的所有卡号集合，从小到大排序
	 */
	public static List<String> getCardNoByPattern(String pattern) {
		int idx = pattern.indexOf("*");
		int len = pattern.length();
		if (idx < 0) {//最底层，无通配符，比对校验位。有改造的余地，可以提高10倍的速度
			List<String> real = new ArrayList<String>();
			if (calVerfNo(pattern.substring(0, len - 1)).equals(pattern.substring(len - 1, len))) {
				real.add(pattern);
			}
			return real;
		}
		
		List<String> list = new ArrayList<String>();
		String pre = pattern.substring(0, idx);
		String post = pattern.substring(idx + 1, len);
		for (int i = 0; i <= 9; i++) {
			List<String> ret = getCardNoByPattern(pre + i + post);
			if (ret != null && ret.size() > 0) {
				list.addAll(ret);
			}
		}
		return list;
	}
	
	
}
