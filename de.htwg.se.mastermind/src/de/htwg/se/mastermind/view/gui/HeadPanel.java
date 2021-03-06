package de.htwg.se.mastermind.view.gui;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;

import de.htwg.se.mastermind.controller.IController;

public class HeadPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private StatusPanel statusPanel;
	private MastercolorsPanel mastercolorsPanel;
	private static final int WIDTH = 450;
	private static final int HEIGHT = 70;

	public HeadPanel(IController controller) {
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.setMinimumSize(new Dimension(WIDTH, HEIGHT));
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setMaximumSize(new Dimension(WIDTH, HEIGHT));
		statusPanel = new StatusPanel(controller);
		mastercolorsPanel = new MastercolorsPanel(controller);
		this.add(statusPanel);
		this.add(mastercolorsPanel);
	}
	
	public void setStatus() {
		statusPanel.setStatus();
	}
	
	public void setStandard() {
		mastercolorsPanel.setStandard();
	}
}
