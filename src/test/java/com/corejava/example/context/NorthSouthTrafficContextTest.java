package com.corejava.example.context;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.corejava.example.context.impl.NorthSouthTrafficContext;
import com.corejava.example.domain.NorthBound;
import com.corejava.example.domain.SouthBound;
import com.corejava.example.stratgey.impl.RedLightStratgey;

public class NorthSouthTrafficContextTest {
	
	@InjectMocks
	private NorthSouthTrafficContext context;
	
	@Before
	public void setup() {
		context = NorthSouthTrafficContext.builder()
				.northBound(NorthBound.builder().cars(0).build())
				.southBound(SouthBound.builder().cars(0).build())
				.build();
		MockitoAnnotations.initMocks(this);
		
	}
	
	@Test
	public void testEWTrafficContextExecute() {
		context.execute(new RedLightStratgey());
	}
	
	@Test
	public void testEWTrafficContextRefresh() {
		context.refresh(new RedLightStratgey());
	}

}
