package com.gladikov.application.entities.linkMaster;
import java.util.*;

import com.gladikov.application.util.MyBool;
import com.gladikov.application.util.MyList;

import lombok.Data;
import lombok.Getter;
@Data
public class LinkGroup {
	
	
	private String recordType="LINKGROUP";
	private String name;
	private Integer serverUpdateRate=1000;
	private String clientRefreshRate="0";
	private MyBool enableLinkTransfer=MyBool.init(true);
	private MyBool removeItemReference=MyBool.init(false);
	private String description="";
	private MyList list;
	@Getter
	private static String title=";\n;Link Group Definitions\n;\nRecord Type,Name,Server Update Rate, Client Refresh Rate,"
			+ "Enable Link Transfers, Remove Item References, Description\n";
	
	
	
	public LinkGroup(String name, String description) {
		this.name = name;
		this.description = description;
		list=new MyList(recordType,name,serverUpdateRate.toString(),clientRefreshRate,enableLinkTransfer.toStringNum(),removeItemReference.toStringNum(),description);
	}
	{
		
	}
	
	public String toString() {
		return list.toString();
	}


	
	

}
