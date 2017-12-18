package com.corejava.example.stratgey.impl;

import org.springframework.stereotype.Component;

import com.corejava.example.domain.Directions;
import com.corejava.example.stratgey.TrafficSignalStrategy;

@Component
public class RedLightStratgey implements TrafficSignalStrategy {

	/*
	 * (non-Javadoc)
	 * @see com.corejava.example.stratgey.TrafficSignalStrategy#apply(com.corejava.example.domain.Directions, com.corejava.example.domain.Directions)
	 * Rule for the Red light to work
	 * 	- on the current instance, all cars in either directions should be added to the queue
	 */
	@Override
	public String apply(Directions d1, Directions d2) {
		d1.addCarToQueue();
		d2.addCarToQueue();
		return "Strategy Applied";
	}

	@Override
	public void refresh() {
	}

}
