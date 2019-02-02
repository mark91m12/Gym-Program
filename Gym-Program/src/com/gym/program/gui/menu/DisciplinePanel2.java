package com.gym.program.gui.menu;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.gym.program.logic.match.Match.TypeOfMatch;
import com.gym.program.utils.CollarType;
import com.gym.program.utils.GuiHelper;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JCheckBox;

public class DisciplinePanel2 extends JPanel {

	private static final long serialVersionUID = 1L;

	private final MainFrame mainFrame;

	private List<TypeOfMatch> disciplinesChoosen;

	private JButton btnSquat;
	private JButton btnDeadlift;
	private JButton btnBenchPress;
	private JButton btnCollarStandard;
	private JButton btnConfirm;

	private boolean benchPressIsSelected;
	private boolean squatIsSelected;
	private boolean deadliftIsSelected;
	private CollarType collarSelected;

	private String squatImgName = "SquatMenu";
	private String deadliftImgName = "deadliftMenu";
	private String benchPressImgName = "BenchPressMenu";
	private String collarStdImgName = "barbellCollar";
	private String collarSprImgName = "barbellSpring";

	public DisciplinePanel2(final MainFrame mF) {
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		setOpaque(false);

		mainFrame = mF;
		disciplinesChoosen = new ArrayList<>();

		btnSquat = new JButton("");
		squatIsSelected = false;
		GuiHelper.getInstance().setScaledImageJBtn(btnSquat, "/menu/SquatMenuBWS.jpg",50);
		btnSquat.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (squatIsSelected) {
					disciplinesChoosen.remove(TypeOfMatch.SQUAT);
					btnSquat.setIcon(getImageIconByName(squatImgName + "BW"));
					squatIsSelected = false;
					if (disciplinesChoosen.size() == 0 && btnConfirm.isEnabled()) {
						btnConfirm.setEnabled(false);
					}
				} else {
					disciplinesChoosen.add(TypeOfMatch.SQUAT);
					btnSquat.setIcon(getImageIconByName(squatImgName));
					squatIsSelected = true;
					btnConfirm.setEnabled(true);
				}
			}
		});

		btnDeadlift = new JButton("");
		deadliftIsSelected = false;
		GuiHelper.getInstance().setScaledImageJBtn(btnDeadlift, "/menu/deadliftMenuBWS.jpg",50);
		btnDeadlift.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (deadliftIsSelected) {
					disciplinesChoosen.remove(TypeOfMatch.DEADLIFT);
					btnDeadlift.setIcon(getImageIconByName(deadliftImgName + "BW"));
					deadliftIsSelected = false;
					if (disciplinesChoosen.size() == 0 && btnConfirm.isEnabled()) {
						btnConfirm.setEnabled(false);
					}
				} else {
					disciplinesChoosen.add(TypeOfMatch.DEADLIFT);
					btnDeadlift.setIcon(getImageIconByName(deadliftImgName));
					deadliftIsSelected = true;
					btnConfirm.setEnabled(true);
				}
			}
		});

		btnBenchPress = new JButton("");
		benchPressIsSelected = false;
		GuiHelper.getInstance().setScaledImageJBtn(btnBenchPress, "/menu/BenchPressMenuBWS.jpg",50);
		btnBenchPress.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (benchPressIsSelected) {
					disciplinesChoosen.remove(TypeOfMatch.BENCHPRESS);
					btnBenchPress.setIcon(getImageIconByName(benchPressImgName + "BW"));
					benchPressIsSelected = false;
					if (disciplinesChoosen.size() == 0 && btnConfirm.isEnabled()) {
						btnConfirm.setEnabled(false);
					}
				} else {
					disciplinesChoosen.add(TypeOfMatch.BENCHPRESS);
					btnBenchPress.setIcon(getImageIconByName(benchPressImgName));
					benchPressIsSelected = true;
					btnConfirm.setEnabled(true);
				}
			}
		});

		btnCollarStandard = new JButton("");
		collarSelected = CollarType.WEIGHT;
		GuiHelper.getInstance().setScaledImageJBtn(btnCollarStandard, "/menu/barbellCollarS.jpg",50);
		btnCollarStandard.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (collarSelected.equals(CollarType.WEIGHT)) {
					btnCollarStandard.setIcon(getImageIconByName(collarSprImgName));
					collarSelected = CollarType.LIGHT;
				} else {
					btnCollarStandard.setIcon(getImageIconByName(collarStdImgName));
					collarSelected = CollarType.WEIGHT;
				}
			}
		});

		JLabel lblselectionDisciplines = new JLabel("Seleziona le discipline");
		lblselectionDisciplines.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblselectionDisciplines.setForeground(Color.WHITE);

		JLabel lblselectionCollarType = new JLabel("Seleziona il tipo di fermo");
		lblselectionCollarType.setForeground(Color.WHITE);
		lblselectionCollarType.setFont(new Font("Tahoma", Font.BOLD, 20));

		JLabel lblselectionWeight = new JLabel("Se disponibili, seleziona i seguenti tagli");
		lblselectionWeight.setForeground(Color.WHITE);
		lblselectionWeight.setFont(new Font("Tahoma", Font.BOLD, 20));

		JCheckBox chckbx0p5 = new JCheckBox("0.5 KG");
		chckbx0p5.setOpaque(false);
		chckbx0p5.setFont(new Font("Tahoma", Font.BOLD, 25));
		chckbx0p5.setForeground(Color.WHITE);

		JCheckBox chckbx0p25 = new JCheckBox("0.25 KG");
		chckbx0p25.setOpaque(false);
		chckbx0p25.setForeground(Color.WHITE);
		chckbx0p25.setFont(new Font("Tahoma", Font.BOLD, 25));

		btnConfirm = new JButton("");
		btnConfirm.setIcon(new ImageIcon(DisciplinePanel2.class.getResource("/btns/button_confirm.png")));
		btnConfirm.setOpaque(false);
		btnConfirm.setEnabled(false);
		btnConfirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.sumbitDisciplines(disciplinesChoosen);
				mainFrame.setCollar(collarSelected);
				mainFrame.getManager().set0p5Present(chckbx0p5.isSelected());
				mainFrame.getManager().set0p25Present(chckbx0p25.isSelected());
			}
		});

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGap(804).addComponent(btnCollarStandard,
								GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup().addGap(803).addComponent(lblselectionDisciplines))
						.addGroup(groupLayout.createSequentialGroup().addGap(794).addComponent(lblselectionCollarType,
								GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup().addGap(188)
								.addComponent(btnSquat, GroupLayout.PREFERRED_SIZE, 493, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnDeadlift, GroupLayout.PREFERRED_SIZE, 493, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnBenchPress,
										GroupLayout.PREFERRED_SIZE, 493, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup().addGap(779)
								.addComponent(chckbx0p5, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
								.addGap(39)
								.addComponent(chckbx0p25, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup().addGap(822).addComponent(btnConfirm,
								GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup().addGap(730).addComponent(lblselectionWeight,
								GroupLayout.PREFERRED_SIZE, 409, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(239, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(64).addComponent(lblselectionDisciplines).addGap(26)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnBenchPress, GroupLayout.PREFERRED_SIZE, 321, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSquat, GroupLayout.PREFERRED_SIZE, 321, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnDeadlift, GroupLayout.PREFERRED_SIZE, 321, GroupLayout.PREFERRED_SIZE))
				.addGap(13)
				.addComponent(lblselectionCollarType, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
				.addGap(18).addComponent(btnCollarStandard, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
				.addGap(81).addComponent(lblselectionWeight, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(chckbx0p25, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
						.addComponent(chckbx0p5, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
				.addGap(65).addComponent(btnConfirm, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(67, Short.MAX_VALUE)));
		setLayout(groupLayout);
	}

	private ImageIcon getImageIconByName(String imgName) {
		return new ImageIcon(DisciplinePanel2.class.getResource("/menu/" + imgName + "S.jpg"));
	}
}
