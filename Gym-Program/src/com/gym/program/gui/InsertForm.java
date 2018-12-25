package com.gym.program.gui;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

public class InsertForm extends JFrame {

	private JPanel contentPane;
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
	private JTextField textField;
	private JLabel fixed_1st_bench;
	private JRadioButton weight_class_benchbtn;
	private JRadioButton age_class_benchbtn;
	private JPanel squat_panel;
	private JTextField textField_1;
	private JLabel fixed_1st_squat;
	private JRadioButton weight_class_squatbtn;
	private JRadioButton age_class_squatbtn;
	private JRadioButton rdbtnSquat;
	private JPanel deadlift_panel;
	private JTextField textField_2;
	private JLabel fixed_1st_deadlift;
	private JRadioButton weight_class_deadbtn;
	private JRadioButton age_class_deadbtn;
	private JRadioButton rdbtnDeadLift;
	private JButton add_lifter_btn;

	/**
	 * Create the frame.
	 */
	public InsertForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 800);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
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

		JComboBox list_age = new JComboBox();

		for (int i = 0; i <= 100; i++) {
			list_age.addItem(new Integer(i));

		}

		txt_weight = new JTextField();
		txt_weight.setColumns(10);

		JLabel fixed_age_label = new JLabel("et\u00E0 :");

		fixed_weight_label = new JLabel("peso :");

		JRadioButton male_radiobtn = new JRadioButton(" M", true);

		JRadioButton female_radiobtn = new JRadioButton(" F");

		System.out.println("M: " + male_radiobtn.isSelected());
		System.out.println("F: " + female_radiobtn.isSelected());

		male_radiobtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				female_radiobtn.setSelected(false);
				System.out.println("M: " + male_radiobtn.isSelected());
				System.out.println("F: " + female_radiobtn.isSelected());

			}
		});
		;

		female_radiobtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				male_radiobtn.setSelected(false);
				System.out.println("M: " + male_radiobtn.isSelected());
				System.out.println("F: " + female_radiobtn.isSelected());
			}
		});
		;

		fixed_surname_label = new JLabel("cognome :");

		fixed_name_label = new JLabel("nome :");

		fixed_team_label = new JLabel("squadra :");

		bench_panel = new JPanel();
		bench_panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Bench Press"));

		JButton submit_btn = new JButton("submit");
		submit_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		squat_panel = new JPanel();
		squat_panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Squat"));

		textField_1 = new JTextField();
		textField_1.setColumns(10);

		fixed_1st_squat = new JLabel("lift :");

		weight_class_squatbtn = new JRadioButton("  categoria peso");

		age_class_squatbtn = new JRadioButton("  categoria et\u00E0");

		rdbtnSquat = new JRadioButton("  seleziona");
		GroupLayout gl_squat_panel = new GroupLayout(squat_panel);
		gl_squat_panel.setHorizontalGroup(gl_squat_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_squat_panel
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_squat_panel.createParallelGroup(Alignment.LEADING).addComponent(rdbtnSquat)
						.addGroup(gl_squat_panel.createSequentialGroup().addGap(8)
								.addComponent(fixed_1st_squat, GroupLayout.PREFERRED_SIZE, 22,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(textField_1,
										GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)))
				.addPreferredGap(ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
				.addGroup(gl_squat_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(age_class_squatbtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)
						.addComponent(weight_class_squatbtn, GroupLayout.PREFERRED_SIZE, 123,
								GroupLayout.PREFERRED_SIZE))
				.addContainerGap()));
		gl_squat_panel.setVerticalGroup(gl_squat_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_squat_panel
				.createSequentialGroup().addGap(11)
				.addGroup(gl_squat_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_squat_panel.createSequentialGroup().addComponent(weight_class_squatbtn)
								.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(age_class_squatbtn))
						.addGroup(gl_squat_panel.createSequentialGroup().addComponent(rdbtnSquat).addGap(18)
								.addGroup(gl_squat_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(fixed_1st_squat))))
				.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		squat_panel.setLayout(gl_squat_panel);

		deadlift_panel = new JPanel();
		deadlift_panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Deadlift"));

		textField_2 = new JTextField();
		textField_2.setColumns(10);

		fixed_1st_deadlift = new JLabel("lift :");

		weight_class_deadbtn = new JRadioButton("  categoria peso");

		age_class_deadbtn = new JRadioButton("  categoria et\u00E0");

		rdbtnDeadLift = new JRadioButton("  seleziona");
		GroupLayout gl_deadlift_panel = new GroupLayout(deadlift_panel);
		gl_deadlift_panel.setHorizontalGroup(gl_deadlift_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_deadlift_panel.createSequentialGroup().addContainerGap().addGroup(gl_deadlift_panel
						.createParallelGroup(Alignment.LEADING).addComponent(rdbtnDeadLift)
						.addGroup(gl_deadlift_panel.createSequentialGroup().addGap(8)
								.addComponent(fixed_1st_deadlift, GroupLayout.PREFERRED_SIZE, 22,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(textField_2,
										GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
						.addGroup(gl_deadlift_panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(age_class_deadbtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(weight_class_deadbtn, GroupLayout.PREFERRED_SIZE, 123,
										GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));
		gl_deadlift_panel.setVerticalGroup(gl_deadlift_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_deadlift_panel.createSequentialGroup().addGap(11).addGroup(gl_deadlift_panel
						.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_deadlift_panel.createSequentialGroup().addComponent(weight_class_deadbtn)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(age_class_deadbtn))
						.addGroup(gl_deadlift_panel.createSequentialGroup().addComponent(rdbtnDeadLift).addGap(18)
								.addGroup(gl_deadlift_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(fixed_1st_deadlift))))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		deadlift_panel.setLayout(gl_deadlift_panel);

		add_lifter_btn = new JButton("Iscrivi");

		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel
								.createSequentialGroup().addGap(
										10)
								.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
										.addComponent(add_lifter_btn, GroupLayout.PREFERRED_SIZE, 63,
												GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
												.createSequentialGroup().addGap(27)
												.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
														.addComponent(submit_btn)
														.addGroup(gl_panel.createSequentialGroup()
																.addComponent(fixed_name_label).addGap(18)
																.addComponent(txt_name, GroupLayout.PREFERRED_SIZE, 277,
																		GroupLayout.PREFERRED_SIZE))
														.addGroup(gl_panel.createSequentialGroup()
																.addComponent(fixed_surname_label).addGap(18)
																.addComponent(txt_surname, GroupLayout.PREFERRED_SIZE,
																		277, GroupLayout.PREFERRED_SIZE))
														.addGroup(gl_panel
																.createParallelGroup(Alignment.TRAILING, false)
																.addGroup(gl_panel.createSequentialGroup()
																		.addComponent(male_radiobtn)
																		.addPreferredGap(ComponentPlacement.UNRELATED)
																		.addComponent(female_radiobtn)
																		.addPreferredGap(ComponentPlacement.RELATED,
																				GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addComponent(fixed_team_label,
																				GroupLayout.PREFERRED_SIZE, 58,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(ComponentPlacement.RELATED)
																		.addComponent(txt_team,
																				GroupLayout.PREFERRED_SIZE, 183,
																				GroupLayout.PREFERRED_SIZE))
																.addGroup(gl_panel.createSequentialGroup()
																		.addComponent(fixed_age_label)
																		.addPreferredGap(ComponentPlacement.UNRELATED)
																		.addComponent(list_age,
																				GroupLayout.PREFERRED_SIZE, 110,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(32)
																		.addComponent(fixed_weight_label,
																				GroupLayout.PREFERRED_SIZE, 41,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(ComponentPlacement.RELATED)
																		.addComponent(txt_weight,
																				GroupLayout.PREFERRED_SIZE, 129,
																				GroupLayout.PREFERRED_SIZE)))))
												.addGroup(gl_panel.createSequentialGroup()
														.addPreferredGap(ComponentPlacement.RELATED).addGroup(gl_panel
																.createParallelGroup(Alignment.LEADING)
																.addComponent(bench_panel, GroupLayout.PREFERRED_SIZE,
																		366, GroupLayout.PREFERRED_SIZE)
																.addComponent(squat_panel, GroupLayout.PREFERRED_SIZE,
																		366, GroupLayout.PREFERRED_SIZE)
																.addComponent(deadlift_panel,
																		GroupLayout.PREFERRED_SIZE, 366, GroupLayout.PREFERRED_SIZE)))))
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

		textField = new JTextField();
		textField.setColumns(10);

		fixed_1st_bench = new JLabel("lift :");

		weight_class_benchbtn = new JRadioButton("  categoria peso");

		age_class_benchbtn = new JRadioButton("  categoria et\u00E0");
		GroupLayout gl_bench_panel = new GroupLayout(bench_panel);
		gl_bench_panel.setHorizontalGroup(gl_bench_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_bench_panel
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_bench_panel.createParallelGroup(Alignment.LEADING).addComponent(rdbtnBenchPress)
						.addGroup(gl_bench_panel.createSequentialGroup().addGap(8)
								.addComponent(fixed_1st_bench, GroupLayout.PREFERRED_SIZE, 22,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(textField,
										GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)))
				.addPreferredGap(ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
				.addGroup(gl_bench_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(age_class_benchbtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)
						.addComponent(weight_class_benchbtn, GroupLayout.PREFERRED_SIZE, 123,
								GroupLayout.PREFERRED_SIZE))
				.addContainerGap()));
		gl_bench_panel.setVerticalGroup(gl_bench_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_bench_panel
				.createSequentialGroup().addGap(11)
				.addGroup(gl_bench_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_bench_panel.createSequentialGroup().addComponent(weight_class_benchbtn)
								.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(age_class_benchbtn))
						.addGroup(gl_bench_panel.createSequentialGroup().addComponent(rdbtnBenchPress).addGap(18)
								.addGroup(gl_bench_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(fixed_1st_bench))))
				.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		bench_panel.setLayout(gl_bench_panel);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);

		bench_panel.setEnabled(false);
		for (Component c : bench_panel.getComponents()) {
			c.setEnabled(false);
		}
	}
}
