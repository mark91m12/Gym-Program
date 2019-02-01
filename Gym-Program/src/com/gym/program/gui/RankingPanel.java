package com.gym.program.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.gym.program.logic.Manager;
import com.gym.program.logic.competitor.Competitor;
import com.gym.program.logic.match.Lifter;
import com.gym.program.logic.match.Match;
import com.gym.program.logic.match.Match.TypeOfMatch;
import com.gym.program.logic.match.RankingPerCategory;
import com.gym.program.logic.match.RankingPerTeam;
import com.gym.program.utils.Category;
import com.gym.program.utils.GuiHelper;
import com.gym.program.utils.Sex;
import com.gym.program.utils.TeamScore;
import com.gym.program.utils.TypeOfRanking;
import com.gym.program.utils.TypeOfRanking.Team_Single;

public class RankingPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MainFrame matchFrame;
	private DefaultComboBoxModel<TypeOfRanking.Team_Single> team_atletModel;
	private DefaultComboBoxModel<TypeOfRanking.Discipline> matchListModel;
	private DefaultComboBoxModel<Category> categoryListModel;
	private JComboBox<TypeOfRanking.Team_Single> comboBoxTeam_Atlet;
	private JComboBox<Category> comboBoxCategoryList;
	private JComboBox<TypeOfRanking.Discipline> comboBoxMatchList;

	private JPanel categoryPanel;
	private JPanel selectionPanel;
	private JPanel rankingListPanel;
	private JPanel tableContainerPanel;
	private JLabel lblCategory;

	/**
	 * Create the panel.
	 * 
	 * @param testFrame
	 */
	public RankingPanel(MainFrame mF) {
		setBackground(GuiHelper.getInstance().getBlue_2());

		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		this.matchFrame = mF;

		selectionPanel = new JPanel();
		selectionPanel.setBackground(GuiHelper.getInstance().getBlue_2());

		rankingListPanel = new JPanel();

		categoryPanel = new JPanel();
		categoryPanel.setBackground(GuiHelper.getInstance().getBlue_2());
		categoryPanel.setEnabled(false);

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(selectionPanel, GroupLayout.DEFAULT_SIZE, GuiHelper.getInstance().getMiusreBy1366(519),
						Short.MAX_VALUE)
				.addComponent(categoryPanel, GroupLayout.DEFAULT_SIZE, GuiHelper.getInstance().getMiusreBy1366(519),
						Short.MAX_VALUE)
				.addComponent(rankingListPanel, GroupLayout.DEFAULT_SIZE, GuiHelper.getInstance().getMiusreBy1366(519),
						Short.MAX_VALUE));
		groupLayout
				.setVerticalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
						groupLayout.createSequentialGroup()
								.addComponent(selectionPanel, GroupLayout.PREFERRED_SIZE,
										GuiHelper.getInstance().getMiusreBy1366(91), GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(categoryPanel, GroupLayout.PREFERRED_SIZE,
										GuiHelper.getInstance().getMiusreBy1366(53), GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(rankingListPanel, GroupLayout.PREFERRED_SIZE,
										GuiHelper.getInstance().getMiusreBy1366(294), Short.MAX_VALUE)
								.addContainerGap()));
		lblCategory = new JLabel("Seleziona categoria");
		comboBoxCategoryList = new JComboBox<Category>();
		GroupLayout gl_categoryPanel = new GroupLayout(categoryPanel);
		gl_categoryPanel.setHorizontalGroup(gl_categoryPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_categoryPanel.createSequentialGroup().addGap(GuiHelper.getInstance().getMiusreBy1366(212))
						.addComponent(comboBoxCategoryList, 0, 0, Short.MAX_VALUE)
						.addGap(GuiHelper.getInstance().getMiusreBy1366(222)))
				.addGroup(gl_categoryPanel.createSequentialGroup().addGap(GuiHelper.getInstance().getMiusreBy1366(199))
						.addComponent(lblCategory, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGap(GuiHelper.getInstance().getMiusreBy1366(208))));
		gl_categoryPanel.setVerticalGroup(gl_categoryPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_categoryPanel.createSequentialGroup().addComponent(lblCategory)
						.addGap(GuiHelper.getInstance().getMiusreBy1366(9))
						.addComponent(comboBoxCategoryList, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		categoryPanel.setLayout(gl_categoryPanel);

		tableContainerPanel = new JPanel();
		tableContainerPanel.setBackground(GuiHelper.getInstance().getBlue_2());

		comboBoxCategoryList.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				refreshRankingList();
			}
		});

		JLabel lblMatchList = new JLabel("Visualizza classifica per:");

		comboBoxMatchList = new JComboBox<TypeOfRanking.Discipline>();
		matchListModel = new DefaultComboBoxModel<TypeOfRanking.Discipline>();

		for (TypeOfMatch type : matchFrame.getManager().getMatches().keySet()) {
			switch (type) {
			case BENCHPRESS:
				matchListModel.addElement(TypeOfRanking.Discipline.BENCHPRESS);
				break;
			case SQUAT:
				matchListModel.addElement(TypeOfRanking.Discipline.SQUAT);
				break;
			case DEADLIFT:
				matchListModel.addElement(TypeOfRanking.Discipline.DEADLIFT);
				break;
			default:
				break;
			}
		}
		matchListModel.addElement(TypeOfRanking.Discipline.ABSOLUTE);

		comboBoxMatchList.setModel(matchListModel);
		comboBoxMatchList.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				boolean absolute = false;
				TypeOfMatch t = null;
				switch ((TypeOfRanking.Discipline) comboBoxMatchList.getSelectedItem()) {
				case BENCHPRESS:
					absolute = false;
					t = TypeOfMatch.BENCHPRESS;
					break;
				case SQUAT:
					absolute = false;
					t = TypeOfMatch.SQUAT;
					break;
				case DEADLIFT:
					absolute = false;
					t = TypeOfMatch.DEADLIFT;
					break;
				case ABSOLUTE:
					absolute = true;
					break;
				default:
					break;
				}
				Manager manager = matchFrame.getManager();
				Map<TypeOfMatch, Match> matches = manager.getMatches();

				TypeOfRanking.Team_Single team_atlet = (TypeOfRanking.Team_Single) team_atletModel.getSelectedItem();
				Set<Category> cats = new HashSet<Category>();
				if (!team_atlet.equals(TypeOfRanking.Team_Single.TEAM)) {
					Sex sex = null;
					if (team_atlet.equals(TypeOfRanking.Team_Single.SINGLE_MALE)) {
						sex = Sex.MALE;
					} else if (team_atlet.equals(TypeOfRanking.Team_Single.SINGLE_FEMALE)) {
						sex = Sex.FEMALE;
					}
					if (absolute) {
						cats = manager.getAbsoluteCategories(sex);
					} else {
						cats = manager.getCategoriesBy(t, sex);
					}
				}
				System.out.println("ABS CATEG:" + cats);
				categoryListModel = new DefaultComboBoxModel(cats.toArray());
				comboBoxCategoryList.setModel(categoryListModel);
				refreshRankingList();
			}
		});
		rankingListPanel.setLayout(new BorderLayout(0, 0));
		tableContainerPanel.setLayout(new BorderLayout(0, 0));
		rankingListPanel.add(tableContainerPanel);

		comboBoxTeam_Atlet = new JComboBox<TypeOfRanking.Team_Single>();
		team_atletModel = new DefaultComboBoxModel<TypeOfRanking.Team_Single>();
		team_atletModel.addElement(Team_Single.TEAM);
		team_atletModel.addElement(Team_Single.SINGLE_MALE);
		team_atletModel.addElement(Team_Single.SINGLE_FEMALE);
		comboBoxTeam_Atlet.setModel(team_atletModel);
		setCategoryPanelEnabled(false);
		comboBoxTeam_Atlet.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (comboBoxTeam_Atlet.getSelectedItem().equals(Team_Single.TEAM)) {
					setCategoryPanelEnabled(false);
					refreshRankingList();
				} else {
					setCategoryPanelEnabled(true);
					refreshRankingList();
				}
			}

		});

		GroupLayout gl_selectionPanel = new GroupLayout(selectionPanel);
		gl_selectionPanel.setHorizontalGroup(gl_selectionPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_selectionPanel.createSequentialGroup().addGap(GuiHelper.getInstance().getMiusreBy1366(180))
						.addComponent(lblMatchList, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE).addGap(GuiHelper.getInstance().getMiusreBy1366(176)))
				.addGroup(gl_selectionPanel.createSequentialGroup().addGap(GuiHelper.getInstance().getMiusreBy1366(207))
						.addGroup(gl_selectionPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(comboBoxTeam_Atlet, Alignment.TRAILING, 0, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(comboBoxMatchList, Alignment.TRAILING, 0, 87, Short.MAX_VALUE))
						.addGap(GuiHelper.getInstance().getMiusreBy1366(225))));
		gl_selectionPanel.setVerticalGroup(gl_selectionPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_selectionPanel.createSequentialGroup().addGap(GuiHelper.getInstance().getMiusreBy1366(5)).addComponent(lblMatchList)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(comboBoxTeam_Atlet, GroupLayout.PREFERRED_SIZE, GuiHelper.getInstance().getMiusreBy1366(21), GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(comboBoxMatchList, GroupLayout.PREFERRED_SIZE, GuiHelper.getInstance().getMiusreBy1366(21), GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		selectionPanel.setLayout(gl_selectionPanel);
		setLayout(groupLayout);
	}

	private void setCategoryPanelEnabled(boolean b) {
		lblCategory.setEnabled(b);
		comboBoxCategoryList.resetKeyboardActions();
		comboBoxCategoryList.setEnabled(b);
	}

	private void refreshRankingList() {
		TypeOfRanking.Team_Single team_single = (TypeOfRanking.Team_Single) comboBoxTeam_Atlet.getSelectedItem();
		TypeOfRanking.Discipline discipline = (TypeOfRanking.Discipline) comboBoxMatchList.getSelectedItem();
		if (team_single != null && discipline != null) {
			tableContainerPanel.removeAll();
			JScrollPane scroll = null;
			Map<TypeOfMatch, Match> matches = matchFrame.getManager().getMatches();
			switch (team_single) {
			case TEAM:
				switch (discipline) {
				case BENCHPRESS:
					scroll = GuiHelper.getInstance()
							.createTableForRanking(matches.get(TypeOfMatch.BENCHPRESS).getTeamScores());
					break;
				case SQUAT:
					scroll = GuiHelper.getInstance()
							.createTableForRanking(matches.get(TypeOfMatch.SQUAT).getTeamScores());
					break;
				case DEADLIFT:
					scroll = GuiHelper.getInstance()
							.createTableForRanking(matches.get(TypeOfMatch.DEADLIFT).getTeamScores());
					break;
				case ABSOLUTE:
					RankingPerTeam temp = new RankingPerTeam();
					popolateRankingPerTeamScoreList(matches.get(TypeOfMatch.BENCHPRESS), temp);
					popolateRankingPerTeamScoreList(matches.get(TypeOfMatch.SQUAT), temp);
					popolateRankingPerTeamScoreList(matches.get(TypeOfMatch.DEADLIFT), temp);
					scroll = GuiHelper.getInstance().createTableForRanking(temp);
					break;
				default:
					break;
				}
				break;
			case SINGLE_MALE:
				Category category = (Category) comboBoxCategoryList.getSelectedItem();
				if (category != null) {

					switch (discipline) {
					case BENCHPRESS:
						RankingPerCategory rankingBench = matches.get(TypeOfMatch.BENCHPRESS).getMatchRanking()
								.getRankings().get(category);
						scroll = GuiHelper.getInstance().createTableForRanking(rankingBench.getBySex(Sex.MALE));
						break;
					case SQUAT:
						RankingPerCategory rankingSquat = matches.get(TypeOfMatch.SQUAT).getMatchRanking().getRankings()
								.get(category);
						scroll = GuiHelper.getInstance().createTableForRanking(rankingSquat.getBySex(Sex.MALE));
						break;
					case DEADLIFT:
						RankingPerCategory rankingDeadlift = matches.get(TypeOfMatch.DEADLIFT).getMatchRanking()
								.getRankings().get(category);
						scroll = GuiHelper.getInstance().createTableForRanking(rankingDeadlift.getBySex(Sex.MALE));
						break;
					case ABSOLUTE:
						List<Competitor> competitors = this.matchFrame.getManager().getAbsoluteCompetitors(Sex.MALE,
								category);
						scroll = GuiHelper.getInstance().createTableForAbsoluteRanking(competitors);
						break;
					default:
						break;
					}
				}
				break;
			case SINGLE_FEMALE:
				Category category2 = (Category) comboBoxCategoryList.getSelectedItem();
				if (category2 != null) {

					switch (discipline) {
					case BENCHPRESS:
						RankingPerCategory rankingBench = matches.get(TypeOfMatch.BENCHPRESS).getMatchRanking()
								.getRankings().get(category2);
						scroll = GuiHelper.getInstance().createTableForRanking(rankingBench.getBySex(Sex.FEMALE));
						break;
					case SQUAT:
						RankingPerCategory rankingSquat = matches.get(TypeOfMatch.SQUAT).getMatchRanking().getRankings()
								.get(category2);
						scroll = GuiHelper.getInstance().createTableForRanking(rankingSquat.getBySex(Sex.FEMALE));
						break;
					case DEADLIFT:
						RankingPerCategory rankingDeadlift = matches.get(TypeOfMatch.DEADLIFT).getMatchRanking()
								.getRankings().get(category2);
						scroll = GuiHelper.getInstance().createTableForRanking(rankingDeadlift.getBySex(Sex.FEMALE));
						break;
					case ABSOLUTE:
						List<Competitor> competitors = this.matchFrame.getManager().getAbsoluteCompetitors(Sex.FEMALE,
								category2);
						scroll = GuiHelper.getInstance().createTableForAbsoluteRanking(competitors);
						System.out.println("COMPETITORS ************************************************* "
								+ this.matchFrame.getManager().getCompetitors().size());
						break;
					default:
						break;
					}
				}
				break;
			default:
				break;
			}
			if (scroll != null) {
				scroll.getViewport().setBackground(GuiHelper.getInstance().getBlue_1());
				tableContainerPanel.add(scroll);
			}
			tableContainerPanel.updateUI();
		}
	}

	private void popolateRankingPerTeamScoreList(Match match, RankingPerTeam temp) {
		boolean found = false;

		for (TeamScore toAdd : match.getTeamScores()) {
			found = false;
			for (TeamScore inList : temp) {
				if (inList.getName().equals(toAdd.getName())) {
					inList.setScore(inList.getScore() + toAdd.getScore());
					found = true;
					break;
				}
			}
			if (!found) {
				temp.add(toAdd);
			}
		}
	}

	private void popolateRankingPerCategoryList(RankingPerCategory rankingPerCategory, RankingPerCategory temp) {
		boolean found = false;
		for (Lifter toAdd : rankingPerCategory) {
			found = false;
			for (Lifter inList : temp) {
				if (inList.equals(toAdd)) {
					System.out.println("equals toAdd:" + inList.getCompetitor().getName());
					inList.setScore(inList.getScore() + toAdd.getScore());
					found = true;
					break;
				}
			}
			if (!found) {
				temp.add(toAdd);
			}
		}
	}
}
