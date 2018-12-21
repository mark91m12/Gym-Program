package com.gym.program.utils;

import java.awt.Color;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

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

}
