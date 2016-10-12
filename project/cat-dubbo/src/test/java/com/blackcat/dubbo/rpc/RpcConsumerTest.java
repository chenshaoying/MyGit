package com.blackcat.dubbo.rpc;

import com.blackcat.dubbo.service.HelloService;

public class RpcConsumerTest {
	public static void main(String[] args) throws Exception {
        HelloService hello = RpcFramework.refer(HelloService.class, "127.0.0.1", 1111);
        for(int i=0; i < 10; i++) {
        	System.out.println(hello.hello());        	
        }
        System.in.read(); // 按任意键退出
    }
}
