package com.gym.program.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.gym.program.logic.match.Match.TypeOfMatch;
import com.gym.program.utils.CollarType;
import com.gym.program.utils.GuiHelper;

import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JRadioButton;

public class DisciplinePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final MainFrame mainFrame;

	private List<TypeOfMatch> disciplinesChoosen;

	/**
	 * Create the panel.
	 */
	public DisciplinePanel(final MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		disciplinesChoosen = new ArrayList<>();
		// disciplinesChoosen = new DefaultListModel();
		setBackground(SystemColor.menu);

		JButton btnSubmitDisciplineSelection = new JButton("Conferma");
		btnSubmitDisciplineSelection.setEnabled(false);

		JPanel disciplineSelectionPanel = new JPanel();
		disciplineSelectionPanel.setBackground(SystemColor.menu);

		JLabel lblSelezionaDiscipline = new JLabel("Seleziona discipline:");
		lblSelezionaDiscipline.setFont(new Font("Tahoma", Font.BOLD, 13));

		JCheckBox chckbxBenchPress = new JCheckBox("Bench Press");
		chckbxBenchPress.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {// checkbox has
																// been selected
					disciplinesChoosen.add(TypeOfMatch.BENCHPRESS);
					if (!btnSubmitDisciplineSelection.isEnabled()) {
						btnSubmitDisciplineSelection.setEnabled(true);
					}
				} else {// checkbox has been deselected
					disciplinesChoosen.remove(TypeOfMatch.BENCHPRESS);
					if (disciplinesChoosen.size() == 0 && btnSubmitDisciplineSelection.isEnabled()) {
						btnSubmitDisciplineSelection.setEnabled(false);
					}
				}
			}
		});

		JCheckBox chckbxSquat = new JCheckBox("Squat");
		chckbxSquat.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {// checkbox has
																// been selected
					disciplinesChoosen.add(TypeOfMatch.SQUAT);
					if (!btnSubmitDisciplineSelection.isEnabled()) {
						btnSubmitDisciplineSelection.setEnabled(true);
					}
				} else {// checkbox has been deselected
					disciplinesChoosen.remove(TypeOfMatch.SQUAT);
					if (disciplinesChoosen.size() == 0 && btnSubmitDisciplineSelection.isEnabled()) {
						btnSubmitDisciplineSelection.setEnabled(false);
					}
				}
			}
		});

		JCheckBox chckbxDeadlift = new JCheckBox("Deadlift");
		chckbxDeadlift.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {// checkbox has
																// been selected
					disciplinesChoosen.add(TypeOfMatch.DEADLIFT);
					if (!btnSubmitDisciplineSelection.isEnabled()) {
						btnSubmitDisciplineSelection.setEnabled(true);
					}
				} else {// checkbox has been deselected
					disciplinesChoosen.remove(TypeOfMatch.DEADLIFT);
					if (disciplinesChoosen.size() == 0 && btnSubmitDisciplineSelection.isEnabled()) {
						btnSubmitDisciplineSelection.setEnabled(false);
					}
				}
			}
		});

		JRadioButton rdbtnCollarLight = new JRadioButton("Neutro(0Kg)");
		JRadioButton rdbtnCollarWeight = new JRadioButton("Standard(2.5Kg)", true);

		Set<JRadioButton> set = new HashSet<>();
		set.add(rdbtnCollarLight);
		set.add(rdbtnCollarWeight);
		GuiHelper.getInstance().setSwitch(set);

		JLabel lblSelezionaFermi = new JLabel("Seleziona fermi:");
		lblSelezionaFermi.setFont(new Font("Tahoma", Font.BOLD, 13));

		JLabel lblAggiungiTagli = new JLabel("Aggiungi tagli:");
		lblAggiungiTagli.setFont(new Font("Tahoma", Font.BOLD, 13));

		JCheckBox checkBox0p5 = new JCheckBox("0.5 Kg");
		checkBox0p5.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if (e.getStateChange() == ItemEvent.SELECTED)
					DisciplinePanel.this.mainFrame.getManager().set0p5Present(true);
				else
					DisciplinePanel.this.mainFrame.getManager().set0p5Present(false);
			}
		});

		JCheckBox checkBox0p25 = new JCheckBox("0.25 Kg");
		checkBox0p25.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if (e.getStateChange() == ItemEvent.SELECTED)
					DisciplinePanel.this.mainFrame.getManager().set0p25Present(true);
				else
					DisciplinePanel.this.mainFrame.getManager().set0p25Present(false);
			}
		});

		GroupLayout gl_disciplineSelectionPanel = new GroupLayout(disciplineSelectionPanel);
		gl_disciplineSelectionPanel
				.setHorizontalGroup(gl_disciplineSelectionPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_disciplineSelectionPanel.createSequentialGroup().addGap(57)
								.addComponent(lblSelezionaDiscipline).addContainerGap(33, Short.MAX_VALUE))
						.addGroup(gl_disciplineSelectionPanel.createSequentialGroup().addComponent(rdbtnCollarLight)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(rdbtnCollarWeight,
										GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE))
						.addGroup(gl_disciplineSelectionPanel.createSequentialGroup().addGap(21)
								.addGroup(gl_disciplineSelectionPanel.createParallelGroup(Alignment.TRAILING)
										.addComponent(chckbxSquat, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 126,
												Short.MAX_VALUE)
										.addComponent(chckbxDeadlift, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
												126, Short.MAX_VALUE)
										.addComponent(chckbxBenchPress, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE))
								.addGap(71))
						.addGroup(gl_disciplineSelectionPanel.createSequentialGroup()
								.addContainerGap(53, Short.MAX_VALUE)
								.addGroup(gl_disciplineSelectionPanel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblAggiungiTagli, GroupLayout.PREFERRED_SIZE, 103,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblSelezionaFermi))
								.addGap(62))
						.addGroup(gl_disciplineSelectionPanel.createSequentialGroup().addContainerGap()
								.addComponent(checkBox0p5, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(checkBox0p25, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(46, Short.MAX_VALUE)));
		gl_disciplineSelectionPanel.setVerticalGroup(gl_disciplineSelectionPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_disciplineSelectionPanel.createSequentialGroup().addContainerGap()
						.addComponent(lblSelezionaDiscipline).addGap(18).addComponent(chckbxBenchPress).addGap(18)
						.addComponent(chckbxSquat, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addGap(18).addComponent(chckbxDeadlift).addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(lblAggiungiTagli, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_disciplineSelectionPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(checkBox0p25).addComponent(checkBox0p5))
						.addPreferredGap(ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
						.addComponent(lblSelezionaFermi).addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_disciplineSelectionPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(rdbtnCollarLight).addComponent(rdbtnCollarWeight))));

		btnSubmitDisciplineSelection.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.sumbitDisciplines(disciplinesChoosen);
				if (rdbtnCollarLight.isSelected()) {
					mainFrame.setCollar(CollarType.LIGHT);
				} else if (rdbtnCollarWeight.isSelected()) {
					mainFrame.setCollar(CollarType.WEIGHT);
				} else {

				}
			}
		});

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout
				.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGap(128).addComponent(
								btnSubmitDisciplineSelection, GroupLayout.PREFERRED_SIZE, 106,
								GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup().addGap(131).addComponent(disciplineSelectionPanel,
								GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(101, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
						.addComponent(disciplineSelectionPanel, GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnSubmitDisciplineSelection)
						.addContainerGap()));

		disciplineSelectionPanel.setLayout(gl_disciplineSelectionPanel);
		setLayout(groupLayout);
	}
}
