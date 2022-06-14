package com.gladikov.application.entities.linkMaster;

import com.gladikov.application.entities.aux.ModbusItem;
import com.gladikov.application.entities.aux.Task;
import com.gladikov.application.util.MyList;

import lombok.Getter;

public class LinkItemInput {
	private String recordType="LINKITEM";
	private String linkGroup;
	private String name;
	@Getter
	private String clientAccess;
	private String covOnly="FALSE";
	private String machineName="Local Machine";
	private String serverName="Kepware.KEPServerEX.V6";
	private String accessPath="";
	private String itemID;
	@Getter
	private String dataType;
	private String deadBandType="None";
	private String deadBand="";
	private String deadBandLowRange="";
	private String deadBandHighRange="";
	private String scaling="";
	private String rawLow="";
	private String rawHigh="";
	private String scaledLow="";
	private String scaledHigh="";
	private String scaledDataType="";
	private String clampLow="";
	private String clampHigh="";
	private String engUnits="";
	private String description="";
	private MyList list;
	private String slaveAddress;
	private String dcsAddress;
	@Getter
	private LinkItemOutput linkItemOutput;
	@Getter
	private String dcsAddressShort;
	@Getter
	private static String title=";\n;Link Item Defenitions\n;\nRecord Type,Link Group,Name, Client Access, COV Only,Machine Name, "
			+ "Server Name, Access Path, Item ID, Data Type, Deadband Type,Deadband,Deadband Low Range,Deadband High Range,Scaling,Raw Low,Raw High,"
			+ "Scaled Low,Scaled High,Scaled Data Type,Clamp Low,Clamp High,Eng Units,Description\n";
	
	public LinkItemInput(ModbusItem item,String tag) {
		linkGroup=tag.replace("-", "_");
		name=item.getName();
		clientAccess=item.getAccess();
		dataType=item.getDataType();
		slaveAddress=linkGroup.replace("_", "-")+"."+linkGroup.replace("_", "-")+"."+item.getAddress();
		dcsAddressShort=dataType.contains("Bool")?
												(clientAccess.contains("RO")?Task.getRC().getRBit():Task.getRC().getWBit()):
														(clientAccess.contains("RO")?Task.getRC().getRReg():Task.getRC().getWReg());
		dcsAddress="DCS.DCS."+dcsAddressShort;
		
		itemID=clientAccess.contains("RO")?slaveAddress:dcsAddress;
		if(item.getIsScaled()) {
			scaling=item.getScale();
			rawLow=item.getRawLow();
			rawHigh=item.getRawHigh();
			scaledLow=item.getScaledLow();
			scaledHigh=item.getScaledHigh();
			scaledDataType=item.getScaledDataType();
			clampLow=item.getClampLow();
			clampHigh=item.getClampHigh();
		}
		linkItemOutput=new LinkItemOutput(linkGroup+"."+name, clientAccess.contains("RO")?dcsAddress:slaveAddress, dataType);
	}
	
	public LinkItemInput setItemID(String id) {
		itemID=id;
		return this;
	}
	
	
	public String toString() {
		list=new MyList(recordType,linkGroup,name,clientAccess,covOnly,machineName,serverName,accessPath,itemID,dataType,deadBandType,deadBand,deadBandLowRange,deadBandHighRange,
				scaling,rawLow,rawHigh,scaledLow,scaledHigh,scaledDataType,clampLow,clampHigh,engUnits,description);
		return list.toString();
	}

	public String getName() {
		return name;
	}

	public String getSlaveAddress() {
		return slaveAddress;
	}

	public String getDcsAddress() {
		return dcsAddress;
	}

	public void setSlaveAddress(String slaveAddress) {
		this.slaveAddress = slaveAddress;
	}

	public String getLinkGroup() {
		return linkGroup;
	}
}
