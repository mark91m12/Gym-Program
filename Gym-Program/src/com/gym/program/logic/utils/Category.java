package com.gym.program.logic.utils;

public interface Category {

	public enum Age implements Category {
		SUB_JUNIOR, JUNIOR, SENIOR, MASTER1, MASTER2, MASTER3, MASTER4
	}

	public enum Weight implements Category {
		// female weights classes
		MINUS_43, MINUS_47, MINUS_52, MINUS_57, MINUS_63, MINUS_72, MINUS_84, PLUS_84,
		// male weights classes
		MINUS_53, MINUS_59, MINUS_66, MINUS_74, MINUS_83, MINUS_93, MINUS_105, MINUS_120, PLUS_120,
	}
}
