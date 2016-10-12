/**
 * 
 */
package com.blackcat.frame.core.utils;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jollyja
 *
 */
public class ICUtil {
	
	/**
	 * 依次返回： 
	 * 模（bcd）
	 * 公钥指数（int型字符）
	 * 私钥指数（bcd）
	 * p（bcd）
	 * q（bcd）
	 * dp（bcd）
	 * dq（bcd）
	 * qinv（bcd）
	 * 
	 * 
		version           Version,
		modulus           INTEGER,  -- n
		publicExponent    INTEGER,  -- e
		privateExponent   INTEGER,  -- d
		prime1            INTEGER,  -- p
		prime2            INTEGER,  -- q
		exponent1         INTEGER,  -- d mod (p-1)
		exponent2         INTEGER,  -- d mod (q-1)
		coefficient       INTEGER,  -- (inverse of q) mod p
		otherPrimeInfos   OtherPrimeInfos OPTIONAL 
		
02 8191 00 811DBE6C050316A140586B9E2848380C053280864266F200A3AC87CD736A6136798E4895EBC3245CC9BB678D11ED6135D97A20FF5AA6B8BB35017E6EB7B0488E97E98009274BA2870F0A6E21C6C0C949214E9641997847EC4FD22DB116F4BD0EE8601D2D18BF683F543723F40EB713AC39DFA1E7581C861FCAF8EFAC1694ECFC520DA0334AA1D42434A1D1B5B062776B
02 49 00 EBCE791FBE5CDD533B31396ABEDD6EE426B60C2E96151A177DB49F013862A32C3DA0DFD42FF76E982DCF991689687815E9E5091871F3CC81082F56B30BAC8C465E6C4789BA789551
02 49 00 D2427CE4CCC5246F410A7C78CB109ACC631B3321775213AF9842BB40F79C7089EFACF73950D55AC88D26A17069F378E4BED63375B5A232656085CE5D95DD90E9D460357630A8E66B
02 49 00 9D3450BFD43DE8E22776264729E8F49819CEB2C9B96366BA53CDBF5625971772D3C095381FFA49BAC93510B9B0F0500E9BEE06104BF7DDAB5ACA39CCB273082EE99D85067C50638B
02 49 00 8C2C5343332E184A2B5C52FB320B11DD9767776BA4E16275102C7CD5FA684B069FC8A4D0E08E3C85B36F164AF14CFB4329E4224E7916CC4395AE8993B93E609BE2EACE4ECB1B4447
02 48    040DA688AE542A8C7FEDF7F12138DEB09B827A0A430D205DD6BFEC3FE8589CBC9D23C38ED472406D9FF3F244217B2A3F5D190088C8BDED459339C6807B4899E23094FBB7F17F503A
8000000000000000
	 * @param data
	 * @return
	 */
	public static String[] decodePrivateKeyDER(String data) {
		String ss = "";
		String[] ret = new String[8];
		
		int idx = 2;
		String tmp = data.substring(2, 4);
		idx += (2 + (Integer.valueOf(tmp, 16) - 128) * 2);
		
		idx += 6;
		
		idx += 2;
		tmp = data.substring(idx, idx+2);
		ss = data.substring(idx+2,idx+2+(Integer.valueOf(tmp, 16) - 128) * 2);
		idx += (2 + (Integer.valueOf(tmp, 16) - 128) * 2);
		ret[0] = data.substring(idx, idx+Integer.valueOf(ss, 16) * 2);
		if (ret[0].startsWith("00")) {
			ret[0] = ret[0].substring(2);
		}
		idx += Integer.valueOf(ss, 16) * 2;
		
		idx += 2;
		ss = data.substring(idx, idx+2);
		idx += 2;
		ret[1] = data.substring(idx, idx+Integer.valueOf(ss, 16)*2);
		idx += 2;
		
		idx += 2;
		tmp = data.substring(idx, idx+2);
		ss = data.substring(idx+2,idx+2+(Integer.valueOf(tmp, 16) - 128) * 2);
		idx += (2 + (Integer.valueOf(tmp, 16) - 128) * 2);
		ret[2] = data.substring(idx, idx+Integer.valueOf(ss, 16) * 2);
		if (ret[2].startsWith("00")) {
			ret[2] = ret[2].substring(2);
		}
		idx += Integer.valueOf(ss, 16) * 2;

		idx += 2;
		ss = data.substring(idx, idx+2);
		idx += 2;
		ret[3] = data.substring(idx, idx+Integer.valueOf(ss, 16) * 2);
		if (ret[3].startsWith("00")) {
			ret[3] = ret[3].substring(2);
		}
		idx += Integer.valueOf(ss, 16) * 2;

		idx += 2;
		ss = data.substring(idx, idx+2);
		idx += 2;
		ret[4] = data.substring(idx, idx+Integer.valueOf(ss, 16) * 2);
		if (ret[4].startsWith("00")) {
			ret[4] = ret[4].substring(2);
		}
		idx += Integer.valueOf(ss, 16) * 2;
		
		idx += 2;
		ss = data.substring(idx, idx+2);
		idx += 2;
		ret[5] = data.substring(idx, idx+Integer.valueOf(ss, 16) * 2);
		if (ret[5].startsWith("00")) {
			ret[5] = ret[5].substring(2);
		}
		idx += Integer.valueOf(ss, 16) * 2;
		
		idx += 2;
		ss = data.substring(idx, idx+2);
		idx += 2;
		ret[6] = data.substring(idx, idx+Integer.valueOf(ss, 16) * 2);
		if (ret[6].startsWith("00")) {
			ret[6] = ret[6].substring(2);
		}
		idx += Integer.valueOf(ss, 16) * 2;
		
		idx += 2;
		ss = data.substring(idx, idx+2);
		idx += 2;
		ret[7] = data.substring(idx, idx+Integer.valueOf(ss, 16) * 2);
		if (ret[7].startsWith("00")) {
			ret[7] = ret[7].substring(2);
		}
		idx += Integer.valueOf(ss, 16) * 2;

		return ret;
	}
	
	/**
	 * 
		version           Version,
		modulus           INTEGER,  -- n
		publicExponent    INTEGER,  -- e
		privateExponent   INTEGER,  -- d
		prime1            INTEGER,  -- p
		prime2            INTEGER,  -- q
		exponent1         INTEGER,  -- d mod (p-1)
		exponent2         INTEGER,  -- d mod (q-1)
		coefficient       INTEGER,  -- (inverse of q) mod p
		otherPrimeInfos   OtherPrimeInfos OPTIONAL 
		
30 8202A4 
02 01 00
02 8191 00 C1AC9DA20784A1F1E084A16D3C6C541207CBC0C9639A6B00F582CBB42D1F91D1B6556CE0E1A4B68B2E991B539AE411D0C637317F07FA1518CF823DA613886CD5E3DE400DBAF173CC54A09B3735432FB02E319745F0227593018C83D9AFD6495D72878605D51E30152BA08CFB96DF66E311C5AD61F786BA2A5930A41049756260E3C9955D917CDB6681BF379073B52EDB 
02 01 03
02 8191 00 811DBE6C050316A140586B9E2848380C053280864266F200A3AC87CD736A6136798E4895EBC3245CC9BB678D11ED6135D97A20FF5AA6B8BB35017E6EB7B0488E97E98009274BA2870F0A6E21C6C0C949214E9641997847EC4FD22DB116F4BD0EE8601D2D18BF683F543723F40EB713AC39DFA1E7581C861FCAF8EFAC1694ECFC520DA0334AA1D42434A1D1B5B062776B
02 49 00 EBCE791FBE5CDD533B31396ABEDD6EE426B60C2E96151A177DB49F013862A32C3DA0DFD42FF76E982DCF991689687815E9E5091871F3CC81082F56B30BAC8C465E6C4789BA789551
02 49 00 D2427CE4CCC5246F410A7C78CB109ACC631B3321775213AF9842BB40F79C7089EFACF73950D55AC88D26A17069F378E4BED63375B5A232656085CE5D95DD90E9D460357630A8E66B
02 49 00 9D3450BFD43DE8E22776264729E8F49819CEB2C9B96366BA53CDBF5625971772D3C095381FFA49BAC93510B9B0F0500E9BEE06104BF7DDAB5ACA39CCB273082EE99D85067C50638B
02 49 00 8C2C5343332E184A2B5C52FB320B11DD9767776BA4E16275102C7CD5FA684B069FC8A4D0E08E3C85B36F164AF14CFB4329E4224E7916CC4395AE8993B93E609BE2EACE4ECB1B4447
02 48    040DA688AE542A8C7FEDF7F12138DEB09B827A0A430D205DD6BFEC3FE8589CBC9D23C38ED472406D9FF3F244217B2A3F5D190088C8BDED459339C6807B4899E23094FBB7F17F503A
8000000000000000
	 * @return
	 */
	public static String encodePrivateKeyDER(String modulus, int publicEx, String privateEx, 
			String prime1, String prime2, String exponent1, String exponent2, String coefficient) {
		boolean pre = false;
		int size = 0;
		StringBuilder builder = new StringBuilder();
		
//		02 01 00
		builder.append("020100");
		
//		02 8191 00 C1AC9DA20784A1F1E084A16D3C6C541207CBC0C9639A6B00F582CBB42D1F91D1B6556CE0E1A4B68B2E991B539AE411D0C637317F07FA1518CF823DA613886CD5E3DE400DBAF173CC54A09B3735432FB02E319745F0227593018C83D9AFD6495D72878605D51E30152BA08CFB96DF66E311C5AD61F786BA2A5930A41049756260E3C9955D917CDB6681BF379073B52EDB 
		if (Integer.valueOf(modulus.substring(0, 1), 16) >= 8) {//首BIT为1的情况
			pre = true;
		} else {
			pre = false;
		}
		size = modulus.length() / 2 + (pre ? 1 : 0);
		builder.append("02");
		if (size > 128) {
			String s1 = ICUtil.f_num2hex(size);
			builder.append(ICUtil.f_num2hex((128+s1.length()/2))+s1);
		} else {
			builder.append(ICUtil.f_num2hex(size));
		}
		if (pre) {
			builder.append("00");
		}
		builder.append(modulus);
		
//		02 01 03
		builder.append("02");
		builder.append(ICUtil.f_num2hex(ICUtil.f_num2hex(publicEx).length() / 2));
		builder.append(ICUtil.f_num2hex(publicEx));
		
//		02 8191 00 811DBE6C050316A140586B9E2848380C053280864266F200A3AC87CD736A6136798E4895EBC3245CC9BB678D11ED6135D97A20FF5AA6B8BB35017E6EB7B0488E97E98009274BA2870F0A6E21C6C0C949214E9641997847EC4FD22DB116F4BD0EE8601D2D18BF683F543723F40EB713AC39DFA1E7581C861FCAF8EFAC1694ECFC520DA0334AA1D42434A1D1B5B062776B
		if (Integer.valueOf(privateEx.substring(0, 1), 16) >= 8) {//首BIT为1的情况
			pre = true;
		} else {
			pre = false;
		}
		size = privateEx.length() / 2 + (pre ? 1 : 0);
		builder.append("02");
		if (size > 128) {
			String s1 = ICUtil.f_num2hex(size);
			builder.append(ICUtil.f_num2hex((128+s1.length()/2))+s1);
		} else {
			builder.append(ICUtil.f_num2hex(size));
		}
		if (pre) {
			builder.append("00");
		}
		builder.append(privateEx);
		
//		02 49 00 EBCE791FBE5CDD533B31396ABEDD6EE426B60C2E96151A177DB49F013862A32C3DA0DFD42FF76E982DCF991689687815E9E5091871F3CC81082F56B30BAC8C465E6C4789BA789551
		if (Integer.valueOf(prime1.substring(0, 1), 16) >= 8) {//首BIT为1的情况
			pre = true;
		} else {
			pre = false;
		}
		size = prime1.length() / 2 + (pre ? 1 : 0);
		builder.append("02");
		builder.append(ICUtil.f_num2hex(size));
		if (pre) {
			builder.append("00");
		}
		builder.append(prime1);
		
//		02 49 00 D2427CE4CCC5246F410A7C78CB109ACC631B3321775213AF9842BB40F79C7089EFACF73950D55AC88D26A17069F378E4BED63375B5A232656085CE5D95DD90E9D460357630A8E66B
		if (Integer.valueOf(prime2.substring(0, 1), 16) >= 8) {//首BIT为1的情况
			pre = true;
		} else {
			pre = false;
		}
		size = prime2.length() / 2 + (pre ? 1 : 0);
		builder.append("02");
		builder.append(ICUtil.f_num2hex(size));
		if (pre) {
			builder.append("00");
		}
		builder.append(prime2);
		
//		02 49 00 9D3450BFD43DE8E22776264729E8F49819CEB2C9B96366BA53CDBF5625971772D3C095381FFA49BAC93510B9B0F0500E9BEE06104BF7DDAB5ACA39CCB273082EE99D85067C50638B
		if (Integer.valueOf(exponent1.substring(0, 1), 16) >= 8) {//首BIT为1的情况
			pre = true;
		} else {
			pre = false;
		}
		size = exponent1.length() / 2 + (pre ? 1 : 0);
		builder.append("02");
		builder.append(ICUtil.f_num2hex(size));
		if (pre) {
			builder.append("00");
		}
		builder.append(exponent1);
		
//		02 49 00 8C2C5343332E184A2B5C52FB320B11DD9767776BA4E16275102C7CD5FA684B069FC8A4D0E08E3C85B36F164AF14CFB4329E4224E7916CC4395AE8993B93E609BE2EACE4ECB1B4447
		if (Integer.valueOf(exponent2.substring(0, 1), 16) >= 8) {//首BIT为1的情况
			pre = true;
		} else {
			pre = false;
		}
		size = exponent2.length() / 2 + (pre ? 1 : 0);
		builder.append("02");
		builder.append(ICUtil.f_num2hex(size));
		if (pre) {
			builder.append("00");
		}
		builder.append(exponent2);
		
//		02 48    040DA688AE542A8C7FEDF7F12138DEB09B827A0A430D205DD6BFEC3FE8589CBC9D23C38ED472406D9FF3F244217B2A3F5D190088C8BDED459339C6807B4899E23094FBB7F17F503A
		if (Integer.valueOf(coefficient.substring(0, 1), 16) >= 8) {//首BIT为1的情况
			pre = true;
		} else {
			pre = false;
		}
		size = coefficient.length() / 2 + (pre ? 1 : 0);
		builder.append("02");
		builder.append(ICUtil.f_num2hex(size));
		if (pre) {
			builder.append("00");
		}
		builder.append(coefficient);
		
//		30 8202A4 
		size = builder.length() / 2;
		if (size > 128) {
			String s1 = ICUtil.f_num2hex(size);
			builder.insert(0, ICUtil.f_num2hex((128+s1.length()/2))+s1);
		} else {
			builder.insert(0, ICUtil.f_num2hex(size));
		}
		builder.insert(0, "30");
		
		return builder.toString();
	}
	
	/**
	 * 返回bcd码公钥、公钥指数（十六进制指数）
	 * @param data
	 * @return
	 */
	public static String[] decodePublicKeyDER(String data) {
		int before = 4;//序列标识	字节长度
		int bytelen = Integer.valueOf(data.substring(2, 4),16);
		if (bytelen > 128) {
			int lensize = bytelen -128;
			bytelen = Integer.valueOf(data.substring(4, 4 + lensize*2), 16);
			before += lensize*2;
		}
		before+=2;//整数标识
		bytelen = Integer.valueOf(data.substring(before, before+2),16);
		if (bytelen > 128) {
			int lensize = bytelen -128;
			bytelen = Integer.valueOf(data.substring(before+2,before+2+lensize*2), 16);
			before += lensize*2+2;
		} else {
			before+=2;//模长度
		}
		String pubktx = "";
//		String pubktx = data.substring(before, before + bytelen * 2);
		if (!data.substring(before, before+2).equals("00")) {
			pubktx = data.substring(before, before + bytelen * 2);//
			before+=bytelen * 2;//模
		} else {
			pubktx = data.substring(before+2, before + bytelen * 2);//前面有个00
			before+=(bytelen * 2);//模
		}
		before+=2;//整数标识
		bytelen = Integer.valueOf(data.substring(before, before+2), 16);//指数长度
		before+=2;//指数长度

		String pubkex = data.substring(before, before + bytelen*2);
		return new String[] {pubktx, pubkex};
	}
	
	/**
	 * 组装公钥der编码
	 * 
	 * modulus           INTEGER,  -- n
	 * publicExponent    INTEGER,  -- e
	 * 
30 8197
02 8191 00 C1AC9DA20784A1F1E084A16D3C6C541207CBC0C9639A6B00F582CBB42D1F91D1B6556CE0E1A4B68B2E991B539AE411D0C637317F07FA1518CF823DA613886CD5E3DE400DBAF173CC54A09B3735432FB02E319745F0227593018C83D9AFD6495D72878605D51E30152BA08CFB96DF66E311C5AD61F786BA2A5930A41049756260E3C9955D917CDB6681BF379073B52EDB 
02 01 03
	 * 
	 * @param pubktx 公钥 bcd码
	 * @param pubkex 公钥指数
	 * @return
	 */
	public static String encodePublicKeyDER(String pubktx, int pubkex) {
		StringBuilder builder = new StringBuilder();
		String ex = ICUtil.f_num2hex(pubkex);
		String exlen = ICUtil.f_num2hex(ex.length() / 2);
		int modsize = pubktx.length() / 2 + 1;
		String modsizstr = "";
		if (modsize > 128) {
			String s1 = ICUtil.f_num2hex(modsize);
			modsizstr = ICUtil.f_num2hex((128+s1.length()/2))+s1;
		} else {
			modsizstr = ICUtil.f_num2hex(modsize);;
		}
		
		builder.append("02").append(modsizstr);
		if (Integer.valueOf(pubktx.substring(0, 1), 16) >= 8) {//首BIT为1的情况
			builder.append("00");
		}
		builder.append(pubktx).append("02").append(exlen).append(ex);
		
		int size = builder.length() / 2;
		String sizestr = "";
		if (size > 128) {
			String s1 = ICUtil.f_num2hex(size);
			sizestr = ICUtil.f_num2hex((128+s1.length()/2))+s1;
		} else {
			sizestr = ICUtil.f_num2hex(size);;
		}
		builder.insert(0, sizestr);
		builder.insert(0, "30");
		return builder.toString();
	}
	
	
	/**
	 * bcd字符串(双数)转成字节码
	 * @param input
	 * @return
	 */
	public static byte[] bcd2hex(String input) {
		if (input == null || input.length() == 0) {
			return new byte[] {};
		}
		byte[] bs = new byte[input.length() / 2];
		for (int i = 0; i < input.length(); i++) {
			int x = Integer.parseInt(input.substring(i, i+2), 16);
			bs[i / 2] = (byte) x;
			i++;
		}
		
		return bs;
	}

	/**
	 * 字节码转成bcd字符串
	 * @param input
	 * @return
	 */
	public static String hex2bcd(byte[] input) {
		StringBuilder builder = new StringBuilder();
		if (input != null && input.length != 0) {
			for (int i = 0; i < input.length; i++) {
		        int v = input[i] & 0xFF;  
		        String hv = Integer.toHexString(v);  
		        if (hv.length() < 2) {  
		        	builder.append(0);  
		        }
		        builder.append(hv.toUpperCase());
			}
		}
		return builder.toString();
	}
	/**
	 * 字节码转成bcd字符串
	 * @param input
	 * @return
	 */
	public static String hex2bcd(byte[] input, int length) {
		StringBuilder builder = new StringBuilder();
		if (input != null && length != 0) {
			for (int i = 0; i < length; i++) {
		        int v = input[i] & 0xFF;  
		        String hv = Integer.toHexString(v);  
		        if (hv.length() < 2) {  
		        	builder.append(0);  
		        }
		        builder.append(hv.toUpperCase());
			}
		}
		return builder.toString();
	}


	public static void dumpHex(char[] input) {
		StringBuilder builder = new StringBuilder();
		builder.append("begin dump hex, char length " + (input == null ? "null" : input.length));
		builder.append("\n");
		if (input != null && input.length != 0) {
			for (int i = 0; i < input.length; i++) {
		        int v = input[i];  
		        String hv = Integer.toHexString(v);  
		        if (hv.length() < 2) {  
		        	builder.append(0);  
		        }
		        builder.append(hv.toUpperCase());
		        builder.append(" ");
				if (i % 16 == 15) {
					builder.append("\n");
				}
			}
		}
		builder.append("\n");
		builder.append("end dump hex");
//		System.out.println(builder.toString());
	}

	public static void dumpHex(byte[] input) {
		StringBuilder builder = new StringBuilder();
		builder.append("begin dump hex, char length " + (input == null ? "null" : input.length));
		builder.append("\n");
		if (input != null && input.length != 0) {
			for (int i = 0; i < input.length; i++) {
		        int v = input[i] & 0xFF;  
		        String hv = Integer.toHexString(v);  
		        if (hv.length() < 2) {  
		        	builder.append(0);  
		        }
		        builder.append(hv.toUpperCase());
		        builder.append(" ");
				if (i % 16 == 15) {
					builder.append("\n");
				}
			}
		}
		builder.append("\n");
		builder.append("end dump hex");
//		System.out.println(builder.toString());
	}
	
	/**
	 * 格式化为tag|length|value@
	 * 其中value为十六进制字符串，由外部传入
	 * @param tag
	 * @param value 只支持偶数位的十六进制字符串
	 * @return
	 */
	public static String f_tlv2(String tag, String value) {
		return tag + "|" + (value == null ? 0 : value.length() / 2) + "|" + (value == null ? "" : value) + "@";
	}
	
	/**
	 * 将字符串格式化成十六进制字符串表示
	 * @param value
	 * @return
	 */
	public static String f_str2hex(String value) {
		if (StrUtil.isEmptyTrim(value)) {
			return "";
		}
		byte[] bs;
		try {
			bs = value.getBytes("GBK");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
		
	    StringBuilder stringBuilder = new StringBuilder();  
	    for (int i = 0; i < bs.length; i++) {  
	        int v = bs[i] & 0xFF;  
	        String hv = Integer.toHexString(v);  
	        if (hv.length() < 2) {  
	            stringBuilder.append(0);  
	        }  
	        stringBuilder.append(hv);  
	    }  
	    return stringBuilder.toString().toUpperCase();  
	}
	
	/**
	 * 将数字转成十六进制并格式化成十六进制字符串表示
	 * @param value
	 * @return
	 */
	public static String f_num2hex(int value) {
		String s = Integer.toHexString(value).toUpperCase();
		return s.length() % 2 == 0 ? s : "0" + s;
	}
	
	/**
	 * 将数值转换成不带小数的字符串
	 * @param value
	 * @return
	 */
	public static String f_num2str(BigDecimal value, int scale) {
		if (value == null) {
			return "";
		}
		String s = value.setScale(scale, BigDecimal.ROUND_FLOOR).toString();
//		System.out.println(value.toString());
		s = s.replaceAll("\\.", "");
		return lpadeven(s, "0");
	}
	
	/**
	 * 左补为偶数
	 * @param str
	 * @return
	 */
	public static String lpadeven(String str, String pad) {
		if (str == null) {
			return "";
		}
		return str.length() % 2 == 0 ? str : pad + str;
	}
	
	/**
	 * 右补为偶数
	 * @param str
	 * @param pad
	 * @return
	 */
	public static String rpadeven(String str, String pad) {
		if (str == null) {
			return "";
		}
		return str.length() % 2 == 0 ? str : str + pad;
	}
	
	/**
	 * 左补位
	 * @param src
	 * @param pad
	 * @param maxlength
	 * @return
	 */
	public static String lpad(String str, String pad, int maxlength) {
		if (str == null) {
			return "";
		}
		if (str.length() < maxlength) {
			StringBuilder b =  new StringBuilder();
			for (int i = 0; i < maxlength - str.length(); i++) {
				b.append(pad);
			}
			return b.toString() + str;
		} else {
			return str;
		}
	}
	
	/**
	 * 右补位
	 * @param src
	 * @param pad
	 * @param maxlength
	 * @return
	 */
	public static String rpad(String str, String pad, int maxlength) {
		if (str == null) {
			return "";
		}
		if (str.length() < maxlength) {
			StringBuilder b =  new StringBuilder();
			for (int i = 0; i < maxlength - str.length(); i++) {
				b.append(pad);
			}
			return str + b.toString();
		} else {
			return str;
		}
	}

	/**
	 * 对奇数位的字符串前补0
	 * @param value
	 * @return
	 */
	public static String f_lpadhex(String value) {
		if (value == null) {
			return "";
		}
		return value.length() % 2 == 0 ? value : "0" + value;
	}
	
	/**
	 * 对奇数位的字符串后补F
	 * @param value
	 * @return
	 */
	public static String f_rpadhex(String value) {
		if (value == null) {
			return "";
		}
		return value.length() % 2 == 0 ? value : value + "F";
	}
	
	
	/**
	 * 十六进制字符串转换成二进制字符串
	 * @param hexstr
	 */
	public static String f_hexstr2binstr(String hexstr) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < hexstr.length() / 2; i++) {
			builder.append(f_num2binstr(Integer.parseInt(hexstr.substring(i * 2, i * 2 + 2), 16)));
		}
		return builder.toString();
	}
	
	/**
	 * 二进制字符串转换成十六进制字符串
	 * @param hexstr
	 */
	public static String f_binstr2hexbin(String binstr) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < binstr.length() / 8; i++) {
			builder.append(f_num2hex(Integer.parseInt(binstr.substring(i * 8, i* 8 + 8), 2)));
		}
		return builder.toString();
	}
	
	/**
	 * 数字转二进制字符串
	 * @param hexstr
	 * @return
	 */
	public static String f_num2binstr(int value) {
		String ret = Integer.toBinaryString(value);
		if (ret.length() % 8 == 0) {
			return ret;
		}
		return ("00000000"+ret).substring(ret.length() % 8);
	}
	
	/**
	 * 十六进制字符串异或
	 * @param s1
	 * @param s2
	 * @return
	 */
	public static String xor(String s1, String s2) {
		String ss1 = f_hexstr2binstr(s1);
		String ss2 = f_hexstr2binstr(s2);
		StringBuilder builder = new StringBuilder();
		
		for (int i = 0; i < ss1.length(); i++) {
			builder.append(Integer.valueOf(ss1.substring(i, i+1)) ^ Integer.valueOf(ss2.substring(i, i+1)));
		}
		
		return f_binstr2hexbin(builder.toString());
	}
	
	/**
	 * 科友通讯报文格式
	 * 	3位域标识号+域数据长度4位+域数据。
	 * 
	 * @param tag
	 * @param val
	 * @return
	 */
	public static String keyouFormat(String tag, String val) {
		StringBuilder builder = new StringBuilder();
		builder.append(tag)
			.append(lpad(val.length()+"", "0", 4))
			.append(val);
//		log.info(tag + " : " + lpad(val.length()+"", "0", 4) + " : " + val);
		return builder.toString();
	}
	
	/**
	 * 科友通讯报文解析
	 * 	3位域标识号+域数据长度4位+域数据。
	 * 
	 * @param output 返回报文bcd
	 * @return
	 */
	public static Map<String, String> keyouExtract(String output) {
		Map<String, String> map = new HashMap<String, String>();
		if (StrUtil.isEmptyTrim(output)) {
			return map;
		}
//		System.out.println("XXXXX:"+new String(ICUtil.bcd2hex(output)));
		int cnt = Integer.valueOf(new String(ICUtil.bcd2hex(output.substring(0, 6))));
		int index = 6;
//
		for (int i = 0; i < cnt; i++) {
			String key = new String(ICUtil.bcd2hex(output.substring(index, index + 6)));
			index += 6;
			int c = Integer.valueOf(new String(ICUtil.bcd2hex(output.substring(index, index + 8))))*2;
			index += 8;
			String val = output.substring(index, index+c);
			index += c;
			map.put(key, val);
//			log.info(key + " : " + val);
		}
		
		return map;
	}
	
	/**
     * 
     * @param byte1
     * @param byte2
     * @return
     */
    public static byte[] byteMerger(byte[] byte1, byte[] byte2) {
        byte[] byte3 = new byte[byte1.length + byte2.length];
        System.arraycopy(byte1, 0, byte3, 0, byte1.length);
        System.arraycopy(byte2, 0, byte3, byte1.length, byte2.length);
        return byte3;
    }
    
    /**
     *
     * 
     * @param data
     * @return
     */
    public static String getTlvDataLength(String data) {
        if (data == null || data.length() == 0) {
            return "00";
        }
        String str;
        int length = data.length() / 2;
        int temp = f_num2hex(length).length() / 2;
        if (length > 128) {
            str = (f_num2hex(128 + temp) + f_num2hex(length));
        } else {
            str = f_num2hex(length);
        }
        return str;
    }

    /**
     * 
     * 
     * @param data
     * @return
     */
    public static String getCpsDataLength(String data) {
        if (data == null || data.length() == 0) {
            return "00";
        }
        String str;
        int length = data.length() / 2;
        if (length == 255) {
            str = "FF" + "00" + f_num2hex(length);
        }
        else if(length >= 256){
            str="FF" + f_num2hex(length);
        }
        else {
            str=f_num2hex(length);
        }
        return str;
    }
	
}
