package com.gym.program.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.gym.program.logic.Manager;
import com.gym.program.logic.competitor.Competitor;
import com.gym.program.logic.competitor.CompetitorBuilder;
import com.gym.program.logic.match.Match;
import com.gym.program.logic.match.Match.TypeOfMatch;
import com.gym.program.utils.Choice;
import com.gym.program.utils.Sex;

import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JTabbedPane;

public class MatchFrame extends JFrame {

	private JPanel contentPane;
	private MainFrame mainFrame;
	private Manager manager;

//	public static void main(String[] args) {
//		MatchFrame m = new MatchFrame(new Manager());
//	}
	/**
	 * Create the frame.
	 */
	public MatchFrame(MainFrame mF) {
		this.mainFrame = mF;
		this.manager = mF.getManager();
//		
//		Match m1 = new Match(TypeOfMatch.BENCHPRESS);
//		Match m2 = new Match(TypeOfMatch.DEADLIFT);
//		
//		CompetitorBuilder builder = CompetitorBuilder.newBuilder().setName("Davide").setSurname("Amato")
//				.setSex(Sex.MALE).setAge(24).setTeam("kc").setWeight(83.40);
//
//		Competitor c1 = builder.build();
//		Competitor c2 = builder.setName("Marco").setAge(27).setWeight(78).build();
//		Competitor c3 = builder.setName("Andrea").setAge(29).setWeight(62).build();
//		Competitor c4 = builder.setName("Chiara").setAge(16).setWeight(55).build();
//		Competitor c5 = builder.setName("Mimmo").setAge(58).setWeight(90).build();
//
//		// c1 c3 c5 to all matches
//		manager.addMatch(m1);
//		manager.addMatch(m2);
//
//<<<<<<< HEAD
//		manager.getMatches().get(TypeOfMatch.BENCHPRESS).signUp(c1, Choice.CLSS_WEIGHT, 1120);
//		manager.getMatches().get(TypeOfMatch.DEADLIFT).signUp(c1, Choice.CLSS_WEIGHT, 1140);
//		manager.getMatches().get(TypeOfMatch.BENCHPRESS).signUp(c2, Choice.CLSS_AGE, 1140);
//		manager.getMatches().get(TypeOfMatch.DEADLIFT).signUp(c2, Choice.CLSS_AGE, 1150);
//		manager.getMatches().get(TypeOfMatch.BENCHPRESS).signUp(c3, Choice.CLSS_AGE, 1100);
//		manager.getMatches().get(TypeOfMatch.DEADLIFT).signUp(c3, Choice.CLSS_AGE, 1120);
//		manager.getMatches().get(TypeOfMatch.BENCHPRESS).signUp(c4, Choice.CLSS_AGE, 1150);
//		manager.getMatches().get(TypeOfMatch.DEADLIFT).signUp(c5, Choice.CLSS_AGE,1100);
//
//=======
//		manager.getMatches().get(TypeOfMatch.BENCHPRESS).signUp(c1, Choice.CLSS_WEIGHT, 120);
//		manager.getMatches().get(TypeOfMatch.DEADLIFT).signUp(c1, Choice.CLSS_WEIGHT, 140);
//		manager.getMatches().get(TypeOfMatch.BENCHPRESS).signUp(c2, Choice.CLSS_AGE, 140);
//		manager.getMatches().get(TypeOfMatch.DEADLIFT).signUp(c2, Choice.CLSS_AGE, 150);
//		manager.getMatches().get(TypeOfMatch.BENCHPRESS).signUp(c3, Choice.CLSS_AGE, 100);
//		manager.getMatches().get(TypeOfMatch.DEADLIFT).signUp(c3, Choice.CLSS_AGE, 120);
//		manager.getMatches().get(TypeOfMatch.BENCHPRESS).signUp(c4, Choice.CLSS_AGE, 50);
//		manager.getMatches().get(TypeOfMatch.DEADLIFT).signUp(c5, Choice.CLSS_AGE, 100);
//		
//		
//		
//		
//>>>>>>> branch 'master' of https://github.com/mark91m12/Gym-Program
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		setVisible(true);
		contentPane = new JPanel();
		// contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		JTabbedPane tabbed_pane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbed_pane);

		tabbed_pane.add(" pedana ", new Card(this));
		tabbed_pane.add(" ordine ", new OrderPanel(this));
		tabbed_pane.add(" classifica ", new RankingPanel(this));
		this.setVisible(true);
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(final WindowEvent e) {
					final int i = JOptionPane.showConfirmDialog(MatchFrame.this, "Sei sicuro di voler chiudere l'applicazione?", "ESCI",
							JOptionPane.YES_NO_OPTION);
					if (i == JOptionPane.YES_OPTION) {
						comeBackToMainFrame();
					}
			}

		});
	}

	public Manager getManager() {
		return manager;
	}

	public void comeBackToMainFrame() {
		this.mainFrame.setVisible(true);
		this.mainFrame.update();
		this.dispose();
	}
}
