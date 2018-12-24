package com.gym.program.utils;

import java.util.Comparator;

import com.gym.program.logic.match.Lifter;

public class CallComparator implements Comparator<Lifter> {
	@Override
	public int compare(Lifter lifter1, Lifter lifter2) {
		return Double.compare(lifter1.getCurrentAttemptWeight(), lifter2.getCurrentAttemptWeight());
	}
}