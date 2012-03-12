package org.pan.linkedin.search;

public enum DatePosted {
	
	ANY_TIME("select-all"),
	DAY_AGO_1("1"),
	DAYS_AGO_2_7("2"),
	DAYS_AGO_8_14("3"),
	DAYS_AGO_15_30("4");
	
	private String value;
	
	private DatePosted(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
