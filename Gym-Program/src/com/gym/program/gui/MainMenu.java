package com.gym.program.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.gym.program.logic.Manager;
import com.gym.program.utils.GuiHelper;

public class MainMenu extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	JButton createEventBtn, exitBtn;
	JPanel panel;

	ImageIcon imageBg;
	JLabel picture;

	public MainMenu() {

		panel = new JPanel();
		
		panel.setLayout(null);
		panel.setOpaque(false);
		panel.setSize(620, 520);
		getContentPane().add(panel);

		// Add background
		GuiHelper.getInstance().addBgImageJF(this, "images/main_menu_bg.jpg", 0);

		// Create Event Button
		createEventBtn = new JButton("Crea Gara");
		createEventBtn.setBounds(253, 40, 110, 25);
		createEventBtn.setFocusable(false);
		panel.add(createEventBtn);

		// Exit Button
		exitBtn = new JButton(" Exit ");
		exitBtn.setBounds(253, 410, 110, 25);
		exitBtn.setFocusable(false);
		panel.add(exitBtn);

		this.pack();

		setTitle("Gym Program");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(620, 520);
		setResizable(false);
		setVisible(true);

		createEventBtn.addActionListener(this);
		exitBtn.addActionListener(this);
		
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == createEventBtn) {

			// Open window for events choice ( BENCH | SQUAT | DEADLIFT )
			// new CreateEventMenu();

			new MainFrame(new Manager());

			this.dispose();

		}

		else if (e.getSource() == exitBtn) {
			System.exit(0);
		}
	}

}