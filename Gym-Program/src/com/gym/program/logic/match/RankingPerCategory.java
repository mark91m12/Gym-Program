package com.gym.program.logic.match;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class RankingPerCategory extends LinkedList<Lifter> {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public RankingPerCategory(List<Lifter> lifters) {
		super(lifters);
	}

	public RankingPerCategory() {
		super();
	}

	/**
	 * Sort lifters based on score. Lifter with highest score will appear at the
	 * beginning of the list. Lifter with the lowlest scope will appear at the end.
	 */
	public void sortRanking() {
		this.sort(new Comparator<Lifter>() {
			@Override
			public int compare(Lifter o1, Lifter o2) {
				if (o1.getScore() > o2.getScore()) { // o1.score > o2.score
					return -1;
				} else if (o2.getScore() > o1.getScore()) { // o2.score > o1.score
					return 1;
				} else { // o1.score == o2.score TODO order by name or age?
					return 0;// 01 score
				}
			}
		});
	}
}
