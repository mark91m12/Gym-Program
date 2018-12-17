package com.gym.program.logic;

import java.util.List;

import com.gym.program.logic.competitor.Competitor;
import com.gym.program.logic.competitor.Competitor.Choice;

public class Match {

	public enum TypeOfMatch {
		BENCHPRESS, SQUAT, DEADLIFT
	}

	private List<Competitor> competitors;
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
	public void signUp(Competitor competitor, Choice choice) {
		competitor.getMap().put(this.type, choice);
		this.competitors.add(competitor);
	}

}
