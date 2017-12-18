package com.corejava.example.controller;

import javax.inject.Inject;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.corejava.example.service.TrafficSignalProblemService;

@RestController
public class TrafficSignalController {
	
	@Inject
	private TrafficSignalProblemService trafficSignalProblemService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<String> initiateTrafficSignal(){
		
		trafficSignalProblemService.loadTrafficSignal();
		return ResponseEntity.ok("Traffic Signal Initiated");
	}

}
