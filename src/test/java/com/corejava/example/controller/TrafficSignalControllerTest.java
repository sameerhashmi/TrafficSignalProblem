package com.corejava.example.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.corejava.example.service.TrafficSignalProblemService;

@RunWith(SpringRunner.class)
@WebMvcTest(value=TrafficSignalController.class, secure = false)
//@ContextConfiguration(classes= {TrafficSignalProblemApplication.class})
public class TrafficSignalControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private TrafficSignalProblemService trafficSignalProblemService;
		
	@Test
	public void testLoadTrafficSignal() throws Exception {
		
		Mockito.doNothing().when(trafficSignalProblemService).loadTrafficSignal();
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println(result.getResponse());
		assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
		
	}

}
