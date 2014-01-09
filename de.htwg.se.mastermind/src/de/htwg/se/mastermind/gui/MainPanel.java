package de.htwg.se.mastermind.gui;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class MainPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private final static int DEFAULT_X = 500;
	private final static int DEFAULT_Y = 600;
	
	public MainPanel() {
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		Border border = BorderFactory.createEmptyBorder();
		this.setSize(DEFAULT_X, DEFAULT_Y);
		this.setBorder(border);
	}
}
