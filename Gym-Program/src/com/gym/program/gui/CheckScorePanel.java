package com.gym.program.gui;

import javax.swing.JPanel;
import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextPane;

public class CheckScorePanel extends JPanel {

	private JComboBox sex_cmbx;
	private JTextField txt_field_bw;
	private JTextField txt_field_lifted;

	/**
	 * Create the panel.
	 */
	public CheckScorePanel() {

		JLabel fixed_sex_label = new JLabel("Genere");
		fixed_sex_label.setFont(new Font("Tahoma", Font.PLAIN, 18));

		sex_cmbx = new JComboBox();
		sex_cmbx.setFont(new Font("Tahoma", Font.PLAIN, 14));
		sex_cmbx.addItem("Maschile");
		sex_cmbx.addItem("Femminile");

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
		calculate_wilks_btn.setEnabled(false);

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
}
