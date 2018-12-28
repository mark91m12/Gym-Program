package com.gym.program.utils;

import java.util.ArrayList;

import com.gym.program.logic.competitor.Competitor;
import com.gym.program.utils.Category.Age;
import com.gym.program.utils.Category.Weight;

public class LogicHelper {

	// male constants
	private static final double a_male = -216.0475144;
	private static final double b_male = 16.2606339;
	private static final double c_male = -0.002388645;
	private static final double d_male = -0.00113732;
	private static final double e_male = 0.00000701863;
	private static final double f_male = -0.00000001291;
	// female constants
	private static final double a_female = 594.31747775582;
	private static final double b_female = -27.23842536447;
	private static final double c_female = 0.82112226871;
	private static final double d_female = -0.00930733913;
	private static final double e_female = 0.00004731582;
	private static final double f_female = -0.00000009054;

	public static double getMaleResult(double bw, double weight_lifted) {

		double coeff_male = 500 / (a_male + (b_male * bw) + (c_male * Math.pow(bw, 2)) + (d_male * Math.pow(bw, 3))
				+ (e_male * Math.pow(bw, 4)) + (f_male * Math.pow(bw, 5)));

		return weight_lifted * coeff_male;
	}

	public static double getFemaleResult(double bw, double weight_lifted) {

		double coeff_female = 500 / (a_female + (b_female * bw) + (c_female * Math.pow(bw, 2))
				+ (d_female * Math.pow(bw, 3)) + (e_female * Math.pow(bw, 4)) + (f_female * Math.pow(bw, 5)));

		return weight_lifted * coeff_female;
	}

	public static ArrayList<WeightDisc> calculateWeights(double weight, double bar) {

		WeightDisc plate = new TwentyFiveKg();

		double target;

		ArrayList<WeightDisc> plates = new ArrayList<WeightDisc>();

		target = (weight - bar) / 2;
		plate.updateList(target, plates);

		return plates;

	}

	public static Category getCategory(Choice choice, Competitor competitor) {

		Category result = Age.SENIOR;
		int age = competitor.getAge();

		switch (choice) {
		case CLSS_AGE:
			if (age < 18) {
				result = Age.SUB_JUNIOR;
			} else if (age >= 18 && age <= 23) {
				result = Age.JUNIOR;
			} else if (age >= 24 && age <= 39) {
				result = Age.SENIOR;
			} else if (age >= 40 && age <= 49) {
				result = Age.MASTER1;
			} else if (age >= 50 && age <= 59) {
				result = Age.MASTER2;
			} else if (age >= 60 && age <= 69) {
				result = Age.MASTER3;
			} else if (age >= 70) {
				result = Age.MASTER4;
			}
			break;
		case CLSS_WEIGHT:
			double weight = competitor.getWeight();
			switch (competitor.getSex()) {
			case MALE:
				if (weight <= 59.0) {
					if (weight <= 53.0 && (age < 18 || age >= 18 && age <= 23)) {
						result = Weight.MINUS_53;
					} else {
						result = Weight.MINUS_59;
					}

				} else if (weight >= 59.01 && weight <= 66.0) {
					result = Weight.MINUS_66;
				} else if (weight >= 66.01 && weight <= 74.0) {
					result = Weight.MINUS_74;
				} else if (weight >= 74.01 && weight <= 83.0) {
					result = Weight.MINUS_83;
				} else if (weight >= 83.01 && weight <= 93.0) {
					result = Weight.MINUS_93;
				} else if (weight >= 93.01 && weight <= 105.0) {
					result = Weight.MINUS_105;
				} else if (weight >= 105.01 && weight <= 120.0) {
					result = Weight.MINUS_120;
				} else if (weight >= 120.01) {
					result = Weight.PLUS_120;
				}
				break;
			case FEMALE:
				if (weight <= 47.0) {
					if (weight <= 43.0 && (age < 18 || age >= 18 && age <= 23)) {
						result = Weight.MINUS_43;
					} else {
						result = Weight.MINUS_47;
					}
				} else if (weight >= 47.01 && weight <= 52.0) {
					result = Weight.MINUS_52;
				} else if (weight >= 52.01 && weight <= 57.0) {
					result = Weight.MINUS_57;
				} else if (weight >= 57.01 && weight <= 63.0) {
					result = Weight.MINUS_63;
				} else if (weight >= 63.01 && weight <= 72.0) {
					result = Weight.MINUS_72;
				} else if (weight >= 72.01 && weight <= 84.0) {
					result = Weight.MINUS_84;
				} else if (weight >= 84.01) {
					result = Weight.PLUS_84;
				}
				break;
			default:
				break;
			}// end switch sex
			break;
		default:
			break;

		}// end switch Choice

		return result;
	}

}
