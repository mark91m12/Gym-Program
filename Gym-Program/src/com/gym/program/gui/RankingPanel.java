package com.gym.program.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.gym.program.logic.match.Match.TypeOfMatch;
import com.gym.program.utils.Category;
import com.gym.program.utils.GuiHelper;
import com.gym.program.utils.TypeOfRanking;
import com.gym.program.utils.TypeOfRanking.Team_Single;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class RankingPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MatchFrame matchFrame;
	private DefaultComboBoxModel<TypeOfRanking.Team_Single> team_atletModel;
	private DefaultComboBoxModel<TypeOfRanking.Discipline> matchListModel;
	private DefaultComboBoxModel<Category> categoryListModel;
	private JComboBox<TypeOfRanking.Team_Single> comboBoxTeam_Atlet;
	private JComboBox<Category> comboBoxCategoryList;
	private JComboBox<TypeOfRanking.Discipline> comboBoxMatchList;
	
	private JPanel categoryPanel;
	private JPanel selectionPanel;
	private JPanel rankingListPanel;
	private JLabel lblCategory;
	/**
	 * Create the panel.
	 * @param testFrame 
	 */
	public RankingPanel(MatchFrame mF) {
		
		this.matchFrame = mF;
		
		selectionPanel = new JPanel();
		
		rankingListPanel = new JPanel();
		
		categoryPanel = new JPanel();
		categoryPanel.setEnabled(false);
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(selectionPanel, GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)
				.addComponent(categoryPanel, GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)
				.addComponent(rankingListPanel, GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addComponent(selectionPanel, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(categoryPanel, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rankingListPanel, GroupLayout.PREFERRED_SIZE, 294, Short.MAX_VALUE)
					.addContainerGap())
		);
		lblCategory = new JLabel("Seleziona categoria");
		comboBoxCategoryList = new JComboBox<Category>();
		GroupLayout gl_categoryPanel = new GroupLayout(categoryPanel);
		gl_categoryPanel.setHorizontalGroup(
			gl_categoryPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_categoryPanel.createSequentialGroup()
					.addGroup(gl_categoryPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_categoryPanel.createSequentialGroup()
							.addGap(185)
							.addComponent(lblCategory))
						.addGroup(gl_categoryPanel.createSequentialGroup()
							.addGap(130)
							.addComponent(comboBoxCategoryList, GroupLayout.PREFERRED_SIZE, 263, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(126, Short.MAX_VALUE))
		);
		gl_categoryPanel.setVerticalGroup(
			gl_categoryPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_categoryPanel.createSequentialGroup()
					.addGap(3)
					.addComponent(lblCategory)
					.addGap(6)
					.addComponent(comboBoxCategoryList, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(33, Short.MAX_VALUE))
		);
		categoryPanel.setLayout(gl_categoryPanel);

		JPanel tableContainerPanel = new JPanel();
		tableContainerPanel.setBackground(Color.WHITE);
		
		comboBoxCategoryList.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tableContainerPanel.removeAll();
				JScrollPane scroll = GuiHelper.getInstance().createTableForRanking(
						matchFrame.getManager().getMatches().get(comboBoxMatchList.getSelectedItem()).getMatchRanking().getRankings().get(comboBoxCategoryList.getSelectedItem()));
				tableContainerPanel.add(scroll);
				tableContainerPanel.updateUI();
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
				switch ((TypeOfRanking.Discipline)comboBoxMatchList.getSelectedItem()) {
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
					tableContainerPanel.removeAll();
					//TODO Per Ogni TOM lista di punteggio per squadra; 
//					JScrollPane scroll = GuiHelper.getInstance().createTableForRanking(
//							matchFrame.getManager().getMatches().get(comboBoxMatchList.getSelectedItem()).getMatchRanking().getRankings().get(comboBoxCategoryList.getSelectedItem()));
//					tableContainerPanel.add(scroll);
					tableContainerPanel.updateUI();
					break;
				default:
					break;
				}
				if(!absolute) {
					Set<Category> categories = new HashSet<Category>();
					for (Category c: matchFrame.getManager().getMatches().get(t).getMatchRanking().getRankings().keySet()) {
						categories.add(c);
					}
					System.out.println("ACTION MATCH LIST:"+categories+"--"+comboBoxMatchList.getSelectedItem());
					categoryListModel = new DefaultComboBoxModel(categories.toArray());
					comboBoxCategoryList.setModel(categoryListModel);
				}
			}
		});
		
		GroupLayout gl_rankingListPanel = new GroupLayout(rankingListPanel);
		gl_rankingListPanel.setHorizontalGroup(
			gl_rankingListPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_rankingListPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(tableContainerPanel, GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_rankingListPanel.setVerticalGroup(
			gl_rankingListPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_rankingListPanel.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(tableContainerPanel, GroupLayout.PREFERRED_SIZE, 274, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		tableContainerPanel.setLayout(new BorderLayout(0, 0));
		rankingListPanel.setLayout(gl_rankingListPanel);
		
		comboBoxTeam_Atlet = new JComboBox<TypeOfRanking.Team_Single>();
		team_atletModel = new DefaultComboBoxModel<TypeOfRanking.Team_Single>();
		team_atletModel.addElement(Team_Single.TEAM);
		team_atletModel.addElement(Team_Single.SINGLE_MALE);
		team_atletModel.addElement(Team_Single.SINGLE_FEMALE);
		comboBoxTeam_Atlet.setModel(team_atletModel);
		comboBoxTeam_Atlet.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(comboBoxTeam_Atlet.getSelectedItem().equals(Team_Single.TEAM)) {
					setCategoryPanelEnabled(false);
				}else {
					setCategoryPanelEnabled(true);
				}
			}

		});
		
		GroupLayout gl_selectionPanel = new GroupLayout(selectionPanel);
		gl_selectionPanel.setHorizontalGroup(
			gl_selectionPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_selectionPanel.createSequentialGroup()
					.addContainerGap(180, Short.MAX_VALUE)
					.addComponent(lblMatchList, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
					.addGap(176))
				.addGroup(gl_selectionPanel.createSequentialGroup()
					.addGap(127)
					.addGroup(gl_selectionPanel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(comboBoxMatchList, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(comboBoxTeam_Atlet, Alignment.LEADING, 0, 265, Short.MAX_VALUE))
					.addGap(5))
		);
		gl_selectionPanel.setVerticalGroup(
			gl_selectionPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_selectionPanel.createSequentialGroup()
					.addGap(5)
					.addComponent(lblMatchList)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(comboBoxTeam_Atlet, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(comboBoxMatchList, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addGap(59))
		);
		selectionPanel.setLayout(gl_selectionPanel);
		setLayout(groupLayout);
	}

	private void setCategoryPanelEnabled(boolean b) {
		lblCategory.setEnabled(b);
		comboBoxCategoryList.resetKeyboardActions();
		comboBoxCategoryList.setEnabled(b);
	}
}
