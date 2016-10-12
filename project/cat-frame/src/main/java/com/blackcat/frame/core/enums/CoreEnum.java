package com.blackcat.frame.core.enums;

public interface CoreEnum {
	String getKey();	
	String getValue();
	String getDesc();
	
	
	/*static enum SessionEnum implements CoreEnum {
		USER("USER","USER","用户");
		
		private final String key;
		private final String value;
		private final String desc;

		private SessionEnum(String key,String value,String desc) {
			this.key = key;
			this.value = value;
			this.desc = desc; 
		}
		
		@Override
		public String getKey() {
			return key;
		}

		@Override
		public String getValue() {
			return value;
		}

		@Override
		public String getDesc() {
			return desc;
		}
		
	}*/
}
