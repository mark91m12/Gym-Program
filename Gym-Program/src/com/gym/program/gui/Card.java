package com.gym.program.gui;

import java.awt.Color;
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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.gym.program.utils.WeightDisc;

public class Card extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel plates_panel;
	
	

	/**
	 * Create the frame.
	 */

	public Card() {

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		setVisible(true);

		// setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

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
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(1).addComponent(button_panel,
								GroupLayout.DEFAULT_SIZE, 1339, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup().addGroup(gl_contentPane
								.createParallelGroup(Alignment.LEADING)
								.addComponent(plates_panel, GroupLayout.DEFAULT_SIZE, 744, Short.MAX_VALUE)
								.addComponent(lifter_panel, GroupLayout.PREFERRED_SIZE, 744, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup().addGap(262).addComponent(
										fixed_plates_label, GroupLayout.PREFERRED_SIZE, 197,
										GroupLayout.PREFERRED_SIZE)))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(target_panel, GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)))
				.addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lifter_panel, GroupLayout.PREFERRED_SIZE, 381, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(fixed_plates_label, GroupLayout.PREFERRED_SIZE, 41, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(plates_panel,
										GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE))
						.addComponent(target_panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 703, Short.MAX_VALUE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(button_panel, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)));

		JPanel image_exercise_panel = new JPanel();
		image_exercise_panel.setBackground(Color.GREEN);

		JLabel time_label = new JLabel("Time :");
		time_label.setFont(new Font("Serif", Font.PLAIN, 40));

		JLabel seconds_left_label = new JLabel("43 s");
		seconds_left_label.setFont(new Font("Serif", Font.PLAIN, 40));
		seconds_left_label.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel Kg_label = new JLabel("Kg :");
		Kg_label.setFont(new Font("Serif", Font.PLAIN, 50));

		JLabel label = new JLabel("130,5");
		label.setFont(new Font("Serif", Font.PLAIN, 99));

		JLabel exercise_label = new JLabel("Bench Press");
		exercise_label.setFont(new Font("Serif", Font.PLAIN, 40));
		GroupLayout gl_target_panel = new GroupLayout(target_panel);
		gl_target_panel
				.setHorizontalGroup(gl_target_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_target_panel.createSequentialGroup()
								.addContainerGap(207, Short.MAX_VALUE)
								.addComponent(exercise_label, GroupLayout.PREFERRED_SIZE, 273,
										GroupLayout.PREFERRED_SIZE)
								.addGap(110))
						.addGroup(gl_target_panel.createSequentialGroup().addContainerGap()
								.addComponent(Kg_label, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_target_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_target_panel.createSequentialGroup().addGap(10)
												.addComponent(time_label, GroupLayout.PREFERRED_SIZE, 113,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(seconds_left_label, GroupLayout.PREFERRED_SIZE, 104,
														GroupLayout.PREFERRED_SIZE))
										.addComponent(label, GroupLayout.PREFERRED_SIZE, 256,
												GroupLayout.PREFERRED_SIZE)))
						.addGroup(Alignment.LEADING,
								gl_target_panel
										.createSequentialGroup().addGap(32).addComponent(image_exercise_panel,
												GroupLayout.PREFERRED_SIZE, 535, GroupLayout.PREFERRED_SIZE)
										.addContainerGap(23, Short.MAX_VALUE)));
		gl_target_panel.setVerticalGroup(gl_target_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_target_panel.createSequentialGroup()
						.addComponent(exercise_label, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
						.addGap(4)
						.addComponent(image_exercise_panel, GroupLayout.PREFERRED_SIZE, 386, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
						.addGroup(gl_target_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(Kg_label, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
								.addComponent(label, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_target_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(time_label, GroupLayout.PREFERRED_SIZE, 84,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(seconds_left_label, GroupLayout.PREFERRED_SIZE, 77,
										GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));
		target_panel.setLayout(gl_target_panel);

		JLabel lifter_team_label = new JLabel("squadra con nome lungo assai");
		lifter_team_label.setFont(new Font("Serif", Font.PLAIN, 35));

		JLabel fixed_team_label = new JLabel("team :");
		fixed_team_label.setFont(new Font("Serif", Font.PLAIN, 35));

		JPanel name_panel = new JPanel();

		JLabel fixed_category_label = new JLabel("categoria :");
		fixed_category_label.setFont(new Font("Serif", Font.PLAIN, 35));

		JLabel lifter_category_label = new JLabel("Senior");
		lifter_category_label.setFont(new Font("Serif", Font.PLAIN, 35));

		JLabel fixed_record_label = new JLabel("record :");
		fixed_record_label.setFont(new Font("Serif", Font.PLAIN, 35));

		JLabel record_weights_label = new JLabel("180 kg");
		record_weights_label.setFont(new Font("Serif", Font.PLAIN, 35));

		JPanel attempts_panel = new JPanel();
		GroupLayout gl_lifter_panel = new GroupLayout(lifter_panel);
		gl_lifter_panel
				.setHorizontalGroup(gl_lifter_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_lifter_panel
						.createSequentialGroup().addContainerGap().addGroup(gl_lifter_panel
								.createParallelGroup(
										Alignment.LEADING)
								.addGroup(gl_lifter_panel.createSequentialGroup()
										.addGroup(gl_lifter_panel.createParallelGroup(Alignment.LEADING)
												.addComponent(fixed_team_label, GroupLayout.PREFERRED_SIZE, 180,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(fixed_category_label, GroupLayout.PREFERRED_SIZE, 195,
														GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_lifter_panel.createParallelGroup(Alignment.LEADING)
												.addComponent(lifter_category_label, GroupLayout.PREFERRED_SIZE, 422,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(lifter_team_label)))
								.addGroup(gl_lifter_panel.createSequentialGroup()
										.addComponent(fixed_record_label, GroupLayout.PREFERRED_SIZE, 195,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(record_weights_label,
												GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)))
						.addGap(111))
						.addComponent(name_panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 759, Short.MAX_VALUE)
						.addGroup(gl_lifter_panel.createSequentialGroup()
								.addComponent(attempts_panel, GroupLayout.PREFERRED_SIZE, 749,
										GroupLayout.PREFERRED_SIZE)
								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		gl_lifter_panel.setVerticalGroup(gl_lifter_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_lifter_panel
				.createSequentialGroup()
				.addComponent(name_panel, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_lifter_panel.createParallelGroup(Alignment.BASELINE).addComponent(lifter_team_label)
						.addComponent(fixed_team_label, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_lifter_panel.createParallelGroup(Alignment.LEADING).addComponent(fixed_category_label)
						.addComponent(lifter_category_label, GroupLayout.PREFERRED_SIZE, 46,
								GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_lifter_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(fixed_record_label, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
						.addComponent(record_weights_label, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
				.addGap(18).addComponent(attempts_panel, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(31, Short.MAX_VALUE)));

		JLabel fixed_attempts_label = new JLabel("tentativi :");
		fixed_attempts_label.setFont(new Font("Serif", Font.PLAIN, 35));

		JLabel first_attempt_label = new JLabel("110");
		first_attempt_label.setIcon(new ImageIcon("C:\\Users\\Mark\\Desktop\\immagini Gym program\\positive-50px.png"));
		first_attempt_label.setHorizontalAlignment(SwingConstants.CENTER);
		first_attempt_label.setFont(new Font("Serif", Font.PLAIN, 35));

		JLabel second_attempt_label = new JLabel("120");
		second_attempt_label
				.setIcon(new ImageIcon("C:\\Users\\Mark\\Desktop\\immagini Gym program\\negative-50px.png"));
		second_attempt_label.setHorizontalAlignment(SwingConstants.CENTER);
		second_attempt_label.setFont(new Font("Serif", Font.PLAIN, 35));

		JLabel third_attempt_label = new JLabel("130.5");
		third_attempt_label.setIcon(new ImageIcon("C:\\Users\\Mark\\Desktop\\immagini Gym program\\white-50px.png"));
		third_attempt_label.setHorizontalAlignment(SwingConstants.CENTER);
		third_attempt_label.setFont(new Font("Serif", Font.PLAIN, 35));

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
								.addGroup(gl_attempts_panel.createSequentialGroup().addGap(292).addComponent(
										fixed_attempts_label, GroupLayout.PREFERRED_SIZE, 145,
										GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(79, Short.MAX_VALUE)));
		gl_attempts_panel.setVerticalGroup(gl_attempts_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_attempts_panel.createSequentialGroup().addContainerGap()
						.addComponent(fixed_attempts_label, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
						.addGroup(gl_attempts_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(second_attempt_label).addComponent(first_attempt_label)
								.addComponent(third_attempt_label, GroupLayout.PREFERRED_SIZE, 50,
										GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));
		attempts_panel.setLayout(gl_attempts_panel);

		JLabel lifter_surname_label = new JLabel("Azzeccagarbugli");

		lifter_surname_label.setVerticalAlignment(SwingConstants.TOP);
		lifter_surname_label.setHorizontalAlignment(SwingConstants.LEFT);
		lifter_surname_label.setFont(new Font("Serif", Font.PLAIN, 50));

		JLabel lifter_name_label = new JLabel("Pierferdinando");
		lifter_name_label.setHorizontalAlignment(SwingConstants.LEFT);
		lifter_name_label.setFont(new Font("Serif", Font.PLAIN, 50));
		name_panel.setLayout(new FlowLayout(FlowLayout.LEFT, 40, 5));
		name_panel.add(lifter_surname_label);
		name_panel.add(lifter_name_label);
		lifter_panel.setLayout(gl_lifter_panel);

		JButton btnValid = new JButton("valida");
		btnValid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Card.this.dispose();
			}
		});
		btnValid.setVerticalAlignment(SwingConstants.BOTTOM);
		btnValid.setHorizontalAlignment(SwingConstants.RIGHT);

		JButton btnNegative = new JButton("negativa");
		btnNegative.setVerticalAlignment(SwingConstants.BOTTOM);
		btnNegative.setHorizontalAlignment(SwingConstants.RIGHT);
		btnNegative.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Card.this.dispose();

			}
		});
		GroupLayout gl_button_panel = new GroupLayout(button_panel);
		gl_button_panel.setHorizontalGroup(gl_button_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_button_panel.createSequentialGroup().addContainerGap(569, Short.MAX_VALUE)
						.addComponent(btnValid).addPreferredGap(ComponentPlacement.RELATED).addComponent(btnNegative)));
		gl_button_panel.setVerticalGroup(gl_button_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_button_panel
				.createParallelGroup(Alignment.BASELINE).addComponent(btnNegative).addComponent(btnValid)));
		button_panel.setLayout(gl_button_panel);
		contentPane.setLayout(gl_contentPane);
	}

	public void addPlates(ArrayList<WeightDisc> plates) {

		for (WeightDisc weightDisc : plates) {
			JLabel disc_label = this.createLabel();
			disc_label.setText(weightDisc.getLabel() + " x " + weightDisc.getOccurrance());
			disc_label.setIcon(new ImageIcon(weightDisc.getPathImage()));
			this.plates_panel.add(disc_label);
			this.plates_panel.revalidate();
		}

	}

	private JLabel createLabel() {
		JLabel temp = new JLabel();
		temp.setFont(new Font("Tahoma", Font.PLAIN, 25));
		temp.setHorizontalTextPosition(JLabel.CENTER);
		temp.setVerticalTextPosition(JLabel.BOTTOM);

		return temp;
	}
}
