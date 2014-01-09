package de.htwg.se.mastermind.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import de.htwg.se.mastermind.controller.IController;

public class MastercolorsPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private IController controller;
	private String [] masterColors;
	
	public MastercolorsPanel(IController controller) {
		this.controller = controller;
		this.setMinimumSize(new Dimension(150, 50));
		this.setPreferredSize(new Dimension(150, 50));
		this.setMaximumSize(new Dimension(150, 50));
		this.masterColors = new String[controller.getColumnsAmount()/2];
		this.initializeArray();
		this.setBorder(BorderFactory.createTitledBorder("Mastercolors"));
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (this.controller.isSolved() || this.controller.getActualRow() == this.controller.getRowsAmount() - 1) {
			masterColors = controller.getMastermindColors();
		}
		
		int x = 45, y = 25;
		for (int i = masterColors.length - 1; i >= 0; i--) {
			g.setColor(getColorFromString(masterColors[i]));
			g.fillOval(x, y, 20, 20);
			x += 30;
		}
	}
	
	public Color getColorFromString(String color) {
		
		if (color.equals("yl")) {
			return Color.yellow;
		}
		
		if (color.equals("bl")) {
			return Color.blue;
		}
		
		if (color.equals("rd")) {
			return Color.red;
		}
		
		if (color.equals("gr")) {
			return Color.green;
		}
		
		if (color.equals("or")) {
			return Color.orange;
		}
		
		if (color.equals("pk")) {
			return Color.pink;
		}
		
		if (color.equals("pu")) {
			return Color.magenta;
		}
		
		if (color.equals("gy")) {
			return Color.gray;
		}
		
		return null;
	}
	
	public void initializeArray() {
		for (int i = 0; i < this.masterColors.length; i++) {
			this.masterColors[i] = "gy";
		}
	}
	
	public void setStandard() {
		this.initializeArray();
	}
}
