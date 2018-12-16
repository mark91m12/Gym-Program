package com.gym.program.logic;

import java.util.List;

public class Manager {

	private List<Match> matches;

	public boolean addMatch(Match m) {
		return this.matches.add(m);
	}

	public boolean removeMatch(Match m) {
		return this.matches.remove(m);
	}

}
