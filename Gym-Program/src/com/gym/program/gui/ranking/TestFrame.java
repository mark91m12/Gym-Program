package com.gym.program.gui.ranking;

import java.awt.EventQueue;

import javax.swing.JFrame;

import com.gym.program.logic.Manager;
import com.gym.program.logic.competitor.Competitor;
import com.gym.program.logic.match.Match;
import com.gym.program.logic.match.Match.TypeOfMatch;
import com.gym.program.utils.Choice;
import com.gym.program.utils.Sex;

public class TestFrame extends JFrame {

//	private JPanel contentPane;
	private RankingPanel rankingPanel;	
	private Manager manager;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestFrame frame = new TestFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TestFrame() {
		manager = new Manager();
		Match match = new Match(TypeOfMatch.BENCHPRESS);
		Match match2 = new Match(TypeOfMatch.SQUAT);
		Competitor c = new Competitor("Davide", "Amato", Sex.MALE, "team", 84, 24);
		Competitor c1 = new Competitor("Marco", "Amato", Sex.MALE, "team", 78, 27);
		match.signUp(c, Choice.CLSS_WEIGHT, 120);
		match.signUp(c1, Choice.CLSS_AGE, 130);
		
		Competitor c2 = new Competitor("Andrea", "Amato", Sex.MALE, "team", 62, 29);
		Competitor c3 = new Competitor("Chiara", "Amato", Sex.FEMALE, "team", 55, 16);
		match2.signUp(c, Choice.CLSS_AGE, 140);
		match2.signUp(c1, Choice.CLSS_WEIGHT, 150);
		match2.signUp(c2, Choice.CLSS_WEIGHT, 100);
		match2.signUp(c3, Choice.CLSS_AGE, 60);
		manager.addMatch(match);
		manager.addMatch(match2);
		
		rankingPanel = new RankingPanel(this);
		
//		setContentPane(contentPane);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setContentPane(rankingPanel);
		
//		pack();
		setLocationRelativeTo(null);
	}

	public Manager getManager() {
		return manager;
	}

	
}
