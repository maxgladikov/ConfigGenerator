package com.gladikov.application.util;

public class RegCounter {
	private Integer rreg = 0;
	private Integer rbit = 0;
	private Integer wreg = 0;
	private Integer wbit = 0;
	private Boolean flag = false;

	public RegCounter(int rreg, int wreg) {
		this.rreg = rreg;
		this.wreg = wreg;
	}

	public String getRBit() {
		flag=(rbit==15)?false:true;
		return rbit==15?
					(rreg++).toString() + "." + resetRBit().toString():
										rreg.toString() + "." + (rbit++).toString();
				
	}


	public String getRReg() {
		rreg=(flag==true)?++rreg:rreg;
		flag=false;
		rbit = 0;
		return (rreg++).toString();
	}

	public String getWBit() {
		return wbit==15?
				(wreg++).toString() + "." + resetWBit().toString():
									wreg.toString() + "." + (wbit++).toString();
	}

	public String getWReg() {
		wbit = 0;
		return (wreg++).toString();
	}

	private Integer resetRBit() {
		rbit=0;
		return 15;
	}
	private Integer resetWBit() {
		wbit=0;
		return 15;
	}
	public void next() {
		if(rbit!=0) {
		rbit=0;
		rreg++;}
	}
}
