package com.gladikov.application.entities.linkMaster;

import com.gladikov.application.util.MyList;

import lombok.Getter;

public class LinkItemOutput {
	private String recordType="LINKITEMOUTPUT";
	private String linkItem;
	private String machineName="Local Machine";
	private String serverName="Kepware.KEPServerEX.V6";
	private String accessPath="";
	private String itemID;
	private String dataType;
	private MyList list;
	@Getter
	private static String title=";\n;Link Item Output Definitions\n;\nRecord Type,Link Item,Machine Name,Server Name,Access Path, Item ID,Data Type\n";
	
	
		
	public LinkItemOutput(String linkItem, String itemID, String dataType) {
		super();
		this.linkItem = linkItem;
		this.itemID = itemID;
		this.dataType = dataType;
	}



	public String toString() {
		list=new MyList(recordType,linkItem,machineName,serverName,accessPath,itemID,dataType);
		return list.toString();
	}

}
