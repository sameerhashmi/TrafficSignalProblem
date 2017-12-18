package com.corejava.example.stratgey;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;

import com.corejava.example.domain.Directions;
import com.corejava.example.domain.EastBound;
import com.corejava.example.domain.NorthBound;
import com.corejava.example.domain.SouthBound;
import com.corejava.example.domain.WestBound;
import com.corejava.example.stratgey.impl.GreenLightStratgey;

public class GreenLightStratgeyTest {
	
	@InjectMocks
	private GreenLightStratgey greenLightStratgey;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		
	}
	
	@Test
	public void testApplyTrafficLightOpenAtStart() {
		Directions d1 = NorthBound.builder().cars(0).build();
		Directions d2 = SouthBound.builder().cars(0).build();
		greenLightStratgey.apply(d1,d2);
		
		assertEquals(d1.getCarCount().intValue(), 0);
		assertEquals(d2.getCarCount().intValue(), 0);
	}
	
	@Test
	public void testApplyTrafficLightClosed() {
		Directions d1 = NorthBound.builder().cars(5).build();
		Directions d2 = SouthBound.builder().cars(5).build();
		greenLightStratgey.apply(d1,d2);
		
		assertEquals(d1.getCarCount().intValue(), 6);
		assertEquals(d2.getCarCount().intValue(), 6);
	}
	
	@Test
	public void testApplyTrafficLightOpenWarmupStartedNSBound() {
		
		ReflectionTestUtils.setField(greenLightStratgey, "signalCount", new Integer(1));
		
		Directions d1 = NorthBound.builder().cars(5).build();
		Directions d2 = SouthBound.builder().cars(5).build();
		greenLightStratgey.apply(d1,d2);
		
		assertEquals(d1.getCarCount().intValue(), 6);
		assertEquals(d2.getCarCount().intValue(), 6);
	}
	
	@Test
	public void testApplyTrafficLightOpenWarmupStartedEWBound() {
		
		ReflectionTestUtils.setField(greenLightStratgey, "signalCount", new Integer(1));
		
		Directions d1 = EastBound.builder().cars(5).build();
		Directions d2 = WestBound.builder().cars(5).build();
		greenLightStratgey.apply(d1,d2);
		
		assertEquals(d1.getCarCount().intValue(), 6);
		assertEquals(d2.getCarCount().intValue(), 6);
	}
	
	@Test
	public void testApplyTrafficLightOpenWarmupDoneNSBound() {
		
		ReflectionTestUtils.setField(greenLightStratgey, "signalCount", new Integer(2));
		
		Directions d1 = NorthBound.builder().cars(5).build();
		Directions d2 = SouthBound.builder().cars(5).build();
		greenLightStratgey.apply(d1,d2);
		
		assertEquals(d1.getCarCount().intValue(), 5);
		assertEquals(d2.getCarCount().intValue(), 5);
	}
	
	@Test
	public void testApplyTrafficLightOpenWarmupDoneEWBound() {
		
		ReflectionTestUtils.setField(greenLightStratgey, "signalCount", new Integer(2));
		
		Directions d1 = EastBound.builder().cars(5).build();
		Directions d2 = WestBound.builder().cars(5).build();
		greenLightStratgey.apply(d1,d2);
		
		assertEquals(d1.getCarCount().intValue(), 5);
		assertEquals(d2.getCarCount().intValue(), 5);
	}
	
	
	@Test
	public void testRefresh() {
		
		ReflectionTestUtils.setField(greenLightStratgey, "signalCount", new Integer(5));
		greenLightStratgey.refresh();
		assertEquals(1,ReflectionTestUtils.getField(greenLightStratgey, "signalCount"));
		
	}


}
