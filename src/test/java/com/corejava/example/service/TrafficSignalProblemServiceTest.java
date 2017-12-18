package com.corejava.example.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;

import com.corejava.example.stratgey.impl.GreenLightStratgey;
import com.corejava.example.stratgey.impl.RedLightStratgey;

public class TrafficSignalProblemServiceTest {
	
	@InjectMocks
	private TrafficSignalProblemService trafficSignalProblemService;
	
	@Mock
	private GreenLightStratgey greenLightStratgey;
	
	@Mock
	private RedLightStratgey redLightStratgey;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		ReflectionTestUtils.setField(trafficSignalProblemService, "redLightFrequency", new Integer(4));
		ReflectionTestUtils.setField(trafficSignalProblemService, "trafficOperationFrequency", new Integer(20));
	}
	
	@Test
	public void testLoadTrafficSignal() {
		trafficSignalProblemService.loadTrafficSignal();
	}

}
