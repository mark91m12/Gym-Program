package com.gym.program.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import com.gym.program.logic.Manager;
import com.gym.program.logic.match.Lifter;
import com.gym.program.utils.Attempt;
import com.gym.program.utils.GuiHelper;
import com.gym.program.utils.LogicHelper;
import com.gym.program.utils.RecordKey;
import com.gym.program.utils.RecordsDB;
import com.gym.program.utils.WeightDisc;

public class Card extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel plates_panel;
	private JLabel lifter_surname_label;
	private JLabel lifter_name_label;
	private JLabel lifter_team_label;
	private JLabel lifter_category_label;
	private JLabel lifter_class_label;
	private JLabel record_weights_label;
	private JLabel first_attempt_label;
	private JLabel second_attempt_label;
	private JLabel third_attempt_label;
	private JLabel exercise_label;
	private JLabel current_lift_label;
	private JLabel seconds_left_label;
	private JPanel image_exercise_panel;
	private JButton btnValid;
	private JButton btnNegative;
	private MatchFrame match_frame;
	private Lifter current_lifter;
	private double bar_weight;
	private JLabel collar_label;
	private JLabel light_collar_label;
	private JPanel bonus_lift_panel;

	private Timer timer;
	private int time;
	private JLabel fixed_bonus_attempt_label;
	private JLabel bonus_attempt_label;
	private JLabel fixed_rack_label;
	private JLabel rack_number_label;

	/**
	 * Create the frame.
	 */

	public Card(MatchFrame mf) {

		Color blue_3 = new Color(30, 145, 245);
		Color blue_2 = new Color(51, 153, 255);
		Color blue_1 = new Color(102, 178, 255);

		setBackground(blue_3);

		this.match_frame = mf;

		System.out.println("c  " + this.match_frame.getManager());

		System.out.println(this.match_frame.getManager().getCurrentLifter());
		this.current_lifter = this.match_frame.getManager().getCurrentLifter();

		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		setVisible(true);

		collar_label = this.createLabel();
		collar_label.setIcon(new ImageIcon("images/fermo2_5kg50px.png"));
		collar_label.setText(" ");

		light_collar_label = this.createLabel();
		light_collar_label.setIcon(new ImageIcon("images/fermo100px.png"));
		light_collar_label.setText(" ");

		// setBounds(100, 100, 450, 300);
		// contentPane = new JPanel();
		// contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		// this.setsetContentPane(contentPane);

		JPanel button_panel = new JPanel();
		button_panel.setBackground(blue_3);

		JPanel lifter_panel = new JPanel();
		lifter_panel.setBackground(blue_2);

		plates_panel = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) plates_panel.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		plates_panel.setBackground(blue_2);

		JPanel target_panel = new JPanel();
		target_panel.setBackground(blue_2);

		JLabel fixed_plates_label = new JLabel(" caricamento :");
		fixed_plates_label.setForeground(Color.WHITE);
		fixed_plates_label.setVerticalAlignment(SwingConstants.TOP);
		fixed_plates_label.setHorizontalAlignment(SwingConstants.LEFT);
		fixed_plates_label.setFont(new Font("Serif", Font.PLAIN, 35));
		GroupLayout gl_contentPane = new GroupLayout(this);
		gl_contentPane
				.setHorizontalGroup(
						gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup().addGroup(gl_contentPane
										.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
												.createSequentialGroup().addGroup(gl_contentPane
														.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
																.createSequentialGroup().addContainerGap()
																.addGroup(gl_contentPane
																		.createParallelGroup(Alignment.LEADING)
																		.addComponent(lifter_panel, Alignment.TRAILING,
																				GroupLayout.PREFERRED_SIZE,
																				GuiHelper.getInstance().getMiusre(734),
																				Short.MAX_VALUE)
																		.addComponent(plates_panel,
																				GroupLayout.DEFAULT_SIZE, 734,
																				Short.MAX_VALUE))
																.addGap(GuiHelper.getInstance().getMiusre(13)))
														.addGroup(gl_contentPane.createSequentialGroup()
																.addGap(GuiHelper.getInstance().getMiusre(258))
																.addComponent(fixed_plates_label,
																		GroupLayout.PREFERRED_SIZE,
																		GuiHelper.getInstance().getMiusre(197),
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.RELATED)))
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(target_panel, GroupLayout.PREFERRED_SIZE,
														GuiHelper.getInstance().getMiusre(590),
														GroupLayout.PREFERRED_SIZE)
												.addGap(GuiHelper.getInstance().getMiusre(9)))
										.addGroup(gl_contentPane.createSequentialGroup()
												.addGap(GuiHelper.getInstance().getMiusre(1)).addComponent(button_panel,
														GroupLayout.DEFAULT_SIZE, GuiHelper.getInstance()
																.getMiusre(1355),
														Short.MAX_VALUE)))
										.addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(
				Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap().addGroup(
						gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(lifter_panel, GroupLayout.PREFERRED_SIZE,
												GuiHelper.getInstance().getMiusre(358), GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(fixed_plates_label, GroupLayout.PREFERRED_SIZE,
												GuiHelper.getInstance().getMiusre(41), Short.MAX_VALUE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(plates_panel, GroupLayout.PREFERRED_SIZE,
												GuiHelper.getInstance().getMiusre(251), GroupLayout.PREFERRED_SIZE))
								.addComponent(target_panel, GroupLayout.PREFERRED_SIZE,
										GuiHelper.getInstance().getMiusre(662), Short.MAX_VALUE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(button_panel, GroupLayout.PREFERRED_SIZE, GuiHelper.getInstance().getMiusre(28),
								GroupLayout.PREFERRED_SIZE)
						.addGap(GuiHelper.getInstance().getMiusre(43))));

		image_exercise_panel = new JPanel();
		image_exercise_panel.setBackground(blue_3);
		image_exercise_panel.setPreferredSize(
				new Dimension(GuiHelper.getInstance().getMiusre(500), GuiHelper.getInstance().getMiusre(500)));
		JLabel time_label = new JLabel("Time :");
		time_label.setForeground(SystemColor.infoText);
		time_label.setFont(new Font("Serif", Font.PLAIN, 40));

		time = 60;
		seconds_left_label = new JLabel("" + time + "s");
		seconds_left_label.setForeground(SystemColor.infoText);
		seconds_left_label.setFont(new Font("Serif", Font.PLAIN, 40));
		seconds_left_label.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel Kg_label = new JLabel("Kg :");
		Kg_label.setForeground(SystemColor.infoText);
		Kg_label.setFont(new Font("Serif", Font.PLAIN, 50));

		current_lift_label = new JLabel();
		current_lift_label.setForeground(Color.WHITE);
		current_lift_label.setFont(new Font("Serif", Font.PLAIN, 99));

		exercise_label = new JLabel();
		exercise_label.setForeground(Color.WHITE);
		exercise_label.setHorizontalAlignment(SwingConstants.CENTER);
		exercise_label.setFont(new Font("Serif", Font.PLAIN, 40));

		ActionListener timerAL = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (time > 0) {
					Card.this.logic();
					seconds_left_label.repaint();
				} else {
					timer.stop();
				}
			}
		};
		timer = new Timer(1000, timerAL);
		JButton btnStartStop = new JButton("Start/Stop");
		btnStartStop.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (timer.isRunning()) {
					timer.stop();
				} else {
					timer.start();
				}
			}
		});

		timer.restart();

		fixed_rack_label = new JLabel("rack :");
		fixed_rack_label.setForeground(SystemColor.infoText);
		fixed_rack_label.setFont(new Font("Serif", Font.PLAIN, 35));
		fixed_rack_label.setVisible(false);

		rack_number_label = new JLabel("");
		rack_number_label.setForeground(Color.WHITE);
		rack_number_label.setHorizontalAlignment(SwingConstants.CENTER);
		rack_number_label.setFont(new Font("Serif", Font.PLAIN, 35));
		rack_number_label.setVisible(false);

		GroupLayout gl_target_panel = new GroupLayout(target_panel);
		gl_target_panel
				.setHorizontalGroup(
						gl_target_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(
										gl_target_panel
												.createSequentialGroup().addGroup(gl_target_panel
														.createParallelGroup(Alignment.LEADING).addGroup(gl_target_panel
																.createSequentialGroup()
																.addContainerGap()
																.addGroup(gl_target_panel
																		.createParallelGroup(Alignment.LEADING)
																		.addGroup(Alignment.TRAILING, gl_target_panel
																				.createSequentialGroup()
																				.addComponent(fixed_rack_label,
																						GroupLayout.PREFERRED_SIZE,
																						GuiHelper.getInstance()
																								.getMiusre(87),
																						GroupLayout.PREFERRED_SIZE)
																				.addGap(GuiHelper.getInstance()
																						.getMiusre(18))
																				.addComponent(rack_number_label,
																						GroupLayout.PREFERRED_SIZE,
																						GuiHelper.getInstance()
																								.getMiusre(63),
																						GroupLayout.PREFERRED_SIZE)
																				.addPreferredGap(
																						ComponentPlacement.RELATED,
																						GuiHelper.getInstance()
																								.getMiusre(27),
																						Short.MAX_VALUE)
																				.addComponent(Kg_label,
																						GroupLayout.PREFERRED_SIZE,
																						GuiHelper.getInstance()
																								.getMiusre(101),
																						GroupLayout.PREFERRED_SIZE))
																		.addComponent(btnStartStop, Alignment.TRAILING))
																.addGroup(gl_target_panel
																		.createParallelGroup(Alignment.LEADING)
																		.addGroup(
																				gl_target_panel.createSequentialGroup()
																						.addGap(GuiHelper.getInstance()
																								.getMiusre(28))
																						.addComponent(time_label,
																								GroupLayout.PREFERRED_SIZE,
																								GuiHelper.getInstance()
																										.getMiusre(113),
																								GroupLayout.PREFERRED_SIZE)
																						.addPreferredGap(
																								ComponentPlacement.RELATED)
																						.addComponent(
																								seconds_left_label,
																								GroupLayout.PREFERRED_SIZE,
																								GuiHelper.getInstance()
																										.getMiusre(104),
																								GroupLayout.PREFERRED_SIZE))
																		.addGroup(gl_target_panel
																				.createSequentialGroup()
																				.addGap(GuiHelper.getInstance()
																						.getMiusre(18))
																				.addComponent(current_lift_label,
																						GroupLayout.PREFERRED_SIZE,
																						GuiHelper.getInstance()
																								.getMiusre(256),
																						GroupLayout.PREFERRED_SIZE))))
														.addGroup(gl_target_panel.createSequentialGroup()
																.addContainerGap().addComponent(image_exercise_panel,
																		GroupLayout.DEFAULT_SIZE,
																		GuiHelper.getInstance().getMiusre(570),
																		Short.MAX_VALUE))
														.addGroup(gl_target_panel.createSequentialGroup()
																.addGap(GuiHelper.getInstance()
																		.getMiusre(165))
																.addComponent(exercise_label,
																		GroupLayout.PREFERRED_SIZE,
																		GuiHelper.getInstance().getMiusre(266),
																		GroupLayout.PREFERRED_SIZE)))
												.addContainerGap()));
		gl_target_panel.setVerticalGroup(gl_target_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_target_panel
				.createSequentialGroup().addComponent(exercise_label, GroupLayout.PREFERRED_SIZE,
						GuiHelper.getInstance().getMiusre(84),
						GroupLayout.PREFERRED_SIZE)
				.addGap(GuiHelper.getInstance().getMiusre(4))
				.addComponent(image_exercise_panel, GroupLayout.PREFERRED_SIZE, GuiHelper.getInstance().getMiusre(357),
						GroupLayout.PREFERRED_SIZE)
				.addGroup(gl_target_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_target_panel
						.createSequentialGroup().addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_target_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(current_lift_label, GroupLayout.PREFERRED_SIZE,
										GuiHelper.getInstance().getMiusre(117), GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_target_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(Kg_label, GroupLayout.PREFERRED_SIZE,
												GuiHelper.getInstance().getMiusre(73), GroupLayout.PREFERRED_SIZE)
										.addComponent(fixed_rack_label, GroupLayout.PREFERRED_SIZE,
												GuiHelper.getInstance().getMiusre(38), GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_target_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_target_panel.createSequentialGroup()
										.addGap(GuiHelper.getInstance().getMiusre(40)).addComponent(btnStartStop))
								.addGroup(gl_target_panel.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED).addGroup(
												gl_target_panel.createParallelGroup(Alignment.BASELINE)
														.addComponent(time_label, GroupLayout.PREFERRED_SIZE,
																GuiHelper.getInstance().getMiusre(84),
																GroupLayout.PREFERRED_SIZE)
														.addComponent(seconds_left_label, GroupLayout.PREFERRED_SIZE,
																GuiHelper.getInstance().getMiusre(77),
																GroupLayout.PREFERRED_SIZE)))))
						.addGroup(gl_target_panel.createSequentialGroup().addGap(GuiHelper.getInstance().getMiusre(77))
								.addComponent(rack_number_label, GroupLayout.PREFERRED_SIZE,
										GuiHelper.getInstance().getMiusre(38), GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		image_exercise_panel.setLayout(new BorderLayout(0, 0));
		target_panel.setLayout(gl_target_panel);

		lifter_team_label = new JLabel();
		lifter_team_label.setForeground(Color.WHITE);
		lifter_team_label.setFont(new Font("Serif", Font.PLAIN, 35));

		JLabel fixed_team_label = new JLabel("team :");
		fixed_team_label.setForeground(SystemColor.infoText);
		fixed_team_label.setFont(new Font("Serif", Font.PLAIN, 35));

		JPanel name_panel = new JPanel();
		name_panel.setForeground(Color.WHITE);
		name_panel.setBackground(blue_2);

		JLabel fixed_category_label = new JLabel("categoria :");
		fixed_category_label.setForeground(SystemColor.infoText);
		fixed_category_label.setFont(new Font("Serif", Font.PLAIN, 35));

		lifter_category_label = new JLabel();
		lifter_category_label.setForeground(Color.WHITE);
		lifter_category_label.setFont(new Font("Serif", Font.PLAIN, 35));

		JLabel fixed_record_label = new JLabel("record :");
		fixed_record_label.setForeground(SystemColor.infoText);
		fixed_record_label.setFont(new Font("Serif", Font.PLAIN, 35));

		record_weights_label = new JLabel();
		record_weights_label.setForeground(Color.WHITE);
		record_weights_label.setFont(new Font("Serif", Font.PLAIN, 35));

		JPanel attempts_panel = new JPanel();
		attempts_panel.setBackground(blue_2);

		bonus_lift_panel = new JPanel();
		bonus_lift_panel.setBackground(blue_1);

		lifter_class_label = new JLabel();
		lifter_class_label.setForeground(SystemColor.infoText);
		lifter_class_label.setFont(new Font("Serif", Font.PLAIN, 35));

		GroupLayout gl_lifter_panel = new GroupLayout(lifter_panel);
		gl_lifter_panel.setHorizontalGroup(gl_lifter_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_lifter_panel.createSequentialGroup().addContainerGap().addGroup(gl_lifter_panel
						.createParallelGroup(Alignment.LEADING).addGroup(gl_lifter_panel
								.createSequentialGroup()
								.addGroup(gl_lifter_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(fixed_team_label, GroupLayout.PREFERRED_SIZE,
												GuiHelper.getInstance().getMiusre(180), GroupLayout.PREFERRED_SIZE)
										.addComponent(fixed_category_label, GroupLayout.PREFERRED_SIZE,
												GuiHelper.getInstance().getMiusre(195), GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_lifter_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(lifter_team_label, GroupLayout.DEFAULT_SIZE,
												GuiHelper.getInstance().getMiusre(320), Short.MAX_VALUE)
										.addComponent(lifter_category_label, GroupLayout.PREFERRED_SIZE,
												GuiHelper.getInstance().getMiusre(320), GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_lifter_panel.createSequentialGroup()
								.addComponent(lifter_class_label, GroupLayout.PREFERRED_SIZE,
										GuiHelper.getInstance().getMiusre(322), GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(fixed_record_label)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(record_weights_label,
										GroupLayout.DEFAULT_SIZE, GuiHelper.getInstance().getMiusre(80),
										Short.MAX_VALUE)))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(bonus_lift_panel, GroupLayout.PREFERRED_SIZE,
								GuiHelper.getInstance().getMiusre(184), GroupLayout.PREFERRED_SIZE)
						.addGap(GuiHelper.getInstance().getMiusre(34)))
				.addGroup(gl_lifter_panel.createSequentialGroup()
						.addComponent(attempts_panel, GroupLayout.PREFERRED_SIZE,
								GuiHelper.getInstance().getMiusre(749), GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addComponent(name_panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE,
						GuiHelper.getInstance().getMiusre(759), Short.MAX_VALUE));
		gl_lifter_panel.setVerticalGroup(gl_lifter_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_lifter_panel
				.createSequentialGroup().addContainerGap()
				.addComponent(name_panel, GroupLayout.PREFERRED_SIZE, GuiHelper.getInstance().getMiusre(83),
						GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED).addGroup(gl_lifter_panel.createParallelGroup(
						Alignment.TRAILING)
						.addGroup(gl_lifter_panel.createSequentialGroup()
								.addGroup(gl_lifter_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(lifter_team_label, GroupLayout.PREFERRED_SIZE,
												GuiHelper.getInstance().getMiusre(38), GroupLayout.PREFERRED_SIZE)
										.addComponent(fixed_team_label, GroupLayout.PREFERRED_SIZE,
												GuiHelper.getInstance().getMiusre(38), GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_lifter_panel
										.createParallelGroup(Alignment.LEADING).addComponent(fixed_category_label)
										.addComponent(lifter_category_label, GroupLayout.PREFERRED_SIZE,
												GuiHelper.getInstance().getMiusre(46), GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(
										ComponentPlacement.RELATED)
								.addGroup(
										gl_lifter_panel.createParallelGroup(Alignment.LEADING).addComponent(
												lifter_class_label, GroupLayout.PREFERRED_SIZE, GuiHelper.getInstance()
														.getMiusre(46),
												GroupLayout.PREFERRED_SIZE)
												.addGroup(gl_lifter_panel.createParallelGroup(Alignment.BASELINE)
														.addComponent(record_weights_label, GroupLayout.PREFERRED_SIZE,
																GuiHelper.getInstance().getMiusre(46),
																GroupLayout.PREFERRED_SIZE)
														.addComponent(fixed_record_label, GroupLayout.PREFERRED_SIZE,
																GuiHelper.getInstance().getMiusre(46),
																GroupLayout.PREFERRED_SIZE))))
						.addComponent(bonus_lift_panel, GroupLayout.PREFERRED_SIZE,
								GuiHelper.getInstance().getMiusre(141), GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(attempts_panel, GroupLayout.PREFERRED_SIZE,
						GuiHelper.getInstance().getMiusre(108), GroupLayout.PREFERRED_SIZE)
				.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		bonus_lift_panel.setLayout(new BorderLayout(0, 0));

		fixed_bonus_attempt_label = new JLabel();
		fixed_bonus_attempt_label.setForeground(SystemColor.infoText);
		fixed_bonus_attempt_label.setBackground(blue_2);
		fixed_bonus_attempt_label.setText("alzata bonus");
		fixed_bonus_attempt_label.setHorizontalAlignment(SwingConstants.CENTER);
		fixed_bonus_attempt_label.setFont(new Font("Serif", Font.PLAIN, 35));
		bonus_lift_panel.add(fixed_bonus_attempt_label, BorderLayout.NORTH);

		bonus_attempt_label = new JLabel();
		bonus_attempt_label.setBackground(blue_2);
		bonus_attempt_label.setHorizontalAlignment(SwingConstants.CENTER);
		bonus_attempt_label.setFont(new Font("Serif", Font.PLAIN, 35));
		bonus_lift_panel.add(bonus_attempt_label, BorderLayout.CENTER);
		this.setWhiteIcon(bonus_attempt_label);

		bonus_lift_panel.setVisible(false);

		JLabel fixed_attempts_label = new JLabel("tentativi :");
		fixed_attempts_label.setForeground(Color.WHITE);
		fixed_attempts_label.setFont(new Font("Serif", Font.PLAIN, 35));

		first_attempt_label = new JLabel();
		first_attempt_label.setForeground(SystemColor.infoText);
		first_attempt_label.setHorizontalAlignment(SwingConstants.CENTER);
		first_attempt_label.setFont(new Font("Serif", Font.PLAIN, 35));
		this.setWhiteIcon(first_attempt_label);

		second_attempt_label = new JLabel();
		second_attempt_label.setForeground(SystemColor.infoText);
		second_attempt_label.setHorizontalAlignment(SwingConstants.CENTER);
		second_attempt_label.setFont(new Font("Serif", Font.PLAIN, 35));
		this.setWhiteIcon(second_attempt_label);

		third_attempt_label = new JLabel();
		third_attempt_label.setForeground(SystemColor.infoText);
		third_attempt_label.setHorizontalAlignment(SwingConstants.CENTER);
		third_attempt_label.setFont(new Font("Serif", Font.PLAIN, 35));
		this.setWhiteIcon(third_attempt_label);

		GroupLayout gl_attempts_panel = new GroupLayout(attempts_panel);
		gl_attempts_panel.setHorizontalGroup(gl_attempts_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_attempts_panel.createSequentialGroup()
						.addGroup(gl_attempts_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_attempts_panel.createSequentialGroup().addContainerGap()
										.addComponent(first_attempt_label, GroupLayout.PREFERRED_SIZE,
												GuiHelper.getInstance().getMiusre(228), GroupLayout.PREFERRED_SIZE)
										.addGap(GuiHelper.getInstance().getMiusre(16))
										.addComponent(second_attempt_label, GroupLayout.PREFERRED_SIZE,
												GuiHelper.getInstance().getMiusre(199), GroupLayout.PREFERRED_SIZE)
										.addGap(GuiHelper.getInstance().getMiusre(18)).addComponent(third_attempt_label,
												GroupLayout.PREFERRED_SIZE, GuiHelper.getInstance().getMiusre(199),
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_attempts_panel
										.createSequentialGroup().addGap(GuiHelper.getInstance().getMiusre(291))
										.addComponent(fixed_attempts_label, GroupLayout.PREFERRED_SIZE,
												GuiHelper.getInstance().getMiusre(145), GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(GuiHelper.getInstance().getMiusre(79), Short.MAX_VALUE)));
		gl_attempts_panel.setVerticalGroup(gl_attempts_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_attempts_panel.createSequentialGroup()
						.addComponent(fixed_attempts_label, GroupLayout.PREFERRED_SIZE,
								GuiHelper.getInstance().getMiusre(28), GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, GuiHelper.getInstance().getMiusre(32),
								Short.MAX_VALUE)
						.addGroup(gl_attempts_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(second_attempt_label).addComponent(first_attempt_label).addComponent(
										third_attempt_label, GroupLayout.PREFERRED_SIZE, GuiHelper.getInstance()
												.getMiusre(50),
										GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));
		attempts_panel.setLayout(gl_attempts_panel);

		lifter_surname_label = new JLabel();
		lifter_surname_label.setForeground(Color.WHITE);

		lifter_surname_label.setVerticalAlignment(SwingConstants.TOP);
		lifter_surname_label.setHorizontalAlignment(SwingConstants.LEFT);
		lifter_surname_label.setFont(new Font("Serif", Font.PLAIN, 50));

		lifter_name_label = new JLabel();
		lifter_name_label.setForeground(Color.WHITE);
		lifter_name_label.setHorizontalAlignment(SwingConstants.LEFT);
		lifter_name_label.setFont(new Font("Serif", Font.PLAIN, 50));
		name_panel.setLayout(new FlowLayout(FlowLayout.LEFT, 40, 5));
		name_panel.add(lifter_surname_label);
		name_panel.add(lifter_name_label);
		lifter_panel.setLayout(gl_lifter_panel);

		btnValid = new JButton("valida");
		btnValid.setVerticalAlignment(SwingConstants.BOTTOM);
		btnValid.setHorizontalAlignment(SwingConstants.RIGHT);

		btnValid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setLiftValidation(true);
			}
		});

		btnNegative = new JButton("negativa");
		btnNegative.setVerticalAlignment(SwingConstants.BOTTOM);
		btnNegative.setHorizontalAlignment(SwingConstants.RIGHT);

		btnNegative.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setLiftValidation(false);
			}
		});
		GroupLayout gl_button_panel = new GroupLayout(button_panel);
		gl_button_panel.setHorizontalGroup(gl_button_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_button_panel.createSequentialGroup()
						.addContainerGap(GuiHelper.getInstance().getMiusre(569), Short.MAX_VALUE).addComponent(btnValid)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnNegative)));
		gl_button_panel.setVerticalGroup(gl_button_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_button_panel
				.createParallelGroup(Alignment.BASELINE).addComponent(btnNegative).addComponent(btnValid)));
		button_panel.setLayout(gl_button_panel);
		this.setLayout(gl_contentPane);

		switch (this.match_frame.getCollar()) {
		case LIGHT:
			this.bar_weight = 20.00;
			break;
		case WEIGHT:
			this.bar_weight = 25.00;
			break;
		default:
			break;
		}

		this.updateCard();
	}

	public void addPlates(ArrayList<WeightDisc> plates) {

		this.plates_panel.removeAll();

		for (WeightDisc weightDisc : plates) {
			JLabel disc_label = this.createLabel();
			disc_label.setText("[" + weightDisc.getLabel() + " x " + weightDisc.getOccurrance() + "]");
			disc_label.setIcon(new ImageIcon(weightDisc.getPathImage()));
			this.plates_panel.add(disc_label);
		}

		switch (this.match_frame.getCollar()) {
		case LIGHT:
			this.plates_panel.add(this.light_collar_label);
			break;
		case WEIGHT:
			this.plates_panel.add(this.collar_label);
			break;
		default:
			break;
		}
		this.plates_panel.revalidate();

	}

	private JLabel createLabel() {
		JLabel temp = new JLabel();
		temp.setFont(new Font("Tahoma", Font.PLAIN, 20));
		temp.setHorizontalTextPosition(JLabel.CENTER);
		temp.setVerticalTextPosition(JLabel.BOTTOM);

		return temp;
	}

	private void setPositiveIcon(JLabel label, boolean isPositive) {

		if (isPositive) {
			label.setIcon(new ImageIcon("images/positive-50px.png"));
		} else {
			label.setIcon(new ImageIcon("images/negative-50px.png"));
		}
	}

	private void setWhiteIcon(JLabel label) {
		label.setIcon(new ImageIcon("images/white-50px.png"));
	}

	public void setLifterData() {

		this.lifter_name_label.setText(current_lifter.getCompetitor().getName());
		this.lifter_surname_label.setText(current_lifter.getCompetitor().getSurname());
		this.lifter_team_label.setText(current_lifter.getCompetitor().getTeam());
		this.lifter_category_label.setText(current_lifter.getCategory().toString());
		this.lifter_class_label.setText(
				current_lifter.getCompetitor().getAge_class() + " " + current_lifter.getCompetitor().getWeight_class());

		this.first_attempt_label.setText(current_lifter.getAttemptWeight(Attempt.StandardAttempt.FIRST).toString());
		this.second_attempt_label.setText(current_lifter.getAttemptWeight(Attempt.StandardAttempt.SECOND).toString());
		this.third_attempt_label.setText(current_lifter.getAttemptWeight(Attempt.StandardAttempt.THIRD).toString());
		String text = " - ";

		if (current_lifter.hasBonusAttempt()) {
			text = current_lifter.getAttemptWeight(current_lifter.getBonusAttemptType()).toString();
		}
		this.bonus_attempt_label.setText(text);
		updateLabelAttempts();

		this.bonus_lift_panel.setVisible(false);

		if (current_lifter.hasBonusAttempt() && (current_lifter.getCurrentAttempt().equals(Attempt.BonusAttempt.RECORD)
				|| current_lifter.getCurrentAttempt().equals(Attempt.BonusAttempt.DISPUTED)))
			this.bonus_lift_panel.setVisible(true);

		this.exercise_label.setText(this.match_frame.getManager().getCurrentTypeOfMatch().toString());
		this.current_lift_label.setText(Double.toString(current_lifter.getCurrentAttemptWeight()));

		LogicHelper.calculateWeights(current_lifter.getCurrentAttemptWeight(), this.bar_weight,
				this.match_frame.getManager().is0p5Present(), this.match_frame.getManager().is0p25Present());
		ArrayList<WeightDisc> result = LogicHelper.getPlates();
		this.addPlates(result);

		Manager manager = match_frame.getManager();
		switch (manager.getCurrentTypeOfMatch()) {
		case BENCHPRESS:
			GuiHelper.getInstance().addBgImageJP(image_exercise_panel, "images/disciplines/benchpress.png", 200);
			this.fixed_rack_label.setVisible(true);
			this.rack_number_label.setText(Double.toString(current_lifter.getRack_number()));
			this.rack_number_label.setVisible(true);
			break;
		case DEADLIFT:
			GuiHelper.getInstance().addBgImageJP(image_exercise_panel, "images/disciplines/deadlift.png", 200);
			break;
		case SQUAT:
			GuiHelper.getInstance().addBgImageJP(image_exercise_panel, "images/disciplines/squat.png", 200);
			this.fixed_rack_label.setVisible(true);
			this.rack_number_label.setText(Double.toString(current_lifter.getRack_number()));
			this.rack_number_label.setVisible(true);
			break;
		default:
			break;
		}

		Double record = RecordsDB.getInstance()
				.getRecord(new RecordKey(manager.getCurrentTypeOfMatch(), current_lifter.getCompetitor().getSex(),
						current_lifter.getCompetitor().getAge_class(),
						current_lifter.getCompetitor().getWeight_class()));
		if (record != null) {
			record_weights_label.setText(record.toString());
		} else {
			record_weights_label.setText(" - ");
		}

	}

	private void updateLabelAttempts() {
		try {
			this.setPositiveIcon(first_attempt_label, current_lifter.getAttemptResult(Attempt.StandardAttempt.FIRST));
		} catch (Exception e) {
			// TODO: handle exception
			this.setWhiteIcon(first_attempt_label);
		}

		try {
			this.setPositiveIcon(second_attempt_label, current_lifter.getAttemptResult(Attempt.StandardAttempt.SECOND));
		} catch (Exception e) {
			// TODO: handle exception
			this.setWhiteIcon(second_attempt_label);
		}

		try {
			this.setPositiveIcon(third_attempt_label, current_lifter.getAttemptResult(Attempt.StandardAttempt.THIRD));
		} catch (Exception e) {
			this.setWhiteIcon(third_attempt_label);
		}

		try {
			this.setPositiveIcon(bonus_attempt_label,
					current_lifter.getAttemptResult(current_lifter.getBonusAttemptType()));
		} catch (Exception e) {
			// TODO: handle exception
			this.setWhiteIcon(bonus_attempt_label);
		}

	}

	private void setLiftValidation(boolean isValid) {

		try {
			if (current_lifter.getCurrentAttemptWeight() >= RecordsDB.getInstance()
					.getRecord(new RecordKey(match_frame.getManager().getCurrentTypeOfMatch(),
							current_lifter.getCompetitor().getSex(), current_lifter.getCompetitor().getAge_class(),
							current_lifter.getCompetitor().getWeight_class()))
					&& isValid) {
				current_lifter.setBonusAttemptType(Attempt.BonusAttempt.RECORD);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		current_lifter.setCurrentAttemptResult(isValid);
		if (isValid) {
			match_frame.getManager().getMatches().get(match_frame.getManager().getCurrentTypeOfMatch())
					.getMatchRanking().getRankings().get(match_frame.getManager().getCurrentLifter().getCategory())
					.sortRanking();
		}
		if (current_lifter.hasMoreLift()) {

			boolean is_valid = false;

			String weight = JOptionPane.showInputDialog(getParent(), "Inserire la prossima alzata per l'atleta \n"
					+ current_lifter.getCompetitor().getName() + " " + current_lifter.getCompetitor().getSurname(),
					null);

			boolean tooHigh = false;
			boolean tooSmall = false;
			while (!is_valid) {
				if (tooHigh) {
					weight = JOptionPane.showInputDialog(getParent(),
							"Inserire la prossima alzata per l'atleta \n" + current_lifter.getCompetitor().getName()
									+ " " + current_lifter.getCompetitor().getSurname(),
							null);
					tooHigh = false;
				} else if (tooSmall) {
					weight = JOptionPane.showInputDialog(getParent(),
							"Il peso che hai inserito è inferiore o uguale al miglior tentativo dell'atleta. Prego inserire peso maggiore",
							null);
					tooSmall = false;
				} else {
					try {
						double temp = Double.parseDouble(weight);
						int confirm = JOptionPane.YES_OPTION;
						// JOptionPane.showMessageDialog(getParent(),
						// "PREVIOUS=="+current_lifter.getCurrentAttemptWeight(),
						// "ALERT", JOptionPane.ERROR_MESSAGE);
						if (temp < current_lifter.getCurrentAttemptWeight()
								|| (temp == current_lifter.getCurrentAttemptWeight()
										&& current_lifter.getCurrentAttemptResult())) {
							tooSmall = true;
						} else {
							if (temp >= (current_lifter.getCompetitor().getWeight() * 2.5)) {
								confirm = JOptionPane.showConfirmDialog(getParent(),
										"Il peso inserito sembrerebbe eccessivo. Sicuro che la scelta sia coretta?",
										"ATTENZIONE", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
							}
							if (confirm == JOptionPane.YES_OPTION) {
								if (LogicHelper.calculateWeights(temp, this.bar_weight,
										this.match_frame.getManager().is0p5Present(),
										this.match_frame.getManager().is0p25Present())) {
									current_lifter.setNextAttemptWeight(temp);
									is_valid = true;
								} else {
									weight = JOptionPane.showInputDialog(getParent(),
											"Purtroppo i dischi a disposizione non permettono l'inserimento del peso selezionato,\nRestano fuori "
													+ LogicHelper.rounded(LogicHelper.getRest()) + " kg",
											null);
								}
							} else {
								tooHigh = true;
							}
						}
					} catch (NumberFormatException e) {
						weight = JOptionPane.showInputDialog(getParent(), "Inserire il peso correttamente", null);
					}
				}
			}
		} else if (current_lifter.getCurrentAttempt().equals(Attempt.StandardAttempt.THIRD) && !isValid) {
			match_frame.getManager().getCurrentMatch().addLifterCanDispute(current_lifter);
		}
		updateCard();
	}

	private void updateCard() {
		updateCurrentLifter();
		if (current_lifter != null) {
			setLifterData();

			resetTimer();

			// LogicHelper.calculateWeights(current_lifter.getCurrentAttemptWeight(),
			// this.bar_weight);
			// ArrayList<WeightDisc> result = LogicHelper.getPlates();
			// this.addPlates(result);
		} else { // no more lifters
			match_frame.comeBackToMainFrame();
		}
	}

	private void updateCurrentLifter() {
		this.match_frame.getManager().getMatches().get(this.match_frame.getManager().getCurrentTypeOfMatch())
				.updateLifters();
		this.current_lifter = this.match_frame.getManager().getCurrentLifter();
	}

	private void logic() {
		time--;
		seconds_left_label.setText("" + time + "s");
	}

	private void resetTimer() {
		if (timer.isRunning()) {
			timer.stop();
		}
		time = 60;
		seconds_left_label.setText("" + time + "s");
	}

}
