package com.gym.program.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
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
import java.awt.BorderLayout;

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
		button_panel.setBackground(Color.CYAN);

		JPanel lifter_panel = new JPanel();
		lifter_panel.setBackground(Color.RED);

		plates_panel = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) plates_panel.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		plates_panel.setBackground(Color.BLUE);

		JPanel target_panel = new JPanel();
		target_panel.setBackground(Color.ORANGE);

		JLabel fixed_plates_label = new JLabel(" caricamento :");
		fixed_plates_label.setVerticalAlignment(SwingConstants.TOP);
		fixed_plates_label.setHorizontalAlignment(SwingConstants.LEFT);
		fixed_plates_label.setFont(new Font("Serif", Font.PLAIN, 35));
		GroupLayout gl_contentPane = new GroupLayout(this);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(
				Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup().addGroup(gl_contentPane
						.createParallelGroup(Alignment.TRAILING).addGroup(gl_contentPane
								.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(lifter_panel, GroupLayout.PREFERRED_SIZE, 744, Short.MAX_VALUE)
										.addGroup(gl_contentPane.createSequentialGroup().addGap(264).addComponent(
												fixed_plates_label, GroupLayout.PREFERRED_SIZE, 197,
												GroupLayout.PREFERRED_SIZE))
										.addComponent(plates_panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE))
								.addPreferredGap(ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
								.addComponent(target_panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(1).addComponent(button_panel,
								GroupLayout.DEFAULT_SIZE, 1355, Short.MAX_VALUE)))
						.addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lifter_panel, GroupLayout.PREFERRED_SIZE, 369, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(fixed_plates_label, GroupLayout.PREFERRED_SIZE, 41, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(plates_panel,
										GroupLayout.PREFERRED_SIZE, 251, GroupLayout.PREFERRED_SIZE))
						.addComponent(target_panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(button_panel, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE).addGap(43)));

		image_exercise_panel = new JPanel();
		image_exercise_panel.setBackground(Color.WHITE);
		image_exercise_panel.setPreferredSize(new Dimension(500, 500));
		JLabel time_label = new JLabel("Time :");
		time_label.setFont(new Font("Serif", Font.PLAIN, 40));

		time = 60;
		seconds_left_label = new JLabel("" + time + "s");
		seconds_left_label.setFont(new Font("Serif", Font.PLAIN, 40));
		seconds_left_label.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel Kg_label = new JLabel("Kg :");
		Kg_label.setFont(new Font("Serif", Font.PLAIN, 50));

		current_lift_label = new JLabel();
		current_lift_label.setFont(new Font("Serif", Font.PLAIN, 99));

		exercise_label = new JLabel();
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

		fixed_rack_label = new JLabel("rack :");
		fixed_rack_label.setFont(new Font("Serif", Font.PLAIN, 35));
		fixed_rack_label.setVisible(false);

		rack_number_label = new JLabel("");
		rack_number_label.setHorizontalAlignment(SwingConstants.CENTER);
		rack_number_label.setFont(new Font("Serif", Font.PLAIN, 35));
		rack_number_label.setVisible(false);

		GroupLayout gl_target_panel = new GroupLayout(target_panel);
		gl_target_panel
				.setHorizontalGroup(gl_target_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_target_panel.createSequentialGroup()
								.addContainerGap(174, Short.MAX_VALUE)
								.addComponent(exercise_label, GroupLayout.PREFERRED_SIZE, 266,
										GroupLayout.PREFERRED_SIZE)
								.addGap(159))
						.addGroup(gl_target_panel.createSequentialGroup().addGap(32).addGroup(gl_target_panel
								.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_target_panel.createSequentialGroup()
										.addGroup(gl_target_panel.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_target_panel.createSequentialGroup().addGap(15)
														.addComponent(fixed_rack_label, GroupLayout.PREFERRED_SIZE, 87,
																GroupLayout.PREFERRED_SIZE))
												.addGroup(gl_target_panel.createSequentialGroup().addGap(24)
														.addComponent(rack_number_label, GroupLayout.PREFERRED_SIZE, 63,
																GroupLayout.PREFERRED_SIZE)))
										.addPreferredGap(ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
										.addGroup(gl_target_panel.createParallelGroup(Alignment.LEADING)
												.addComponent(Kg_label, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE,
														101, GroupLayout.PREFERRED_SIZE)
												.addComponent(btnStartStop, Alignment.TRAILING))
										.addGroup(gl_target_panel.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_target_panel.createSequentialGroup().addGap(28)
														.addComponent(time_label, GroupLayout.PREFERRED_SIZE, 113,
																GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(seconds_left_label, GroupLayout.PREFERRED_SIZE,
																104, GroupLayout.PREFERRED_SIZE))
												.addGroup(gl_target_panel.createSequentialGroup().addGap(18)
														.addComponent(current_lift_label, GroupLayout.PREFERRED_SIZE,
																256, GroupLayout.PREFERRED_SIZE))))
								.addComponent(image_exercise_panel, GroupLayout.PREFERRED_SIZE, 535,
										GroupLayout.PREFERRED_SIZE))
								.addContainerGap()));
		gl_target_panel.setVerticalGroup(gl_target_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_target_panel
				.createSequentialGroup()
				.addComponent(exercise_label, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE).addGap(4)
				.addComponent(image_exercise_panel, GroupLayout.PREFERRED_SIZE, 357, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGroup(gl_target_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(current_lift_label, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
						.addComponent(Kg_label, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_target_panel.createSequentialGroup()
								.addComponent(fixed_rack_label, GroupLayout.PREFERRED_SIZE, 38,
										GroupLayout.PREFERRED_SIZE)
								.addGap(18)))
				.addGroup(gl_target_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_target_panel.createSequentialGroup().addGap(40).addComponent(btnStartStop))
						.addGroup(gl_target_panel.createSequentialGroup().addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_target_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(rack_number_label, GroupLayout.PREFERRED_SIZE, 38,
												GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_target_panel.createParallelGroup(Alignment.BASELINE)
												.addComponent(time_label, GroupLayout.PREFERRED_SIZE, 84,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(seconds_left_label, GroupLayout.PREFERRED_SIZE, 77,
														GroupLayout.PREFERRED_SIZE)))))
				.addContainerGap(15, Short.MAX_VALUE)));
		image_exercise_panel.setLayout(new BorderLayout(0, 0));
		target_panel.setLayout(gl_target_panel);

		lifter_team_label = new JLabel();
		lifter_team_label.setFont(new Font("Serif", Font.PLAIN, 35));

		JLabel fixed_team_label = new JLabel("team :");
		fixed_team_label.setFont(new Font("Serif", Font.PLAIN, 35));

		JPanel name_panel = new JPanel();

		JLabel fixed_category_label = new JLabel("categoria :");
		fixed_category_label.setFont(new Font("Serif", Font.PLAIN, 35));

		lifter_category_label = new JLabel();
		lifter_category_label.setFont(new Font("Serif", Font.PLAIN, 35));

		JLabel fixed_record_label = new JLabel("record :");
		fixed_record_label.setFont(new Font("Serif", Font.PLAIN, 35));

		record_weights_label = new JLabel();
		record_weights_label.setFont(new Font("Serif", Font.PLAIN, 35));

		JPanel attempts_panel = new JPanel();

		bonus_lift_panel = new JPanel();
		GroupLayout gl_lifter_panel = new GroupLayout(lifter_panel);
		gl_lifter_panel
				.setHorizontalGroup(gl_lifter_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_lifter_panel
						.createSequentialGroup().addContainerGap()
						.addGroup(gl_lifter_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_lifter_panel
								.createSequentialGroup()
								.addGroup(gl_lifter_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(fixed_team_label, GroupLayout.PREFERRED_SIZE, 180,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(fixed_category_label, GroupLayout.PREFERRED_SIZE, 195,
												GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_lifter_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(lifter_team_label, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lifter_category_label, GroupLayout.PREFERRED_SIZE, 320,
												GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_lifter_panel.createSequentialGroup()
										.addComponent(fixed_record_label, GroupLayout.PREFERRED_SIZE, 195,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(record_weights_label,
												GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)))
						.addGap(18)
						.addComponent(bonus_lift_panel, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
						.addGap(26))
						.addComponent(name_panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 759, Short.MAX_VALUE)
						.addGroup(gl_lifter_panel.createSequentialGroup()
								.addComponent(attempts_panel, GroupLayout.PREFERRED_SIZE, 749,
										GroupLayout.PREFERRED_SIZE)
								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		gl_lifter_panel.setVerticalGroup(gl_lifter_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_lifter_panel
				.createSequentialGroup()
				.addComponent(name_panel, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_lifter_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_lifter_panel
								.createSequentialGroup().addGroup(gl_lifter_panel
										.createParallelGroup(Alignment.BASELINE).addComponent(lifter_team_label,
												GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
										.addComponent(fixed_team_label, GroupLayout.PREFERRED_SIZE, 38,
												GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_lifter_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(fixed_category_label).addComponent(lifter_category_label,
												GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_lifter_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(fixed_record_label, GroupLayout.PREFERRED_SIZE, 46,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(record_weights_label, GroupLayout.PREFERRED_SIZE, 46,
												GroupLayout.PREFERRED_SIZE)))
						.addComponent(bonus_lift_panel, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addComponent(attempts_panel, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		bonus_lift_panel.setLayout(new BorderLayout(0, 0));

		fixed_bonus_attempt_label = new JLabel();
		fixed_bonus_attempt_label.setText("alzata bonus");
		fixed_bonus_attempt_label.setHorizontalAlignment(SwingConstants.CENTER);
		fixed_bonus_attempt_label.setFont(new Font("Serif", Font.PLAIN, 35));
		bonus_lift_panel.add(fixed_bonus_attempt_label, BorderLayout.NORTH);

		bonus_attempt_label = new JLabel();
		bonus_attempt_label.setHorizontalAlignment(SwingConstants.CENTER);
		bonus_attempt_label.setFont(new Font("Serif", Font.PLAIN, 35));
		bonus_lift_panel.add(bonus_attempt_label, BorderLayout.CENTER);
		this.setWhiteIcon(bonus_attempt_label);

		bonus_lift_panel.setVisible(false);

		JLabel fixed_attempts_label = new JLabel("tentativi :");
		fixed_attempts_label.setFont(new Font("Serif", Font.PLAIN, 35));

		first_attempt_label = new JLabel();
		first_attempt_label.setHorizontalAlignment(SwingConstants.CENTER);
		first_attempt_label.setFont(new Font("Serif", Font.PLAIN, 35));
		this.setWhiteIcon(first_attempt_label);

		second_attempt_label = new JLabel();
		second_attempt_label.setHorizontalAlignment(SwingConstants.CENTER);
		second_attempt_label.setFont(new Font("Serif", Font.PLAIN, 35));
		this.setWhiteIcon(second_attempt_label);

		third_attempt_label = new JLabel();
		third_attempt_label.setHorizontalAlignment(SwingConstants.CENTER);
		third_attempt_label.setFont(new Font("Serif", Font.PLAIN, 35));
		this.setWhiteIcon(third_attempt_label);

		GroupLayout gl_attempts_panel = new GroupLayout(attempts_panel);
		gl_attempts_panel.setHorizontalGroup(gl_attempts_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_attempts_panel.createSequentialGroup()
						.addGroup(gl_attempts_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_attempts_panel.createSequentialGroup().addContainerGap()
										.addComponent(first_attempt_label, GroupLayout.PREFERRED_SIZE, 228,
												GroupLayout.PREFERRED_SIZE)
										.addGap(16)
										.addComponent(second_attempt_label, GroupLayout.PREFERRED_SIZE, 199,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18).addComponent(third_attempt_label, GroupLayout.PREFERRED_SIZE, 199,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_attempts_panel.createSequentialGroup().addGap(291).addComponent(
										fixed_attempts_label, GroupLayout.PREFERRED_SIZE, 145,
										GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(79, Short.MAX_VALUE)));
		gl_attempts_panel.setVerticalGroup(gl_attempts_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_attempts_panel.createSequentialGroup()
						.addComponent(fixed_attempts_label, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
						.addGroup(gl_attempts_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(second_attempt_label).addComponent(first_attempt_label).addComponent(
										third_attempt_label, GroupLayout.PREFERRED_SIZE, 50,
										GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));
		attempts_panel.setLayout(gl_attempts_panel);

		lifter_surname_label = new JLabel();

		lifter_surname_label.setVerticalAlignment(SwingConstants.TOP);
		lifter_surname_label.setHorizontalAlignment(SwingConstants.LEFT);
		lifter_surname_label.setFont(new Font("Serif", Font.PLAIN, 50));

		lifter_name_label = new JLabel();
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
				.addGroup(gl_button_panel.createSequentialGroup().addContainerGap(569, Short.MAX_VALUE)
						.addComponent(btnValid).addPreferredGap(ComponentPlacement.RELATED).addComponent(btnNegative)));
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

		if (current_lifter.hasBonusAttempt())
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
			GuiHelper.getInstance().addBgImageJP(image_exercise_panel, "images/disciplines/benchpress.png");
			this.fixed_rack_label.setVisible(true);
			this.rack_number_label.setText(Double.toString(current_lifter.getRack_number()));
			this.rack_number_label.setVisible(true);
			break;
		case DEADLIFT:
			GuiHelper.getInstance().addBgImageJP(image_exercise_panel, "images/disciplines/deadlift.png");
			break;
		case SQUAT:
			GuiHelper.getInstance().addBgImageJP(image_exercise_panel, "images/disciplines/squat.png");
			this.fixed_rack_label.setVisible(true);
			this.rack_number_label.setText(Double.toString(current_lifter.getRack_number()));
			this.rack_number_label.setVisible(true);
			break;
		default:
			break;
		}
		record_weights_label.setText("" + RecordsDB.getInstance()
				.getRecord(new RecordKey(manager.getCurrentTypeOfMatch(), current_lifter.getCategory())));
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

		if (current_lifter.getCurrentAttemptWeight() >= RecordsDB.getInstance().getRecord(
				new RecordKey(match_frame.getManager().getCurrentTypeOfMatch(), current_lifter.getCategory()))) {
			current_lifter.setBonusAttemptType(Attempt.BonusAttempt.RECORD);
			System.out.println("SET BONUS");
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
//						if (temp <= current_lifter.getCurrentAttemptWeight()
//								&& (current_lifter.getCurrentAttemptResult()
//										|| temp <= current_lifter.getBestAttemptWeight())) {
						if(temp < current_lifter.getPreviousAttemptWeight() || (temp == current_lifter.getPreviousAttemptWeight() && current_lifter.getPreviousAttemptResult())) {
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
}
