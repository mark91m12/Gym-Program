package com.gym.program.utils;

import java.util.List;

public abstract class WeightDisc {

	public WeightDisc successor = null;
	protected double kg = 0;
	protected static boolean is_present_0_5_kg = false;
	protected static boolean is_present_0_25_kg = false;
	protected static boolean check_weights = true;
	protected static double rest = 0;

	public double getKg() {
		return kg;
	}

	public String getLabel() {
		return label;
	}

	public int getOccurrance() {
		return occurrance;
	}

	protected String label;
	protected int occurrance = 0;

	public final void updateList(double target, List<WeightDisc> list) {

		if (this.kg <= target) {
			list.add(this);
		}

		while (this.kg <= target) {
			target -= this.kg;
			this.occurrance++;
		}

		setSuccessor(target, list);

	}

	public abstract void setSuccessor(double target, List<WeightDisc> list);

	public abstract String getPathImage();

}

class W25Kg extends WeightDisc {

	public W25Kg() {
		this.kg = 25;
		this.label = "25";

	}

	public void setSuccessor(double target, List<WeightDisc> list) {

		this.successor = new W20Kg();
		this.successor.updateList(target, list);

	}

	@Override
	public String getPathImage() {
		return "images/plates/25kg.png";
	}

}

class W20Kg extends WeightDisc {

	public W20Kg() {
		this.kg = 20;
		this.label = "20";

	}

	public void setSuccessor(double target, List<WeightDisc> list) {

		this.successor = new W15Kg();
		this.successor.updateList(target, list);

	}

	@Override
	public String getPathImage() {
		return "images/plates/20kg.png";
	}

}

class W15Kg extends WeightDisc {

	public W15Kg() {
		this.kg = 15;
		this.label = "15";

	}

	public void setSuccessor(double target, List<WeightDisc> list) {

		this.successor = new W10Kg();
		this.successor.updateList(target, list);

	}

	@Override
	public String getPathImage() {
		return "images/plates/15kg.png";
	}

}

class W10Kg extends WeightDisc {

	public W10Kg() {
		this.kg = 10;
		this.label = "10";

	}

	public void setSuccessor(double target, List<WeightDisc> list) {

		this.successor = new W5Kg();
		this.successor.updateList(target, list);

	}

	@Override
	public String getPathImage() {
		return "images/plates/10kg.png";
	}

}

class W5Kg extends WeightDisc {

	public W5Kg() {
		this.kg = 5;
		this.label = "5";

	}

	public void setSuccessor(double target, List<WeightDisc> list) {

		this.successor = new W2p5Kg();
		this.successor.updateList(target, list);

	}

	@Override
	public String getPathImage() {
		return "images/plates/5kg.png";
	}
}

class W2p5Kg extends WeightDisc {

	public W2p5Kg() {
		this.kg = 2.5;
		this.label = "2.5";

	}

	public void setSuccessor(double target, List<WeightDisc> list) {

		this.successor = new W1p25Kg();
		this.successor.updateList(target, list);

	}

	@Override
	public String getPathImage() {
		return "images/plates/2_5kg.png";
	}
}

class W1p25Kg extends WeightDisc {

	public W1p25Kg() {
		this.kg = 1.25;
		this.label = "1.25";

	}

	public void setSuccessor(double target, List<WeightDisc> list) {

		if (target > 0) {

			if (is_present_0_5_kg) {
				this.successor = new W0p5Kg();
				this.successor.updateList(target, list);
			} else if (is_present_0_25_kg) {
				this.successor = new W0p25Kg();
				this.successor.updateList(target, list);
			} else {
				WeightDisc.check_weights = false;
				WeightDisc.rest = target;
			}

		} else {
			WeightDisc.check_weights = true;
		}

	}

	@Override
	public String getPathImage() {
		return "images/plates/1_25kg.png";
	}
}

class W0p5Kg extends WeightDisc {

	public W0p5Kg() {
		this.kg = 0.5;
		this.label = "0.5";

	}

	public void setSuccessor(double target, List<WeightDisc> list) {

		if (target > 0 && !is_present_0_25_kg) {
			WeightDisc.check_weights = false;
			WeightDisc.rest = target;
		} else {
			this.successor = new W0p25Kg();
			this.successor.updateList(target, list);
		}

	}

	@Override
	public String getPathImage() {
		return "images/plates/0_5kg.png";
	}
}

class W0p25Kg extends WeightDisc {

	public W0p25Kg() {
		this.kg = 0.25;
		this.label = "0.25";

	}

	public void setSuccessor(double target, List<WeightDisc> list) {

		if (target > 0) {
			WeightDisc.check_weights = false;
			WeightDisc.rest = target;
		}

	}

	@Override
	public String getPathImage() {
		return "images/plates/0_25kg.png";
	}
}
