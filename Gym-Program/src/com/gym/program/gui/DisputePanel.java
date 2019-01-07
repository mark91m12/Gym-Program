package com.gym.program.gui;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.gym.program.logic.match.Lifter;
import com.gym.program.logic.match.Match.TypeOfMatch;
import com.gym.program.utils.GuiHelper;
import java.awt.BorderLayout;
import java.awt.Dimension;

public class DisputePanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public DisputePanel(MainFrame m) {
		JLabel lblLifters = new JLabel("Atleti:");
		JPanel tableContainerPanel = new JPanel();
		tableContainerPanel.setBackground(Color.WHITE);
		
		JLabel lblDisciplineSelection = new JLabel("Seleziona disciplina");
		
		JComboBox comboBoxDisciplines = new JComboBox();
		DefaultComboBoxModel<TypeOfMatch> disciplinesModel = new DefaultComboBoxModel();
		for (TypeOfMatch type : m.getManager().getMatches().keySet()) {
			disciplinesModel.addElement(type);
		}
		comboBoxDisciplines.setModel(disciplinesModel);
		comboBoxDisciplines.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tableContainerPanel.removeAll();
				List<Lifter> lifters = new LinkedList();
				for (Lifter lifter : m.getManager().getMatches().get(comboBoxDisciplines.getSelectedItem()).getLiftersCanDispute()) {
					lifters.add(lifter);
				}
				JScrollPane scroll = GuiHelper.getInstance().createTableForDispute(lifters);
				tableContainerPanel.add(scroll);
				tableContainerPanel.updateUI();
			}
		});

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(tableContainerPanel, GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
					.addGap(16))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblLifters, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(390, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(425)
					.addComponent(lblDisciplineSelection)
					.addContainerGap(431, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(363)
					.addComponent(comboBoxDisciplines, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(395, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblDisciplineSelection)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(comboBoxDisciplines, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addGap(39)
					.addComponent(lblLifters)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tableContainerPanel, GroupLayout.PREFERRED_SIZE, 257, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(16, Short.MAX_VALUE))
		);
		tableContainerPanel.setLayout(new BorderLayout(0, 0));
		setLayout(groupLayout);
		setSize(new Dimension(1956, 1055));
	}
}
