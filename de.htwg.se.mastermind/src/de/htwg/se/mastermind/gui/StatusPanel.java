package de.htwg.se.mastermind.gui;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import de.htwg.se.mastermind.controller.IController;

public class StatusPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private IController controller;
	private JLabel labelStatus;
	private final static int WIDTH = 150;
	private final static int HEIGHT = 150;
	
	public StatusPanel(IController controller) {
		this.controller = controller;
		labelStatus = new JLabel("Welcome to Mastermind!");
		this.setMinimumSize(new Dimension(WIDTH, HEIGHT));
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setMaximumSize(new Dimension(WIDTH, HEIGHT));
		Border border = BorderFactory.createTitledBorder("Status");
		this.setBorder(border);
		this.add(labelStatus);
	}
	
	public void setStatus() {
		this.labelStatus.setText(controller.getStatusLine());
	}
}
