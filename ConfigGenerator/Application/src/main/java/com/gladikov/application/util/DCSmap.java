package com.gladikov.application.util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.gladikov.application.entities.linkMaster.LinkItemInput;

import utils.ProcessorCSV;


public class DCSmap {
	
	private List<String> map=new ArrayList<String>();
	private Comparator<LinkItemInput> comparator=Comparator.comparing(LinkItemInput::getLinkGroup).
			thenComparing(LinkItemInput::getClientAccess).thenComparing(LinkItemInput::getDataType);
	
	
	public void add(List<LinkItemInput> list ) {
		list.stream().sorted(comparator)
		.forEach(x->map.add(x.getLinkGroup()+","+x.getName()+","+(x.getDataType().contains("Bool")?"Bool":"Word")+","+x.getClientAccess()+","+x.getDcsAddressShort()+"_"+'\n'));
		
	}
	
	public void getMap(String where) {
		StringBuilder sb=new StringBuilder();
		map.stream().forEach(x->sb.append(x));
		ProcessorCSV.write(where, sb.toString());
	}

}
