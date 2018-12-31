package com.gym.program.gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.TableModel;

import com.gym.program.logic.Manager;
import com.gym.program.logic.competitor.Competitor;
import com.gym.program.logic.competitor.CompetitorBuilder;
import com.gym.program.logic.match.Match;
import com.gym.program.logic.match.Match.TypeOfMatch;
import com.gym.program.utils.Choice;
import com.gym.program.utils.GuiHelper;
import com.gym.program.utils.Sex;
import java.awt.BorderLayout;

public class OrderPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox choice_box;
	private JPanel list_panel;
	private JPanel choice_panel;

	/**
	 * Create the frame.
	 */

	public OrderPanel() {

		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		setVisible(true);

		list_panel = new JPanel();
		list_panel.setBackground(Color.CYAN);

		choice_panel = new JPanel();

		GroupLayout gl_contentPane = new GroupLayout(this);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup().addGap(1)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(choice_panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1355,
										Short.MAX_VALUE)
								.addComponent(list_panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1355,
										Short.MAX_VALUE))
						.addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(choice_panel, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
						.addComponent(list_panel, GroupLayout.PREFERRED_SIZE, 670, GroupLayout.PREFERRED_SIZE)
						.addGap(43)));
		list_panel.setLayout(new BorderLayout(0, 0));

		choice_box = new JComboBox();

		choice_box.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				// UPDATE LIST 
				System.out.println("SCELTO " + choice_box.getSelectedItem());
			}
		});

		choice_panel.add(choice_box);
		this.setPossibleChoices();

		this.initTable();

		this.setLayout(gl_contentPane);
	}

	private void setPossibleChoices() {
		this.choice_box.addItem("Bench Press");
		this.choice_box.addItem("Squat");
		this.choice_box.addItem("Deadlift");

		// this.match.... get list typeofmatch

		// foreach list add item
	}

	private void initTable() {

		Manager manager = new Manager();

		Match match_bench = new Match(TypeOfMatch.BENCHPRESS);

		CompetitorBuilder builder = CompetitorBuilder.newBuilder().setName("c1 nome").setSurname("c1 cognome")
				.setSex(Sex.MALE).setAge(24).setTeam("kc").setWeight(82.40);

		Competitor c1 = builder.build();

		// c1 c3 c5 to all matches
		manager.addMatch(match_bench);

		manager.getMatches().get(TypeOfMatch.BENCHPRESS).signUp(c1, Choice.CLSS_WEIGHT, 120);
		manager.getMatches().get(TypeOfMatch.BENCHPRESS).signUp(c1, Choice.CLSS_AGE, 140);
		manager.getMatches().get(TypeOfMatch.BENCHPRESS).signUp(c1, Choice.CLSS_WEIGHT, 120);
		manager.getMatches().get(TypeOfMatch.BENCHPRESS).signUp(c1, Choice.CLSS_AGE, 110);

		Object names[] = { " Posizione ", " Cognome ", " Nome ", " Squadra ", " Età ", " Peso Corporeo ", " Categoria ",
				" Peso da sollevare " };

		JScrollPane scroll = GuiHelper.getInstance().createTable(names,
				manager.getMatches().get(TypeOfMatch.BENCHPRESS).getLifters());

		this.list_panel.add(scroll);

	}
}
