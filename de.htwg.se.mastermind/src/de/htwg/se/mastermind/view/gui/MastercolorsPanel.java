package de.htwg.se.mastermind.view.gui;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import de.htwg.se.mastermind.controller.IController;

public class MastercolorsPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private IController controller;
	private String [] masterColors;
	private static final int WIDTH = 190;
	private static final int HEIGHT = 60;
	private static final int XBALLS = 45;
	private static final int YBALLS = 25;
	private static final int WIDTHHEIGHTBALLS = 20;
	private static final int XINCREASE = 30;
	
	public MastercolorsPanel(IController controller) {
		this.controller = controller;
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.masterColors = new String[controller.getColumnsAmount()/2];
		this.initializeArray();
		this.setBorder(BorderFactory.createTitledBorder("Mastercolors"));
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int actualRow = this.controller.getActualRow();
		int rowsAmount = this.controller.getRowsAmount();
		boolean isSolved = this.controller.isSolved();
		boolean showSolution = this.controller.getShowSolution();
		if (isSolved || showSolution || actualRow == rowsAmount - 1) {
			masterColors = controller.getMastermindColors();
		}
		
		int x = XBALLS, y = YBALLS, width = WIDTHHEIGHTBALLS, height = WIDTHHEIGHTBALLS, xIncrease = XINCREASE;
		for (int i = masterColors.length - 1; i >= 0; i--) {
			g.setColor(controller.getColorFromString(masterColors[i]));
			g.fillOval(x, y, width, height);
			x += xIncrease;
		}
	}
	
	public final void initializeArray() {
		for (int i = 0; i < this.masterColors.length; i++) {
			this.masterColors[i] = "gy";
		}
	}
	
	public void setStandard() {
		this.initializeArray();
		this.setNewWidth();
	}
	
	public void setNewWidth() {
		int columnsAmount = controller.getColumnsAmount();
		
		switch(columnsAmount) {
			case 4:
				this.setPreferredSize(new Dimension(113, HEIGHT));
				break;
		
			case 8:
				this.setPreferredSize(new Dimension(190, HEIGHT));
				break;
				
			case 12:
				this.setPreferredSize(new Dimension(240, HEIGHT));
				break;
		}
	}
}
