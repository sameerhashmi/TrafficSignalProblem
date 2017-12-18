package com.corejava.example.enums;

public enum DirectionsEnum {
	
	NORTH("NORTH-BOUND", "N"),
	SOUTH("SOUTH-BOUND", "S"),
	EAST("EAST-BOUND", "E"),
	WEST("WEST-BOUND", "W");
	
	private String desc;
	private String direction;

	private DirectionsEnum(String _desc, String _direction) {
		this.desc = _desc;
		this.direction = _direction;
	}
	
	public String getDirection() {
		return this.direction;
	}
	
	public String getDirectionDesc() {
		return this.desc;
	}
	
}
