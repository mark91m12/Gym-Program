package com.gym.program.gui;

import java.awt.Color;
import java.awt.Font;
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

import com.gym.program.logic.Manager;
import com.gym.program.logic.competitor.Competitor;
import com.gym.program.logic.competitor.CompetitorBuilder;
import com.gym.program.logic.match.Match;
import com.gym.program.logic.match.Match.TypeOfMatch;
import com.gym.program.utils.Choice;
import com.gym.program.utils.GuiHelper;
import com.gym.program.utils.Sex;

public class MainFrame extends JFrame implements PanelSwitcher {

	private JPanel contentPane;
	private final DisciplinePanel disciplinePanel;
	private JPanel mainPanelToSwitch;
	private Manager manager;
	private JButton btnChooseDisciplines;
	private JButton btnInsertLifters;
	private JRadioButton rdbtnBenchPress;
	private JRadioButton rdbtnSquat;
	private JRadioButton rdbtnDeadLift;
	private JButton btnStart;

	private JButton btnTest;
	
	private MatchFrame matchFrame;

	/**
	 * Create the frame.
	 */
	public MainFrame(Manager manager) {
		this.manager = manager;

		this.disciplinePanel = new DisciplinePanel(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setSize(Toolkit.getDefaultToolkit().getScreenSize());

		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(final WindowEvent e) {
				final int i = JOptionPane.showConfirmDialog(MainFrame.this, "Sei sicuro di voler chiudere l'applicazione?", "ESCI",
						JOptionPane.YES_NO_OPTION);
				if (i == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});

		JPanel menuPanel = new JPanel();
		menuPanel.setBackground(Color.DARK_GRAY);

		mainPanelToSwitch = new JPanel();
		mainPanelToSwitch.setBackground(Color.ORANGE);

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(menuPanel, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE).addGap(18)
						.addComponent(mainPanelToSwitch, GroupLayout.DEFAULT_SIZE, 1636, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(mainPanelToSwitch, GroupLayout.DEFAULT_SIZE, 1023, Short.MAX_VALUE)
								.addComponent(menuPanel, GroupLayout.DEFAULT_SIZE, 1023, Short.MAX_VALUE))
						.addGap(0)));

		btnInsertLifters = new JButton("Iscrivi atleti");
		btnInsertLifters.setEnabled(false);
		btnInsertLifters.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showInsertForm();
			}
		});

		JLabel lblSelezionaGara = new JLabel("Seleziona gara");
		lblSelezionaGara.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSelezionaGara.setForeground(Color.WHITE);

		rdbtnBenchPress = new JRadioButton("Bench Press");
		rdbtnBenchPress.setEnabled(false);
		rdbtnBenchPress.setForeground(Color.WHITE);
		rdbtnBenchPress.setBackground(Color.DARK_GRAY);

		rdbtnSquat = new JRadioButton("Squat");
		rdbtnSquat.setForeground(Color.WHITE);
		rdbtnSquat.setBackground(Color.DARK_GRAY);
		rdbtnSquat.setEnabled(false);

		rdbtnDeadLift = new JRadioButton("Dead Lift");
		rdbtnDeadLift.setForeground(Color.WHITE);
		rdbtnDeadLift.setBackground(Color.DARK_GRAY);
		rdbtnDeadLift.setEnabled(false);

		Set<JRadioButton> setRdBtns = new HashSet<>();
		setRdBtns.add(rdbtnBenchPress);
		setRdBtns.add(rdbtnSquat);
		setRdBtns.add(rdbtnDeadLift);
		GuiHelper.getInstance().setSwitch(setRdBtns);

		btnStart = new JButton("Inizia gara");
		btnStart.setEnabled(false);
		btnStart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (rdbtnBenchPress.isSelected()) {
					MainFrame.this.manager.setCurrentTypeOfMatch(TypeOfMatch.BENCHPRESS);
				} else if (rdbtnSquat.isSelected()) {
					MainFrame.this.manager.setCurrentTypeOfMatch(TypeOfMatch.BENCHPRESS);
				} else if (rdbtnDeadLift.isSelected()) {
					MainFrame.this.manager.setCurrentTypeOfMatch(TypeOfMatch.BENCHPRESS);
				}
				matchFrame = new MatchFrame(MainFrame.this);
				MainFrame.this.setVisible(false);
			}
		});

		btnChooseDisciplines = new JButton("Scegli discipline");
		btnChooseDisciplines.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switchTo(disciplinePanel);
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
						.setSex(Sex.MALE).setAge(24).setTeam("kc").setWeight(83.40);
		
				Competitor c1 = builder.build();
				Competitor c2 = builder.setName("Marco").setAge(27).setWeight(78).build();
				Competitor c3 = builder.setName("Andrea").setAge(29).setWeight(62).build();
				Competitor c4 = builder.setName("Chiara").setAge(16).setWeight(55).build();
				Competitor c5 = builder.setName("Mimmo").setAge(58).setWeight(90).build();
		
				// c1 c3 c5 to all matches
				manager.addMatch(m1);
				manager.addMatch(m2);
		
				MainFrame.this.manager.setMatches(new HashMap<>());
				MainFrame.this.manager.addMatch(m1);
				MainFrame.this.manager.addMatch(m2);
				MainFrame.this.manager.addMatch(m3);
				MainFrame.this.manager.getMatches().get(TypeOfMatch.BENCHPRESS).signUp(c1, Choice.CLSS_WEIGHT, 120);
				MainFrame.this.manager.getMatches().get(TypeOfMatch.SQUAT).signUp(c1, Choice.CLSS_WEIGHT, 140);
				MainFrame.this.manager.getMatches().get(TypeOfMatch.DEADLIFT).signUp(c1, Choice.CLSS_WEIGHT, 160);
				MainFrame.this.manager.getMatches().get(TypeOfMatch.BENCHPRESS).signUp(c2, Choice.CLSS_AGE, 130);
				MainFrame.this.manager.getMatches().get(TypeOfMatch.SQUAT).signUp(c2, Choice.CLSS_WEIGHT, 150);
				MainFrame.this.manager.getMatches().get(TypeOfMatch.DEADLIFT).signUp(c2, Choice.CLSS_AGE, 160);
				MainFrame.this.manager.getMatches().get(TypeOfMatch.BENCHPRESS).signUp(c3, Choice.CLSS_AGE, 100);
				MainFrame.this.manager.getMatches().get(TypeOfMatch.SQUAT).signUp(c3, Choice.CLSS_WEIGHT, 120);
				MainFrame.this.manager.getMatches().get(TypeOfMatch.DEADLIFT).signUp(c3, Choice.CLSS_AGE, 120);
				MainFrame.this.manager.getMatches().get(TypeOfMatch.BENCHPRESS).signUp(c5, Choice.CLSS_AGE, 70);
				MainFrame.this.manager.getMatches().get(TypeOfMatch.DEADLIFT).signUp(c4, Choice.CLSS_AGE, 60);
				
				MainFrame.this.update();
				btnStart.setEnabled(true);
			}
		});
		GroupLayout gl_menuPanel = new GroupLayout(menuPanel);
		gl_menuPanel.setHorizontalGroup(
			gl_menuPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_menuPanel.createSequentialGroup()
					.addGroup(gl_menuPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_menuPanel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_menuPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(rdbtnBenchPress)
								.addGroup(gl_menuPanel.createSequentialGroup()
									.addGap(24)
									.addComponent(btnStart))
								.addGroup(gl_menuPanel.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(rdbtnSquat, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(rdbtnDeadLift, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE))))
						.addGroup(gl_menuPanel.createSequentialGroup()
							.addGap(53)
							.addGroup(gl_menuPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(btnChooseDisciplines)
								.addComponent(btnInsertLifters, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnTest)))
						.addGroup(gl_menuPanel.createSequentialGroup()
							.addGap(63)
							.addComponent(lblSelezionaGara)))
					.addContainerGap(57, Short.MAX_VALUE))
		);
		gl_menuPanel.setVerticalGroup(
			gl_menuPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_menuPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnChooseDisciplines)
					.addGap(56)
					.addComponent(btnInsertLifters)
					.addGap(18)
					.addComponent(btnTest)
					.addGap(47)
					.addComponent(lblSelezionaGara)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(rdbtnBenchPress)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(rdbtnSquat)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(rdbtnDeadLift)
					.addGap(18)
					.addComponent(btnStart)
					.addContainerGap(661, Short.MAX_VALUE))
		);
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

	public void showInsertForm() {
		switchTo(new InsertForm(this));
	}

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
}
