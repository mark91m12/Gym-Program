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

	public MatchRanking(List<Lifter> lifters) {
		super();
		this.lifters = lifters;
		this.rankings = new HashMap<>();
		for (Lifter lifter : lifters) {
			Category category = lifter.getCategory();
			RankingPerCategory ranking = this.rankings.get(category);
			if (ranking == null) {
				ranking = new RankingPerCategory();
			}
			ranking.add(lifter);
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
	}

	public void updateLifter(Lifter lifter) {
		Category category = lifter.getCategory();
		RankingPerCategory ranking = this.rankings.get(category);
		if (ranking != null) {
			if (!ranking.contains(lifter)) {
				ranking.add(lifter);
			}
		} else {
			ranking = new RankingPerCategory();
			ranking.add(lifter);
		}
		ranking.sortRanking();
	}

	@Override
	public String toString() {
		return "MatchRanking \n[lifters=" + this.lifters + ", \nrankings=" + this.rankings + "]";
	}

}
