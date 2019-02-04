package com.gym.program.logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.gym.program.logic.competitor.Competitor;
import com.gym.program.logic.match.Lifter;
import com.gym.program.logic.match.Match;
import com.gym.program.logic.match.RankingPerTeam;
import com.gym.program.logic.match.Match.TypeOfMatch;
import com.gym.program.utils.Attempt;
import com.gym.program.utils.Category;
import com.gym.program.utils.Category.Male;
import com.gym.program.utils.Choice;
import com.gym.program.utils.RecordKey;
import com.gym.program.utils.Sex;
import com.gym.program.utils.TeamScore;
import com.gym.program.utils.TypeOfRanking;

public class Manager {

	private List<Competitor> competitors;

	public Set<Category> getCategoriesBy(TypeOfMatch tom, Sex sex){
		Set<Category> result = new HashSet<Category>();
		Set<Category> toAdd = matches.get(tom).getMatchRanking().getRankings().keySet();
		for (Category category : toAdd) {
			if(sex.equals(Sex.MALE) && category instanceof Category.Male) {
				result.add(category);
			}else if(sex.equals(Sex.FEMALE) && category instanceof Category.Female){
				result.add(category);
			}
		}
		return result;
	}
	
	public Set<Category> getAbsoluteCategories(Sex sex){
		Set<Category> result = new HashSet<Category>();
		for (Competitor competitor : competitors) {
			if(competitor.getSex().equals(sex)) {
				result.add(competitor.getCategory());
			}
		}
		return result;
	}
	
	public List<Competitor> getCompetitors() {
		return competitors;
	}

	public List<Competitor> getAbsoluteCompetitors(Sex sex, Category category) {

		List<Competitor> result = new ArrayList<Competitor>();
		for (Competitor competitor : competitors) {
			if (competitor.getSex().equals(sex) && competitor.isAbsolute_ranking() && competitor.getCategory().equals(category))
				result.add(competitor);
		}
		return result;
	}

	public void setCompetitors(List<Competitor> competitors) {
		this.competitors = competitors;
	}

	private Map<TypeOfMatch, Match> matches;
	private TypeOfMatch currentTypeOfMatch;
	private Set<TypeOfMatch> completed;

	private boolean is_0p25_present;
	private boolean is_0p5_present;
	private boolean started;

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
		competitors = new ArrayList<Competitor>();
		started = false;
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

	public void TestTeamScores() {
		RankingPerTeam tmp = this.getCurrentMatch().getTeamScores();

		for (TeamScore teamScore : tmp) {
			System.out.println(teamScore.getName() + " ===> " + teamScore.getScore());
		}
	}

	public void setStarted(boolean b) {
		started = b;
	}

	public boolean isStarted() {
		return started;
	}
	
}
