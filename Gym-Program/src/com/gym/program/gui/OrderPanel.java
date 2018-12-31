package com.gym.program.gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class OrderPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox choice_box;

	/**
	 * Create the frame.
	 */

	public OrderPanel() {

		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		setVisible(true);

		// setBounds(100, 100, 450, 300);
		// contentPane = new JPanel();
		// contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		// this.setsetContentPane(contentPane);

		JPanel list_panel = new JPanel();
		list_panel.setBackground(Color.CYAN);

		JPanel choice_panel = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(this);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup().addGap(1)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(choice_panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1355,
										Short.MAX_VALUE)
								.addComponent(list_panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1355,
										Short.MAX_VALUE))
						.addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(choice_panel, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
						.addComponent(list_panel, GroupLayout.PREFERRED_SIZE, 670, GroupLayout.PREFERRED_SIZE)
						.addGap(43)));
		list_panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		choice_box = new JComboBox();
		choice_panel.add(choice_box);
		this.setPossibleChoices();

		Object rowData[][] = { { "Row1-Column1", "Row1-Column2", "Row1-Column3" },
				{ "Row2-Column1", "Row2-Column2", "Row2-Column3" } };
		Object columnNames[] = { "Column One", "Column Two", "Column Three" };

		TableModel model = new DefaultTableModel(rowData, columnNames);
		JTable table = new JTable(model);
		JScrollPane scroll = new JScrollPane();
		scroll.add(table);
		list_panel.add(table);
		this.setLayout(gl_contentPane);
	}

	private void setPossibleChoices() {
		this.choice_box.addItem("Bench Press");
		this.choice_box.addItem("Squat");
		this.choice_box.addItem("Deadlift");

		// this.match.... get list typeofmatch

		// foreach list add item
	}
}
