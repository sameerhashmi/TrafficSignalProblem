package com.corejava.example.stratgey.impl;

import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import com.corejava.example.domain.Directions;
import com.corejava.example.stratgey.TrafficSignalStrategy;

@Component
public class GreenLightStratgey implements TrafficSignalStrategy {
	
	private int signalCount = 1;
	
	/*
	 * (non-Javadoc)
	 * @see com.corejava.example.stratgey.TrafficSignalStrategy#apply(com.corejava.example.domain.Directions, com.corejava.example.domain.Directions)
	 * Rules for the green traffic light to work
	 *  - if car count == 0 means traffic light was open before the car came, so it can be added to the queue and removed in same instance
	 *  - Add car to the lane only if the traffic lights were closed in earlier state (car count > 0).
	 *  - Let the car go once the signal count > 1 means the first car to leave has to warm up and leave in second instance
	 */
	@Override
	public String apply(Directions d1, Directions d2) {
		
		Predicate<Directions> trafficLightClosedAtStart = d -> !d.getCarCount().equals(0);
		Predicate<Integer> firstCarStartAndMoving = d -> d > 1;
		 
		if(trafficLightClosedAtStart.test(d1)) {
			d1.addCarToQueue();
			d2.addCarToQueue();

			if(firstCarStartAndMoving.test(signalCount)) {
				d1.go();
				d2.go();
			}
		}
		
		signalCount++;
		return "Strategy Applied";
	}

	/*
	 * (non-Javadoc)
	 * @see com.corejava.example.stratgey.TrafficSignalStrategy#refresh()
	 * Refersh the signal count everytime the stratgey is flipped to Red
	 */
	@Override
	public void refresh() {
		signalCount = 1;
	}

}
