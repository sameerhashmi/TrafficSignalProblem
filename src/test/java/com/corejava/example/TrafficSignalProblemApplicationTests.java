package com.corejava.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.corejava.example.TrafficSignalProblemApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TrafficSignalProblemApplication.class)
public class TrafficSignalProblemApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void applicationStarts() {
		TrafficSignalProblemApplication.main(new String[] {});
	}

}
