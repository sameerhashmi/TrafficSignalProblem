package com.corejava.example.context.impl;

import com.corejava.example.context.TrafficContext;
import com.corejava.example.domain.NorthBound;
import com.corejava.example.domain.SouthBound;
import com.corejava.example.stratgey.TrafficSignalStrategy;

import lombok.Builder;
import lombok.Getter;


/*
 * This class holds the North Bound traffic as well as South Bound traffic 
 */
@Getter
@Builder
public class NorthSouthTrafficContext implements TrafficContext {
	
	private NorthBound northBound;
	private SouthBound southBound;
	
	@Override
	public void execute(TrafficSignalStrategy trafficSignalStrategy) {
		trafficSignalStrategy.apply(northBound, southBound);
		
	}

	@Override
	public void refresh(TrafficSignalStrategy trafficSignalStrategy) {
		trafficSignalStrategy.refresh();
	}

}
