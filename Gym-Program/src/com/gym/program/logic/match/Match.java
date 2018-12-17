package com.gym.program.logic.match;

import java.util.ArrayList;
import java.util.List;

import com.gym.program.logic.competitor.Competitor;

public class Match {

	public enum TypeOfMatch {
		BENCHPRESS, SQUAT, DEADLIFT
	}

	private List<Lifter> lifters;
	private TypeOfMatch type;
	private MatchRanking matchRanking;

	public Match(TypeOfMatch type) {
		this.lifters = new ArrayList<>();
		this.setType(type);
		this.matchRanking = new MatchRanking();
	}

	public TypeOfMatch getType() {
		return this.type;
	}

	public void setType(TypeOfMatch type) {
		this.type = type;
	}

	public List<Lifter> getLifters() {
		return this.lifters;
	}

	public void setLifters(List<Lifter> lifters) {
		this.lifters = lifters;
	}

	@SuppressWarnings("unchecked")
	public void signUp(Competitor competitor, Choice choice, double first_lift) {

		// set choice for category
		competitor.getMap().put(this.type, choice);
		// set first lift
		Lifter lifter = new Lifter(competitor, first_lift, choice);
		this.lifters.add(lifter);
		this.matchRanking.addLifter(lifter);
	}

}
