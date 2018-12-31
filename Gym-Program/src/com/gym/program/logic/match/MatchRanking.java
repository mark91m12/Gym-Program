package com.gym.program.logic.match;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.gym.program.utils.Category;

public class MatchRanking {
	public Map<Category, RankingPerCategory> getRankings() {
		return rankings;
	}

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
			this.rankings.put(category, ranking);
		}
	}

	public MatchRanking() {
		super();
		this.lifters = new LinkedList<>();
		this.rankings = new HashMap<>();
	}

	public void addLifter(Lifter lifter) {
		System.out.println("ADDED lifter on MATCH RANKING");
		System.out.println("lifter:" + lifter + " \ncurrent ranking: " + this.rankings);
		Category category = lifter.getCategory();
		RankingPerCategory ranking = this.rankings.get(category);
		if (ranking == null) {
			ranking = new RankingPerCategory();
		}
		ranking.add(lifter);
		this.rankings.put(category, ranking);
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
		this.rankings.put(category, ranking);
	}

	@Override
	public String toString() {
		String s = "MatchRanking: \n";
		s += "LIFTERS:\n";
		for (Lifter lifter : this.lifters) {
			s += this.lifters + "\n";
		}
		s += "RANKINGS:\n";
		for (Category c : this.rankings.keySet()) {
			s += c + ":\n" + this.rankings.get(c);
		}
		return s;
	}

}
