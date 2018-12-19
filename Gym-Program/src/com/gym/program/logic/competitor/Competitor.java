package com.gym.program.logic.competitor;

import java.util.HashMap;
import java.util.Map;

import com.gym.program.logic.match.Match.TypeOfMatch;
import com.gym.program.logic.utils.Choice;
import com.gym.program.logic.utils.Sex;

public class Competitor {

	private String name;
	private String surname;
	private double weight;
	private int age;
	private Sex sex;
	private String team;
	private Map map;

	public Competitor(String name, String surname, Sex sex, String team, double weight, int age) {
		this.setName(name);
		this.setSurname(surname);
		this.setSex(sex);
		this.setTeam(team);
		this.setWeight(weight);
		this.setAge(age);

		this.map = new HashMap<TypeOfMatch, Choice>();

	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public double getWeight() {
		return this.weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Sex getSex() {
		return this.sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public String getTeam() {
		return this.team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public Map getMap() {
		return this.map;
	}

	public void setMap(Map map) {
		this.map = map;
	}

	@Override
	public String toString() {
		return "Competitor [name=" + this.name + ", surname=" + this.surname + ", weight=" + this.weight + ", age="
				+ this.age + ", sex=" + this.sex + ", team=" + this.team + ", map=" + this.map + "]";
	}

}