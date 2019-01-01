package com.gym.program.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.gym.program.logic.match.Match.TypeOfMatch;
import com.gym.program.utils.GuiHelper;

public class OrderPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox<String> choice_box;
	private JPanel list_panel;
	private JPanel choice_panel;
	private MatchFrame match_frame;
	private Object names[] = { " Posizione ", " Cognome ", " Nome ", " Squadra ", " Età ", " Peso Corporeo ",
			" Categoria ", " Peso da sollevare " };

	private JScrollPane scroll;

	/**
	 * Create the frame.
	 */

	public OrderPanel(MatchFrame mf) {

		this.match_frame = mf;
		
		System.out.println("OP  "+this.match_frame.getManager());

		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		setVisible(true);

		list_panel = new JPanel();
		list_panel.setBackground(Color.CYAN);

		choice_panel = new JPanel();

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
		list_panel.setLayout(new BorderLayout(0, 0));

		choice_box = new JComboBox<String>();

		choice_box.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				updateTable();
			}
		});

		choice_panel.add(choice_box);
		this.setPossibleChoices();

		this.setLayout(gl_contentPane);
	}

	private void setPossibleChoices() {

		for (TypeOfMatch type : this.match_frame.getManager().getMatches().keySet()) {
			this.choice_box.addItem(type.toString());
		}

	}

	private void updateTable() {

		this.list_panel.removeAll();

		this.scroll = GuiHelper.getInstance().createTable(names, this.match_frame.getManager().getMatches()
				.get(TypeOfMatch.valueOf((String) this.choice_box.getSelectedItem())).getLifters());

		this.list_panel.add(this.scroll);
		this.list_panel.updateUI();
	}

}
