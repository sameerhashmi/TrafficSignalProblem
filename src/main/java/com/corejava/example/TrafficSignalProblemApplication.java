package com.corejava.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class TrafficSignalProblemApplication {

	public static void main(String[] args) {
		log.info("Traffic Signal Problem Applcation is up.");
		SpringApplication.run(TrafficSignalProblemApplication.class, args);
	}
}
