package com.gym.program.gui;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JList;
import javax.swing.JButton;

public class DisciplineSelectionPanel extends JInternalFrame {

	/**
	 * Create the panel.
	 */
	public DisciplineSelectionPanel() {
		setBackground(Color.PINK);
		
		JPanel disciplineSelectionPanel = new JPanel();
		disciplineSelectionPanel.setBackground(Color.MAGENTA);
		
		JPanel disciplineOrderPanel = new JPanel();
		disciplineOrderPanel.setBackground(Color.RED);
		
		JButton btnSubmitDisciplineSelection = new JButton("Avanti");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(disciplineSelectionPanel, GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(disciplineOrderPanel, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)
					.addGap(53))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(128)
					.addComponent(btnSubmitDisciplineSelection, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(207, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(disciplineOrderPanel, 0, 0, Short.MAX_VALUE)
						.addComponent(disciplineSelectionPanel, GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
					.addComponent(btnSubmitDisciplineSelection)
					.addContainerGap())
		);
		
		JLabel lblCambiaOrdine = new JLabel("Cambia ordine");
		
		JList list = new JList();
		GroupLayout gl_disciplineOrderPanel = new GroupLayout(disciplineOrderPanel);
		gl_disciplineOrderPanel.setHorizontalGroup(
			gl_disciplineOrderPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_disciplineOrderPanel.createSequentialGroup()
					.addContainerGap(73, Short.MAX_VALUE)
					.addComponent(lblCambiaOrdine)
					.addGap(71))
				.addGroup(gl_disciplineOrderPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(list, GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_disciplineOrderPanel.setVerticalGroup(
			gl_disciplineOrderPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_disciplineOrderPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblCambiaOrdine)
					.addGap(18)
					.addComponent(list, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(149, Short.MAX_VALUE))
		);
		disciplineOrderPanel.setLayout(gl_disciplineOrderPanel);
		
		JLabel lblSelezionaDiscipline = new JLabel("Seleziona discipline");
		
		JCheckBox chckbxBenchPress = new JCheckBox("Bench Press");
		
		JCheckBox chckbxSquat = new JCheckBox("Squat");
		
		JCheckBox chckbxDeadlift = new JCheckBox("Deadlift");
		GroupLayout gl_disciplineSelectionPanel = new GroupLayout(disciplineSelectionPanel);
		gl_disciplineSelectionPanel.setHorizontalGroup(
			gl_disciplineSelectionPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_disciplineSelectionPanel.createSequentialGroup()
					.addGroup(gl_disciplineSelectionPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_disciplineSelectionPanel.createSequentialGroup()
							.addGap(52)
							.addComponent(lblSelezionaDiscipline))
						.addGroup(gl_disciplineSelectionPanel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_disciplineSelectionPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(chckbxBenchPress, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
								.addComponent(chckbxDeadlift, GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
								.addComponent(chckbxSquat, GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE))))
					.addContainerGap())
		);
		gl_disciplineSelectionPanel.setVerticalGroup(
			gl_disciplineSelectionPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_disciplineSelectionPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblSelezionaDiscipline)
					.addGap(18)
					.addComponent(chckbxBenchPress)
					.addGap(18)
					.addComponent(chckbxSquat)
					.addGap(18)
					.addComponent(chckbxDeadlift)
					.addContainerGap(142, Short.MAX_VALUE))
		);
		disciplineSelectionPanel.setLayout(gl_disciplineSelectionPanel);
		setLayout(groupLayout);
	}
}
