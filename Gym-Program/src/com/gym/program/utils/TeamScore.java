package com.gym.program.utils;

public class TeamScore {

	private String name;
	private double score;

	public TeamScore(String name, double score) {
		this.name = name;
		this.score =  LogicHelper.rounded(score);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = LogicHelper.rounded(score);
	}

}
