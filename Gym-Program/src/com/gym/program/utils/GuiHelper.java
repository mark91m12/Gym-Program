package com.gym.program.utils;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.Toolkit;
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
import com.gym.program.logic.match.RankingPerTeam;

public class GuiHelper {

	private Color blue_3;
	private Color blue_2;
	private Color blue_1;

	private static GuiHelper instance = null;

	public static GuiHelper getInstance() {
		if (instance == null) {
			instance = new GuiHelper();
		}

		return instance;
	}

	private GuiHelper() {

		blue_3 = new Color(30, 145, 245);
		blue_2 = new Color(51, 153, 255);
		blue_1 = new Color(102, 178, 255);

	}

	private double getScreenWidth() {

		return Toolkit.getDefaultToolkit().getScreenSize().getWidth();

	}

	private double getScreenHeight() {

		return Toolkit.getDefaultToolkit().getScreenSize().getHeight();

	}

	public int getMiusreBy1366(int x) {

		return (int) ((x / 1366.00) * GuiHelper.getInstance().getScreenWidth());

	}

	public void addBgImageJF(JFrame frame, String path, int scale) {

		ImageIcon imageBg = new ImageIcon(path);
		Image scaledImage = imageBg.getImage().getScaledInstance(frame.getPreferredSize().width - scale,
				frame.getPreferredSize().height - scale, Image.SCALE_SMOOTH);
		JLabel picture = new JLabel(new ImageIcon(scaledImage));
		frame.add(picture);
	}

	public Color getBlue_3() {
		return blue_3;
	}

	public void setBlue_3(Color blue_3) {
		this.blue_3 = blue_3;
	}

	public Color getBlue_2() {
		return blue_2;
	}

	public void setBlue_2(Color blue_2) {
		this.blue_2 = blue_2;
	}

	public Color getBlue_1() {
		return blue_1;
	}

	public void setBlue_1(Color blue_1) {
		this.blue_1 = blue_1;
	}

	public void addBgImageJP(JPanel panel, String path, int scale) {

		ImageIcon imageBg = new ImageIcon(path);
		Image scaledImage = imageBg.getImage().getScaledInstance(panel.getPreferredSize().width - scale,
				panel.getPreferredSize().height - scale, Image.SCALE_SMOOTH);
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
		table.getTableHeader().setBackground(GuiHelper.getInstance().getBlue_1());
		table.setEnabled(false);

		JScrollPane scroll = new JScrollPane(table);
		return scroll;
	}

	public JScrollPane createTableForTeamRanking(Map<String, Double> teams_scores) {

		Object names[] = { " Posizione ", " Squadra ", " Punteggio" };

		Object rowData[][] = new Object[teams_scores.keySet().size()][names.length];

		// Map sorted =
		// teams_scores.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
		// .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) ->
		// e2, LinkedHashMap::new));
		//
		// for (int i = 0; i < teams_scores.keySet().size(); i++) {
		// rowData[i][0] = i + 1;
		// rowData[i][1] =
		// teams_scores.get(key).get(i).getCompetitor().getSurname();
		// rowData[i][2] = lifters.get(i).getCompetitor().getName();
		// rowData[i][3] = lifters.get(i).getCompetitor().getTeam();
		// rowData[i][4] = lifters.get(i).getCompetitor().getAge();
		// rowData[i][5] = lifters.get(i).getCompetitor().getWeight();
		// rowData[i][6] = lifters.get(i).getCategory();
		// rowData[i][7] = lifters.get(i).getCurrentAttemptWeight();
		// }

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

		Object names[] = { " Cognome ", " Nome ", "Punteggio", " Squadra ", " Età ", " Categoria ", " Prima alzta ",
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

	public JScrollPane createTableForRanking(RankingPerTeam teamScores) {
		Object names[] = { " Posizione ", " Squadra ", "Punteggio" };
		Object rowData[][] = new Object[teamScores.size()][names.length];

		for (int i = 0; i < teamScores.size(); i++) {
			rowData[i][0] = i + 1;
			rowData[i][1] = teamScores.get(i).getName();
			rowData[i][2] = teamScores.get(i).getScore();
		}

		TableModel model = new DefaultTableModel(rowData, names) {
			public boolean isCellEditable(int row, int column) {
				return false;// This causes all cells to be not editable
			}
		};
		// ZebraJTable table = new ZebraJTable(model);
		JTable table = new JTable(model);
		table.getTableHeader().setReorderingAllowed(false);
		JScrollPane scroll = new JScrollPane(table);
		return scroll;
	}

	public JScrollPane createTableForAbsoluteRanking(List<Competitor> competitors) {
		// TODO Auto-generated method stub

		competitors.sort(new Comparator<Competitor>() {
			@Override
			public int compare(Competitor c1, Competitor c2) {
				if (c1.getScore() > c2.getScore()) { // o1.score > o2.score
					return -1;
				} else if (c2.getScore() > c1.getScore()) { // o2.score >
															// o1.score
					return 1;
				} else { // o1.score == o2.score TODO order by name or age?
					return 0;// 01 score
				}
			}
		});

		Object names[] = { " Posizione ", " Cognome ", " Nome ", "Punteggio", " Squadra ", " Età ", " Peso Corporeo ",
				" Categoria " };
		Object rowData[][] = new Object[competitors.size()][names.length];

		for (int i = 0; i < competitors.size(); i++) {
			rowData[i][0] = i + 1;
			rowData[i][1] = competitors.get(i).getSurname();
			rowData[i][2] = competitors.get(i).getName();
			rowData[i][3] = competitors.get(i).getScore();
			rowData[i][4] = competitors.get(i).getTeam();
			rowData[i][5] = competitors.get(i).getAge();
			rowData[i][6] = competitors.get(i).getWeight();
			rowData[i][7] = competitors.get(i).getCategory();

		}

		TableModel model = new DefaultTableModel(rowData, names) {
			public boolean isCellEditable(int row, int column) {
				return false;// This causes all cells to be not editable
			}
		};
		// ZebraJTable table = new ZebraJTable(model);
		JTable table = new JTable(model);

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