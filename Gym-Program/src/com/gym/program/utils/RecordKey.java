package com.gym.program.utils;

import com.gym.program.logic.match.Match.TypeOfMatch;

public class RecordKey {
	private TypeOfMatch typeOfMatch;
	private Category age;
	private Category weight;
	private Sex sex;

	public RecordKey(TypeOfMatch typeOfMatch, Sex sex, Category age, Category weight) {
		super();
		this.typeOfMatch = typeOfMatch;
		this.age = age;
		this.weight = weight;
		this.sex = sex;
	}

	public TypeOfMatch getTypeOfMatch() {
		return typeOfMatch;
	}

	public void setTypeOfMatch(TypeOfMatch typeOfMatch) {
		this.typeOfMatch = typeOfMatch;
	}

	public Category getAge() {
		return age;
	}

	public void setAge(Category age) {
		this.age = age;
	}

	public Category getWeight() {
		return weight;
	}

	public void setWeight(Category weight) {
		this.weight = weight;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + ((weight == null) ? 0 : weight.hashCode());
		result = prime * result + ((typeOfMatch == null) ? 0 : typeOfMatch.hashCode());
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
		RecordKey other = (RecordKey) obj;
		if (sex == null) {
			if (other.sex != null)
				return false;
		} else if (!sex.equals(other.sex))
			return false;
		if (age == null) {
			if (other.age != null)
				return false;
		} else if (!age.equals(other.age))
			return false;
		if (weight == null) {
			if (other.weight != null)
				return false;
		} else if (!weight.equals(other.weight))
			return false;
		if (typeOfMatch != other.typeOfMatch)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RecordKey [typeOfMatch=" + typeOfMatch + ", class=" + age + " " + weight + " " + sex + "]";
	}

}
