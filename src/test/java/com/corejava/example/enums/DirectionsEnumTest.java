package com.corejava.example.enums;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DirectionsEnumTest {
	
	@Test
	public void testGetDirection() {
		String direction = DirectionsEnum.EAST.getDirection();
		assertEquals(direction, "E");
	}
	
	@Test
	public void testGetDirectionDesc() {
		String direction = DirectionsEnum.EAST.getDirectionDesc();
		assertEquals(direction, "EAST-BOUND");
	}

}
