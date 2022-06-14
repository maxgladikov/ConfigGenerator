package com.gladikov.application.entities.aux;

import java.util.*;

import com.gladikov.application.util.RegCounter;

import lombok.Data;
@Data
public class Task {
	private static RegCounter rc;
	private String tag;
	private String type;
	private String adapter;
	private String slaveAddress;
	private Map<String,ModbusItem> pattern;
	
	
	public Task(List<String> list,Map<String,ModbusItem> pattern ) {
		this.tag = list.get(0);
		this.type = list.get(1);
		this.slaveAddress = list.get(2);
		this.adapter = list.get(3);
		this.pattern=pattern;
		
	}
	
	public Task processAddress() {
		slaveAddress=tag+"."+tag+".";
		return this;
	}
	
	public static void setRC(RegCounter rci) {
		rc=rci;
	}
	
	public static RegCounter getRC() {
		return rc;
	}
	
	@Override
	public String toString() {
		return tag+" "+type+" "+slaveAddress;
	}
	
}
