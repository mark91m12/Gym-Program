package com.gym.program.gui;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.gym.program.logic.Manager;
import com.gym.program.logic.competitor.Competitor;
import com.gym.program.logic.competitor.CompetitorBuilder;
import com.gym.program.logic.match.Match;
import com.gym.program.logic.match.Match.TypeOfMatch;
import com.gym.program.utils.Choice;
import com.gym.program.utils.GuiHelper;
import com.gym.program.utils.LogicHelper;
import com.gym.program.utils.Sex;

public class InsertForm extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txt_name;
	private JTextField txt_surname;
	private JTextField txt_team;
	private JTextField txt_weight;
	private JLabel fixed_weight_label;
	private JLabel fixed_surname_label;
	private JLabel fixed_name_label;
	private JLabel fixed_team_label;
	private JPanel bench_panel;
	private JRadioButton rdbtnBenchPress;
	private JTextField txt_lift_bench;
	private JLabel fixed_1st_bench;
	private JRadioButton weight_class_benchbtn;
	private JRadioButton age_class_benchbtn;
	private JPanel squat_panel;
	private JTextField txt_lift_squat;
	private JLabel fixed_1st_squat;
	private JRadioButton weight_class_squatbtn;
	private JRadioButton age_class_squatbtn;
	private JRadioButton rdbtnSquat;
	private JPanel deadlift_panel;
	private JTextField txt_lift_deadlift;
	private JLabel fixed_1st_deadlift;
	private JRadioButton weight_class_deadbtn;
	private JRadioButton age_class_deadbtn;
	private JRadioButton rdbtnDeadLift;
	private JButton add_lifter_btn;
	private JRadioButton male_radiobtn;
	private JRadioButton female_radiobtn;
	private JComboBox<Integer> list_age;

	private double bar_weight;

	private Competitor c;

	private MainFrame mainFrame;
	private Manager manager;
	private JTextField txt_rack_n_bench;
	private JTextField txt_rack_n_squat;
	private JLabel fixed_rack_n_squat_label;

	/**
	 * Create the frame.
	 */
	public InsertForm(MainFrame m) {
		mainFrame = m;
		manager = mainFrame.getManager();
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 680);
		setVisible(true);
		// setLocationRelativeTo(null);
		// setContentPane(contentPane);

		switch (this.mainFrame.getCollar()) {
		case LIGHT:
			this.bar_weight = 20.00;
			break;
		case WEIGHT:
			this.bar_weight = 25.00;
			break;
		default:
			break;
		}

		JPanel panel = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(this);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane
						.createSequentialGroup().addContainerGap().addComponent(panel, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(365, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 592, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(136, Short.MAX_VALUE)));

		txt_name = new JTextField();
		txt_name.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txt_name.setColumns(10);

		txt_surname = new JTextField();
		txt_surname.setColumns(10);

		txt_team = new JTextField();
		txt_team.setColumns(10);

		list_age = new JComboBox<Integer>();

		for (int i = 13; i <= 100; i++) {
			list_age.addItem(new Integer(i));

		}

		txt_weight = new JTextField();
		txt_weight.setColumns(10);

		JLabel fixed_age_label = new JLabel("et\u00E0 :");

		fixed_weight_label = new JLabel("peso :");

		male_radiobtn = new JRadioButton(" M", true);
		female_radiobtn = new JRadioButton(" F");
		Set<JRadioButton> setRdBtns = new HashSet<>();
		setRdBtns.add(male_radiobtn);
		setRdBtns.add(female_radiobtn);
		GuiHelper.getInstance().setSwitch(setRdBtns);

		fixed_surname_label = new JLabel("cognome :");

		fixed_name_label = new JLabel("nome :");

		fixed_team_label = new JLabel("squadra :");

		bench_panel = new JPanel();
		bench_panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Bench Press"));

		JButton submit_btn = new JButton("Conferma dati");
		submit_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (checkDataInput()) {
					initDisciplineForms();
					submitLifter();
					updateChoicePanels();
					add_lifter_btn.setEnabled(true);
				} else {
					JOptionPane.showMessageDialog(InsertForm.this, "Non hai inserito tutte le informazioni necessarie.",
							"ATTENZIONE", 2);
				}

			}
		});

		squat_panel = new JPanel();
		squat_panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Squat"));

		txt_lift_squat = new JTextField();
		txt_lift_squat.setColumns(10);

		fixed_1st_squat = new JLabel("peso da sollevare:");

		weight_class_squatbtn = new JRadioButton("  categoria peso", true);
		age_class_squatbtn = new JRadioButton("  categoria et\u00E0");
		Set<JRadioButton> setRdBtns2 = new HashSet<>();
		setRdBtns2.add(weight_class_squatbtn);
		setRdBtns2.add(age_class_squatbtn);
		GuiHelper.getInstance().setSwitch(setRdBtns2);

		rdbtnSquat = new JRadioButton("  seleziona");
		rdbtnSquat.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				int stateChange = e.getStateChange();
				if (stateChange == ItemEvent.SELECTED) {
					setEnabledPanelComponents(TypeOfMatch.SQUAT, true);
				} else if (stateChange == ItemEvent.DESELECTED) {
					setEnabledPanelComponents(TypeOfMatch.SQUAT, false);
				}
			}
		});

		txt_rack_n_squat = new JTextField();
		txt_rack_n_squat.setColumns(10);

		fixed_rack_n_squat_label = new JLabel("numero rack :");
		GroupLayout gl_squat_panel = new GroupLayout(squat_panel);
		gl_squat_panel.setHorizontalGroup(gl_squat_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_squat_panel.createSequentialGroup().addContainerGap()
						.addGroup(gl_squat_panel.createParallelGroup(Alignment.LEADING).addComponent(rdbtnSquat)
								.addGroup(gl_squat_panel.createSequentialGroup().addGap(8).addComponent(fixed_1st_squat,
										GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_squat_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(txt_lift_squat, GroupLayout.PREFERRED_SIZE, 57,
										GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_squat_panel.createSequentialGroup()
										.addComponent(fixed_rack_n_squat_label, GroupLayout.PREFERRED_SIZE, 66,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(txt_rack_n_squat,
												GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)))
						.addGap(18)
						.addGroup(gl_squat_panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(age_class_squatbtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(weight_class_squatbtn, GroupLayout.PREFERRED_SIZE, 123,
										GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));
		gl_squat_panel
				.setVerticalGroup(
						gl_squat_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_squat_panel
								.createSequentialGroup().addGap(11).addGroup(gl_squat_panel
										.createParallelGroup(Alignment.LEADING).addGroup(gl_squat_panel
												.createSequentialGroup().addGroup(gl_squat_panel
														.createParallelGroup(Alignment.BASELINE)
														.addComponent(weight_class_squatbtn)
														.addComponent(txt_rack_n_squat, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(fixed_rack_n_squat_label))
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addComponent(age_class_squatbtn))
										.addGroup(gl_squat_panel.createSequentialGroup().addComponent(rdbtnSquat)
												.addGap(18).addGroup(gl_squat_panel
														.createParallelGroup(Alignment.BASELINE).addComponent(
																fixed_1st_squat)
														.addComponent(txt_lift_squat, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		squat_panel.setLayout(gl_squat_panel);

		deadlift_panel = new JPanel();
		deadlift_panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Deadlift"));

		txt_lift_deadlift = new JTextField();
		txt_lift_deadlift.setColumns(10);

		fixed_1st_deadlift = new JLabel("peso da sollevare:");

		weight_class_deadbtn = new JRadioButton("  categoria peso", true);
		age_class_deadbtn = new JRadioButton("  categoria et\u00E0");
		Set<JRadioButton> setRdBtns3 = new HashSet<>();
		setRdBtns3.add(weight_class_deadbtn);
		setRdBtns3.add(age_class_deadbtn);
		GuiHelper.getInstance().setSwitch(setRdBtns3);

		rdbtnDeadLift = new JRadioButton("  seleziona");
		rdbtnDeadLift.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				int stateChange = e.getStateChange();
				if (stateChange == ItemEvent.SELECTED) {
					setEnabledPanelComponents(TypeOfMatch.DEADLIFT, true);
				} else if (stateChange == ItemEvent.DESELECTED) {
					setEnabledPanelComponents(TypeOfMatch.DEADLIFT, false);
				}
			}
		});
		GroupLayout gl_deadlift_panel = new GroupLayout(deadlift_panel);
		gl_deadlift_panel.setHorizontalGroup(gl_deadlift_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_deadlift_panel.createSequentialGroup().addContainerGap()
						.addGroup(gl_deadlift_panel.createParallelGroup(Alignment.LEADING).addComponent(rdbtnDeadLift)
								.addGroup(gl_deadlift_panel.createSequentialGroup().addGap(8).addComponent(
										fixed_1st_deadlift, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(txt_lift_deadlift, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addGroup(gl_deadlift_panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(age_class_deadbtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(weight_class_deadbtn, GroupLayout.PREFERRED_SIZE, 123,
										GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));
		gl_deadlift_panel.setVerticalGroup(gl_deadlift_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_deadlift_panel.createSequentialGroup().addGap(11)
						.addGroup(gl_deadlift_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_deadlift_panel.createSequentialGroup()
										.addComponent(weight_class_deadbtn).addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addComponent(age_class_deadbtn))
								.addGroup(
										gl_deadlift_panel.createSequentialGroup().addComponent(rdbtnDeadLift).addGap(18)
												.addGroup(gl_deadlift_panel.createParallelGroup(Alignment.BASELINE)
														.addComponent(fixed_1st_deadlift).addComponent(
																txt_lift_deadlift, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		deadlift_panel.setLayout(gl_deadlift_panel);

		add_lifter_btn = new JButton("Iscrivi");
		add_lifter_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (canAddLifter()) {
					addLifter();
					InsertForm.this.mainFrame.setStartBtnEnabled(true);
				} else {
					JOptionPane.showMessageDialog(InsertForm.this, "Non hai inserito tutte le informazioni necessarie.",
							"ATTENZIONE", 2);
				}
			}

		});
		add_lifter_btn.setEnabled(false);

		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel
								.createSequentialGroup().addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createSequentialGroup().addContainerGap().addComponent(
												add_lifter_btn, GroupLayout.PREFERRED_SIZE, 84,
												GroupLayout.PREFERRED_SIZE))
										.addGroup(
												gl_panel.createSequentialGroup().addGap(10).addGroup(gl_panel
														.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
																.createSequentialGroup().addGap(27).addGroup(gl_panel
																		.createParallelGroup(Alignment.TRAILING)
																		.addGroup(gl_panel.createSequentialGroup()
																				.addComponent(
																						fixed_name_label)
																				.addGap(18).addComponent(txt_name,
																						GroupLayout.PREFERRED_SIZE, 277,
																						GroupLayout.PREFERRED_SIZE))
																		.addGroup(gl_panel.createSequentialGroup()
																				.addComponent(fixed_surname_label)
																				.addGap(18).addComponent(txt_surname,
																						GroupLayout.PREFERRED_SIZE, 277,
																						GroupLayout.PREFERRED_SIZE))
																		.addGroup(gl_panel
																				.createParallelGroup(Alignment.TRAILING,
																						false)
																				.addGroup(gl_panel
																						.createSequentialGroup()
																						.addComponent(male_radiobtn)
																						.addPreferredGap(
																								ComponentPlacement.UNRELATED)
																						.addComponent(female_radiobtn)
																						.addPreferredGap(
																								ComponentPlacement.RELATED,
																								GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(fixed_team_label,
																								GroupLayout.PREFERRED_SIZE,
																								58,
																								GroupLayout.PREFERRED_SIZE)
																						.addPreferredGap(
																								ComponentPlacement.RELATED)
																						.addComponent(txt_team,
																								GroupLayout.PREFERRED_SIZE,
																								183,
																								GroupLayout.PREFERRED_SIZE))
																				.addGroup(gl_panel
																						.createSequentialGroup()
																						.addComponent(fixed_age_label)
																						.addPreferredGap(
																								ComponentPlacement.UNRELATED)
																						.addComponent(list_age,
																								GroupLayout.PREFERRED_SIZE,
																								110,
																								GroupLayout.PREFERRED_SIZE)
																						.addGap(32)
																						.addComponent(
																								fixed_weight_label,
																								GroupLayout.PREFERRED_SIZE,
																								41,
																								GroupLayout.PREFERRED_SIZE)
																						.addPreferredGap(
																								ComponentPlacement.RELATED)
																						.addComponent(txt_weight,
																								GroupLayout.PREFERRED_SIZE,
																								129,
																								GroupLayout.PREFERRED_SIZE)))
																		.addComponent(submit_btn,
																				GroupLayout.PREFERRED_SIZE, 147,
																				GroupLayout.PREFERRED_SIZE)))
														.addGroup(gl_panel.createSequentialGroup()
																.addPreferredGap(ComponentPlacement.RELATED).addGroup(
																		gl_panel.createParallelGroup(Alignment.LEADING)
																				.addComponent(bench_panel,
																						GroupLayout.PREFERRED_SIZE, 366,
																						GroupLayout.PREFERRED_SIZE)
																				.addComponent(squat_panel,
																						GroupLayout.PREFERRED_SIZE, 366,
																						GroupLayout.PREFERRED_SIZE)
																				.addComponent(deadlift_panel,
																						GroupLayout.PREFERRED_SIZE, 366,
																						GroupLayout.PREFERRED_SIZE))))))
								.addContainerGap(23, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup().addContainerGap()
								.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(txt_name, GroupLayout.PREFERRED_SIZE, 34,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(fixed_name_label))
								.addGap(18)
								.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(fixed_surname_label).addComponent(txt_surname,
												GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
								.addGap(18)
								.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(txt_weight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(list_age, GroupLayout.PREFERRED_SIZE, 18,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(fixed_age_label).addComponent(fixed_weight_label))
								.addGap(18)
								.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(txt_team, GroupLayout.PREFERRED_SIZE, 34,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(fixed_team_label).addComponent(male_radiobtn)
										.addComponent(female_radiobtn))
								.addGap(18).addComponent(submit_btn).addGap(18)
								.addComponent(bench_panel, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(squat_panel, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(deadlift_panel, GroupLayout.PREFERRED_SIZE, 97,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(add_lifter_btn)
								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		rdbtnBenchPress = new JRadioButton("  seleziona");
		rdbtnBenchPress.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				int stateChange = e.getStateChange();
				if (stateChange == ItemEvent.SELECTED) {
					setEnabledPanelComponents(TypeOfMatch.BENCHPRESS, true);
				} else if (stateChange == ItemEvent.DESELECTED) {
					setEnabledPanelComponents(TypeOfMatch.BENCHPRESS, false);
				}
			}
		});
		txt_lift_bench = new JTextField();
		txt_lift_bench.setColumns(10);

		fixed_1st_bench = new JLabel("peso da sollevare:");

		weight_class_benchbtn = new JRadioButton("  categoria peso", true);
		age_class_benchbtn = new JRadioButton("  categoria et\u00E0");
		Set<JRadioButton> setRdBtns4 = new HashSet<>();
		setRdBtns4.add(weight_class_benchbtn);
		setRdBtns4.add(age_class_benchbtn);
		GuiHelper.getInstance().setSwitch(setRdBtns4);

		txt_rack_n_bench = new JTextField();
		txt_rack_n_bench.setColumns(10);

		JLabel fixed_rack_n_bench_label = new JLabel("numero rack :");

		GroupLayout gl_bench_panel = new GroupLayout(bench_panel);
		gl_bench_panel.setHorizontalGroup(gl_bench_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_bench_panel.createSequentialGroup().addContainerGap()
						.addGroup(gl_bench_panel.createParallelGroup(Alignment.LEADING).addComponent(rdbtnBenchPress)
								.addGroup(gl_bench_panel.createSequentialGroup().addGap(8).addComponent(fixed_1st_bench,
										GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addGap(6)
						.addGroup(gl_bench_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(txt_lift_bench, GroupLayout.PREFERRED_SIZE, 59,
										GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_bench_panel.createSequentialGroup()
										.addComponent(fixed_rack_n_bench_label, GroupLayout.PREFERRED_SIZE, 66,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(txt_rack_n_bench,
												GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)))
						.addGap(18)
						.addGroup(gl_bench_panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(age_class_benchbtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(weight_class_benchbtn, GroupLayout.PREFERRED_SIZE, 123,
										GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));
		gl_bench_panel.setVerticalGroup(gl_bench_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_bench_panel.createSequentialGroup().addGap(11)
						.addGroup(gl_bench_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_bench_panel.createSequentialGroup()
										.addGroup(gl_bench_panel.createParallelGroup(Alignment.BASELINE)
												.addComponent(weight_class_benchbtn).addComponent(txt_rack_n_bench,
														GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(age_class_benchbtn))
								.addGroup(gl_bench_panel.createSequentialGroup()
										.addGroup(gl_bench_panel.createParallelGroup(Alignment.BASELINE)
												.addComponent(rdbtnBenchPress).addComponent(fixed_rack_n_bench_label))
										.addGap(18)
										.addGroup(gl_bench_panel.createParallelGroup(Alignment.BASELINE)
												.addComponent(fixed_1st_bench).addComponent(txt_lift_bench,
														GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		bench_panel.setLayout(gl_bench_panel);
		panel.setLayout(gl_panel);
		this.setLayout(gl_contentPane);
		setEnabledPanel(TypeOfMatch.BENCHPRESS, false);
		setEnabledPanel(TypeOfMatch.SQUAT, false);
		setEnabledPanel(TypeOfMatch.DEADLIFT, false);
		setEnabledPanelComponents(TypeOfMatch.BENCHPRESS, false);
		setEnabledPanelComponents(TypeOfMatch.SQUAT, false);
		setEnabledPanelComponents(TypeOfMatch.DEADLIFT, false);
	}

	private void updateChoicePanels() {
		this.age_class_benchbtn.setText(c.getAge_class().toString());
		this.age_class_deadbtn.setText(c.getAge_class().toString());
		this.age_class_squatbtn.setText(c.getAge_class().toString());
		this.weight_class_benchbtn.setText(c.getWeight_class().toString());
		this.weight_class_squatbtn.setText(c.getWeight_class().toString());
		this.weight_class_deadbtn.setText(c.getWeight_class().toString());
	}

	public void setEnabledPanel(TypeOfMatch type, boolean value) {

		switch (type) {
		case BENCHPRESS:
			this.bench_panel.setEnabled(value);
			rdbtnBenchPress.setEnabled(value);
			break;
		case SQUAT:
			this.squat_panel.setEnabled(value);
			rdbtnSquat.setEnabled(value);
			break;
		case DEADLIFT:
			this.deadlift_panel.setEnabled(value);
			rdbtnDeadLift.setEnabled(value);
			break;
		default:
			break;
		}

	}

	private void setEnabledPanelComponents(TypeOfMatch type, boolean value) {
		switch (type) {
		case BENCHPRESS:
			for (Component c : bench_panel.getComponents()) {
				if (!c.equals(rdbtnBenchPress)) {
					c.setEnabled(value);
				}
			}
			break;
		case SQUAT:
			for (Component c : squat_panel.getComponents()) {
				if (!c.equals(rdbtnSquat)) {
					c.setEnabled(value);
				}
			}
			break;
		case DEADLIFT:
			for (Component c : deadlift_panel.getComponents()) {
				if (!c.equals(rdbtnDeadLift)) {
					c.setEnabled(value);
				}
			}
			break;
		default:
			break;
		}
	}

	private void submitLifter() {

		CompetitorBuilder builder = CompetitorBuilder.newBuilder().setName(this.txt_name.getText())
				.setSurname(this.txt_surname.getText()).setAge((int) this.list_age.getSelectedItem())
				.setTeam(this.txt_team.getText()).setWeight(Double.parseDouble(this.txt_weight.getText()));

		if (this.male_radiobtn.isSelected())
			builder.setSex(Sex.MALE);
		else
			builder.setSex(Sex.FEMALE);

		this.c = builder.build();

	}

	private boolean checkDataInput() {
		boolean result = false;
		if (!txt_name.getText().equals("") && !txt_name.getText().equals(null) && !txt_surname.getText().equals("")
				&& !txt_surname.getText().equals(null) && list_age.getSelectedIndex() > 0
				&& !txt_team.getText().equals(null) && !txt_team.getText().equals("")) {
			try {
				Double.parseDouble(this.txt_weight.getText());
				result = true;
			} catch (NumberFormatException e) {
				// not a double
				result = false;
			}
		}
		return result;
	}

	public void initDisciplineForms() {
		Manager manager = mainFrame.getManager();
		Set<TypeOfMatch> matches = manager.getMatches().keySet();
		if (matches.contains(TypeOfMatch.BENCHPRESS)) {
			setEnabledPanel(TypeOfMatch.BENCHPRESS, true);
		}
		if (matches.contains(TypeOfMatch.SQUAT)) {
			setEnabledPanel(TypeOfMatch.SQUAT, true);
		}
		if (matches.contains(TypeOfMatch.DEADLIFT)) {
			setEnabledPanel(TypeOfMatch.DEADLIFT, true);
		}
	}

	private boolean canAddLifter() {
		if (rdbtnBenchPress.isSelected()) {

			if (txt_lift_bench.getText().equals("") || txt_lift_bench.getText().equals(null)
					|| txt_rack_n_bench.getText().equals("") || txt_rack_n_bench.getText().equals(null)) {
				return false;
			}
			try {

				Double.parseDouble(txt_rack_n_bench.getText());
				if (!LogicHelper.calculateWeights(Double.parseDouble(this.txt_lift_bench.getText()), this.bar_weight)) {
					return false;
				}

			} catch (NumberFormatException e) {
				return false;
			}
		}
		if (rdbtnSquat.isSelected()) {
			if (txt_lift_squat.getText().equals("") || txt_lift_squat.getText().equals(null)
					|| txt_rack_n_squat.getText().equals("") || txt_rack_n_squat.getText().equals(null)) {
				return false;
			}
			try {

				Double.parseDouble(txt_rack_n_squat.getText());
				if (!LogicHelper.calculateWeights(Double.parseDouble(this.txt_lift_squat.getText()), this.bar_weight)) {
					return false;
				}
			} catch (NumberFormatException e) {
				return false;
			}
		}
		if (rdbtnDeadLift.isSelected()) {
			if (txt_lift_deadlift.getText().equals("") || txt_lift_deadlift.getText().equals(null)) {
				return false;
			}
			try {
				if (!LogicHelper.calculateWeights(Double.parseDouble(this.txt_lift_deadlift.getText()),
						this.bar_weight)) {
					return false;
				}
			} catch (NumberFormatException e) {
				return false;
			}
		}
		if (!rdbtnBenchPress.isSelected() && !rdbtnSquat.isSelected() && !rdbtnDeadLift.isSelected()) {
			return false;
		}
		return true;
	}

	private void addLifter() {
		Map<TypeOfMatch, Match> matches = manager.getMatches();
		if (rdbtnBenchPress.isSelected()) {
			if (weight_class_benchbtn.isSelected()) {
				matches.get(TypeOfMatch.BENCHPRESS).signUp(c, Choice.CLSS_WEIGHT,
						Double.parseDouble(txt_lift_bench.getText()), Double.parseDouble(txt_rack_n_bench.getText()));
			} else {
				matches.get(TypeOfMatch.BENCHPRESS).signUp(c, Choice.CLSS_AGE,
						Double.parseDouble(txt_lift_bench.getText()), Double.parseDouble(txt_rack_n_bench.getText()));
			}
		}
		if (rdbtnSquat.isSelected()) {
			if (weight_class_squatbtn.isSelected()) {
				matches.get(TypeOfMatch.SQUAT).signUp(c, Choice.CLSS_WEIGHT,
						Double.parseDouble(txt_lift_squat.getText()), Double.parseDouble(txt_rack_n_squat.getText()));
			} else {
				matches.get(TypeOfMatch.SQUAT).signUp(c, Choice.CLSS_AGE, Double.parseDouble(txt_lift_squat.getText()),
						Double.parseDouble(txt_rack_n_squat.getText()));
			}
		}
		if (rdbtnDeadLift.isSelected()) {
			if (weight_class_deadbtn.isSelected()) {
				matches.get(TypeOfMatch.DEADLIFT).signUp(c, Choice.CLSS_WEIGHT,
						Double.parseDouble(txt_lift_deadlift.getText()), 0);
			} else {
				matches.get(TypeOfMatch.DEADLIFT).signUp(c, Choice.CLSS_AGE,
						Double.parseDouble(txt_lift_deadlift.getText()), 0);
			}
		}
		reset();
		System.out.println(manager);
	}

	void reset() {
		mainFrame.showInsertForm();
	}
}
