package com.corejava.example.stratgey;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;

import com.corejava.example.domain.Directions;
import com.corejava.example.domain.NorthBound;
import com.corejava.example.domain.SouthBound;
import com.corejava.example.stratgey.impl.RedLightStratgey;

public class RedLightStratgeyTest {
	
	@InjectMocks
	private RedLightStratgey redLightStratgey;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testApply() {
		Directions d1 = NorthBound.builder().cars(1).build();
		Directions d2 = SouthBound.builder().cars(4).build();
		redLightStratgey.apply(d1,d2);
		
		assertEquals(d1.getCarCount().intValue(), 2);
		assertEquals(d2.getCarCount().intValue(), 5);
	}
	

	@Test
	public void testRefresh() {
		redLightStratgey.refresh();
	}

}
