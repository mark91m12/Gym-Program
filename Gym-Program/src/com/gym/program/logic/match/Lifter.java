package com.gym.program.logic.match;

import java.util.HashMap;
import java.util.Map;

import com.gym.program.logic.competitor.Competitor;
import com.gym.program.utils.Attempt;
import com.gym.program.utils.Category;
import com.gym.program.utils.Category.Age;
import com.gym.program.utils.Category.Weight;
import com.gym.program.utils.Choice;
import com.gym.program.utils.LogicHelper;

public class Lifter {

	private double score;

	private Map<Attempt, Double> attemptsWeights;
	private Map<Attempt, Boolean> attemptsResults;
	private Attempt currentAttempt;

	private Competitor competitor;
	private Category category;

	public Lifter(Competitor competitor, Choice choice) {
		this.competitor = competitor;
		this.setCategory(choice);
		this.attemptsWeights = new HashMap<Attempt, Double>();
		this.attemptsResults = new HashMap<Attempt, Boolean>();
		this.currentAttempt = Attempt.FIRST;
	}

	public void setCategory(Choice choice) {
		this.category = LogicHelper.getCategory(choice, this.competitor);

	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public double getScore() {
		return (Double) score == null ? 0.0 : score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public Double getAttemptWeight(Attempt a) {
		Double weight = this.attemptsWeights.get(a);
		return weight == null ? 0.0 : weight;
	}

	public void setAttemptWeight(Attempt a, double weight) {
		this.attemptsWeights.put(a, weight);
	}

	public Boolean getAttemptResult(Attempt a) {
		Boolean result = this.attemptsResults.get(a);
		return result;// ==null?false:result;
	}

	public void setAttemptResult(Attempt a, boolean result) {
		this.attemptsResults.put(a, result);
	}

	@Override
	public String toString() {
		return "Lifter [score=" + this.score + ", attemptsWeights=" + this.attemptsWeights + ", attemptsResults="
				+ this.attemptsResults + ", competitor=" + this.competitor + ", category=" + this.category + "]";
	}

	public Competitor getCompetitor() {
		return this.competitor;
	}

	public void setCompetitor(Competitor competitor) {
		this.competitor = competitor;
	}

	public boolean setNextAttemptWeight(double weight) {
		if (this.setNextCurrentAttempt()) {
			this.setAttemptWeight(this.currentAttempt, weight);
			return true;
		} else {
			return false;
		}
	}

	public double getCurrentAttemptWeight() {
		return this.getAttemptWeight(this.currentAttempt);
	}

	public void setCurrentAttemptResult(boolean result) {
		this.setAttemptResult(this.currentAttempt, result);
		this.setNextCurrentAttempt();
	}

	private boolean setNextCurrentAttempt() {
		switch (this.currentAttempt) {
		case FIRST:
			this.currentAttempt = Attempt.SECOND;
			return true;
		case SECOND:
			this.currentAttempt = Attempt.THIRD;
			return true;
		case THIRD:
			return false;
		default:
			return false;
		}
	}

	public boolean hasMoreLift() {
		if (this.currentAttempt.equals(Attempt.THIRD))
			return false;
		return true;
	}

	public Attempt getCurrentAttempt() {
		return this.currentAttempt;
	}

	public void setCurrentAttempt(Attempt currentAttempt) {
		this.currentAttempt = currentAttempt;
	}
}
