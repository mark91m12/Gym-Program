package com.gym.program.logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gym.program.logic.competitor.Competitor;
import com.gym.program.logic.match.Lifter;
import com.gym.program.logic.match.Match;
import com.gym.program.logic.match.Match.TypeOfMatch;
import com.gym.program.utils.Attempt;
import com.gym.program.utils.Choice;

public class Manager {


	private Map<TypeOfMatch, Match> matches;
	private List<TypeOfMatch> matchesOrder;

	public Manager() {
		this.matches = new HashMap<>();
		this.matchesOrder = new ArrayList<>();
	}

	public Map<TypeOfMatch, Match> getMatches() {
		return this.matches;
	}

	public void setMatches(Map<TypeOfMatch, Match> matches) {
		this.matches = matches;
	}

	public boolean addMatch(Match m) {

		// message ( the choosen match is yet selected )
		if (this.matches.containsKey(m.getType())) {
			return false;
		}

		this.matches.put(m.getType(), m);

		return true;
	}

	public boolean removeMatch(Match m) {
		this.matches.remove(m.getType());
		return true;
	}

	public void start() {
		for (TypeOfMatch typeOfMatch : this.matches.keySet()) {
			System.out.println("START MATCH TYPE:" + typeOfMatch);
			System.out.println("INITIAL RANKING:\n" + this.matches.get(typeOfMatch).getMatchRanking());
			this.matches.get(typeOfMatch).start();
		}
	}

	public List<TypeOfMatch> getMatchesOrder() {
		return this.matchesOrder;
	}

	public void setMatchesOrder(List<TypeOfMatch> matchesOrder) {
		this.matchesOrder = matchesOrder;
	}

	public TypeOfMatch getCurrentTypeOfMatch() {
		return this.matchesOrder.get(0);
	}

	public TypeOfMatch getNextTypeOfMatch() {
		this.matchesOrder.remove(0);
		return this.matchesOrder.get(0);
	}

	public void signupLifter(List<TypeOfMatch> typeOfMatches, Competitor competitor, Choice choice, double first_lift) {
		for (TypeOfMatch typeOfMatch : typeOfMatches) {
			this.matches.get(typeOfMatch).signUp(competitor, choice, first_lift);
		}
	}

	public Lifter getNextLifter() {
		return this.matches.get(this.getNextTypeOfMatch()).getNextLifter();
	}

	public Lifter getCurrentLifter() {
		return this.matches.get(this.getNextTypeOfMatch()).getCurrentLifter();
	}

	public void updateLifterResult(Attempt a, boolean result) {
		this.getCurrentLifter().setAttemptResult(a, result);
	}

	@Override
	public String toString() {
		return "Manager [matches=" + matches + ", matchesOrder=" + matchesOrder + "]";
	}

}
