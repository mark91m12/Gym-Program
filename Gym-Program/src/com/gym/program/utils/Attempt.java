package com.gym.program.utils;

public interface Attempt {
	public enum StandardAttempt implements Attempt {
		FIRST, SECOND, THIRD
	}
	
	public enum BonusAttempt implements Attempt {
		DISPUTED, RECORD, GENERAL
	}
}
