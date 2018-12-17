package com.gym.program.logic;

import java.util.List;

enum TypeOfMatch {
	BENCHPRESS, SQUAT, DEADLIFT
}

public class Match {

	private List<Competitor> competitors;
	private TypeOfMatch type;
	private Ranking ranking;

}
