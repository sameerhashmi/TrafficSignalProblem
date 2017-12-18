package com.corejava.example.context;

import com.corejava.example.stratgey.TrafficSignalStrategy;

public interface TrafficContext {
	public void refresh(TrafficSignalStrategy trafficSignalStrategy);
	public void execute(TrafficSignalStrategy trafficSignalStrategy);

}
