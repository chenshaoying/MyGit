package com.blackcat.frame.spider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.dom4j.Document;
import org.dom4j.io.SAXReader;

public class SimpleSpider {
	
	public static String getUrlContent(String url) {
		StringBuilder result = new StringBuilder();
		BufferedReader reader = null;
		try {
			URL real = new URL(url);
			URLConnection conn = real.openConnection();
			conn.connect();
			reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line = null;
			while ((line = reader.readLine()) != null) {
				result.append(line).append("\n"); 
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return result.toString();
	}
	
	public static String getUrlContent1(String url) {
		//StringBuilder result = new StringBuilder();
		SAXReader reader = null;
		Document doc = null;
		try {
			URL real = new URL(url);
			reader = new SAXReader();
		    doc = reader.read(real);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return doc == null ? "":doc.asXML();
	}
}
