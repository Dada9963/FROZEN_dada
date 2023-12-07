package com.frozen.fkp.topInfo;

public class TopInfo {
	private String nameResult;
	private String imgResult;
	private String address;
	
	public TopInfo() {
		// TODO Auto-generated constructor stub
	}

	public TopInfo(String nameResult, String imgResult, String address) {
		super();
		this.nameResult = nameResult;
		this.imgResult = imgResult;
		this.address = address;
	}

	public String getNameResult() {
		return nameResult;
	}

	public void setNameResult(String nameResult) {
		this.nameResult = nameResult;
	}

	public String getImgResult() {
		return imgResult;
	}

	public void setImgResult(String imgResult) {
		this.imgResult = imgResult;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
}
