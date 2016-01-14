package com.blackcat.frame.core.utils;

import java.util.List;

import org.junit.Test;

import com.blackcat.frame.core.model.SysUser;
import com.blackcat.frame.core.service.SysUserService;
public class StrUtilTest {
	@Test
	public void l_padTest() {
		String msg = "1111我日";
		System.out.println(StrUtil.l_pad(msg, '我', 20));	
	}
	
	@Test
	public void overrideTest() {
		SysUserService s = new SysUserService() {
			@Override
			public boolean validateUser(SysUser user) {
				System.out.println("galigeigei");
				return false;
			}

			@Override
			public SysUser queryUserDetail(String userid) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public List<SysUser> getUsersSelective(SysUser condition) {
				// TODO Auto-generated method stub
				return null;
			}
		};
		System.out.println(s.validateUser(new SysUser()));
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
 }
