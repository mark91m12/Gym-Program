package com.gym.program.utils;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

import com.gym.program.logic.Manager;
import com.gym.program.logic.competitor.Competitor;
import com.gym.program.logic.match.Lifter;
import com.gym.program.logic.match.Match.TypeOfMatch;

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
		Image scaledImage = imageBg.getImage().getScaledInstance(panel.getPreferredSize().width - 150,
				panel.getPreferredSize().height - 150, Image.SCALE_SMOOTH);
		JLabel picture = new JLabel(new ImageIcon(scaledImage));
		panel.add(picture);
	}

	public void setBgColor(List<JComponent> components, Color color) {
		for (JComponent jComponent : components) {
			jComponent.setBackground(color);
		}
	}

	public String getEmptyError(List<String> list) {
		String response = "";
		if (!list.isEmpty())
			response = "Riempire i seguenti campi :\n";

		for (String tmp : list) {
			response += tmp + "\n";
		}

		return response;
	}

	public String getIncorrectError(String string) {
		return "Inserire " + string + " correttamente\n";
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

	public JScrollPane createTableForTeamRanking(Map<String, Double> teams_scores) {

		Object names[] = { " Posizione ", " Squadra ", " Punteggio" };

		Object rowData[][] = new Object[teams_scores.keySet().size()][names.length];

//		Map sorted = teams_scores.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
//				.collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
//
//		for (int i = 0; i < teams_scores.keySet().size(); i++) {
//			rowData[i][0] = i + 1;
//			rowData[i][1] = teams_scores.get(key).get(i).getCompetitor().getSurname();
//			rowData[i][2] = lifters.get(i).getCompetitor().getName();
//			rowData[i][3] = lifters.get(i).getCompetitor().getTeam();
//			rowData[i][4] = lifters.get(i).getCompetitor().getAge();
//			rowData[i][5] = lifters.get(i).getCompetitor().getWeight();
//			rowData[i][6] = lifters.get(i).getCategory();
//			rowData[i][7] = lifters.get(i).getCurrentAttemptWeight();
//		}

		TableModel model = new DefaultTableModel(rowData, names);
		JTable table = new JTable(model);
		table.getTableHeader().setReorderingAllowed(false);

		JScrollPane scroll = new JScrollPane(table);

		return scroll;
	}

	public JScrollPane createTableForRanking(List<Lifter> lifters) {

		Object names[] = { " Posizione ", " Cognome ", " Nome ", "Punteggio", " Squadra ", " Et� ", " Peso Corporeo ",
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

			Double firstAttemptWeight = lifters.get(i).getAttemptWeight(Attempt.StandardAttempt.FIRST);
			rowData[i][8] = firstAttemptWeight == null || firstAttemptWeight == 0 ? "-" : firstAttemptWeight;

			Double secondAttemptWeight = lifters.get(i).getAttemptWeight(Attempt.StandardAttempt.SECOND);
			rowData[i][9] = secondAttemptWeight == null || secondAttemptWeight == 0 ? "-" : secondAttemptWeight;

			Double thirdAttemptWeight = lifters.get(i).getAttemptWeight(Attempt.StandardAttempt.THIRD);
			rowData[i][10] = thirdAttemptWeight == null || thirdAttemptWeight == 0 ? "-" : thirdAttemptWeight;

			Double bonusAttemptWeight = lifters.get(i).getAttemptWeight(lifters.get(i).getBonusAttemptType());
			rowData[i][11] = bonusAttemptWeight == null || bonusAttemptWeight == 0 ? "-" : bonusAttemptWeight;

		}

		TableCellRenderer tableCellRenderer = new TableCellRenderer() {
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int column) {
				JLabel label = new JLabel();
				if (value != null)
					label.setText(value.toString());

				switch (column) {
				case 8:
					return coloredCell(lifters, row, label, Attempt.StandardAttempt.FIRST);
				case 9:
					return coloredCell(lifters, row, label, Attempt.StandardAttempt.SECOND);
				case 10:
					return coloredCell(lifters, row, label, Attempt.StandardAttempt.THIRD);
				case 11:
					return coloredCell(lifters, row, label, Attempt.BonusAttempt.GENERAL);
				default:
					break;
				}

				return label;
			}
		};

		TableModel model = new DefaultTableModel(rowData, names) {
			public boolean isCellEditable(int row, int column) {
				return false;// This causes all cells to be not editable
			}
		};
		// ZebraJTable table = new ZebraJTable(model);
		JTable table = new JTable(model);
		for (int i = 0; i < names.length; i++) {
			table.getColumnModel().getColumn(i).setCellRenderer(tableCellRenderer);
		}
		table.getTableHeader().setReorderingAllowed(false);
		JScrollPane scroll = new JScrollPane(table);
		return scroll;
	}

	private JLabel coloredCell(List<Lifter> lifters, int row, JLabel label, Attempt attempt) {

		if (row >= 0 && row < lifters.size()) {
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
		}
		return label;
	}

	public JScrollPane createTableForDispute(List<Lifter> lifters, Manager manager, TypeOfMatch t) {
		lifters.sort(new Comparator<Lifter>() {// lexicographic order
			@Override
			public int compare(Lifter o1, Lifter o2) {
				Competitor competitor1 = o1.getCompetitor();
				Competitor competitor2 = o2.getCompetitor();
				int result = competitor1.getSurname().compareToIgnoreCase(competitor2.getSurname());
				if (result == 0) {
					result = competitor1.getName().compareToIgnoreCase(competitor2.getName());
					if (result == 0) {
						return Integer.compare(competitor1.getAge(), competitor2.getAge());
					} else {
						return result;
					}
				} else {
					return result;
				}
			}
		});

		Object names[] = { " Cognome ", " Nome ", "Punteggio", " Squadra ", " Et� ", " Categoria ", " Prima alzta ",
				" Seconda alzta ", " Terza alzta ", "Avvia Contestazione" };
		Object rowData[][] = new Object[lifters.size()][names.length];

		Lifter l = null;
		for (int i = 0; i < lifters.size(); i++) {
			l = lifters.get(i);
			rowData[i][0] = l.getCompetitor().getSurname();
			rowData[i][1] = l.getCompetitor().getName();
			rowData[i][2] = l.getScore();
			rowData[i][3] = l.getCompetitor().getTeam();
			rowData[i][4] = l.getCompetitor().getAge();
			rowData[i][5] = l.getCategory();

			Double firstAttemptWeight = l.getAttemptWeight(Attempt.StandardAttempt.FIRST);
			rowData[i][6] = firstAttemptWeight == null || firstAttemptWeight == 0 ? "-" : firstAttemptWeight;

			Double secondAttemptWeight = l.getAttemptWeight(Attempt.StandardAttempt.SECOND);
			rowData[i][7] = secondAttemptWeight == null || secondAttemptWeight == 0 ? "-" : secondAttemptWeight;

			Double thirdAttemptWeight = l.getAttemptWeight(Attempt.StandardAttempt.THIRD);
			rowData[i][8] = thirdAttemptWeight == null || thirdAttemptWeight == 0 ? "-" : thirdAttemptWeight;

			int index = i;
			final JButton btnDispute = new JButton("Contesta");
			btnDispute.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					Lifter lifter = lifters.remove(index);
					Competitor competitor = lifter.getCompetitor();
					JOptionPane
							.showMessageDialog(null,
									"E' stata aggiunta l'alzata bonus per l'alteta:\n" + competitor.getSurname() + " "
											+ competitor.getName(),
									"ALZATA BONUS AGGIUNTA", JOptionPane.INFORMATION_MESSAGE);
					lifter.setBonusAttemptType(Attempt.BonusAttempt.DISPUTED);
					lifter.setNextAttemptWeight(lifter.getCurrentAttemptWeight());
					manager.getMatches().get(t).lifterWonDispute(lifter);
				}
			});
			rowData[i][9] = btnDispute;

		}

		TableCellRenderer tableCellRenderer = new TableCellRenderer() {
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int column) {
				JLabel label = new JLabel();
				if (value != null)
					label.setText(value.toString());

				switch (column) {
				case 6:
					return coloredCell(lifters, row, label, Attempt.StandardAttempt.FIRST);
				case 7:
					return coloredCell(lifters, row, label, Attempt.StandardAttempt.SECOND);
				case 8:
					return coloredCell(lifters, row, label, Attempt.StandardAttempt.THIRD);
				default:
					break;
				}

				return label;
			}
		};

		TableModel model = new DefaultTableModel(rowData, names) {
			public boolean isCellEditable(int row, int column) {
				return false;// This causes all cells to be not editable
			}
		};
		// ZebraJTable table = new ZebraJTable(model);
		JTable table = new JTable(model);
		for (int i = 0; i < names.length - 1; i++) {
			table.getColumnModel().getColumn(i).setCellRenderer(tableCellRenderer);
		}

		TableCellRenderer btnRenderer = new JTableButtonRenderer();
		table.getColumn("Avvia Contestazione").setCellRenderer(btnRenderer);
		table.getColumn("Avvia Contestazione").setCellEditor(new ButtonEditor(new JCheckBox()));
		table.addMouseListener(new JTableButtonMouseListener(table));
		table.getTableHeader().setReorderingAllowed(false);
		JScrollPane scroll = new JScrollPane(table);
		return scroll;
	}

}

// class ButtonRenderer extends JButton implements TableCellRenderer {
//
// public ButtonRenderer() {
// setOpaque(true);
// }
//
// @Override
// public Component getTableCellRendererComponent(JTable table, Object value,
// boolean isSelected, boolean hasFocus, int row, int column) {
// if (isSelected) {
// setForeground(table.getSelectionForeground());
// setBackground(table.getSelectionBackground());
// } else {
// setForeground(table.getForeground());
// setBackground(UIManager.getColor("Button.background"));
// }
// setText((value == null) ? "" : value.toString());
// return this;
// }
// }

class JTableButtonMouseListener extends MouseAdapter {
	private final JTable table;

	public JTableButtonMouseListener(JTable table) {
		this.table = table;
	}

	public void mouseClicked(MouseEvent e) {
		int column = table.getColumnModel().getColumnIndexAtX(e.getX()); // get
																			// the
																			// coloum
																			// of
																			// the
																			// button
		int row = e.getY() / table.getRowHeight(); // get the row of the button

		/* Checking the row or column is valid or not */
		if (row < table.getRowCount() && row >= 0 && column < table.getColumnCount() && column >= 0) {
			Object value = table.getValueAt(row, column);
			if (value instanceof JButton) {
				/* perform a click event */
				((JButton) value).doClick();
			}
		}
	}
}

class JTableButtonRenderer implements TableCellRenderer {
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		JButton button = (JButton) value;

		return button;
	}
}

class ButtonEditor extends DefaultCellEditor {

	protected JButton button;
	private String label;
	private boolean isPushed;

	public ButtonEditor(JCheckBox checkBox) {
		super(checkBox);
		button = new JButton();
		button.setOpaque(true);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fireEditingStopped();
			}
		});
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		if (isSelected) {
			button.setForeground(table.getSelectionForeground());
			button.setBackground(table.getSelectionBackground());
		} else {
			button.setForeground(table.getForeground());
			button.setBackground(table.getBackground());
		}
		label = (value == null) ? "" : value.toString();
		button.setText("Contesta");
		isPushed = true;
		return button;
	}

	@Override
	public Object getCellEditorValue() {
		if (isPushed) {
			JOptionPane.showMessageDialog(button, label + ": Ouch!");
		}
		isPushed = false;
		return label;
	}

	@Override
	public boolean stopCellEditing() {
		isPushed = false;
		return super.stopCellEditing();
	}

}