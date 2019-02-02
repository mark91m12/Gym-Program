package com.gym.program.gui.menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import com.gym.program.gui.ImagePanel;
import com.gym.program.gui.MatchFrame;
import com.gym.program.gui.PanelSwitcher;
import com.gym.program.gui.RankingPanel;
import com.gym.program.logic.Manager;
import com.gym.program.logic.competitor.Competitor;
import com.gym.program.logic.competitor.CompetitorBuilder;
import com.gym.program.logic.match.Match;
import com.gym.program.logic.match.Match.TypeOfMatch;
import com.gym.program.utils.Choice;
import com.gym.program.utils.CollarType;
import com.gym.program.utils.GuiHelper;
import com.gym.program.utils.Sex;

public class MainFrame extends JFrame implements PanelSwitcher {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	// private final DisciplinePanel disciplinePanel;
	private final DisciplinePanel2 disciplinePanel;
	private ImagePanel mainPanelToSwitch;
	private Manager manager;
	private JButton btnChooseDisciplines;
	private JButton btnInsertLifters;
	private JRadioButton rdbtnBenchPress;
	private JRadioButton rdbtnSquat;
	private JRadioButton rdbtnDeadLift;
	private JButton btnStart;

	private JButton btnTest;

	private MatchFrame matchFrame;
	private CollarType collarType;
	private JButton btn_check_score;

	private JButton btnRanking;

	private ImageIcon imageBg;

	/**
	 * Create the frame.
	 */
	public MainFrame(Manager manager) {

		this.manager = manager;

		this.disciplinePanel = new DisciplinePanel2(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setSize(Toolkit.getDefaultToolkit().getScreenSize());

		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(final WindowEvent e) {
				final int i = JOptionPane.showConfirmDialog(MainFrame.this,
						"Sei sicuro di voler chiudere l'applicazione?", "ESCI", JOptionPane.YES_NO_OPTION);
				if (i == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});

		JPanel menuPanel = new JPanel();
		menuPanel.setBackground(Color.DARK_GRAY);

		imageBg = new ImageIcon("images/menu/main_menu3.jpg");
		mainPanelToSwitch = new ImagePanel(null);
		mainPanelToSwitch.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		mainPanelToSwitch.setImage(imageBg.getImage().getScaledInstance(
				mainPanelToSwitch.getSize().width - GuiHelper.getInstance().getMiusreBy1920(280),
				mainPanelToSwitch.getSize().height - GuiHelper.getInstance().getMiusreBy1920(50), Image.SCALE_SMOOTH));

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(menuPanel, GroupLayout.PREFERRED_SIZE,
								GuiHelper.getInstance().getMiusreBy1920(238), GroupLayout.PREFERRED_SIZE)
						.addGap(GuiHelper.getInstance().getMiusreBy1920(18)).addComponent(mainPanelToSwitch,
								GroupLayout.DEFAULT_SIZE, GuiHelper.getInstance().getMiusreBy1920(1636),
								Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(mainPanelToSwitch, GroupLayout.DEFAULT_SIZE,
										GuiHelper.getInstance().getMiusreBy1920(1023), Short.MAX_VALUE)
								.addComponent(menuPanel, GroupLayout.DEFAULT_SIZE,
										GuiHelper.getInstance().getMiusreBy1920(1023), Short.MAX_VALUE))
						.addGap(0)));

		btnInsertLifters = new JButton("");
		btnInsertLifters.setIcon(new ImageIcon(MainFrame.class.getResource("/btns/button_iscrivi-atleti.png")));
		btnInsertLifters.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switchTo(new InsertForm(MainFrame.this));
			}
		});

		JLabel lblSelezionaGara = new JLabel("Seleziona gara:");
		lblSelezionaGara.setFont(new Font("Tahoma", Font.BOLD, GuiHelper.getInstance().getMiusreBy1920(20)));
		lblSelezionaGara.setForeground(Color.WHITE);

		rdbtnBenchPress = new JRadioButton("Bench Press");
		rdbtnBenchPress.setFont(new Font("Tahoma", Font.PLAIN, GuiHelper.getInstance().getMiusreBy1920(16)));
		rdbtnBenchPress.setEnabled(false);
		rdbtnBenchPress.setForeground(Color.WHITE);
		rdbtnBenchPress.setBackground(Color.DARK_GRAY);

		rdbtnSquat = new JRadioButton("Squat");
		rdbtnSquat.setFont(new Font("Tahoma", Font.PLAIN, GuiHelper.getInstance().getMiusreBy1920(16)));
		rdbtnSquat.setForeground(Color.WHITE);
		rdbtnSquat.setBackground(Color.DARK_GRAY);
		rdbtnSquat.setEnabled(false);

		rdbtnDeadLift = new JRadioButton("Dead Lift");
		rdbtnDeadLift.setFont(new Font("Tahoma", Font.PLAIN, GuiHelper.getInstance().getMiusreBy1920(16)));
		rdbtnDeadLift.setForeground(Color.WHITE);
		rdbtnDeadLift.setBackground(Color.DARK_GRAY);
		rdbtnDeadLift.setEnabled(false);

		Set<JRadioButton> setRdBtns = new HashSet<>();
		setRdBtns.add(rdbtnBenchPress);
		setRdBtns.add(rdbtnSquat);
		setRdBtns.add(rdbtnDeadLift);
		GuiHelper.getInstance().setSwitch(setRdBtns);

		btnStart = new JButton("");
		btnStart.setIcon(new ImageIcon(MainFrame.class.getResource("/btns/button_inizia-gara.png")));
		btnStart.setEnabled(false);
		btnStart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (rdbtnBenchPress.isSelected()) {
					MainFrame.this.manager.setCurrentTypeOfMatch(TypeOfMatch.BENCHPRESS);
				} else if (rdbtnSquat.isSelected()) {
					MainFrame.this.manager.setCurrentTypeOfMatch(TypeOfMatch.SQUAT);
				} else if (rdbtnDeadLift.isSelected()) {
					MainFrame.this.manager.setCurrentTypeOfMatch(TypeOfMatch.DEADLIFT);
				}
				matchFrame = new MatchFrame(MainFrame.this);
				// MainFrame.this.setVisible(false);
			}
		});

		btnChooseDisciplines = new JButton("");
		btnChooseDisciplines.setIcon(new ImageIcon(MainFrame.class.getResource("/btns/button_scegli-discipline.png")));
		btnChooseDisciplines.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// switchTo(disciplinePanel);
				switchTo(new DisciplinePanel2(MainFrame.this));
			}
		});

		btnTest = new JButton("Crea istanza Test");
		btnTest.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.this.manager = new Manager();
				Match m1 = new Match(TypeOfMatch.BENCHPRESS);
				Match m2 = new Match(TypeOfMatch.DEADLIFT);
				Match m3 = new Match(TypeOfMatch.SQUAT);

				CompetitorBuilder builder = CompetitorBuilder.newBuilder().setName("Davide").setSurname("Amato")
						.setSex(Sex.MALE).setAge(24).setTeam("karate club").setAbsoluteRanking(true).setWeight(83.40);

				Competitor c1 = builder.build();
				Competitor c2 = builder.setName("Marco").setAge(27).setWeight(78).build();
				Competitor c3 = builder.setName("Andrea").setAge(29).setWeight(62).setTeam("dynamo").build();
				Competitor c4 = builder.setName("Chiara").setAge(16).setWeight(55).setSex(Sex.FEMALE).build();
				Competitor c5 = builder.setName("Mimmo").setAge(58).setWeight(90).setSex(Sex.MALE).setTeam("dynamo")
						.build();

				MainFrame.this.manager.getCompetitors().add(c1);
				MainFrame.this.manager.getCompetitors().add(c2);
				MainFrame.this.manager.getCompetitors().add(c3);
				MainFrame.this.manager.getCompetitors().add(c4);
				MainFrame.this.manager.getCompetitors().add(c5);

				System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@" + manager.getCompetitors());

				// c1 c3 c5 to all matches
				manager.addMatch(m1);
				manager.addMatch(m2);

				MainFrame.this.manager.set0p25Present(true);
				MainFrame.this.manager.set0p5Present(true);

				MainFrame.this.manager.setMatches(new HashMap<>());
				MainFrame.this.manager.addMatch(m1);
				MainFrame.this.manager.addMatch(m2);
				MainFrame.this.manager.addMatch(m3);
				MainFrame.this.manager.getMatches().get(TypeOfMatch.BENCHPRESS).signUp(c1, Choice.CLSS_WEIGHT, 120, 6);
				MainFrame.this.manager.getMatches().get(TypeOfMatch.SQUAT).signUp(c1, Choice.CLSS_WEIGHT, 140, 12);
				MainFrame.this.manager.getMatches().get(TypeOfMatch.DEADLIFT).signUp(c1, Choice.CLSS_WEIGHT, 160, 0);
				MainFrame.this.manager.getMatches().get(TypeOfMatch.BENCHPRESS).signUp(c2, Choice.CLSS_AGE, 130, 6);
				MainFrame.this.manager.getMatches().get(TypeOfMatch.SQUAT).signUp(c2, Choice.CLSS_AGE, 150, 12);
				MainFrame.this.manager.getMatches().get(TypeOfMatch.DEADLIFT).signUp(c2, Choice.CLSS_AGE, 160, 0);
				MainFrame.this.manager.getMatches().get(TypeOfMatch.BENCHPRESS).signUp(c3, Choice.CLSS_AGE, 100, 5);
				MainFrame.this.manager.getMatches().get(TypeOfMatch.SQUAT).signUp(c3, Choice.CLSS_AGE, 120, 14);
				MainFrame.this.manager.getMatches().get(TypeOfMatch.DEADLIFT).signUp(c3, Choice.CLSS_AGE, 120, 0);
				MainFrame.this.manager.getMatches().get(TypeOfMatch.BENCHPRESS).signUp(c5, Choice.CLSS_WEIGHT, 70, 6);
				MainFrame.this.manager.getMatches().get(TypeOfMatch.DEADLIFT).signUp(c4, Choice.CLSS_WEIGHT, 60, 0);

				MainFrame.this.setCollar(CollarType.WEIGHT);
				MainFrame.this.update();
				btnStart.setEnabled(true);
			}
		});

		JButton btnShowDisputePanel = new JButton("");
		btnShowDisputePanel.setIcon(new ImageIcon(MainFrame.class.getResource("/btns/button_contestazioni.png")));
		btnShowDisputePanel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switchTo(new DisputePanel(MainFrame.this));
			}
		});

		btn_check_score = new JButton("");
		btn_check_score.setIcon(new ImageIcon(MainFrame.class.getResource("/btns/button_punteggio-wilks.png")));
		btn_check_score.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				switchTo(new CheckScorePanel());
			}
		});

		btnRanking = new JButton("");
		btnRanking.setIcon(new ImageIcon(MainFrame.class.getResource("/btns/button_classifica.png")));
		btnRanking.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				switchTo(new RankingPanel(MainFrame.this));
			}
		});
		GroupLayout gl_menuPanel = new GroupLayout(menuPanel);
		gl_menuPanel
				.setHorizontalGroup(
						gl_menuPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING,
										gl_menuPanel
												.createSequentialGroup().addGroup(gl_menuPanel
														.createParallelGroup(Alignment.TRAILING).addGroup(
																Alignment.LEADING, gl_menuPanel.createSequentialGroup()
																		.addContainerGap().addComponent(btnStart,
																				GroupLayout.PREFERRED_SIZE,
																				GuiHelper.getInstance()
																						.getMiusreBy1920(202),
																				Short.MAX_VALUE))
														.addGroup(Alignment.LEADING, gl_menuPanel
																.createSequentialGroup().addContainerGap().addComponent(
																		btnShowDisputePanel, GroupLayout.PREFERRED_SIZE,
																		GuiHelper
																				.getInstance().getMiusreBy1920(202),
																		Short.MAX_VALUE))
														.addGroup(Alignment.LEADING,
																gl_menuPanel.createSequentialGroup().addContainerGap()
																		.addComponent(btn_check_score, 0, 0,
																				Short.MAX_VALUE))
														.addGroup(Alignment.LEADING, gl_menuPanel
																.createParallelGroup(Alignment.TRAILING, false)
																.addGroup(Alignment.LEADING, gl_menuPanel
																		.createSequentialGroup()
																		.addGap(GuiHelper.getInstance()
																				.getMiusreBy1920(36))
																		.addGroup(gl_menuPanel
																				.createParallelGroup(Alignment.LEADING,
																						false)
																				.addComponent(rdbtnBenchPress)
																				.addComponent(lblSelezionaGara,
																						GroupLayout.DEFAULT_SIZE,
																						GroupLayout.DEFAULT_SIZE,
																						Short.MAX_VALUE)
																				.addComponent(rdbtnSquat,
																						GroupLayout.DEFAULT_SIZE,
																						GroupLayout.DEFAULT_SIZE,
																						Short.MAX_VALUE)
																				.addComponent(rdbtnDeadLift,
																						GroupLayout.PREFERRED_SIZE,
																						GuiHelper.getInstance()
																								.getMiusreBy1920(108),
																						GroupLayout.PREFERRED_SIZE)
																				.addComponent(btnTest,
																						GroupLayout.DEFAULT_SIZE,
																						GuiHelper.getInstance()
																								.getMiusreBy1920(163),
																						Short.MAX_VALUE)))
																.addGroup(Alignment.LEADING, gl_menuPanel
																		.createSequentialGroup().addContainerGap()
																		.addComponent(btnChooseDisciplines,
																				GroupLayout.PREFERRED_SIZE,
																				GuiHelper.getInstance().getMiusreBy1920(
																						202),
																				Short.MAX_VALUE)))
														.addGroup(gl_menuPanel.createSequentialGroup().addContainerGap()
																.addGroup(gl_menuPanel
																		.createParallelGroup(Alignment.TRAILING)
																		.addComponent(btnRanking, Alignment.LEADING,
																				GroupLayout.PREFERRED_SIZE,
																				GuiHelper.getInstance().getMiusreBy1920(
																						202),
																				Short.MAX_VALUE)
																		.addComponent(btnInsertLifters,
																				Alignment.LEADING,
																				GroupLayout.PREFERRED_SIZE,
																				GuiHelper.getInstance().getMiusreBy1920(
																						202),
																				Short.MAX_VALUE))))
												.addGap(GuiHelper.getInstance().getMiusreBy1920(24))));
		gl_menuPanel.setVerticalGroup(gl_menuPanel.createParallelGroup(Alignment.LEADING).addGroup(gl_menuPanel
				.createSequentialGroup().addGap(GuiHelper.getInstance().getMiusreBy1920(22))
				.addComponent(btnChooseDisciplines, GroupLayout.PREFERRED_SIZE,
						GuiHelper.getInstance().getMiusreBy1920(52), GroupLayout.PREFERRED_SIZE)
				.addGap(GuiHelper.getInstance().getMiusreBy1920(18))
				.addComponent(btnInsertLifters, GroupLayout.PREFERRED_SIZE, GuiHelper.getInstance().getMiusreBy1920(53),
						GroupLayout.PREFERRED_SIZE)
				.addGap(GuiHelper.getInstance().getMiusreBy1920(167))
				.addComponent(btnRanking, GroupLayout.PREFERRED_SIZE, GuiHelper.getInstance().getMiusreBy1920(51),
						GroupLayout.PREFERRED_SIZE)
				.addGap(GuiHelper.getInstance().getMiusreBy1920(18))
				.addComponent(btn_check_score, GroupLayout.PREFERRED_SIZE, GuiHelper.getInstance().getMiusreBy1920(50),
						GroupLayout.PREFERRED_SIZE)
				.addGap(GuiHelper.getInstance().getMiusreBy1920(18))
				.addComponent(btnShowDisputePanel, GroupLayout.PREFERRED_SIZE,
						GuiHelper.getInstance().getMiusreBy1920(50), GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED, GuiHelper.getInstance().getMiusreBy1920(198),
						Short.MAX_VALUE)
				.addComponent(btnTest).addGap(GuiHelper.getInstance().getMiusreBy1920(51))
				.addComponent(lblSelezionaGara).addPreferredGap(ComponentPlacement.UNRELATED)
				.addComponent(rdbtnBenchPress).addPreferredGap(ComponentPlacement.UNRELATED).addComponent(rdbtnSquat)
				.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(rdbtnDeadLift)
				.addGap(GuiHelper.getInstance().getMiusreBy1920(26)).addComponent(btnStart, GroupLayout.PREFERRED_SIZE,
						GuiHelper.getInstance().getMiusreBy1920(51), GroupLayout.PREFERRED_SIZE)
				.addGap(GuiHelper.getInstance().getMiusreBy1920(99))));
		menuPanel.setLayout(gl_menuPanel);
		contentPane.setLayout(gl_contentPane);
		switchTo(disciplinePanel);
		this.setVisible(true);
	}

	@Override
	public void switchTo(JComponent component) {
		this.mainPanelToSwitch.removeAll();
		this.mainPanelToSwitch.add(component);
		this.mainPanelToSwitch.updateUI();
		component.requestFocus();
		// pack();
		setLocationRelativeTo(null);
	}

	public Manager getManager() {
		return manager;
	}

	// public void showInsertForm() {
	// switchTo(new InsertForm(this));
	// }
	//
	// public void showCheckScorePanel() {
	// switchTo(new CheckScorePanel());
	// }
	//
	// public void showRankingPanel() {
	// switchTo(new RankingPanel(this));
	// }

	public void setStartBtnEnabled(boolean b) {
		updateRdBtnsMatchesToStart();
		btnStart.setEnabled(b);
	}

	public void sumbitDisciplines(List<TypeOfMatch> disciplinesChoosen) {
		manager.setMatches(new HashMap<>());
		for (int i = 0; i < disciplinesChoosen.size(); i++) {
			manager.addMatch(new Match(disciplinesChoosen.get(i)));
		}
		btnInsertLifters.setEnabled(true);
	}

	private boolean anyMatchYetSelected() {
		return rdbtnBenchPress.isSelected() || rdbtnSquat.isSelected() || rdbtnDeadLift.isSelected();
	}

	public void update() {
		updateRdBtnsMatchesToStart();
	}

	private void updateRdBtnsMatchesToStart() {
		Set<TypeOfMatch> matches = manager.getMatches().keySet();
		if (matches.contains(TypeOfMatch.BENCHPRESS) && !manager.getCompleted().contains(TypeOfMatch.BENCHPRESS)) {
			rdbtnBenchPress.setEnabled(true);
			if (!anyMatchYetSelected()) {
				rdbtnBenchPress.setSelected(true);
			}
		}
		if (matches.contains(TypeOfMatch.SQUAT) && !manager.getCompleted().contains(TypeOfMatch.SQUAT)) {
			rdbtnSquat.setEnabled(true);
			if (!anyMatchYetSelected()) {
				rdbtnSquat.setSelected(true);
			}
		}
		if (matches.contains(TypeOfMatch.DEADLIFT) && !manager.getCompleted().contains(TypeOfMatch.DEADLIFT)) {
			rdbtnDeadLift.setEnabled(true);
			if (!anyMatchYetSelected()) {
				rdbtnDeadLift.setSelected(true);
			}
		}
	}

	public void setCollar(CollarType cT) {
		this.collarType = cT;
	}

	public CollarType getCollar() {
		return this.collarType;
	}

	// public void showDisputeForm() {
	// switchTo(new DisputePanel(this));
	// }
}
