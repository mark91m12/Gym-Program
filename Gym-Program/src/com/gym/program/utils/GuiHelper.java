package com.gym.program.utils;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.gym.program.logic.match.Lifter;

public class GuiHelper {

	private static GuiHelper instance = null;

	public static GuiHelper getInstance() {
		if (instance == null) {
			instance = new GuiHelper();
		}

		return instance;
	}

	private GuiHelper() {

	}

	public void addBgImageJF(JFrame frame, String path) {

		ImageIcon imageBg = new ImageIcon(path);
		JLabel picture = new JLabel(new ImageIcon(imageBg.getImage()));
		frame.add(picture);
	}

	public void addBgImageJP(JPanel panel, String path) {

		ImageIcon imageBg = new ImageIcon(path);
		JLabel picture = new JLabel(new ImageIcon(imageBg.getImage()));
		panel.add(picture);
	}

	public void setBgColor(List<JComponent> components, Color color) {
		for (JComponent jComponent : components) {
			jComponent.setBackground(color);
		}
	}

	public void setSwitch(Set<JRadioButton> radioBtns) {
		for (JRadioButton rdBtn : radioBtns) {
			rdBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					for (JRadioButton rdBtn2 : radioBtns) {
						rdBtn2.setSelected(false);
					}
					rdBtn.setSelected(true);
				}
			});
		}
	}

	public JScrollPane createTable(Object names[], List<Lifter> lifters) {

		// Object rowData[][] = { { "Row1-Column1", "Row1-Column2",
		// "Row1-Column3" },
		// { "Row2-Column1", "Row2-Column2", "Row2-Column3" } };
		// Object columnNames[] = { "Column One", "Column Two", "Column Three"
		// };

		Object rowData[][] = new Object[lifters.size()][names.length];

		for (int i = 0; i < lifters.size(); i++) {
			rowData[i][0] = i + 1;
			rowData[i][1] = lifters.get(i).getCompetitor().getSurname();
			rowData[i][2] = lifters.get(i).getCompetitor().getName();
			rowData[i][3] = lifters.get(i).getCompetitor().getTeam();
			rowData[i][4] = lifters.get(i).getCompetitor().getAge();
			rowData[i][5] = lifters.get(i).getCompetitor().getWeight();
			rowData[i][6] = lifters.get(i).getCategory();
			rowData[i][7] = lifters.get(i).getCurrentAttemptWeight();
		}

		TableModel model = new DefaultTableModel(rowData, names);
		JTable table = new JTable(model);
		table.getTableHeader().setReorderingAllowed(false);
		JScrollPane scroll = new JScrollPane(table);

		return scroll;
	}
	
	public JScrollPane createTableForRanking( List<Lifter> lifters) {

		Object names[] = { " Posizione "," Cognome "," Nome ","Punteggio"," Squadra "," Età "," Peso Corporeo "," Categoria ",
				" Peso prima alzta "," Esito prima alzta "," Peso seconda alzta "," Esito seconda alzta "," Peso terza alzta "," Esito terza alzta " };
		Object rowData[][] = new Object[lifters.size()][names.length];

		for (int i = 0; i < lifters.size(); i++) {
			rowData[i][0] = i + 1;
			rowData[i][1] = lifters.get(i).getCompetitor().getSurname();
			rowData[i][2] = lifters.get(i).getCompetitor().getName();
			rowData[i][3] = lifters.get(i).getScore();
			rowData[i][4] = lifters.get(i).getCompetitor().getTeam();
			rowData[i][5] = lifters.get(i).getCompetitor().getAge();
			rowData[i][6] = lifters.get(i).getCompetitor().getWeight();
			rowData[i][7] = lifters.get(i).getCategory();
			rowData[i][8] = lifters.get(i).getAttemptWeight(Attempt.FIRST)==null?"-":lifters.get(i).getAttemptWeight(Attempt.FIRST);
			rowData[i][9] = lifters.get(i).getAttemptResult(Attempt.FIRST)==null?"-":(lifters.get(i).getAttemptResult(Attempt.FIRST)==false?"negativo":"positivo");
			rowData[i][10] = lifters.get(i).getAttemptWeight(Attempt.SECOND)==null?"-":lifters.get(i).getAttemptWeight(Attempt.SECOND);
			rowData[i][11] = lifters.get(i).getAttemptResult(Attempt.SECOND)==null?"-":(lifters.get(i).getAttemptResult(Attempt.SECOND)==false?"negativo":"positivo");
			rowData[i][12] = lifters.get(i).getAttemptWeight(Attempt.THIRD)==null?"-":lifters.get(i).getAttemptWeight(Attempt.THIRD);
			rowData[i][13] = lifters.get(i).getAttemptResult(Attempt.THIRD)==null?"-":(lifters.get(i).getAttemptResult(Attempt.THIRD)==false?"negativo":"positivo");
		}

		TableModel model = new DefaultTableModel(rowData, names);
		JTable table = new JTable(model);
		table.getTableHeader().setReorderingAllowed(false);
		JScrollPane scroll = new JScrollPane(table);
		return scroll;
	}
}
