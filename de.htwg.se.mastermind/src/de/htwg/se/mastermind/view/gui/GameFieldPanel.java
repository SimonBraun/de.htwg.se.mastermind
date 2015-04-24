package de.htwg.se.mastermind.view.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import de.htwg.se.mastermind.controller.IController;

public class GameFieldPanel extends JPanel {
	
	private final class MouseClick extends MouseAdapter {
		
		@Override
		public void mouseClicked(MouseEvent m) {
			if (!controller.isSolved() && controller.getActualRow() != controller.getRowsAmount() - 1) {
				setColor(m.getX(), m.getY());
			}
		}
	}
	
	private static final long serialVersionUID = 1L;
	private IController controller;
	private int rows;
	private int columns;
	private Color [][] colors;
	private String [][] colorsString;
	private Color [][] sticks;
	private Color actualColor;
	private String actualStringColor;
	private JButton buttonConfirmRow;
	private static final int WIDTH = 200;
	private static final int HEIGHT = 400;
	private static final int XSTART = 255;
	private static final int YSTART = 265;
	private static final int XSTARTSTICK = 205;
	private static final int XBUTTON = 20;
	private static final int YBUTTONDIFF = 5;
	private static final int WIDTHBUTTON = 110;
	private static final int HEIGHTBUTTON = 30;
	private static final int STICKSIZE = 10;
	private static final int BALLSIZE = 20;
	private static final int THIRTY = 30;
	private static final int THREE = 3;
	private static final int FOUR = 4;
	private static final int FIVE = 5;
	private static final int SIX = 6;
	private static final int ROWS11 = 11;
	private static final int ROWS7 = 7;
	private static final int ROWS3 = 3;
	private static final int YROWS11 = 425;
	private static final int YROWS3 = 105;
	private int yStartNeu = YSTART;
	
	private static final String PATH = "src/resource/";
	private static final String FILEEX = ".png";	
	private Image defaultImage = Toolkit.getDefaultToolkit().getImage(createImagePath("gy"));	
	private Image image;
	
	
	public GameFieldPanel(final IController controller) {
		this.controller = controller;
		this.rows = this.controller.getRowsAmount() - 1;
		this.columns = this.controller.getColumnsAmount()/2;
		this.colors = new Color[rows][columns];
		this.colorsString = new String[rows][columns];
		this.sticks = new Color[rows][columns];
		this.setSize(WIDTH, HEIGHT);
		this.setLayout(null);
		this.setBorder(BorderFactory.createTitledBorder("GameField"));
		MouseClick mouseClick = new MouseClick();
		this.addMouseListener(mouseClick);
		this.addMouseMotionListener(mouseClick);
		this.actualColor = Color.gray;
		this.initializeArrays();
		this.buttonConfirmRow = new JButton("Confirm Row");
		this.buttonConfirmRow.setBounds(XBUTTON, yStartNeu - YBUTTONDIFF, WIDTHBUTTON, HEIGHTBUTTON);
		this.buttonConfirmRow.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int actualRow = controller.getActualRow();
				String[] stickValues = new String[columns];
				int index = 0;
				if (controller.confirmRow()) {
					for (int i = columns * 2 - 1; i >= columns; i--) {
						stickValues[index] = controller.getValue(actualRow, i);
						if (stickValues[index] != null) {
							if (sticks[actualRow][index].equals(Color.gray)) {
								sticks[actualRow][index] = getStickColor(stickValues[index]);
								index++;
							}
						} else {
							break;
						}
					}
					controller.setRowConfirmed(true);

					String idToDelete = null;
					if (controller.isSolved() && ((idToDelete = controller.isInHighScore())) != null) {
						String nameInput = JOptionPane.showInputDialog(null,"You are in the highscore list. Please enter your name:",
								"New highscore!",
								JOptionPane.PLAIN_MESSAGE);

						if (nameInput != null) {
							controller.removeGridById(idToDelete);
							DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
							Date date = new Date();
							controller.setUsername(nameInput);
							controller.setDate(dateFormat.format(date));
							controller.setId(UUID.randomUUID().toString());
							controller.saveToDB();
						}
					}
				}
			}
		});
		this.add(buttonConfirmRow);
	}
	
    public void setImage(Image image) {
	      this.image = image;
	      repaint();
	   }
		 
	 private String createImagePath(String color){
		   return PATH + color + FILEEX;
	 }
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		this.setColorsAndSticks();
		this.setNewButtonLocation();
		
		int x = XSTARTSTICK;
		int y = getPaintY() + STICKSIZE + YBUTTONDIFF;
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				g.setColor(this.sticks[i][j]);
				g.fillOval(x, y, STICKSIZE, STICKSIZE);
				
				if (j == columns/2 - 1) {
					x = XSTARTSTICK;
					y -= BALLSIZE;
				} else {
					x -= BALLSIZE;
				}
			}
			 x = XSTARTSTICK;
			 y -= BALLSIZE;
		}
		
		x = XSTART;
		y = getPaintY();
		
		for (int i = 0; i < rows ; i++) {
			for (int j = columns - 1; j >= 0; j--) {
				if(this.colorsString[i][j] == null || this.colorsString[i][j] == "gy"){
					image = defaultImage;
				}
				else{
					image = Toolkit.getDefaultToolkit().getImage(createImagePath(this.colorsString[i][j]));
				}
				g.drawImage(image,  x, y, this);
				x += BALLSIZE + STICKSIZE;
			}
			x = XSTART;
			y -= BALLSIZE * 2;

		}
	}
	
	public void setColor(int x, int y) {
		int column = 0;
		if (x >= XSTART && x <= XSTART + BALLSIZE && y >= yStartNeu && y <= yStartNeu + BALLSIZE) {
			this.setColor(column + 1);
		} else if (x >= XSTART + THIRTY && x <= XSTART + BALLSIZE + THIRTY && y >= yStartNeu && y <= yStartNeu + BALLSIZE) {
			this.setColor(column + 2);
		} else if (x >= XSTART + THIRTY*2 && x <= XSTART + BALLSIZE + THIRTY*2 && y >= yStartNeu && y <= yStartNeu + BALLSIZE) {
			this.setColor(column + THREE);
		} else if (x >= XSTART + THIRTY * THREE && x <= XSTART + BALLSIZE + THIRTY*THREE && y >= yStartNeu && y <= yStartNeu + BALLSIZE) {
			this.setColor(column + FOUR);
		} else if (x >= XSTART + THIRTY * FOUR && x <= XSTART + BALLSIZE + THIRTY*FOUR && y >= yStartNeu && y <= yStartNeu + BALLSIZE) {
			this.setColor(column + FIVE);
		} else if (x >= XSTART + THIRTY * FIVE && x <= XSTART + BALLSIZE + THIRTY*FIVE && y >= yStartNeu && y <= yStartNeu + BALLSIZE) {
			this.setColor(column + SIX);
		}
	}
	
	private void setColor(int column) {
		if (column <= this.columns) {
			int actualRow = this.controller.getActualRow();
			this.actualColor = getNextColor();
			this.colors[actualRow][columns-column] = actualColor;
			this.controller.setValue(actualRow, columns-column, this.actualStringColor);
			this.colorsString[actualRow][columns-column] = this.actualStringColor;
		}
	}
	
	
	public Color getNextColor() {
		
		if (this.actualStringColor == null) {
			this.actualStringColor = this.controller.getAvailableColors()[0];
			return Color.red;
		}
		
		if (this.actualStringColor == this.controller.getAvailableColors()[0]) {
			this.actualStringColor = this.controller.getAvailableColors()[1];
			return Color.blue;
		}
		
		if (this.actualStringColor == this.controller.getAvailableColors()[1]) {
			this.actualStringColor = this.controller.getAvailableColors()[2];
			return Color.green;
		}
		
		if (this.actualStringColor == this.controller.getAvailableColors()[2]) {
			this.actualStringColor = this.controller.getAvailableColors()[3];
			return Color.yellow;
		}
		
		if (this.actualStringColor == this.controller.getAvailableColors()[3]) {
			this.actualStringColor = this.controller.getAvailableColors()[4];
			return Color.orange;
		}
		
		if (this.actualStringColor == this.controller.getAvailableColors()[4]) {
			this.actualStringColor = this.controller.getAvailableColors()[5];
			return Color.magenta;
		}
		
		if (this.actualStringColor == this.controller.getAvailableColors()[5]) {
			this.actualStringColor = this.controller.getAvailableColors()[6];
			return Color.pink;
		}
		
		if (this.actualStringColor == this.controller.getAvailableColors()[6]) {
			this.actualStringColor = this.controller.getAvailableColors()[0];
			return Color.red;
		}
		else{
			this.actualStringColor = this.controller.getAvailableColors()[0];
		}
		
		return null;
	}
	
/*	public Color getNextColor() {
		
		if (this.actualColor == Color.gray) {
			this.actualStringColor = "yl";
			return Color.yellow;
		}
		
		if (this.actualColor == Color.yellow) {
			this.actualStringColor = "bl";
			return Color.blue;
		}
		
		if (this.actualColor == Color.blue) {
			this.actualStringColor = "gr";
			return Color.green;
		}
		
		if (this.actualColor == Color.green) {
			this.actualStringColor = "rd";
			return Color.red;
		}
		
		if (this.actualColor == Color.red) {
			this.actualStringColor = "or";
			return Color.orange;
		}
		
		if (this.actualColor == Color.orange) {
			this.actualStringColor = "pk";
			return Color.pink;
		}
		
		if (this.actualColor == Color.pink) {
			this.actualStringColor = "pu";
			return Color.magenta;
		}
		
		if (this.actualColor == Color.magenta) {
			this.actualStringColor = "yl";
			return Color.yellow;
		}
		
		return null;
	}*/
	
	public Color getStickColor(String stickColor) {

		if (stickColor == null) {
			return Color.gray;
		}
		
		if (stickColor.equals("bk")) {
			return Color.black;
		} else {
			return Color.white;
		}
	}
	
	public void setStandard() {
		this.yStartNeu = getPaintY();
		this.buttonConfirmRow.setEnabled(true);
		this.initializeArrays();
	}
	
	private void initializeArrays() {
		for (int i = rows - 1; i >= 0; i--) {
			for (int j = columns - 1; j >= 0; j--) {
				this.colors[i][j] = Color.gray;
			}
		}
		
		for (int i = rows - 1; i >= 0 ; i--) {
			for (int j = columns - 1; j >= 0; j--) {
				this.sticks[i][j] = Color.gray;
			}
		}
	}
	
	public int getPaintY() {
		
		switch (this.rows) {
			case ROWS11:
				return YROWS11;
			case ROWS7:
				return YSTART;
			case ROWS3:
				return YROWS3;
			default:
				return -1;
		}
	}
	
	public void setRowsAmount(int rows) {
		this.rows = rows;
	}
	
	public void setYStart() {
		this.yStartNeu = this.getPaintY();
		this.buttonConfirmRow.setBounds(XBUTTON, yStartNeu - YBUTTONDIFF, WIDTHBUTTON, HEIGHTBUTTON);
	}
	
	private void setColorsAndSticks() {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				this.colors[i][j] = controller.getColorFromString(controller.getValue(i, j));
			}
		}
	
		for (int i = 0; i < rows; i++) {
			int columnsAmount = controller.getColumnsAmount();
			for (int j = 0; j < columns; j++) {
				this.sticks[i][j] = getStickColor(controller.getValue(i, columnsAmount - 1));
				columnsAmount--;
			}
		}
	}
	
	private void setNewButtonLocation() {
		boolean rowConfirmed = controller.getRowConfirmed();
		if (rowConfirmed) {
			if (!controller.isSolved() && controller.getActualRow() != controller.getRowsAmount() - 1) {
		    	yStartNeu -= HEIGHTBUTTON + STICKSIZE;
		    	int newButtonY = buttonConfirmRow.getY();
		    	newButtonY -= HEIGHTBUTTON + STICKSIZE;
		    	buttonConfirmRow.setBounds(XBUTTON, newButtonY, WIDTHBUTTON, HEIGHTBUTTON);
			} else {
				buttonConfirmRow.setEnabled(false);
			}
			controller.setRowConfirmed(false);
		}
	}
}
