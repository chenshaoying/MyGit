package com.blackcat.dubbo.rpc;

import com.blackcat.dubbo.service.HelloService;
import com.blackcat.dubbo.service.HelloServiceImpl;

public class RpcProviderTest {
	public static void main(String[] args) throws Exception {
        HelloService hello = new HelloServiceImpl();
        RpcFramework.export(hello, 1111);
        System.in.read(); // 按任意键退出
    }
}
