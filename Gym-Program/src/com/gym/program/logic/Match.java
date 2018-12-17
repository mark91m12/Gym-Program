package com.gym.program.logic;

import java.util.List;

import com.gym.program.logic.competitor.Competitor;

enum TypeOfMatch {
	BENCHPRESS, SQUAT, DEADLIFT
}

public class Match {

	private List<Competitor> competitors;
	private TypeOfMatch type;
	private Ranking ranking;

}
