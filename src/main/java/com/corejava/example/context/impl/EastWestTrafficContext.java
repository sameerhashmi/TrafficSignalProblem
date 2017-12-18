package com.corejava.example.context.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.corejava.example.context.TrafficContext;
import com.corejava.example.domain.EastBound;
import com.corejava.example.domain.WestBound;
import com.corejava.example.stratgey.TrafficSignalStrategy;

import lombok.Builder;
import lombok.Getter;


/*
 * This class holds the West Bound traffic as well as East Bound traffic 
 */
@Getter
@Builder
public class EastWestTrafficContext implements TrafficContext {

	@Autowired
	private TrafficSignalStrategy lightStratgey;
	
	private WestBound westBound;
	private EastBound eastBound;

	@Override
	public void execute(TrafficSignalStrategy trafficSignalStrategy) {
		trafficSignalStrategy.apply(westBound, eastBound);
		
	}

	@Override
	public void refresh(TrafficSignalStrategy trafficSignalStrategy) {
		trafficSignalStrategy.refresh();
		
	}


}
