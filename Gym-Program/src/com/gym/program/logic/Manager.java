package com.gym.program.logic;

import java.util.HashMap;
import java.util.Map;

import com.gym.program.logic.match.Match;
import com.gym.program.logic.match.Match.TypeOfMatch;

public class Manager {

	private Map<TypeOfMatch, Match> matches;

	public Manager() {
		matches = new HashMap<TypeOfMatch, Match>();
	}

	public Map<TypeOfMatch, Match> getMatches() {
		return matches;
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

}
