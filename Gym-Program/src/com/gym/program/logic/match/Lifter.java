package com.gym.program.logic.match;

import com.gym.program.logic.competitor.Competitor;
import com.gym.program.logic.utils.Category;
import com.gym.program.logic.utils.Category.Age;
import com.gym.program.logic.utils.Category.Weight;
import com.gym.program.logic.utils.Choice;

public class Lifter {

	private double score;

	private double first_lift;
	private double second_lift;
	private double third_lift;

	private boolean good_first;
	private boolean good_second;
	private boolean good_third;

	private Competitor competitor;
	private Category category;

	public Lifter(Competitor competitor, double first, Choice choice) {
		this.competitor = competitor;
		this.setFirstLift(first);
		this.setCategory(choice);
	}

	public void setCategory(Choice choice) {
		switch (choice) {
		case CLSS_AGE:
			int age = this.competitor.getAge();
			if (age < 18) {
				this.category = Age.SUB_JUNIOR;
			} else if (age >= 18 && age <= 23) {
				this.category = Age.JUNIOR;
			} else if (age >= 24 && age <= 39) {
				this.category = Age.SENIOR;
			} else if (age >= 40 && age <= 49) {
				this.category = Age.MASTER1;
			} else if (age >= 50 && age <= 59) {
				this.category = Age.MASTER2;
			} else if (age >= 60 && age <= 69) {
				this.category = Age.MASTER3;
			} else if (age >= 70) {
				this.category = Age.MASTER4;
			}
			break;
		case CLSS_WEIGHT:
			double weight = this.competitor.getWeight();
			switch (this.competitor.getSex()) {
			case MALE:
				if (weight <= 59.0) {
					int age2 = this.competitor.getAge();
					if (weight <= 53.0 && (age2 < 18 || age2 >= 18 && age2 <= 23)) {
						this.category = Weight.MINUS_53;
					} else {
						this.category = Weight.MINUS_59;
					}

				} else if (weight >= 59.01 && weight <= 66.0) {
					this.category = Weight.MINUS_66;
				} else if (weight >= 66.01 && weight <= 74.0) {
					this.category = Weight.MINUS_74;
				} else if (weight >= 74.01 && weight <= 83.0) {
					this.category = Weight.MINUS_83;
				} else if (weight >= 83.01 && weight <= 93.0) {
					this.category = Weight.MINUS_93;
				} else if (weight >= 93.01 && weight <= 105.0) {
					this.category = Weight.MINUS_105;
				} else if (weight >= 105.01 && weight <= 120.0) {
					this.category = Weight.MINUS_120;
				} else if (weight >= 120.01) {
					this.category = Weight.PLUS_120;
				}
				break;
			case FEMALE:
				if (weight <= 47.0) {
					int age2 = this.competitor.getAge();
					if (weight <= 43.0 && (age2 < 18 || age2 >= 18 && age2 <= 23)) {
						this.category = Weight.MINUS_43;
					} else {
						this.category = Weight.MINUS_47;
					}
				} else if (weight >= 47.01 && weight <= 52.0) {
					this.category = Weight.MINUS_52;
				} else if (weight >= 52.01 && weight <= 57.0) {
					this.category = Weight.MINUS_57;
				} else if (weight >= 57.01 && weight <= 63.0) {
					this.category = Weight.MINUS_63;
				} else if (weight >= 63.01 && weight <= 72.0) {
					this.category = Weight.MINUS_72;
				} else if (weight >= 72.01 && weight <= 84.0) {
					this.category = Weight.MINUS_84;
				} else if (weight >= 84.01) {
					this.category = Weight.PLUS_84;
				}
				break;
			default:
				break;
			}// end switch sex
			break;
		default:
			break;

		}// end switch Choice

	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public double getScore() {
		return this.score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public double getFirstLift() {
		return this.first_lift;
	}

	public void setFirstLift(double first_lift) {
		this.first_lift = first_lift;
	}

	public double getSecondLift() {
		return this.second_lift;
	}

	public void setSecondLift(double second_lift) {
		this.second_lift = second_lift;
	}

	public double getThirdLift() {
		return this.third_lift;
	}

	public void setThirdLift(double third_lift) {
		this.third_lift = third_lift;
	}

	public boolean isGoodFirst() {
		return this.good_first;
	}

	public void setGoodFirst(boolean good_first) {
		this.good_first = good_first;
	}

	public boolean isGoodSecond() {
		return this.good_second;
	}

	public void setGoodSecond(boolean good_second) {
		this.good_second = good_second;
	}

	public boolean isGoodThird() {
		return this.good_third;
	}

	@Override
	public String toString() {
		return "Lifter [score=" + this.score + ", first_lift=" + this.first_lift + ", second_lift=" + this.second_lift
				+ ", third_lift=" + this.third_lift + ", good_first=" + this.good_first + ", good_second="
				+ this.good_second + ", good_third=" + this.good_third + ", competitor=" + this.competitor
				+ ", category=" + this.category + "]";
	}

	public void setGoodThird(boolean good_third) {
		this.good_third = good_third;
	}

	public Competitor getCompetitor() {
		return this.competitor;
	}

	public void setCompetitor(Competitor competitor) {
		this.competitor = competitor;
	}
}
