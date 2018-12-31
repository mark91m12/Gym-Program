package com.gym.program.utils;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

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

	public void setSwitch(JRadioButton b1, JRadioButton b2) {

		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				b2.setSelected(false);
				b1.setSelected(true);
			}
		});

		b2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				b1.setSelected(false);
				b2.setSelected(true);
			}
		});
		;
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
}
