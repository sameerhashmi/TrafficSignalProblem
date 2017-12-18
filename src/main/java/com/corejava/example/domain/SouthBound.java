package com.corejava.example.domain;

import com.corejava.example.enums.DirectionsEnum;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
public class SouthBound implements Directions{
	
	private Integer cars  = 0;

	@Override
	public String getDirection() {
		// TODO Auto-generated method stub
		return DirectionsEnum.SOUTH.getDirection();
	}

	@Override
	public Integer getCarCount() {
		// TODO Auto-generated method stub
		return getCars();
	}
	
	@Override
	public void addCarToQueue() {
		// TODO Auto-generated method stub
		cars+=1;
	}

	@Override
	public void go() {
		// TODO Auto-generated method stub
		cars-=1;
	}
}
