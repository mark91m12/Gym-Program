package com.gym.program.utils;

import com.gym.program.logic.match.Match.TypeOfMatch;

public class RecordKey {
	private TypeOfMatch typeOfMatch;
	private Category category;
	
	public RecordKey(TypeOfMatch typeOfMatch, Category category) {
		super();
		this.typeOfMatch = typeOfMatch;
		this.category = category;
	}
	
	public TypeOfMatch getTypeOfMatch() {
		return typeOfMatch;
	}
	public void setTypeOfMatch(TypeOfMatch typeOfMatch) {
		this.typeOfMatch = typeOfMatch;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
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
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (typeOfMatch != other.typeOfMatch)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RecordKey [typeOfMatch=" + typeOfMatch + ", category=" + category + "]";
	}
	
}
