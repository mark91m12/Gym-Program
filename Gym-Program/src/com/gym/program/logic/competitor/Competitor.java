package com.gym.program.logic.competitor;

enum Age {
	SUB_JUNIOR, JUNIOR, SENIOR, MASTER1, MASTER2, MASTER3, MASTER4
}

enum Weight {
	// female weights classes
	MINUS_43, MINUS_47, MINUS_52, MINUS_57, MINUS_63, MINUS_72, MINUS_84, PLUS_84,
	// male weights classes
	MINUS_53, MINUS_59, MINUS_66, MINUS_74, MINUS_83, MINUS_93, MINUS_105, MINUS_120, PLUS_120,
}

enum Sex {
	MALE, FEMALE
}

public class Competitor {

	private String name;
	private String surname;
	private double weight;
	private int age;
	private Sex sex;
	private Age age_class;
	private Weight weight_class;
	private String team;

	public Competitor(String name, String surname, Sex sex, String team, double weight, int age) {
		setName(name);
		setSurname(surname);
		setSex(sex);
		setTeam(team);
		setWeight(weight);
		setAge(age);

		setAge_class(age);
		setWeight_class(weight);

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public Age getAge_class() {
		return age_class;
	}

	private void setAge_class(int age) {

		if (age < 18) {
			this.age_class = Age.SUB_JUNIOR;
		} else if (age >= 18 && age <= 23) {
			this.age_class = Age.JUNIOR;
		} else if (age >= 24 && age <= 39) {
			this.age_class = Age.SENIOR;
		} else if (age >= 40 && age <= 49) {
			this.age_class = Age.MASTER1;
		} else if (age >= 50 && age <= 59) {
			this.age_class = Age.MASTER2;
		} else if (age >= 60 && age <= 69) {
			this.age_class = Age.MASTER3;
		} else if (age >= 70) {
			this.age_class = Age.MASTER4;
		}

	}

	public Weight getWeight_class() {
		return weight_class;
	}

	private void setWeight_class(double weight) {

		// male weight classes
		if (this.sex.equals(Sex.MALE)) {

			if (weight <= 59.0) {

				if (weight <= 53.0 && (this.age_class.equals(Age.SUB_JUNIOR) || this.age_class.equals(Age.JUNIOR))) {
					this.weight_class = Weight.MINUS_53;
				} else {
					this.weight_class = Weight.MINUS_59;
				}

			} else if (weight >= 59.01 && weight <= 66.0) {
				this.weight_class = Weight.MINUS_66;
			} else if (weight >= 66.01 && weight <= 74.0) {
				this.weight_class = Weight.MINUS_74;
			} else if (weight >= 74.01 && weight <= 83.0) {
				this.weight_class = Weight.MINUS_83;
			} else if (weight >= 83.01 && weight <= 93.0) {
				this.weight_class = Weight.MINUS_93;
			} else if (weight >= 93.01 && weight <= 105.0) {
				this.weight_class = Weight.MINUS_105;
			} else if (weight >= 105.01 && weight <= 120.0) {
				this.weight_class = Weight.MINUS_120;
			} else if (weight >= 120.01) {
				this.weight_class = Weight.PLUS_120;
			}

		}
		// female weight classes
		else {
			
			if (weight <= 47.0) {

				if (weight <= 43.0 && (this.age_class.equals(Age.SUB_JUNIOR) || this.age_class.equals(Age.JUNIOR))) {
					this.weight_class = Weight.MINUS_43;
				} else {
					this.weight_class = Weight.MINUS_47;
				}

			} else if (weight >= 47.01 && weight <= 52.0) {
				this.weight_class = Weight.MINUS_52;
			} else if (weight >= 52.01 && weight <= 57.0) {
				this.weight_class = Weight.MINUS_57;
			} else if (weight >= 57.01 && weight <= 63.0) {
				this.weight_class = Weight.MINUS_63;
			} else if (weight >= 63.01 && weight <= 72.0) {
				this.weight_class = Weight.MINUS_72;
			} else if (weight >= 72.01 && weight <= 84.0) {
				this.weight_class = Weight.MINUS_84;
			}else if (weight >= 84.01) {
				this.weight_class = Weight.PLUS_84;
			}
		}
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

}
