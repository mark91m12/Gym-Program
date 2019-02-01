package com.gym.program.gui.menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.gym.program.utils.GuiHelper;
import com.gym.program.utils.LogicHelper;
import com.gym.program.utils.Sex;

public class CheckScorePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox<String> sex_cmbx;
	private JTextField txt_field_bw;
	private JTextField txt_field_lifted;
	private double body_weight;
	private double lifted_weight;
	private Sex sex;

	private String response_message;

	/**
	 * Create the panel.
	 */
	public CheckScorePanel() {

		JLabel fixed_sex_label = new JLabel("Genere");
		fixed_sex_label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		sex = Sex.MALE;

		sex_cmbx = new JComboBox<String>();
		sex_cmbx.setFont(new Font("Tahoma", Font.PLAIN, 14));
		sex_cmbx.addItem("Maschile");
		sex_cmbx.addItem("Femminile");

		sex_cmbx.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (sex_cmbx.getSelectedItem().equals("Maschile")) {
					sex = Sex.MALE;
				} else {
					sex = Sex.FEMALE;
				}

			}
		});

		JLabel fixed_bw_label = new JLabel("Peso Corporeo KG");
		fixed_bw_label.setFont(new Font("Tahoma", Font.PLAIN, 18));

		txt_field_bw = new JTextField();
		txt_field_bw.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_field_bw.setColumns(10);

		JLabel fixed_lifted_label = new JLabel("Peso Sollevato");
		fixed_lifted_label.setFont(new Font("Tahoma", Font.PLAIN, 18));

		txt_field_lifted = new JTextField();
		txt_field_lifted.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_field_lifted.setColumns(10);

		JLabel fixed_wilks_label = new JLabel("Punteggio Wilks");
		fixed_wilks_label.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JLabel wilks_label = new JLabel("");
		wilks_label.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton calculate_wilks_btn = new JButton("Calcola\r\n");
		calculate_wilks_btn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		calculate_wilks_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (checkInputData()) {
					wilks_label.setText(Double.toString(
							LogicHelper.rounded(LogicHelper.getWilksResult(body_weight, lifted_weight, sex))));
				} else {
					JOptionPane.showMessageDialog(CheckScorePanel.this, response_message,
							"ATTENZIONE", 2);
				}
			}
		});

		JTextPane wilks_text_pane = new JTextPane();
		wilks_text_pane.setBackground(new Color(65, 105, 225));
		wilks_text_pane.setForeground(Color.WHITE);
		wilks_text_pane.setText("Calcola il punteggio Wilks");
		wilks_text_pane.setFont(new Font("Arial", Font.PLAIN, 18));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(wilks_text_pane, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup().addGap(32).addGroup(groupLayout
						.createParallelGroup(Alignment.TRAILING)
						.addComponent(calculate_wilks_btn, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(fixed_lifted_label).addComponent(fixed_bw_label)
										.addComponent(fixed_wilks_label).addComponent(fixed_sex_label))
								.addGap(18)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(txt_field_lifted)
										.addComponent(txt_field_bw, GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
										.addComponent(wilks_label)
										.addComponent(sex_cmbx, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
						.addContainerGap(20, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addComponent(wilks_text_pane, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addGap(33)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addComponent(fixed_sex_label)
								.addComponent(sex_cmbx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(fixed_bw_label).addComponent(txt_field_bw, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(txt_field_lifted, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(fixed_lifted_label))
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(fixed_wilks_label)
								.addComponent(wilks_label))
						.addPreferredGap(ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
						.addComponent(calculate_wilks_btn).addContainerGap()));
		setLayout(groupLayout);

	}

	protected boolean checkInputData() {
		// TODO Auto-generated method stub
		boolean correct = true;
		List<String> errors = new ArrayList<String>();
		this.response_message = "";

		if (this.txt_field_bw.getText().equals("") || this.txt_field_bw.getText().equals(null)) {
			correct = false;
			errors.add("Peso Corporeo");
		}

		if (this.txt_field_lifted.getText().equals("") || this.txt_field_lifted.getText().equals(null)) {
			correct = false;
			errors.add("Peso Sollevato");
		}

		try {

			if (!this.txt_field_bw.getText().equals(""))
				this.body_weight = Double.parseDouble(this.txt_field_bw.getText());

			if (!this.txt_field_lifted.getText().equals(""))
				this.lifted_weight = Double.parseDouble(this.txt_field_lifted.getText());

		} catch (NumberFormatException e) {
			correct = false;
			this.response_message += GuiHelper.getInstance().getIncorrectError("Il peso corporeo o il peso sollevato");
		}

		this.response_message += GuiHelper.getInstance().getEmptyError(errors);
		return correct;
	}
}
