package com.corejava.example.context;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.corejava.example.context.impl.EastWestTrafficContext;
import com.corejava.example.domain.EastBound;
import com.corejava.example.domain.WestBound;
import com.corejava.example.stratgey.impl.RedLightStratgey;

public class EastWestTrafficContextTest {
	
	@InjectMocks
	private EastWestTrafficContext context;
	
	@Before
	public void setup() {
		context = EastWestTrafficContext.builder()
				.eastBound(EastBound.builder().cars(0).build())
				.westBound(WestBound.builder().cars(0).build())
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
