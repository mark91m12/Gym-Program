package com.gym.program.logic.utils;

import java.util.Comparator;

import com.gym.program.logic.match.Lifter;

public class CallComparator implements Comparator<Lifter> {
	public int compare(Lifter lifter1, Lifter lifter2) {
		return Double.compare(lifter1.getFirstLift(),lifter2.getFirstLift());
	}
}