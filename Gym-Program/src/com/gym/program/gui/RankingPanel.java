package com.gym.program.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.gym.program.logic.match.Lifter;
import com.gym.program.logic.match.Match.TypeOfMatch;
import com.gym.program.utils.Category;
import com.gym.program.utils.GuiHelper;

public class RankingPanel extends JPanel {

	private MatchFrame matchFrame;
	private DefaultComboBoxModel<TypeOfMatch> matchListModel;
	private DefaultComboBoxModel<Category> categoryListModel;
	private DefaultListModel<String> liftersModel;
	
	private JComboBox comboBoxCategoryList;
	private JComboBox comboBoxMatchList;
	/**
	 * Create the panel.
	 * @param testFrame 
	 */
	public RankingPanel(MatchFrame mF) {
		
		this.matchFrame = mF;
		
		JPanel matchListPanel = new JPanel();
		
		JPanel categoryPanel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(matchListPanel, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
				.addComponent(categoryPanel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(matchListPanel, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(categoryPanel, GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE))
		);
		
		JLabel lblMatchList = new JLabel("Seleziona disciplina");
		
		comboBoxMatchList = new JComboBox();
		matchListModel = new DefaultComboBoxModel();
		for (TypeOfMatch type : matchFrame.getManager().getMatches().keySet()) {
			matchListModel.addElement(type);
		}
		comboBoxMatchList.setModel(matchListModel);
		comboBoxMatchList.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Set<Category> categories = new HashSet();
				for (Category c: matchFrame.getManager().getMatches().get(comboBoxMatchList.getSelectedItem()).getMatchRanking().getRankings().keySet()) {
					categories.add(c);
				}
				System.out.println("ACTION MATCH LIST:"+categories+"--"+comboBoxMatchList.getSelectedItem());
				categoryListModel = new DefaultComboBoxModel(categories.toArray());
				comboBoxCategoryList.setModel(categoryListModel);
			}
		});
		
		
		JPanel tableContainerPanel = new JPanel();
		tableContainerPanel.setBackground(Color.WHITE);
		JLabel lblCategory = new JLabel("Seleziona categoria");
		comboBoxCategoryList = new JComboBox();
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
		
		

		GroupLayout gl_categoryPanel = new GroupLayout(categoryPanel);
		gl_categoryPanel.setHorizontalGroup(
			gl_categoryPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_categoryPanel.createSequentialGroup()
					.addGap(124)
					.addComponent(comboBoxCategoryList, 0, 258, Short.MAX_VALUE)
					.addGap(125))
				.addGroup(gl_categoryPanel.createSequentialGroup()
					.addGap(192)
					.addComponent(lblCategory, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(203))
				.addGroup(gl_categoryPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(tableContainerPanel, GroupLayout.PREFERRED_SIZE, 425, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(70, Short.MAX_VALUE))
		);
		gl_categoryPanel.setVerticalGroup(
			gl_categoryPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_categoryPanel.createSequentialGroup()
					.addComponent(lblCategory)
					.addGap(12)
					.addComponent(comboBoxCategoryList, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tableContainerPanel, GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
					.addGap(36))
		);
		tableContainerPanel.setLayout(new BorderLayout(0, 0));
		categoryPanel.setLayout(gl_categoryPanel);
		
		
		GroupLayout gl_matchListPanel = new GroupLayout(matchListPanel);
		gl_matchListPanel.setHorizontalGroup(
			gl_matchListPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_matchListPanel.createSequentialGroup()
					.addGap(127)
					.addComponent(comboBoxMatchList, 0, 199, Short.MAX_VALUE)
					.addGap(124))
				.addGroup(Alignment.LEADING, gl_matchListPanel.createSequentialGroup()
					.addGap(191)
					.addComponent(lblMatchList, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(203))
		);
		gl_matchListPanel.setVerticalGroup(
			gl_matchListPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_matchListPanel.createSequentialGroup()
					.addGap(5)
					.addComponent(lblMatchList)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboBoxMatchList, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(29, Short.MAX_VALUE))
		);
		matchListPanel.setLayout(gl_matchListPanel);
		setLayout(groupLayout);

	}
}
