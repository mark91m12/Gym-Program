package com.gym.program.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JCheckBox;

public class MainApp extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainApp frame = new MainApp();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
					
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
	public MainApp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel menuPanel = new JPanel();
		menuPanel.setBackground(Color.DARK_GRAY);
		
		JInternalFrame mainPanel = new DisciplineSelectionPanel();
//		mainPanel.se Background(Color.ORANGE);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(menuPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(mainPanel, GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(mainPanel, GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
				.addComponent(menuPanel, GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
		);
		GroupLayout gl_mainPanel = new GroupLayout(mainPanel);
		gl_mainPanel.setHorizontalGroup(
			gl_mainPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 263, Short.MAX_VALUE)
		);
		gl_mainPanel.setVerticalGroup(
			gl_mainPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 243, Short.MAX_VALUE)
		);
		
//		mainPanel.setLayout(gl_mainPanel);
		
		JButton btnInsertLifters = new JButton("Iscrivi partecipanti");
		btnInsertLifters.setEnabled(false);
		
		JButton btnStart = new JButton("Avvia gara");
		btnStart.setEnabled(false);
		GroupLayout gl_menuPanel = new GroupLayout(menuPanel);
		gl_menuPanel.setHorizontalGroup(
			gl_menuPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_menuPanel.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_menuPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnStart)
						.addComponent(btnInsertLifters))
					.addContainerGap(12, Short.MAX_VALUE))
		);
		gl_menuPanel.setVerticalGroup(
			gl_menuPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_menuPanel.createSequentialGroup()
					.addGap(5)
					.addComponent(btnInsertLifters)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnStart)
					.addContainerGap(181, Short.MAX_VALUE))
		);
		menuPanel.setLayout(gl_menuPanel);
		contentPane.setLayout(gl_contentPane);
		
	}
}
