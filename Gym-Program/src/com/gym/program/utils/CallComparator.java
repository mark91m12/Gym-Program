package com.gym.program.utils;

import java.util.Comparator;

import com.gym.program.logic.match.Lifter;

public class CallComparator implements Comparator<Lifter> {
	@Override
	public int compare(Lifter lifter1, Lifter lifter2) {
		
		int result = Double.compare(lifter1.getCurrentAttemptWeight(), lifter2.getCurrentAttemptWeight());
				
			if(result == 0){
				result = Integer.compare(lifter2.getWait(), lifter1.getWait());
			}
		
		return result;
	}
}