package com.gym.program.logic.competitor;

import com.gym.program.utils.Sex;

public class CompetitorBuilder {

	private String name;
	private String surname;
	private double weight;
	private int age;
	private Sex sex;
	private String team;
	private boolean absolute_ranking = false;

	private CompetitorBuilder() {
	}

	public static CompetitorBuilder newBuilder() {
		return new CompetitorBuilder();
	}

	public CompetitorBuilder setName(String name) {
		this.name = name;
		return this;
	}

	public CompetitorBuilder setSurname(String surname) {
		this.surname = surname;
		return this;
	}

	public CompetitorBuilder setSex(Sex sex) {
		this.sex = sex;
		return this;
	}

	public CompetitorBuilder setAge(int age) {
		this.age = age;
		return this;
	}

	public CompetitorBuilder setWeight(double weight) {
		this.weight = weight;
		return this;
	}

	public CompetitorBuilder setTeam(String team) {
		this.team = team;
		return this;
	}

	public CompetitorBuilder setAbsoluteRanking(boolean b) {
		this.absolute_ranking = b;
		return this;
	}

	public Competitor build() {
		return new Competitor(this.name, this.surname, this.sex, this.team, this.weight, this.age,
				this.absolute_ranking);
	}

}
