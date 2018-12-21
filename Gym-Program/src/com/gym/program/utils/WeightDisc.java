package com.gym.program.utils;

import java.util.List;

public abstract class WeightDisc {

	public WeightDisc successor = null;
	protected double kg = 0;
	protected String colore;

	public void setSuccessor(WeightDisc suc) {
		this.successor = suc;
	}

	public abstract void updateList(double target, List<String> list);
}

class TwentyFiveKg extends WeightDisc {

	public TwentyFiveKg() {
		this.kg = 25;
		this.colore = "Rosso";

	}

	public void updateList(double target, List<String> list) {

		while (this.kg <= target) {
			target -= this.kg;
			list.add(this.colore);
		}

		this.successor.updateList(target, list);

	}

}

class TwentyKg extends WeightDisc {

	public TwentyKg() {
		this.kg = 20;
		this.colore = "Blu";

	}

	public void updateList(double target, List<String> list) {

		while (this.kg <= target) {
			target -= this.kg;
			list.add(this.colore);
		}

		this.successor.updateList(target, list);

	}

}

class FifteenKg extends WeightDisc {

	public FifteenKg() {
		this.kg = 15;
		this.colore = "Giallo";

	}

	public void updateList(double target, List<String> list) {

		while (this.kg <= target) {
			target -= this.kg;
			list.add(this.colore);
		}

		this.successor.updateList(target, list);

	}

}

class TenKg extends WeightDisc {

	public TenKg() {
		this.kg = 10;
		this.colore = "Verde";

	}

	public void updateList(double target, List<String> list) {

		while (this.kg <= target) {
			target -= this.kg;
			list.add(this.colore);
		}

		this.successor.updateList(target, list);

	}

}

class FiveKg extends WeightDisc {

	public FiveKg() {
		this.kg = 5;
		this.colore = "Bianco";

	}

	public void updateList(double target, List<String> list) {

		while (this.kg <= target) {
			target -= this.kg;
			list.add(this.colore);

		}
		if (target > 0)
			System.out.println("Mancano i tagli piccoli restano fuori " + target * 2 + " kg");

	}
}
