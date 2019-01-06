package com.gym.program.utils;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

import com.gym.program.gui.ZebraJTable;
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
		Image scaledImage = imageBg.getImage().getScaledInstance(panel.getPreferredSize().width,panel.getPreferredSize().height,Image.SCALE_SMOOTH);
		JLabel picture = new JLabel(new ImageIcon(scaledImage));
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

	public JScrollPane createTableForRanking(List<Lifter> lifters) {

		Object names[] = { " Posizione ", " Cognome ", " Nome ", "Punteggio", " Squadra ", " Età ", " Peso Corporeo ",
				" Categoria ", " Prima alzta ", " Seconda alzta ", " Terza alzta ", "alzata Bonus" };
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
			
			Double firstAttemptWeight = lifters.get(i).getAttemptWeight(Attempt.FIRST);
			rowData[i][8] = firstAttemptWeight == null || firstAttemptWeight == 0 ? "-": firstAttemptWeight;
			
			Double secondAttemptWeight = lifters.get(i).getAttemptWeight(Attempt.SECOND);
			rowData[i][9] = secondAttemptWeight == null || secondAttemptWeight == 0 ? "-": secondAttemptWeight;
			
			Double thirdAttemptWeight = lifters.get(i).getAttemptWeight(Attempt.THIRD);
			rowData[i][10] = thirdAttemptWeight == null || thirdAttemptWeight == 0 ? "-": thirdAttemptWeight;
			
			Double bonusAttemptWeight = lifters.get(i).getAttemptWeight(Attempt.BONUS);
			rowData[i][11] = bonusAttemptWeight == null || bonusAttemptWeight == 0 ? "-": bonusAttemptWeight;

		}

		TableCellRenderer tableCellRenderer = new TableCellRenderer() {
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int column) {
				JLabel label = new JLabel();
				if (value != null)
					label.setText(value.toString());

				switch (column) {
				case 8:
					return coloredCell(lifters, row, label, Attempt.FIRST);
				case 9:
					return coloredCell(lifters, row, label, Attempt.SECOND);
				case 10:
					return coloredCell(lifters, row, label, Attempt.THIRD);
				case 11:
					return coloredCell(lifters, row, label, Attempt.BONUS);
				default:
					break;
				}

				return label;
			}
		};

		TableModel model = new DefaultTableModel(rowData, names) {
			public boolean isCellEditable(int row, int column)
		    {
		      return false;//This causes all cells to be not editable
		    }
		};
//		ZebraJTable table = new ZebraJTable(model);
		JTable table = new JTable(model);
		for (int i = 0; i < names.length; i++) {
			table.getColumnModel().getColumn(i).setCellRenderer(tableCellRenderer);
		}
		table.getTableHeader().setReorderingAllowed(false);
		JScrollPane scroll = new JScrollPane(table);
		return scroll;
	}

	private JLabel coloredCell(List<Lifter> lifters, int row, JLabel label, Attempt attempt) {

		if (lifters.get(row).getAttemptResult(attempt) != null) {
			label.setOpaque(true);
			if (lifters.get(row).getAttemptResult(attempt) == true) {
				label.setBackground(Color.GREEN);
				// label.setForeground(Color.WHITE);
			} else {
				label.setBackground(Color.red);
				// label.setForeground(Color.WHITE);
			} 
		}
		return label;
	}

}
