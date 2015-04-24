package de.htwg.se.mastermind.view.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import de.htwg.se.mastermind.controller.IController;
import de.htwg.se.mastermind.observer.Event;
import de.htwg.se.mastermind.observer.IObserver;
import de.htwg.se.mastermind.controller.SizeChangedEvent;

public class MastermindFrame extends JFrame implements IObserver {

	private static final long serialVersionUID = 1L;
	private static final int DEFAULT_Y = 430;
	private static final int DEFAULT_X = 410;
	private static final int ROWS = 8;
	private static final int COLUMNS = 8;
	private static final int ROWS12 = 12;
	private static final int ROWS4 = 4;
	private static final int HEIGHT12 = 600;
	private static final int HEIGHT4 = 270;
	private static final int WIDTH12 = 460;
	private static final int WIDTH4 = 330;
	 
	private JPanel mainPanel;
	private HeadPanel headPanel;
	private GameFieldPanel gameFieldPanel;
	private IController controller;
	private MastermindFrame frame;
	
	public MastermindFrame(final IController myController) {
		this.controller = myController;
		this.controller.addObserver(this);
		this.frame = this;
		
		JMenuBar menuBar;
		
		JMenu fileMenu, optionsMenu;
		JMenuItem newMenuItem, exitMenuItem, showSolutionMenuItem, setSize12MenuItem, setSize8MenuItem, setSize4MenuItem, highscoreMenuItem, removeHighscoreMenuItem, setBasicColorsMenuItem, setCountryColorsMenuItem;
		
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
			newGame();
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
		
		showSolutionMenuItem = new JMenuItem("Show Solution");
		showSolutionMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.showSolution();
			}
		});
		
		setSize12MenuItem = new JMenuItem("Set size 12*8");
		setSize12MenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.resetSize(ROWS12, ROWS12);
				gameFieldPanel.setStandard();
				gameFieldPanel.setRowsAmount(ROWS12 - 1);
				gameFieldPanel.setYStart();
				setHeight(ROWS12);
			}
		});
		
		setSize8MenuItem = new JMenuItem("Set size 8*8");
		setSize8MenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.resetSize(ROWS, COLUMNS);
				gameFieldPanel.setStandard();
				gameFieldPanel.setRowsAmount(ROWS - 1);
				gameFieldPanel.setYStart();
				headPanel.setStandard();
				setHeight(ROWS);
			}
		});
		
		setSize4MenuItem = new JMenuItem("Set size 4*8");
		setSize4MenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.resetSize(ROWS4, ROWS4);
				gameFieldPanel.setStandard();
				gameFieldPanel.setRowsAmount(ROWS4 - 1);
				gameFieldPanel.setYStart();
				headPanel.setStandard();
				setHeight(ROWS4);
			}
		});
		
		highscoreMenuItem = new JMenuItem("Highscores");
		highscoreMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new HighscoreDialog(controller, frame);
			}
		});


		removeHighscoreMenuItem = new JMenuItem("Clear highscores");
		removeHighscoreMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int input = JOptionPane.showConfirmDialog(null,
						"Are you sure to remove all highscore entries?",
						"Remove all highscores",
						JOptionPane.YES_NO_OPTION);

				if (input == 0) {
					controller.removeAllGrids();
				}
			}
		});
		
		setBasicColorsMenuItem = new JMenuItem("Set colors to basic");
		setBasicColorsMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				newGame();
				controller.setChosenColor(controller.getColor("basic"));
				controller.newMasterColors();
			}
		});
		
		setCountryColorsMenuItem = new JMenuItem("Set colors to country");
		setCountryColorsMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				newGame();
				controller.setChosenColor(controller.getColor("country"));
				controller.newMasterColors();
			}
		});
		
		
		optionsMenu.add(showSolutionMenuItem);
		optionsMenu.addSeparator();
		optionsMenu.add(setSize12MenuItem);
		optionsMenu.add(setSize8MenuItem);
		optionsMenu.add(setSize4MenuItem);
		optionsMenu.addSeparator();
		optionsMenu.add(highscoreMenuItem);
		optionsMenu.add(removeHighscoreMenuItem);
		optionsMenu.addSeparator();
		optionsMenu.add(setBasicColorsMenuItem);
		optionsMenu.add(setCountryColorsMenuItem);
		
		menuBar.add(fileMenu);
		menuBar.add(optionsMenu);
		
		mainPanel = new MainPanel();
		headPanel = new HeadPanel(controller);
		gameFieldPanel = new GameFieldPanel(controller);
		mainPanel.add(headPanel);
		mainPanel.add(gameFieldPanel);
		
		this.add(mainPanel);
		this.setJMenuBar(menuBar);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public final void constructMastermindPanel(IController controller) {
		
		if (headPanel != null){
			mainPanel.remove(headPanel);
		}
		headPanel = new HeadPanel(controller);
		
		
		if (gameFieldPanel != null){
			mainPanel.remove(gameFieldPanel);
		}
		gameFieldPanel = new GameFieldPanel(controller);
		gameFieldPanel.setStandard();
		int rowsAmount = controller.getRowsAmount();
		gameFieldPanel.setRowsAmount(rowsAmount - 1);
		gameFieldPanel.setYStart();
		this.setHeight(rowsAmount);
		headPanel.setStandard();
		mainPanel.add(headPanel);
		mainPanel.add(gameFieldPanel);
		setVisible(true);
		repaint();
	}
	
	
	private void newGame(){	
		controller.resetSize(controller.getRowsAmount(), controller.getRowsAmount());
		int rowsAmount = controller.getRowsAmount();
		int columnsAmount = controller.getColumnsAmount();
		controller.create(rowsAmount, columnsAmount);
		gameFieldPanel.setStandard();
		gameFieldPanel.setRowsAmount(rowsAmount - 1);
		gameFieldPanel.setYStart();
		headPanel.setStandard();
	}
	
	@Override
	public void update(Event e) {
		this.headPanel.setStatus();
		
		if(controller.getIsNewGame()) {
			headPanel.setStandard();
			gameFieldPanel.setStandard();
			controller.setIsNewGame(false);
		}
		
		if (e instanceof SizeChangedEvent) {
			constructMastermindPanel(controller);
		}
		this.repaint();
	}
	
	public void setHeight(int rowsAmount) {
		switch (rowsAmount) {
			case ROWS12:
				this.setSize(WIDTH12, HEIGHT12);
				break;
			case ROWS:
				this.setSize(DEFAULT_X, DEFAULT_Y);
				break;
			case ROWS4:
				this.setSize(WIDTH4, HEIGHT4);
				break;
		}
	}
}
