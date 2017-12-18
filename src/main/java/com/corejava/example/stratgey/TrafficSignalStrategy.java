package com.corejava.example.stratgey;

import java.util.function.BiFunction;

import org.springframework.stereotype.Component;

import com.corejava.example.domain.Directions;

@Component
public interface TrafficSignalStrategy extends BiFunction<Directions, Directions, String> {

	void refresh();
	String apply(Directions d1, Directions d2);
}
