package com.blackcat.batch.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import com.blackcat.frame.core.model.SysUser;

public class MyFileReader implements ItemReader<SysUser>{
	private static final Logger log = LoggerFactory.getLogger(MyFileReader.class);

	private String filePath;
	private int startLineNum;
	private String encoding;
	private BufferedReader reader;
	@Override
	public SysUser read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		log.info("reading......");
		if(reader == null) {
			doOpen();
		}
		String line = reader.readLine();
		if(line == null) {
			doClose();
			return null;
		} else {
			return paresLine(line);			
		}
	}

	private void doOpen() {
		File file = new File(filePath);
		if(!file.canRead()) {
			throw new RuntimeException("open file error: file can not be read");
		}
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath),encoding));
			doSkip();
		} catch (UnsupportedEncodingException e1) {
			throw new RuntimeException("open file error: " + e1.getMessage());		
		} catch (FileNotFoundException e1) {
			throw new RuntimeException("open file error: file not exists");
		} catch (IOException e1) {
			throw new RuntimeException("open file error: " + e1.getMessage());
		} 
	}
	
	private void doSkip() throws IOException {
		if(reader != null && startLineNum > 0) {
			int count = 0 ;
			while(count != startLineNum && reader.readLine() != null) {
				count++;
			}
		}
	}
	
	private void doClose() {
		log.info("close reader...");
		if(reader != null) {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	public void setStartLineNum(int startLineNum) {
		if(startLineNum >= 0) {
			this.startLineNum = startLineNum;			
		} else {
			throw new IllegalArgumentException("startLineNum must larger or equals 0!");
		}
	}
	
	private SysUser paresLine(String line) {
		SysUser user = new SysUser();
		user.setUserid(line);
		return user;
	}
	
}
