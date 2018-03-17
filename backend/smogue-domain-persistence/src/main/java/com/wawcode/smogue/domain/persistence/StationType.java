package com.wawcode.smogue.domain.persistence;

public enum StationType {
	GIOS("GIOS");

	private String type;

	StationType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	@Override
	public String toString() {
		return type;
	}
}


