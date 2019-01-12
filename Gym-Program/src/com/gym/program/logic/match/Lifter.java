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
import com.gym.program.utils.Sex;

public class Lifter {

	private double score;

	private double bestAttemptWeight;
	
	private Map<Attempt, Double> attemptsWeights;
	private Map<Attempt, Boolean> attemptsResults;
	private Attempt currentAttempt;

	private Competitor competitor;
	private Category category;
	
	private double rack_number;

	private boolean hasBonusAttempt;
	
	public Lifter(Competitor competitor, Choice choice) {
		this.competitor = competitor;
		this.setCategory(choice);
		this.attemptsWeights = new HashMap<Attempt, Double>();
		this.attemptsResults = new HashMap<Attempt, Boolean>();
		this.currentAttempt = Attempt.FIRST;
		this.bestAttemptWeight = 0;
		this.hasBonusAttempt = false;
	}

	public double getRack_number() {
		return rack_number;
	}

	public void setRack_number(double rack_number) {
		this.rack_number = rack_number;
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

		this.score = LogicHelper.rounded(score);
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

	public Boolean getCurrentAttemptResult() {
		return this.getAttemptResult(this.currentAttempt);
	}
	
	public void setCurrentAttemptResult(boolean result) {
		this.setAttemptResult(this.currentAttempt, result);
		// this.setNextCurrentAttempt();
		if (result) {
			this.setScore(LogicHelper.getWilksResult(this.getCompetitor().getWeight(), this.getCurrentAttemptWeight(),
					this.getCompetitor().getSex()));
			this.setBestAttemptWeight(getCurrentAttemptWeight());
		}
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
			if(hasBonusAttempt) {
				this.currentAttempt = Attempt.BONUS;
				return true;
			}else {
				return false;
			}
		case BONUS:
			return false;
		default:
			return false;
		}
	}

	public boolean hasMoreLift() {
		if ((this.currentAttempt.equals(Attempt.THIRD) && !hasBonusAttempt) || this.currentAttempt.equals(Attempt.BONUS)) {
			return false;
		}
		return true;
	}

	public boolean hasFinished() {
		return !hasMoreLift() && (this.getAttemptResult(this.currentAttempt) != null);
	}

	public Attempt getCurrentAttempt() {
		return this.currentAttempt;
	}

	public void setCurrentAttempt(Attempt currentAttempt) {
		this.currentAttempt = currentAttempt;
	}
	
	public double getBestAttemptWeight() {
		return bestAttemptWeight;
	}

	public void setBestAttemptWeight(double bestAttemptWeight) {
		this.bestAttemptWeight = bestAttemptWeight;
	}

	public boolean hasBonusAttempt() {
		return hasBonusAttempt;
	}

	public void setBonusAttempt() {
		if(!hasBonusAttempt) {
			this.hasBonusAttempt = true;
		}
	}
}
