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
	
	public StatusPanel(IController controller) {
		this.controller = controller;
		labelStatus = new JLabel("Welcome to Mastermind!");
		this.setMinimumSize(new Dimension(150, 50));
		this.setPreferredSize(new Dimension(150, 50));
		this.setMaximumSize(new Dimension(150, 50));
		Border border = BorderFactory.createTitledBorder("Status");
		this.setBorder(border);
		this.add(labelStatus);
	}
	
	public void setStatus() {
		this.labelStatus.setText(controller.getStatusLine());
	}
}
