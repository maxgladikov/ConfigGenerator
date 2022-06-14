package com.gladikov.application.entities.aux;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ModbusItem {
	
	public ModbusItem(List<String> device) {
		name=device.get(0);
		access=device.get(1);
		address=device.get(2);
		dataType=device.get(3);
		description=device.get(4);
		if(device.get(5).equalsIgnoreCase("true")) {
			isScaled=true;
			scale=device.get(6);	
			rawLow=device.get(7);
			rawHigh=device.get(8);
			scaledLow=device.get(9);
			scaledHigh=device.get(10);
			scaledDataType=device.get(11);
			clampLow=device.get(12);	
			clampHigh=device.get(13);
		}else {
			isScaled=false;
		}
	}
	private String name;
	private String access;
	private String dataType;
	private String address;
	private String description;
	private Boolean isScaled;
	private String scale;	
	private String rawLow;
	private String rawHigh;
	private String scaledLow;
	private String scaledHigh;
	private String scaledDataType;
	private String clampLow;	
	private String clampHigh;
}
