package com.gym.program.logic.match;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.gym.program.logic.utils.Category;

public class MatchRanking {
	private List<Lifter> lifters;

	private Map<Category, RankingPerCategory> rankings;

	public MatchRanking(List<Lifter> lifters, Map<Category, RankingPerCategory> rankings) {
		super();
		this.lifters = lifters;
		rankings = new HashMap<>();
		for (Lifter lifter : lifters) {
			Category category = lifter.getCategory();
			RankingPerCategory ranking = rankings.get(category);
			if (ranking == null) {
				ranking = new RankingPerCategory();
			}
			ranking.add(lifter);
			this.rankings = rankings;
		}
	}

	public MatchRanking() {
		super();
		this.lifters = new LinkedList<>();
		this.rankings = new HashMap<>();
	}

	public void addLifter(Lifter lifter) {
		Category category = lifter.getCategory();
		RankingPerCategory ranking = this.rankings.get(category);
		if (ranking == null) {
			ranking = new RankingPerCategory();
		}
		ranking.add(lifter);
		this.rankings = this.rankings;
	}
}
