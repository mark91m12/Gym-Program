package com.gym.program.logic;

import java.util.HashMap;
import java.util.Map;

import com.gym.program.logic.match.Match;
import com.gym.program.logic.match.Match.TypeOfMatch;

public class Manager {

	private Map<TypeOfMatch, Match> matches;

	public Manager() {
		this.matches = new HashMap<>();
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

}
