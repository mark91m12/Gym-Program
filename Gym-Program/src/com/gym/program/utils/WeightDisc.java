package com.gym.program.utils;

import java.util.List;

public abstract class WeightDisc {

	public WeightDisc successor = null;
	protected double kg = 0;

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

class TwentyFiveKg extends WeightDisc {

	public TwentyFiveKg() {
		this.kg = 25;
		this.label = "25";

	}

	public void setSuccessor(double target, List<WeightDisc> list) {

		this.successor = new TwentyKg();
		this.successor.updateList(target, list);

	}

	@Override
	public String getPathImage() {
		// TODO Auto-generated method stub
		return "images/25kg.png";
	}

}

class TwentyKg extends WeightDisc {

	public TwentyKg() {
		this.kg = 20;
		this.label = "20";

	}

	public void setSuccessor(double target, List<WeightDisc> list) {

		this.successor = new FifteenKg();
		this.successor.updateList(target, list);

	}

	@Override
	public String getPathImage() {
		// TODO Auto-generated method stub
		return "images/20kg.png";
	}

}

class FifteenKg extends WeightDisc {

	public FifteenKg() {
		this.kg = 15;
		this.label = "15";

	}

	public void setSuccessor(double target, List<WeightDisc> list) {

		this.successor = new TenKg();
		this.successor.updateList(target, list);

	}

	@Override
	public String getPathImage() {
		// TODO Auto-generated method stub
		return "images/15kg.png";
	}

}

class TenKg extends WeightDisc {

	public TenKg() {
		this.kg = 10;
		this.label = "10";

	}

	public void setSuccessor(double target, List<WeightDisc> list) {

		this.successor = new FiveKg();
		this.successor.updateList(target, list);

	}

	@Override
	public String getPathImage() {
		// TODO Auto-generated method stub
		return "images/10kg.png";
	}

}

class FiveKg extends WeightDisc {

	public FiveKg() {
		this.kg = 5;
		this.label = "5";

	}

	public void setSuccessor(double target, List<WeightDisc> list) {

		this.successor = new TwoPoint5Kg();
		this.successor.updateList(target, list);

	}

	@Override
	public String getPathImage() {
		// TODO Auto-generated method stub
		return "images/5kg.png";
	}
}

class TwoPoint5Kg extends WeightDisc {

	public TwoPoint5Kg() {
		this.kg = 2.5;
		this.label = "2.5";

	}

	public void setSuccessor(double target, List<WeightDisc> list) {

		this.successor = new OnePoint25Kg();
		this.successor.updateList(target, list);

	}

	@Override
	public String getPathImage() {
		// TODO Auto-generated method stub
		return "images/2_5kg.png";
	}
}

class OnePoint25Kg extends WeightDisc {

	public OnePoint25Kg() {
		this.kg = 1.25;
		this.label = "1.25";

	}

	public void setSuccessor(double target, List<WeightDisc> list) {

		if (target > 0)
			System.out.println("Mancano i tagli piccoli restano fuori " + target * 2 + " kg");

	}

	@Override
	public String getPathImage() {
		// TODO Auto-generated method stub
		return "images/1_25kg.png";
	}
}