package com.blackcat.frame.core.utils;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

public class InetUtil {
	
	static String getLocalHost() {
		String localhost = null;
		try {
			Enumeration<NetworkInterface> interfaceList = NetworkInterface.getNetworkInterfaces();
			while(interfaceList.hasMoreElements()) {
				NetworkInterface inte =interfaceList.nextElement();
				Enumeration<InetAddress> addressList = inte.getInetAddresses();
				while(addressList.hasMoreElements()) {
					InetAddress addr = addressList.nextElement();
					if(addr instanceof Inet4Address) {
						System.out.println(addr.getHostAddress() + ":" + addr.getHostName());						
					}
					
				}
			}
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return localhost;
	}
}
