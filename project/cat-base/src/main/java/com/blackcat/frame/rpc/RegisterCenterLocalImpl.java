package com.blackcat.frame.rpc;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

import com.blackcat.frame.core.utils.StrUtil;

public class RegisterCenterLocalImpl implements RegisterCenter{
	
	private static ConcurrentHashMap<String,List<RpcServiceInfo>> map ;
	
	static {
		init();
	}
	
	private static void init() {
		//TODO 从数据库或配置文件加载
		map = new ConcurrentHashMap<String,List<RpcServiceInfo>>();
	}
	
	@Override
	public void reisterService(RpcServiceInfo service) {
		if(service == null || StrUtil.isEmptyTrim(service.getService_id())) {
			throw new IllegalArgumentException("");
		}
		List<RpcServiceInfo> list = map.get(service.getService_id());
		if(list == null) {
			list = new ArrayList<RpcServiceInfo>();
			list.add(service);
			map.put(service.getService_id(), list);
		} else {
			list.add(service);
		}
	}

	@Override
	public RpcServiceInfo getService(String service_id) {
		List<RpcServiceInfo> list = map.get(service_id);
		if(StrUtil.isEmptyCollection(list)) {
			return null;
		} else {
			Random r = new Random();
			return list.get(r.nextInt(list.size()));			
		}
	}

	@Override
	public void cancel(String service_id, String ip, int port) {
		// TODO Auto-generated method stub
		List<RpcServiceInfo> list = map.get(service_id);
		if(StrUtil.isEmptyCollection(list)) {
			//
		} else {
			/*Random r = new Random();
			return list.get(r.nextInt(list.size()));*/		
			
		}
	}

}
