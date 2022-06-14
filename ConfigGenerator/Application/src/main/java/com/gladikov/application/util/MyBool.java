package com.gladikov.application.util;

public class MyBool {
	private Boolean bool;
	
	private MyBool(Boolean bool){
		this.bool=bool;
	}
	
	
	
	public static MyBool  init(Boolean bool) {
		return  new MyBool(bool);
	}
	
	public String toString() {
		return bool.toString();
	}
	
	public String toStringNum() {
		return bool?"1":"0";
	}
	
	
}
