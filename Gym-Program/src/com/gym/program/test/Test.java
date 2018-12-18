package com.gym.program.test;

import java.util.Collections;

import com.gym.program.logic.Manager;
import com.gym.program.logic.competitor.Competitor;
import com.gym.program.logic.competitor.CompetitorBuilder;
import com.gym.program.logic.match.Lifter;
import com.gym.program.logic.match.Match;
import com.gym.program.logic.match.Match.TypeOfMatch;
import com.gym.program.logic.utils.CallComparator;
import com.gym.program.logic.utils.Choice;
import com.gym.program.logic.utils.Sex;
import com.gym.program.logic.utils.WilksCalculator;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// SIMULATING EVENT CREATION

		Manager manager = new Manager();

		Match match_bench = new Match(TypeOfMatch.BENCHPRESS);
		Match match_squat = new Match(TypeOfMatch.SQUAT);

		// create 2 benchpress matches
		Match match_bench_2 = new Match(TypeOfMatch.BENCHPRESS);

		checkMatch(manager, match_bench);
		checkMatch(manager, match_bench_2);
		checkMatch(manager, match_squat);

		System.out.println();

		// SUBSCRIBE COMPETITORS TO MATCHES

		CompetitorBuilder builder = CompetitorBuilder.newBuilder().setName("Tizio").setSurname("Caio").setSex(Sex.MALE)
				.setAge(24).setTeam("KC").setWeight(82.40);

		Competitor c1 = builder.build();
		Competitor c2 = builder.setAge(17).setWeight(68.2).build();
		Competitor c3 = builder.setSex(Sex.FEMALE).setWeight(56.5).build();
		Competitor c4 = builder.setSex(Sex.FEMALE).setWeight(48.5).build();
		Competitor c5 = builder.setAge(37).setWeight(98.2).build();
		Competitor c6 = builder.setAge(87).setWeight(70.2).build();
		Competitor c7 = builder.setAge(28).setTeam("CzWOW").setWeight(86.4).build();

		// c1 c3 c5 to all matches

		for (TypeOfMatch type : manager.getMatches().keySet()) {
			manager.getMatches().get(type).signUp(c1, Choice.CLSS_WEIGHT, 120);
			manager.getMatches().get(type).signUp(c3, Choice.CLSS_WEIGHT, 70);
			manager.getMatches().get(type).signUp(c5, Choice.CLSS_AGE, 180);

		}

		// c2 c4 c6 c7 only Bench

		manager.getMatches().get(TypeOfMatch.BENCHPRESS).signUp(c2, Choice.CLSS_AGE, 80);
		manager.getMatches().get(TypeOfMatch.BENCHPRESS).signUp(c4, Choice.CLSS_WEIGHT, 50);
		manager.getMatches().get(TypeOfMatch.BENCHPRESS).signUp(c6, Choice.CLSS_AGE, 130);
		manager.getMatches().get(TypeOfMatch.BENCHPRESS).signUp(c7, Choice.CLSS_AGE, 150);

		System.out.println("MATCHES selezionati :");
		System.out.println(manager.getMatches() + "\n");

		System.out.println("Lifters per Match :");
		for (TypeOfMatch type : manager.getMatches().keySet()) {
			System.out.println("Per " + type + " => " + manager.getMatches().get(type).getLifters());
		}

		// test Wilks calculator

		System.out.println("score =>> " + WilksCalculator.getMaleResult(75, 110));
		
		
		// test CALL SORTING for first lift

		Match test = manager.getMatches().get(TypeOfMatch.BENCHPRESS);
		
		for (Lifter lifter : test.getLifters()) {
			System.out.println("lifter xx ==> " + lifter.getFirstLift());
		}

		System.out.println("\n\n\n");
		Collections.sort(test.getLifters(), new CallComparator());
		
		for (Lifter lifter : test.getLifters()) {
			System.out.println("lifter xx ==> " + lifter.getFirstLift());
		}

	}

	public static void checkMatch(Manager manager, Match match) {
		if (manager.addMatch(match)) {
			System.out.println("Aggiunto un match di " + match.getType());
		} else {
			System.out.println("L'evento contiene già un match di " + match.getType());
		}
	}

}
