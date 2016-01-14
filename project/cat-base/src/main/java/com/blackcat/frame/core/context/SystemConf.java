package com.blackcat.frame.core.context;

import java.io.IOException;
import java.util.Properties;

public class SystemConf {
    private static SystemConf conf = new SystemConf();
    private static Properties props;
    private SystemConf() {
    	
    }
    private static void init() {
        synchronized (conf) {    
            if (props != null) {
                return;
            }
            props = new Properties();
            try {
                props.load(SystemConf.class.getResourceAsStream("/jdbc.properties"));
            } catch (IOException e) {
                throw new Error("init jdbc.properties error");
            }
        }
    }
    
    public static String getConf(String key) {
        if (props == null) {
            init();
        }
        if (!props.containsKey(key)) {
            throw new Error("key:["+key+"] not in jdbc.properties");
        }
        String value = props.getProperty(key);
        return value;
    }
    
    public static void setConf(String key, String value) {
        props.put(key, value);
    }
    
}