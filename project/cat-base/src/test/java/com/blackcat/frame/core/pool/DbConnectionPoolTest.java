package com.blackcat.frame.core.pool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DbConnectionPoolTest {
	
	public static void main(String[] args) {
		
		try {
			DbConnectionPool pool = DbConnectionPool.getInstance(10);
			for(int i=0;i<10;i++) {
				Thread t = new Thread(new Consumer(pool), "t" + i);
				t.start();
			}
			pool.shutdown();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class Consumer implements Runnable {
	private DbConnectionPool pool;
	public Consumer(DbConnectionPool pool) {
		this.pool = pool;
	}
	@Override
	public void run() {
		Connection conn;
		try {
			conn = pool.fecthConnection();
			PreparedStatement statment = conn.prepareStatement("select * from sys_dict");
			
			ResultSet ret = statment.executeQuery();
			if(ret.next()) {
				System.out.println(Thread.currentThread().getName() + ":" + ret.getString(1));
			}
			pool.releaseConnection(conn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}