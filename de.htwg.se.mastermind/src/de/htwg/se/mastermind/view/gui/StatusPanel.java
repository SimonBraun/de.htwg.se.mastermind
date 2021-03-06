package de.htwg.se.mastermind.view.gui;

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
	private static final int WIDTH = 200;
	private static final int HEIGHT = 60;
	
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
