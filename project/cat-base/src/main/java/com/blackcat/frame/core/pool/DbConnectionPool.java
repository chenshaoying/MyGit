package com.blackcat.frame.core.pool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

import com.blackcat.frame.core.context.SystemConf;

public class DbConnectionPool {
	private LinkedList<Connection> connects;
	private int pool_size;
	private static final int max_pool_size = 100;
	private static final long max_wait_timemills = 60000; 
	private DbConnectionPool() {
		this.connects = new LinkedList<Connection>();
	}

	public static DbConnectionPool getInstance(int pool_size) throws Exception {
		if(pool_size <= 0) {
			throw new IllegalArgumentException("数据库连接池大小必须大于0");
		}
		if(pool_size > max_pool_size) {
			throw new IllegalArgumentException("数据库连接池大小不能大于" + max_pool_size);
		}
		DbConnectionPool pool = new DbConnectionPool();
		for(int i=0;i<pool_size;i++) {
			pool.connects.addLast(createConnection());
		}
		pool.pool_size = pool_size;
		return pool;
	}

	public Connection fecthConnection() throws Exception {
		synchronized(connects) {
			if(connects.isEmpty()) {
				try {
					connects.wait(max_wait_timemills);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(connects.isEmpty()) {
				throw new Exception("连接超时,无可用连接");
			}
			return connects.removeFirst();
		}
	}
	
	public void releaseConnection(Connection conn) {
		synchronized(connects) {		
			connects.addLast(conn);
			connects.notifyAll();
		}
	}
	
	public void shutdown() {
		synchronized(connects) {	
			//等等所有线程归还连接
			while(pool_size != connects.size()) {
				try {
					connects.wait();
					//TimeUnit.SECONDS.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			for(Connection conn:connects) {
				try {
					if(conn != null) {
						System.out.println("connection cloesd");
						conn.close();						
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}
	}
	
	
	private static Connection createConnection() throws Exception {
		
		// 加载MySql的驱动类
		Class.forName(SystemConf.getConf("jdbc.driverClassName"));
		// 连接MySql数据库，用户名和密码都是root
		String url = SystemConf.getConf("jdbc.url");
		String username = SystemConf.getConf("jdbc.username");
		String password = SystemConf.getConf("jdbc.password");		
		Connection con = DriverManager.getConnection(url, username, password);	
		return con;
	}
}


/*class DriverManagerProxy implements InvocationHandler {
	private static final Logger log = LoggerFactory.getLogger(DriverManagerProxy.class);
	private DriverManager target;
	
	  *//** 
     * 绑定委托对象并返回一个代理类 
     * @param target 
     * @return 
     *//*  
    public DriverManager bind(DriverManager target) {  
        this.target = target;  
        //取得代理对象  
        return (DriverManager) Proxy.newProxyInstance(target.getClass().getClassLoader(),  
                target.getClass().getInterfaces(), this);   //要绑定接口(这是一个缺陷，cglib弥补了这一缺陷)  
    } 
    
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		log.info("Proxy start");
		return method.invoke(proxy, args);
	}
	
}*/