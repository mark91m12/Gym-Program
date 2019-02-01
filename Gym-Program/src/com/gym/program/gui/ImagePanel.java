package com.gym.program.gui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class ImagePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private Image image = null;
	private int iWidth2;
	private int iHeight2;

	public ImagePanel(Image image) {
		if(image!=null) {
			this.image = image;
			this.iWidth2 = image.getWidth(this) / 2;
			this.iHeight2 = image.getHeight(this) / 2;
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (image != null) {
			int x = this.getParent().getWidth() / 2 - iWidth2;
			int y = this.getParent().getHeight() / 2 - iHeight2;
			g.drawImage(image, 0, 0, this);
		}
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
		this.iWidth2 = image.getWidth(this) / 2;
		this.iHeight2 = image.getHeight(this) / 2;
	}
	
	
}