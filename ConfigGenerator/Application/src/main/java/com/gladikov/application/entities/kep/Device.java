package com.gladikov.application.entities.kep;

import java.util.Random;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Device {
	
	 	@JsonProperty("common.ALLTYPES_NAME")
		private final String name;
	 	
	 	@JsonProperty("servermain.MULTIPLE_TYPES_DEVICE_DRIVER")
		private final String MULTIPLE_TYPES_DEVICE_DRIVER = "Modbus TCP/IP Ethernet";
	 	@JsonProperty("servermain.DEVICE_MODEL")
		private final Integer DEVICE_MODEL = 0;
	 	@JsonProperty("servermain.DEVICE_UNIQUE_ID")
	 	private final Integer UNIQ;
	 	@JsonProperty("servermain.DEVICE_ID_FORMAT")
	 	private final Integer ID_FORMAT=0;
	 	@JsonProperty("servermain.DEVICE_ID_STRING")
		private final String address;
	 	@JsonProperty("servermain.DEVICE_ID_HEXADECIMAL")
		private final Integer DEVICE_ID_HEXADECIMAL = 0;
	 	@JsonProperty("servermain.DEVICE_ID_DECIMAL")
		private final Integer DEVICE_ID_DECIMAL = 0;
	 	@JsonProperty("servermain.DEVICE_ID_OCTAL")
		private final Integer DEVICE_ID_OCTAL = 0;
	 	@JsonProperty("servermain.DEVICE_DATA_COLLECTION")
		private final Boolean DEVICE_DATA_COLLECTION = true;
	 	@JsonProperty("servermain.DEVICE_SIMULATED")
		private final Boolean DEVICE_SIMULATED = false;
	 	@JsonProperty("servermain.DEVICE_SCAN_MODE")
		private final Integer DEVICE_SCAN_MODE = 0;
	 	@JsonProperty("servermain.DEVICE_SCAN_MODE_RATE_MS")
		private final Integer DEVICE_SCAN_MODE_RATE_MS = 1000;
	 	@JsonProperty("servermain.DEVICE_SCAN_MODE_PROVIDE_INITIAL_UPDATES_FROM_CACHE")
		private final Boolean DEVICE_SCAN_MODE_PROVIDE_INITIAL_UPDATES_FROM_CACHE = false;
	 	@JsonProperty("servermain.DEVICE_CONNECTION_TIMEOUT_SECONDS")
		private final Integer DEVICE_CONNECTION_TIMEOUT_SECONDS = 3;
	 	@JsonProperty("servermain.DEVICE_REQUEST_TIMEOUT_MILLISECONDS")
		private final Integer DEVICE_REQUEST_TIMEOUT_MILLISECONDS = 1000;
	 	@JsonProperty("servermain.DEVICE_RETRY_ATTEMPTS")
		private final Integer DEVICE_RETRY_ATTEMPTS = 3;
	 	@JsonProperty("servermain.DEVICE_INTER_REQUEST_DELAY_MILLISECONDS")
		private final Integer DEVICE_INTER_REQUEST_DELAY_MILLISECONDS = 0;
	 	@JsonProperty("servermain.DEVICE_AUTO_DEMOTION_ENABLE_ON_COMMUNICATIONS_FAILURES")
		private final Boolean DEVICE_AUTO_DEMOTION_ENABLE_ON_COMMUNICATIONS_FAILURES = false;
	 	@JsonProperty("servermain.DEVICE_AUTO_DEMOTION_DEMOTE_AFTER_SUCCESSIVE_TIMEOUTS")
		private final Integer DEVICE_AUTO_DEMOTION_DEMOTE_AFTER_SUCCESSIVE_TIMEOUTS = 2;
	 	@JsonProperty("servermain.DEVICE_AUTO_DEMOTION_PERIOD_MS")
		private final Integer DEVICE_AUTO_DEMOTION_PERIOD_MS = 100000;
	 	@JsonProperty("servermain.DEVICE_AUTO_DEMOTION_DISCARD_WRITES")
		private final Boolean DEVICE_AUTO_DEMOTION_DISCARD_WRITES = false;
	 	@JsonProperty("servermain.DEVICE_TAG_GENERATION_ON_STARTUP")
		private final Integer DEVICE_TAG_GENERATION_ON_STARTUP = 0;
	 	@JsonProperty("servermain.DEVICE_TAG_GENERATION_DUPLICATE_HANDLING")
	 	private final Integer DEVICE_TAG_GENERATION_DUPLICATE_HANDLING = 0;
	 	@JsonProperty("servermain.DEVICE_TAG_GENERATION_GROUP")
	 	private final String DEVICE_TAG_GENERATION_GROUP = "";
	 	@JsonProperty("servermain.DEVICE_TAG_GENERATION_ALLOW_SUB_GROUPS")
	 	private final Boolean DEVICE_TAG_GENERATION_ALLOW_SUB_GROUPS = true;
	 	
	 	
	 	@JsonProperty("modbus_ethernet.DEVICE_VARIABLE_IMPORT_FILE")
		private final String DEVICE_VARIABLE_IMPORT_FILE = "*.txt";
	 	@JsonProperty("modbus_ethernet.DEVICE_VARIABLE_IMPORT_INCLUDE_DESCRIPTIONS")
		private final Integer DEVICE_VARIABLE_IMPORT_INCLUDE_DESCRIPTIONS = 1;
	 	@JsonProperty("modbus_ethernet.DEVICE_UNSOLICITED_OPC_QUALITY_BAD_UNTIL_WRITE")
		private final Boolean DEVICE_UNSOLICITED_OPC_QUALITY_BAD_UNTIL_WRITE = false;
	 	@JsonProperty("modbus_ethernet.DEVICE_UNSOLICITED_COMMUNICATIONS_TIMEOUT_SECONDS")
		private final Integer DEVICE_UNSOLICITED_COMMUNICATIONS_TIMEOUT_SECONDS = 0;
	 	@JsonProperty("modbus_ethernet.DEVICE_DEACTIVATE_TAGS_ON_ILLEGAL_ADDRESS")
		private final Integer DEVICE_DEACTIVATE_TAGS_ON_ILLEGAL_ADDRESS = 1;
	 	@JsonProperty("modbus_ethernet.DEVICE_SUB_MODEL")
		private final Integer DEVICE_SUB_MODEL = 1;
	 	@JsonProperty("modbus_ethernet.DEVICE_ETHERNET_PORT_NUMBER")
		private final Integer DEVICE_ETHERNET_PORT_NUMBER = 502;
	 	@JsonProperty("modbus_ethernet.DEVICE_ETHERNET_IP_PROTOCOL")
		private final Integer DEVICE_ETHERNET_IP_PROTOCOL = 1;
	 	@JsonProperty("modbus_ethernet.DEVICE_ETHERNET_CLOSE_TCP_SOCKET_ON_TIMEOUT")
		private final Boolean DEVICE_ETHERNET_CLOSE_TCP_SOCKET_ON_TIMEOUT = true;
	 	@JsonProperty("modbus_ethernet.DEVICE_ZERO_BASED_ADDRESSING")
		private final Boolean DEVICE_ZERO_BASED_ADDRESSING = true;
	 	@JsonProperty("modbus_ethernet.DEVICE_ZERO_BASED_BIT_ADDRESSING")
		private final Boolean DEVICE_ZERO_BASED_BIT_ADDRESSING = true;
	 	@JsonProperty("modbus_ethernet.DEVICE_HOLDING_REGISTER_BIT_MASK_WRITES")
		private final Boolean DEVICE_HOLDING_REGISTER_BIT_MASK_WRITES = false;
	 	@JsonProperty("modbus_ethernet.DEVICE_MODBUS_FUNCTION_06")
		private final Boolean FUNCTION_06 ;
	 	@JsonProperty("modbus_ethernet.DEVICE_MODBUS_FUNCTION_05")
		private final Boolean DEVICE_MODBUS_FUNCTION_05 = true;
	 	@JsonProperty("modbus_ethernet.DEVICE_CEG_EXTENSION")
		private final Boolean DEVICE_CEG_EXTENSION = true;
	 	@JsonProperty("modbus_ethernet.DEVICE_MAILBOX_CLIENT_PRIVILEGES")
		private final Integer DEVICE_MAILBOX_CLIENT_PRIVILEGES = 0;
	 	@JsonProperty("modbus_ethernet.DEVICE_MODBUS_BYTE_ORDER")
		private final Boolean DEVICE_MODBUS_BYTE_ORDER = true;
	 	@JsonProperty("modbus_ethernet.DEVICE_FIRST_WORD_LOW")
		private final Boolean DEVICE_FIRST_WORD_LOW = true;
	 	@JsonProperty("modbus_ethernet.DEVICE_FIRST_DWORD_LOW")
		private final Boolean DEVICE_FIRST_DWORD_LOW = true;
	 	@JsonProperty("modbus_ethernet.DEVICE_MODICON_BIT_ORDER")
		private final Boolean DEVICE_MODICON_BIT_ORDER = false;
	 	@JsonProperty("modbus_ethernet.DEVICE_TREAT_LONGS_AS_DOUBLE_PRECISION_UNSIGNED_DECIMAL")
		private final Boolean DEVICE_TREAT_LONGS_AS_DOUBLE_PRECISION_UNSIGNED_DECIMAL = false;
	 	@JsonProperty("modbus_ethernet.DEVICE_OUTPUT_COILS")
		private final Integer DEVICE_OUTPUT_COILS = 32;
	 	@JsonProperty("modbus_ethernet.DEVICE_INPUT_COILS")
		private final Integer DEVICE_INPUT_COILS = 32;
	 	@JsonProperty("modbus_ethernet.DEVICE_INTERNAL_REGISTERS")
		private final Integer DEVICE_INTERNAL_REGISTERS = 120;
	 	@JsonProperty("modbus_ethernet.DEVICE_HOLDING_REGISTERS")
		private final Integer DEVICE_HOLDING_REGISTERS = 120;
	 	@JsonProperty("modbus_ethernet.DEVICE_PERFORM_BLOCK_READ_ON_STRINGS")
		private final Integer DEVICE_PERFORM_BLOCK_READ_ON_STRINGS = 0;
	 	
		@JsonProperty("redundancy.DEVICE_SECONDARY_PATH")
		private final String DEVICE_SECONDARY_PATH = "";
		@JsonProperty("redundancy.DEVICE_OPERATING_MODE")
		private final Integer DEVICE_OPERATING_MODE = 0;
		@JsonProperty("redundancy.DEVICE_MONITOR_ITEM")
		private final String DEVICE_MONITOR_ITEM = "";
		@JsonProperty("redundancy.DEVICE_MONITOR_ITEM_POLL_INTERVAL")
		private final Integer DEVICE_MONITOR_ITEM_POLL_INTERVAL = 300;
		@JsonProperty("redundancy.DEVICE_FAVOR_PRIMARY")
		private final Boolean DEVICE_FAVOR_PRIMARY = true;
		@JsonProperty("redundancy.DEVICE_TRIGGER_ITEM")
		private final String DEVICE_TRIGGER_ITEM = "";
		@JsonProperty("redundancy.DEVICE_TRIGGER_ITEM_SCAN_RATE")
		private final Integer DEVICE_TRIGGER_ITEM_SCAN_RATE = 1000;
		@JsonProperty("redundancy.DEVICE_TRIGGER_TYPE")
		private final Integer DEVICE_TRIGGER_TYPE = 0;
		@JsonProperty("redundancy.DEVICE_TRIGGER_OPERATOR")
		private final Integer DEVICE_TRIGGER_OPERATOR = 0;
		@JsonProperty("redundancy.DEVICE_TRIGGER_VALUE")
		private final String DEVICE_TRIGGER_VALUE = "";
		@JsonProperty("redundancy.DEVICE_TRIGGER_TIMEOUT")
		private final Integer DEVICE_TRIGGER_TIMEOUT = 10000;
		
		
	
	public Device(Random random,String name,String id, Boolean f6) {
		UNIQ=random.nextInt()&Integer.MAX_VALUE;
		this.name=name;
		this.address="<"+id+">.254";
		this.FUNCTION_06=f6;
		
	}
	

}
