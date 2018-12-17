package com.gym.program.logic.match;

import java.util.ArrayList;
import java.util.List;

import com.gym.program.logic.competitor.Competitor;
import com.gym.program.logic.competitor.Competitor.Choice;

public class Match {

	public enum TypeOfMatch {
		BENCHPRESS, SQUAT, DEADLIFT
	}

	private List<Lifter> lifters;
	private TypeOfMatch type;
	// private List<Ranking> ranking;

	public Match(TypeOfMatch type) {
		lifters = new ArrayList<Lifter>();
		this.setType(type);
	}

	public TypeOfMatch getType() {
		return type;
	}

	public void setType(TypeOfMatch type) {
		this.type = type;
	}

	public List<Lifter> getLifters() {
		return lifters;
	}

	public void setLifters(List<Lifter> lifters) {
		this.lifters = lifters;
	}

	@SuppressWarnings("unchecked")
	public void signUp(Competitor competitor, Choice choice, double first_lift) {

		// set choice for category
		competitor.getMap().put(this.type, choice);
		// set first lift
		Lifter lifter = new Lifter(competitor, first_lift);

		this.lifters.add(lifter);
	}

}
