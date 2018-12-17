package com.gym.program.logic.match;

import com.gym.program.logic.competitor.Competitor;

public class Lifter {

	private double first_lift;
	private double second_lift;
	private double third_lift;

	private boolean good_first;
	private boolean good_second;
	private boolean good_third;

	private Competitor competitor;

	public Lifter(Competitor competitor, double first) {
		this.competitor = competitor;
		this.setFirstLift(first);
	}

	public double getFirstLift() {
		return first_lift;
	}

	public void setFirstLift(double first_lift) {
		this.first_lift = first_lift;
	}

	public double getSecondLift() {
		return second_lift;
	}

	public void setSecondLift(double second_lift) {
		this.second_lift = second_lift;
	}

	public double getThirdLift() {
		return third_lift;
	}

	public void setThirdLift(double third_lift) {
		this.third_lift = third_lift;
	}

	public boolean isGoodFirst() {
		return good_first;
	}

	public void setGoodFirst(boolean good_first) {
		this.good_first = good_first;
	}

	public boolean isGoodSecond() {
		return good_second;
	}

	public void setGoodSecond(boolean good_second) {
		this.good_second = good_second;
	}

	public boolean isGoodThird() {
		return good_third;
	}

	public void setGoodThird(boolean good_third) {
		this.good_third = good_third;
	}

	public Competitor getCompetitor() {
		return competitor;
	}

	public void setCompetitor(Competitor competitor) {
		this.competitor = competitor;
	}

}
