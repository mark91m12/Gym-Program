package com.gym.program.logic.match;

import java.util.HashMap;
import java.util.Map;

import com.gym.program.logic.competitor.Competitor;
import com.gym.program.utils.Attempt;
import com.gym.program.utils.Category;
import com.gym.program.utils.Attempt.BonusAttempt;
import com.gym.program.utils.Attempt.StandardAttempt;
import com.gym.program.utils.Choice;
import com.gym.program.utils.LogicHelper;
import com.gym.program.utils.Sex;

public class Lifter {

	private double score;

	private Map<Attempt, Double> attemptsWeights;
	private Map<Attempt, Boolean> attemptsResults;
	private Attempt currentAttempt;

	private Competitor competitor;
	private Category category;

	private double rack_number;

	private Attempt bonusAttempt;
	
	private int wait;

	public Lifter(Competitor competitor, Choice choice) {
		this.competitor = competitor;
		this.setCategory(choice);
		this.attemptsWeights = new HashMap<Attempt, Double>();
		this.attemptsResults = new HashMap<Attempt, Boolean>();
		this.currentAttempt = Attempt.StandardAttempt.FIRST;
		this.bonusAttempt = null;
		this.wait = 0;
	}

	public double getRack_number() {
		return rack_number;
	}

	public void setRack_number(double rack_number) {
		this.rack_number = rack_number;
	}

	public void setCategory(Choice choice) {
		this.category = LogicHelper.getCategory(choice, this.competitor);

		if (this.competitor.isAbsolute_ranking()) {
			this.competitor.setCategory(this.category);
		}

	}
	
	public void incrementWait(){
		this.wait++;
	}
	
	public void resetWait(){
		this.wait=0;
	}
	
	public int getWait(){
		return this.wait;
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
		if (a != null) {
			if (a.equals(Attempt.BonusAttempt.GENERAL)) {
				a = bonusAttempt;
			}
			Boolean result = this.attemptsResults.get(a);
			return result;// ==null?false:result;
		}
		return null;
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

			if (!this.currentAttempt.equals(Attempt.BonusAttempt.RECORD)) {
				double score = LogicHelper.getWilksResult(this.getCompetitor().getWeight(),
						this.getCurrentAttemptWeight(), this.getCompetitor().getSex());
				this.setScore(score);
				this.getCompetitor().setScore(this.competitor.getScore() + score);
			}
		}
	}

	private boolean setNextCurrentAttempt() {

		if (this.currentAttempt instanceof StandardAttempt) {
			switch ((StandardAttempt) this.currentAttempt) {
			case FIRST:
				this.currentAttempt = Attempt.StandardAttempt.SECOND;
				return true;
			case SECOND:
				this.currentAttempt = Attempt.StandardAttempt.THIRD;
				return true;
			case THIRD:
				if (hasBonusAttempt()) {
					this.currentAttempt = getBonusAttemptType();
					return true;
				} else {
					return false;
				}
			default:
				return false;
			}
		}
		return false;
	}

	public boolean hasMoreLift() {
		if ((this.currentAttempt.equals(Attempt.StandardAttempt.THIRD) && !hasBonusAttempt())
				|| this.currentAttempt instanceof Attempt.BonusAttempt) {
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

	public boolean hasBonusAttempt() {
		return !(bonusAttempt == null);
	}

	public void setBonusAttemptType(BonusAttempt ba) {
		this.bonusAttempt = ba;
	}

	public Attempt getBonusAttemptType() {
		return bonusAttempt;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((competitor == null) ? 0 : competitor.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lifter other = (Lifter) obj;
		if (competitor == null) {
			if (other.competitor != null)
				return false;
		} else if (!competitor.equals(other.competitor))
			return false;
		return true;
	}

	// public Attempt getPreviousAttempt() {
	// if(this.currentAttempt instanceof StandardAttempt) {
	// switch ((StandardAttempt)this.currentAttempt) {
	// case FIRST:
	// return null;
	// case SECOND:
	// return Attempt.StandardAttempt.FIRST;
	// case THIRD:
	// return Attempt.StandardAttempt.SECOND;
	// default:
	// return null;
	// }
	// }else if (this.currentAttempt instanceof BonusAttempt) {
	// return Attempt.StandardAttempt.THIRD;
	// }
	// return null;
	// }
	//
	// public Double getPreviousAttemptWeight() {
	// if(currentAttempt.equals(Attempt.StandardAttempt.FIRST)) {
	// return getCurrentAttemptWeight();
	// }
	// return this.getAttemptWeight(getPreviousAttempt());
	// }
	//
	// public Boolean getPreviousAttemptResult() {
	// if(currentAttempt.equals(Attempt.StandardAttempt.FIRST)) {
	// return getCurrentAttemptResult();
	// }
	// return this.getAttemptResult(getPreviousAttempt());
	// }
}
