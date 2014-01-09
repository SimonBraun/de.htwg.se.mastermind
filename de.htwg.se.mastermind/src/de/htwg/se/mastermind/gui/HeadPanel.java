package de.htwg.se.mastermind.gui;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;

import de.htwg.se.mastermind.controller.IController;

public class HeadPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private StatusPanel statusPanel;

	public HeadPanel(IController controller) {
		this.setLayout(new GridLayout(0,2));
		this.setMinimumSize(new Dimension(450, 60));
		this.setPreferredSize(new Dimension(450, 60));
		this.setMaximumSize(new Dimension(450, 60));
		statusPanel = new StatusPanel(controller);
		MastercolorsPanel mastercolorsPanel = new MastercolorsPanel(controller);
		this.add(statusPanel);
		this.add(mastercolorsPanel);
	}
	
	public void setStatus() {
		statusPanel.setStatus();
	}
}
