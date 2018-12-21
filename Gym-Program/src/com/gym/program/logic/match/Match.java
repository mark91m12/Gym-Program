package com.gym.program.logic.match;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.gym.program.logic.competitor.Competitor;
import com.gym.program.utils.CallComparator;
import com.gym.program.utils.Choice;
import com.gym.program.utils.WilksCalculator;

public class Match {

	public enum TypeOfMatch {
		BENCHPRESS, SQUAT, DEADLIFT
	}

	private List<Lifter> lifters;
	private TypeOfMatch type;
	private MatchRanking matchRanking;

	public Match(TypeOfMatch type) {
		this.lifters = new ArrayList<>();
		this.setType(type);
		this.matchRanking = new MatchRanking(this.lifters);
	}

	public TypeOfMatch getType() {
		return this.type;
	}

	public void setType(TypeOfMatch type) {
		this.type = type;
	}

	public List<Lifter> getLifters() {
		return this.lifters;
	}

	public void setLifters(List<Lifter> lifters) {
		this.lifters = lifters;
		this.matchRanking = new MatchRanking(this.lifters);
	}

	public MatchRanking getMatchRanking() {
		return this.matchRanking;
	}

	public void setMatchRanking(MatchRanking matchRanking) {
		this.matchRanking = matchRanking;
	}

	@SuppressWarnings("unchecked")
	public void signUp(Competitor competitor, Choice choice, double first_lift) {

		// set choice for category
		competitor.getMap().put(this.type, choice);
		// set first lift
		Lifter lifter = new Lifter(competitor, first_lift, choice);
		this.lifters.add(lifter);
		this.matchRanking.addLifter(lifter);
	}

	public void closeInscriptions() {
		// sort lifters based on their first lift (list will be sorted/updated
		// dynamically during the match)
		Collections.sort(this.getLifters(), new CallComparator());
	}

	public void sortLifters() {
		this.lifters.sort(new CallComparator());
	}

	public void start() {
		this.sortLifters();
		int lift = 1;
		// Create enum for lift FIRST-SECOND-Third ?
		while (lift < 4) {
			System.out.println("------------------------------------------------------------ LIFT TURN:" + lift
					+ "-----------------------------------------------------------------------------");
			Iterator<Lifter> lifterIter = this.lifters.iterator();
			while (lifterIter.hasNext()) {
				Lifter lifter = lifterIter.next();
				this.showViewForLifter(lifter);
				boolean verdict = true;
				this.updateVerdictOfLift(lifter, verdict, lift);
				if (verdict) {
					this.matchRanking.updateLifter(lifter);
				} else {

				}

			}
			lift++;
		}
	}

	private void updateVerdictOfLift(Lifter lifter, boolean isGoodLift, int lift) {
		switch (lift) {
		case 1:
			if (isGoodLift) {
				Competitor competitor = lifter.getCompetitor();
				switch (competitor.getSex()) {
				case MALE:
					lifter.setScore(WilksCalculator.getMaleResult(competitor.getWeight(), lifter.getFirstLift()));
					break;
				case FEMALE:
					lifter.setScore(WilksCalculator.getFemaleResult(competitor.getWeight(), lifter.getFirstLift()));
					break;
				default:
					break;
				}
			}
			lifter.setGoodFirst(isGoodLift);
			break;
		case 2:
			if (isGoodLift) {
				Competitor competitor = lifter.getCompetitor();
				switch (competitor.getSex()) {
				case MALE:
					lifter.setScore(WilksCalculator.getMaleResult(competitor.getWeight(), lifter.getSecondLift()));
					break;
				case FEMALE:
					lifter.setScore(WilksCalculator.getFemaleResult(competitor.getWeight(), lifter.getSecondLift()));
					break;
				default:
					break;
				}
			}
			lifter.setGoodSecond(isGoodLift);
			break;
		case 3:
			if (isGoodLift) {
				Competitor competitor = lifter.getCompetitor();
				switch (competitor.getSex()) {
				case MALE:
					lifter.setScore(WilksCalculator.getMaleResult(competitor.getWeight(), lifter.getThirdLift()));
					break;
				case FEMALE:
					lifter.setScore(WilksCalculator.getFemaleResult(competitor.getWeight(), lifter.getThirdLift()));
					break;
				default:
					break;
				}
			}
			lifter.setGoodThird(isGoodLift);
			break;
		default:
			break;
		}
	}

	public void showViewForLifter(Lifter lifter) {
		Competitor competitor = lifter.getCompetitor();
		System.out.println("LIFTER. Surame:" + competitor.getSurname() + " - Name:" + competitor.getName() + " - Age:"
				+ competitor.getAge() + " - Weight:" + competitor.getWeight() + " - Category:" + lifter.getCategory());
		System.out.println("First Try:" + lifter.getFirstLift());
		System.out.println("Second Try:" + lifter.getSecondLift());
		System.out.println("Third Try:" + lifter.getThirdLift());
		System.out.println("ACTUAL RANKINK:\n" + this.matchRanking);
		System.out.println("***************************************");
	}

	@Override
	public String toString() {
		return "Match [lifters=" + this.lifters + ", type=" + this.type + ", matchRanking=" + this.matchRanking + "]";
	}

}
