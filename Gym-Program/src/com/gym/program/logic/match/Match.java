package com.gym.program.logic.match;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.gym.program.logic.competitor.Competitor;
import com.gym.program.utils.Attempt;
import com.gym.program.utils.CallComparator;
import com.gym.program.utils.Choice;
import com.gym.program.utils.LogicHelper;

public class Match {

	public enum TypeOfMatch {
		BENCHPRESS, SQUAT, DEADLIFT
	}

	private List<Lifter> lifters;
	private List<Lifter> liftersCanDispute;//lifters that have done last attempt with negative validation
	private TypeOfMatch type;
	private MatchRanking matchRanking;

	public Match(TypeOfMatch type) {
		this.lifters = new ArrayList<>();
		this.liftersCanDispute = new ArrayList<>();
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

	public void signUp(Competitor competitor, Choice choice, double first_lift, double rack_number) {

		// set choice for category
		competitor.getMap().put(this.type, choice);
		// set first lift
		Lifter lifter = new Lifter(competitor, choice);
		lifter.setRack_number(rack_number);
		lifter.setAttemptWeight(Attempt.StandardAttempt.FIRST, first_lift);
		lifter.setBestAttemptWeight(first_lift);
		this.lifters.add(lifter);
		this.matchRanking.addLifter(lifter);
		this.sortLifters();
	}

//	public void closeInscriptions() {
//		// sort lifters based on their first lift (list will be sorted/updated
//		// dynamically during the match)
//		Collections.sort(this.getLifters(), new CallComparator());
//	}

	public void updateLifters() {
		Iterator<Lifter> i = lifters.iterator();
		Lifter lifter = null;
		while(i.hasNext()) {
			lifter = i.next();
			if(lifter.hasFinished()) {
				i.remove();
			}
		}
		sortLifters();
	}
	public void sortLifters() {
		this.lifters.sort(new CallComparator());
	}

//	public void start() {
//		this.sortLifters();
//		int lift = 1;
//		// Create enum for lift FIRST-SECOND-Third ?
//		while (lift < 4) {
//			System.out.println("------------------------------------------------------------ LIFT TURN:" + lift
//					+ "-----------------------------------------------------------------------------");
//			Iterator<Lifter> lifterIter = this.lifters.iterator();
//			while (lifterIter.hasNext()) {
//				Lifter lifter = lifterIter.next();
//				this.showViewForLifter(lifter);
//				boolean verdict = true;
//				this.updateVerdictOfLift(lifter, verdict, lift);
//				if (verdict) {
//					this.matchRanking.updateLifter(lifter);
//				} else {
//
//				}
//
//			}
//			lift++;
//		}
//	}

	// private void updateVerdictOfLift(Lifter lifter, boolean isGoodLift, int
	// lift) {
	// switch (lift) {
	// case 1:
	// if (isGoodLift) {
	// Competitor competitor = lifter.getCompetitor();
	// switch (competitor.getSex()) {
	// case MALE:
	// lifter.setScore(LogicHelper.getMaleResult(competitor.getWeight(),
	// lifter.getAttemptWeight(Attempt.FIRST)));
	// break;
	// case FEMALE:
	// lifter.setScore(LogicHelper.getFemaleResult(competitor.getWeight(),
	// lifter.getAttemptWeight(Attempt.FIRST)));
	// break;
	// default:
	// break;
	// }
	// }
	// lifter.setAttemptResult(Attempt.FIRST, isGoodLift);
	// break;
	// case 2:
	// if (isGoodLift) {
	// Competitor competitor = lifter.getCompetitor();
	// switch (competitor.getSex()) {
	// case MALE:
	// lifter.setScore(LogicHelper.getMaleResult(competitor.getWeight(),
	// lifter.getAttemptWeight(Attempt.SECOND)));
	// break;
	// case FEMALE:
	// lifter.setScore(LogicHelper.getFemaleResult(competitor.getWeight(),
	// lifter.getAttemptWeight(Attempt.SECOND)));
	// break;
	// default:
	// break;
	// }
	// }
	// lifter.setAttemptResult(Attempt.SECOND, isGoodLift);
	// break;
	// case 3:
	// if (isGoodLift) {
	// Competitor competitor = lifter.getCompetitor();
	// switch (competitor.getSex()) {
	// case MALE:
	// lifter.setScore(LogicHelper.getMaleResult(competitor.getWeight(),
	// lifter.getAttemptWeight(Attempt.THIRD)));
	// break;
	// case FEMALE:
	// lifter.setScore(LogicHelper.getFemaleResult(competitor.getWeight(),
	// lifter.getAttemptWeight(Attempt.THIRD)));
	// break;
	// default:
	// break;
	// }
	// }
	// lifter.setAttemptResult(Attempt.THIRD, isGoodLift);
	// break;
	// default:
	// break;
	// }
	// }

//	public void showViewForLifter(Lifter lifter) {
//		Competitor competitor = lifter.getCompetitor();
//		System.out.println("LIFTER. Surame:" + competitor.getSurname() + " - Name:" + competitor.getName() + " - Age:"
//				+ competitor.getAge() + " - Weight:" + competitor.getWeight() + " - Category:" + lifter.getCategory());
//		System.out.println("First Try:" + lifter.getAttemptWeight(Attempt.StandardAttempt.FIRST));
////		System.out.println("Second Try:" + lifter.getAttemptWeight(Attempt.SECOND));
////		System.out.println("Third Try:" + lifter.getAttemptWeight(Attempt.THIRD));
//		System.out.println("ACTUAL RANKINK:\n" + this.matchRanking);
//		System.out.println("***************************************");
//	}

	@Override
	public String toString() {
		return "Match [lifters=" + this.lifters + ", type=" + this.type + ", matchRanking=" + this.matchRanking + "]";
	}

	public Lifter getCurrentLifter() {
		return this.lifters.isEmpty()? null:this.lifters.get(0);
	}

	public List<Lifter> getLiftersCanDispute() {
		return liftersCanDispute;
	}

	public void setLiftersCanDispute(List<Lifter> liftersCanDispute) {
		this.liftersCanDispute = liftersCanDispute;
	}

	public boolean addLifterCanDispute(Lifter toAdd) {
		return this.liftersCanDispute.add(toAdd);
	}
	
	public boolean lifterWonDispute(Lifter toDelete) {
		return lifters.add(toDelete) && liftersCanDispute.remove(toDelete);
	}
//	public Lifter getNextLifter() {
//		this.lifters.remove(0);
//		Lifter lifter = null;
//		try {
//			lifter = this.lifters.get(0);
//		} catch (Exception e) {
//
//		}
//		return lifter;
//	}
}
