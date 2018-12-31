package com.gym.program.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.gym.program.logic.Manager;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

public class MainFrame extends JFrame implements PanelSwitcher{

	private JPanel contentPane;
	private final DisciplinePanel disciplinePanel;
	private JPanel mainPanelToSwitch;
	private Manager manager;
	private JButton btnStart;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		manager = new Manager();
		
		this.disciplinePanel = new DisciplinePanel(this);
		setBounds(100, 100, 600, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(final WindowEvent e) {
					final int i = JOptionPane.showConfirmDialog(MainFrame.this, "Do you really want to exit?", "Exit?",
							JOptionPane.YES_NO_OPTION);
					if (i == JOptionPane.YES_OPTION) {
						System.exit(0);
					}
			}
		});
		
		
		
		
		JPanel menuPanel = new JPanel();
		menuPanel.setBackground(Color.DARK_GRAY);
		
		mainPanelToSwitch = new JPanel();
		mainPanelToSwitch.setBackground(Color.ORANGE);
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(menuPanel, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(mainPanelToSwitch, GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(mainPanelToSwitch, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE)
						.addComponent(menuPanel, GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE))
					.addGap(0))
		);
		
		JButton btnInsertLifters = new JButton("Iscrivi atleti");
		btnInsertLifters.setEnabled(false);
		
		btnStart = new JButton("Inizia gara");
		btnStart.setEnabled(false);
		GroupLayout gl_menuPanel = new GroupLayout(menuPanel);
		gl_menuPanel.setHorizontalGroup(
			gl_menuPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_menuPanel.createSequentialGroup()
					.addContainerGap(25, Short.MAX_VALUE)
					.addGroup(gl_menuPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnStart)
						.addComponent(btnInsertLifters))
					.addGap(23))
		);
		gl_menuPanel.setVerticalGroup(
			gl_menuPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_menuPanel.createSequentialGroup()
					.addGap(46)
					.addComponent(btnInsertLifters)
					.addPreferredGap(ComponentPlacement.RELATED, 254, Short.MAX_VALUE)
					.addComponent(btnStart)
					.addContainerGap())
		);
		menuPanel.setLayout(gl_menuPanel);
		contentPane.setLayout(gl_contentPane);
		switchTo(disciplinePanel);
	}

	@Override
	public void switchTo(JComponent component) {
		this.mainPanelToSwitch.removeAll();
		this.mainPanelToSwitch.add(component);
		this.mainPanelToSwitch.updateUI();
		component.requestFocus();
//		pack();
		setLocationRelativeTo(null);
	}

	public Manager getManager() {
		return manager;
	}

	public void showInsertForm() {
		switchTo(new InsertForm(this));
	}

	public void setStartBtnEnabled(boolean b) {
		btnStart.setEnabled(b);
	}
	
}
