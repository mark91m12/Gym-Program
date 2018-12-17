package com.gym.program.logic.match;

import java.util.List;

import com.gym.program.logic.competitor.Competitor;
import com.gym.program.logic.competitor.Competitor.Choice;

public class Match {

	public enum TypeOfMatch {
		BENCHPRESS, SQUAT, DEADLIFT
	}

	private List<Lifter> lifters;
	private TypeOfMatch type;
	private List<Ranking> ranking;
	
	public Match(){
		
	}

	public TypeOfMatch getType() {
		return type;
	}

	public void setType(TypeOfMatch type) {
		this.type = type;
	}

	@SuppressWarnings("unchecked")
	public void signUp(Competitor competitor, Choice choice,double first_lift) {
		
		// set choice for category
		competitor.getMap().put(this.type, choice);
		// set first lift 
		Lifter lifter = new Lifter(competitor,first_lift);
		
		this.lifters.add(lifter);
	}

}
