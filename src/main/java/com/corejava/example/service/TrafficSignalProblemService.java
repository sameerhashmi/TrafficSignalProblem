package com.corejava.example.service;

import java.util.function.BiConsumer;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.corejava.example.context.TrafficContext;
import com.corejava.example.context.impl.EastWestTrafficContext;
import com.corejava.example.context.impl.NorthSouthTrafficContext;
import com.corejava.example.domain.Directions;
import com.corejava.example.domain.EastBound;
import com.corejava.example.domain.NorthBound;
import com.corejava.example.domain.SouthBound;
import com.corejava.example.domain.WestBound;
import com.corejava.example.stratgey.impl.GreenLightStratgey;
import com.corejava.example.stratgey.impl.RedLightStratgey;

@Service
public class TrafficSignalProblemService {
	
	@Autowired
	private GreenLightStratgey greenLightStratgey;
	
	@Autowired
	private RedLightStratgey redLightStratgey;
	
	@Value("${traffic.red.light.frequency}")
	private int redLightFrequency;
	
	@Value("${traffic.operatrion.frequency}")
	private int trafficOperationFrequency;
	
	private boolean switchTrafficLight = true;
	
	/*
	 * This method initiates and handles the traffic signal
	 * for a direction. Either North South bound
	 * or East West Bound
	 */
	public void loadTrafficSignal() {
		// TODO Auto-generated method stub

		NorthSouthTrafficContext northSouthTrafficContext = null;
		EastWestTrafficContext eastWestTrafficContext = null;
		Function<Directions, String> contextOutput = d -> d.getDirection() + " = " + d.getCarCount() +" ;"; 

		for (int i = 0; i <= trafficOperationFrequency; i++) {
			if (i == 0) {
				eastWestTrafficContext = EastWestTrafficContext.builder()
						.eastBound(EastBound.builder().cars(0).build())
						.westBound(WestBound.builder().cars(0).build())
						.build();
				northSouthTrafficContext = NorthSouthTrafficContext.builder()
						.northBound(NorthBound.builder().cars(0).build())
						.southBound(SouthBound.builder().cars(0).build())
						.build();

			} else {
				startTrafficSignal(i,eastWestTrafficContext, northSouthTrafficContext);
			}
			
			System.out.println("Instance <" + i + "> | "
					+ contextOutput.apply(northSouthTrafficContext.getNorthBound())
					+ contextOutput.apply(northSouthTrafficContext.getSouthBound())
					+ contextOutput.apply(eastWestTrafficContext.getEastBound())
					+ contextOutput.apply(eastWestTrafficContext.getWestBound()));

		}

	}
	
	/*
	 * Handle and switch the traffic signals
	 */

	private void startTrafficSignal(int counter, EastWestTrafficContext eastWestTrafficContext,
			NorthSouthTrafficContext northSouthTrafficContext) {
		
		BiConsumer<TrafficContext, TrafficContext> handleTraffic = (c1,c2) -> {
			c1.execute(greenLightStratgey);
			c2.execute(redLightStratgey);
		};
		
		if (counter % redLightFrequency == 0) {
			switchTrafficLight = !switchTrafficLight;
			northSouthTrafficContext.execute(redLightStratgey);
			eastWestTrafficContext.execute(redLightStratgey);
			northSouthTrafficContext.refresh(greenLightStratgey);
			eastWestTrafficContext.refresh(greenLightStratgey);
		} else {
			
			if (switchTrafficLight) {
				handleTraffic.accept(northSouthTrafficContext,eastWestTrafficContext);
			} else {
				handleTraffic.accept(eastWestTrafficContext,northSouthTrafficContext);
			}
		}

	}

}
