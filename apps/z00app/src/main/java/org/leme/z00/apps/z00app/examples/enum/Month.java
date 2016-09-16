package com.pointclickcare.lunchandlearn;

public enum Month {
	
	JANUARY(1, "Jan"),
	FEBRUARY(2, "Feb");
	
	private int number;
	private String shortName;
	
	private Month(int number, String shortName ) {
		this.number = number;
		this.shortName = shortName;
	}

	public int getNumber() {
		return number;
	}

	public String getShortName() {
		return shortName;
	}
}
