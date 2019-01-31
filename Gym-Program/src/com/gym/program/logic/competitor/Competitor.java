package com.gym.program.logic.competitor;

import java.util.HashMap;
import java.util.Map;

import com.gym.program.logic.match.Match.TypeOfMatch;
import com.gym.program.utils.Category;
import com.gym.program.utils.Choice;
import com.gym.program.utils.Sex;
import com.gym.program.utils.LogicHelper;

public class Competitor {

	private String name;
	private String surname;
	private double weight;
	private int age;
	private Sex sex;
	private String team;
	private Category age_class;
	private Category weight_class;
	private Map<TypeOfMatch, Choice> map;
	private double score;
	private boolean absolute_ranking;
	private Category category;

	 

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public boolean isAbsolute_ranking() {
		return absolute_ranking;
	}

	public void setAbsolute_ranking(boolean absolute_ranking) {
		this.absolute_ranking = absolute_ranking;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public Competitor(String name, String surname, Sex sex, String team, double weight, int age,boolean absolute) {
		this.setName(name);
		this.setSurname(surname);
		this.setSex(sex);
		this.setTeam(team);
		this.setWeight(weight);
		this.setAge(age);

		this.setAge_class();
		this.setWeight_class();
		
		this.score = 0;
		this.absolute_ranking = absolute;

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

	public Map<TypeOfMatch, Choice> getMap() {
		return this.map;
	}

	public void setMap(Map<TypeOfMatch, Choice> map) {
		this.map = map;
	}

	@Override
	public String toString() {
		return "Competitor [name=" + this.name + ", surname=" + this.surname + ", weight=" + this.weight + ", age="
				+ this.age + ", sex=" + this.sex + ", team=" + this.team + ", map=" + this.map + "]";
	}

	public Category getAge_class() {
		return age_class;
	}

	private void setAge_class() {
		this.age_class = LogicHelper.getCategory(Choice.CLSS_AGE, this);
	}

	public Category getWeight_class() {
		return weight_class;
	}

	private void setWeight_class() {
		this.weight_class = LogicHelper.getCategory(Choice.CLSS_WEIGHT, this);
		System.out.println("this wc "+this.weight_class);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		result = prime * result + ((team == null) ? 0 : team.hashCode());
		long temp;
		temp = Double.doubleToLongBits(weight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Competitor other = (Competitor) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (sex != other.sex)
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		if (team == null) {
			if (other.team != null)
				return false;
		} else if (!team.equals(other.team))
			return false;
		if (Double.doubleToLongBits(weight) != Double.doubleToLongBits(other.weight))
			return false;
		return true;
	}

	
}