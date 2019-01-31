package com.gym.program.logic.match;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import com.gym.program.utils.TeamScore;

public class RankingPerTeam extends LinkedList<TeamScore> {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public RankingPerTeam(List<TeamScore> teams) {
		super(teams);
	}

	public RankingPerTeam() {
		super();
	}

	public void sortRanking() {
		this.sort(new Comparator<TeamScore>() {
			@Override
			public int compare(TeamScore o1, TeamScore o2) {
				if (o1.getScore() > o2.getScore()) { // o1.score > o2.score
					return -1;
				} else if (o2.getScore() > o1.getScore()) { // o2.score >
															// o1.score
					return 1;
				} else { // o1.score == o2.score TODO order by name or age?
					return 0;// 01 score
				}
			}

		});
	}
}
