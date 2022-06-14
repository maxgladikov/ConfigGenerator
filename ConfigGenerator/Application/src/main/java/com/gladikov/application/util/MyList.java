package com.gladikov.application.util;
import java.util.Arrays;
import java.util.List;

public class MyList {
	private List<String> list;
	
	public MyList(String... in) {
		list=Arrays.asList(in);
	}

	
	
	public String toString(){
		StringBuilder row=new StringBuilder();
		if(list != null && list.size() > 0) {
			
			for (int i=0;i<list.size()-1;i++) {
				row.append(list.get(i));
				row.append(",");
			}
			row.append(list.get(list.size() - 1));
			row.append("\n");		
			return row.toString();
		}
		else {
			return "\n";
		}
		
	}
}
