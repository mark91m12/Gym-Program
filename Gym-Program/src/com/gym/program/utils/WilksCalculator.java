package com.gym.program.utils;

import java.util.ArrayList;

public class WilksCalculator {

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

}
