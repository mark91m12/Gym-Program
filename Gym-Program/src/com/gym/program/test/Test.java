package com.gym.program.test;

import java.awt.Menu;
import java.util.Collections;

import com.gym.program.gui.MainMenu;
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
		System.out.println("\n\n\n");
		System.out.println("*********** TEST EVENT CREATION ****************");

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
		System.out.println("\n\n\n");
		System.out.println("*********** TEST SUBSCRIBE COMPETITORS TO MATCHES****************");

		CompetitorBuilder builder = CompetitorBuilder.newBuilder().setName("C1 NOME").setSurname("C1 COGNOME")
				.setSex(Sex.MALE).setAge(24).setTeam("KC").setWeight(82.40);

		Competitor c1 = builder.build();
		Competitor c2 = builder.setName("C2 NOME").setSurname("C2 COGNOME").setAge(17).setWeight(68.2).build();
		Competitor c3 = builder.setName("C3 NOME").setSurname("C3 COGNOME").setSex(Sex.FEMALE).setWeight(56.5).build();
		Competitor c4 = builder.setName("C4 NOME").setSurname("C4 COGNOME").setSex(Sex.FEMALE).setWeight(48.5).build();
		Competitor c5 = builder.setName("C5 NOME").setSurname("C5 COGNOME").setAge(37).setWeight(98.2).build();
		Competitor c6 = builder.setName("C6 NOME").setSurname("C6 COGNOME").setAge(87).setWeight(70.2).build();
		Competitor c7 = builder.setName("C7 NOME").setSurname("C7 COGNOME").setAge(28).setTeam("CzWOW").setWeight(86.4)
				.build();

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
		System.out.println("\n\n\n");
		System.out.println("*********** TEST SORTING FOR CALL ****************");

		Match test = manager.getMatches().get(TypeOfMatch.BENCHPRESS);
		System.out.println("Match BENCHPRESS");

		System.out.println("BEFORE SORT");
		for (Lifter lifter : test.getLifters()) {
			System.out.println(lifter + " ==> " + lifter.getFirstLift());
		}

		Collections.sort(test.getLifters(), new CallComparator());

		System.out.println("AFTER SORT");
		for (Lifter lifter : test.getLifters()) {
			System.out.println(lifter + " ==> " + lifter.getFirstLift());
		}

		// test Main Flow
		System.out.println("\n\n\n");
		System.out.println("*********** TEST MAIN FLOW ****************");
		manager.start();
		
		
		
		// TEST main menu window
		
		new MainMenu();
	}

	public static void checkMatch(Manager manager, Match match) {
		if (manager.addMatch(match)) {
			System.out.println("Aggiunto un match di " + match.getType());
		} else {
			System.out.println("L'evento contiene già un match di " + match.getType());
		}
	}

}
