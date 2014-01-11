package de.htwg.se.mastermind.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import de.htwg.se.mastermind.controller.IController;
import de.htwg.se.mastermind.observer.Event;
import de.htwg.se.mastermind.observer.IObserver;

public class MastermindFrame extends JFrame implements IObserver {

	private static final long serialVersionUID = 1L;
	private static final int DEFAULT_Y = 430;
	private static final int DEFAULT_X = 380;
	private static final int ROWS = 8;
	private static final int COLUMNS = 8;
	
	private JPanel mainPanel;
	private HeadPanel headPanel;
	private GameFieldPanel gameFieldPanel;
	IController controller;
	
	public MastermindFrame(final IController myController) {
		this.controller = myController;
		this.controller.addObserver(this);

		JMenuBar menuBar;
		
		JMenu fileMenu, optionsMenu;
		JMenuItem newMenuItem, exitMenuItem, setSize4MenuItem;
		
		this.setTitle("Mastermind");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(DEFAULT_X, DEFAULT_Y);
		this.setResizable(false);
		
		menuBar = new JMenuBar();
		
		/*
		 *FileMenu 
		 */
		
		fileMenu = new JMenu("File");
		
		newMenuItem = new JMenuItem("New");
		newMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				controller.create(ROWS, COLUMNS);
				gameFieldPanel.setStandard();
				headPanel.setStandard();
			}
		});
		
		exitMenuItem = new JMenuItem("Exit");
		exitMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		fileMenu.add(newMenuItem);
		fileMenu.addSeparator();
		fileMenu.add(exitMenuItem);
		
		/**
		 * OptionsMenu
		 */
		optionsMenu = new JMenu("Options");
		
		setSize4MenuItem = new JMenuItem("Set size 4*8");
		setSize4MenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.create(ROWS/2, COLUMNS);
				gameFieldPanel.setStandard();
				gameFieldPanel.setRowsAmount(ROWS/2 - 1);
				gameFieldPanel.setYStart();
				headPanel.setStandard();
				setHeight(300);
			}
		});
		
		optionsMenu.add(setSize4MenuItem);
		
		menuBar.add(fileMenu);
		menuBar.add(optionsMenu);
		
		mainPanel = new MainPanel();
		headPanel = new HeadPanel(controller);
		gameFieldPanel = new GameFieldPanel(controller);
		mainPanel.add(headPanel);
		mainPanel.add(gameFieldPanel);

		this.setJMenuBar(menuBar);
		this.add(mainPanel);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}
	@Override
	public void update(Event e) {
		this.headPanel.setStatus();
		repaint();
	}
	
	public void setHeight(int size) {
		this.setSize(DEFAULT_X, size);
	}
}
