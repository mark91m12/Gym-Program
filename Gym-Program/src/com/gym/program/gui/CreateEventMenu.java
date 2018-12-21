package com.gym.program.gui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.gym.program.utils.GuiHelper;

public class CreateEventMenu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private List<JComponent> components;

	/**
	 * Create the frame.
	 */
	public CreateEventMenu() {

		components = new ArrayList<JComponent>();

		Color bg_color = new Color(69, 180, 249);

		setTitle("Seleziona gli esercizi ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		setSize(729, 350);
		setResizable(false);
		setVisible(true);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		components.add(contentPane);

		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		// BENCH PANEL
		JPanel bench_panel = new JPanel();
		GridBagConstraints gbc_bench_panel = new GridBagConstraints();
		gbc_bench_panel.insets = new Insets(0, 0, 5, 5);
		gbc_bench_panel.fill = GridBagConstraints.BOTH;
		gbc_bench_panel.gridx = 0;
		gbc_bench_panel.gridy = 0;
		contentPane.add(bench_panel, gbc_bench_panel);
		JCheckBox chckbxNewCheckBox = new JCheckBox("Bench Press");
		bench_panel.add(chckbxNewCheckBox);
		components.add(chckbxNewCheckBox);
		components.add(bench_panel);

		// SQUAT PANEL
		JPanel squat_panel = new JPanel();
		GridBagConstraints gbc_squat_panel = new GridBagConstraints();
		gbc_squat_panel.insets = new Insets(0, 0, 5, 5);
		gbc_squat_panel.fill = GridBagConstraints.BOTH;
		gbc_squat_panel.gridx = 1;
		gbc_squat_panel.gridy = 0;
		contentPane.add(squat_panel, gbc_squat_panel);
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Squat");
		squat_panel.add(chckbxNewCheckBox_1);
		components.add(squat_panel);
		components.add(chckbxNewCheckBox_1);

		// DEADLIFT PANEL
		JPanel deadlift_panel = new JPanel();
		GridBagConstraints gbc_deadlift_panel = new GridBagConstraints();
		gbc_deadlift_panel.insets = new Insets(0, 0, 5, 5);
		gbc_deadlift_panel.fill = GridBagConstraints.BOTH;
		gbc_deadlift_panel.gridx = 2;
		gbc_deadlift_panel.gridy = 0;
		contentPane.add(deadlift_panel, gbc_deadlift_panel);
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("Deadlift");
		deadlift_panel.add(chckbxNewCheckBox_2);
		components.add(deadlift_panel);
		components.add(chckbxNewCheckBox_2);

		// BUTTON PANEL
		JPanel button_panel = new JPanel();
		GridBagConstraints gbc_button_panel = new GridBagConstraints();
		gbc_button_panel.fill = GridBagConstraints.VERTICAL;
		gbc_button_panel.gridwidth = 3;
		gbc_button_panel.insets = new Insets(0, 0, 0, 5);
		gbc_button_panel.gridx = 0;
		gbc_button_panel.gridy = 1;
		JButton createEventBtn = new JButton("Crea Evento");
		createEventBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_panel.add(createEventBtn);
		contentPane.add(button_panel, gbc_button_panel);
		components.add(button_panel);

		GuiHelper.getInstance().addBgImageJP(bench_panel, "images/bench_press_bg.jpg");
		GuiHelper.getInstance().addBgImageJP(deadlift_panel, "images/deadlift_bg.jpg");
		GuiHelper.getInstance().addBgImageJP(squat_panel, "images/squat_bg.jpg");

		GuiHelper.getInstance().setBgColor(components, bg_color);

	}

}
