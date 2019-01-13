package com.gym.program.logic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.gym.program.logic.competitor.Competitor;
import com.gym.program.logic.match.Lifter;
import com.gym.program.logic.match.Match;
import com.gym.program.logic.match.Match.TypeOfMatch;
import com.gym.program.utils.Attempt;
import com.gym.program.utils.Choice;
import com.gym.program.utils.RecordKey;

public class Manager {

	private Map<TypeOfMatch, Match> matches;
	private TypeOfMatch currentTypeOfMatch;
	private Set<TypeOfMatch> completed;

	private boolean is_0p25_present;
	private boolean is_0p5_present;

	public boolean is0p25Present() {
		return is_0p25_present;
	}

	public void set0p25Present(boolean is_0p25_present) {
		this.is_0p25_present = is_0p25_present;
	}

	public boolean is0p5Present() {
		return is_0p5_present;
	}

	public void set0p5Present(boolean is_0p5_present) {
		this.is_0p5_present = is_0p5_present;
	}

	public Manager() {
		this.matches = new HashMap<>();
		completed = new HashSet<>();
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

	// public void start() {
	// for (TypeOfMatch typeOfMatch : this.matches.keySet()) {
	// System.out.println("START MATCH TYPE:" + typeOfMatch);
	// System.out.println("INITIAL RANKING:\n" +
	// this.matches.get(typeOfMatch).getMatchRanking());
	// this.matches.get(typeOfMatch).start();
	// }
	// }

	// public void signupLifter(List<TypeOfMatch> typeOfMatches, Competitor
	// competitor, Choice choice, double first_lift) {
	// for (TypeOfMatch typeOfMatch : typeOfMatches) {
	// this.matches.get(typeOfMatch).signUp(competitor, choice, first_lift);
	// }
	// }

	public TypeOfMatch getCurrentTypeOfMatch() {
		return currentTypeOfMatch;
	}

	public void setCurrentTypeOfMatch(TypeOfMatch type) {
		this.currentTypeOfMatch = type;
	}

	public Set<TypeOfMatch> getCompleted() {
		return completed;
	}

	public void setCompleted(TypeOfMatch completed) {
		this.completed.add(completed);
	}

	// public Lifter getNextLifter() {
	// return this.matches.get(this.currentTypeOfMatch).getNextLifter();
	// }

	public Lifter getCurrentLifter() {
		return this.matches.get(this.currentTypeOfMatch).getCurrentLifter();
	}

	public void updateLifterResult(Attempt a, boolean result) {
		this.getCurrentLifter().setAttemptResult(a, result);
	}

	public Match getCurrentMatch() {
		return this.matches.get(currentTypeOfMatch);
	}
}
