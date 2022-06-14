package com.gladikov.application.entities.kep;

import java.util.Arrays;
import java.util.Random;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.NoArgsConstructor;

//@JsonPropertyOrder(alphabetic=true)
//@JsonPropertyOrder({ "name", "id" })
public class Channel {
		@JsonIgnore
		private Random random;
	 	@JsonProperty("common.ALLTYPES_NAME")
		private final String name;
	 	
		 @JsonProperty("servermain.MULTIPLE_TYPES_DEVICE_DRIVER")
		private final String MULTIPLE_TYPES_DEVICE_DRIVER = "Modbus TCP/IP Ethernet";
		 @JsonProperty("servermain.CHANNEL_DIAGNOSTICS_CAPTURE")
		private final Boolean CHANNEL_DIAGNOSTICS_CAPTURE = true;
		 @JsonProperty("servermain.CHANNEL_UNIQUE_ID")
		 private final Integer UNIQ;
		 @JsonProperty("servermain.CHANNEL_ETHERNET_COMMUNICATIONS_NETWORK_ADAPTER_STRING")
		private final String adapter;
		 @JsonProperty("servermain.CHANNEL_WRITE_OPTIMIZATIONS_METHOD")
		private final Integer CHANNEL_WRITE_OPTIMIZATIONS_METHOD = 1;
		 @JsonProperty("servermain.CHANNEL_WRITE_OPTIMIZATIONS_DUTY_CYCLE")
		private final Integer CHANNEL_WRITE_OPTIMIZATIONS_DUTY_CYCLE = 10;
		 @JsonProperty("servermain.CHANNEL_NON_NORMALIZED_FLOATING_POINT_HANDLING")
		private final Integer CHANNEL_NON_NORMALIZED_FLOATING_POINT_HANDLING = 0;
		 @JsonProperty("servermain.CHANNEL_COMMUNICATIONS_SERIALIZATION_VIRTUAL_NETWORK")
		private final Integer CHANNEL_COMMUNICATIONS_SERIALIZATION_VIRTUAL_NETWORK = 0;
		 @JsonProperty("servermain.CHANNEL_COMMUNICATIONS_SERIALIZATION_TRANSACTIONS_PER_CYCLE")
		private final Integer CHANNEL_COMMUNICATIONS_SERIALIZATION_TRANSACTIONS_PER_CYCLE = 1;
		 @JsonProperty("servermain.CHANNEL_COMMUNICATIONS_SERIALIZATION_NETWORK_MODE")
		private final Integer CHANNEL_COMMUNICATIONS_SERIALIZATION_NETWORK_MODE = 0;
		
		@JsonProperty("modbus_ethernet.CHANNEL_USE_ONE_OR_MORE_SOCKETS_PER_DEVICE")
		private final Integer CHANNEL_USE_ONE_OR_MORE_SOCKETS_PER_DEVICE = 1;
		@JsonProperty("modbus_ethernet.CHANNEL_MAXIMUM_SOCKETS_PER_DEVICE")
		private final Integer CHANNEL_MAXIMUM_SOCKETS_PER_DEVICE = 10;
		@JsonProperty("modbus_ethernet.CHANNEL_ETHERNET_PORT_NUMBER")
		private final Integer CHANNEL_ETHERNET_PORT_NUMBER = 502;
		@JsonProperty("modbus_ethernet.CHANNEL_ETHERNET_PROTOCOL")
		private final Integer CHANNEL_ETHERNET_PROTOCOL = 0;
		@JsonProperty("devices")
		private Device[] devices;
	
		public Channel(Random random,String channelName,String adapterName,String deviceName,String deviceID,Boolean f6) {
			UNIQ=random.nextInt()& Integer.MAX_VALUE;
			this.name=channelName;
			adapter=adapterName;
			devices=new Device[1];
			devices[0]= new Device(random,deviceName,deviceID,f6);
		}

}
