package com.blackcat.frame.rpc;

public interface RegisterCenter {
	
	void reisterService(RpcServiceInfo service);
	
	RpcServiceInfo getService(String service_id);
	
	void cancel(String service_id,String ip, int port);
	
}
