package de.htwg.se.mastermind.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import de.htwg.se.mastermind.controller.IController;

public class GameFieldPanel extends JPanel {
	
	private final class MouseClick extends MouseAdapter {
		
		@Override
		public void mouseClicked(MouseEvent m) {
			setColor(m.getX(), m.getY());
		}
	}
	
	private static final long serialVersionUID = 1L;
	private IController controller;
	private int rows;
	private int columns;
	private MouseClick mouseClick;
	private int xStart = 230;
	private int yStart = 265;
	private int yStartNeu = yStart;
	private Color [][] colors;
	private Color [][] sticks;
	private Color actualColor;
	private String actualStringColor;
	private JButton buttonConfirmRow;
	
	public GameFieldPanel(final IController controller) {
		this.controller = controller;
		this.rows = this.controller.getRowsAmount() - 1;
		this.columns = this.controller.getColumnsAmount()/2;
		this.colors = new Color[rows][columns];
		this.sticks = new Color[rows][columns];
		this.setSize(200, 400);
		this.setLayout(null);
		this.setBorder(BorderFactory.createTitledBorder("GameField"));
		this.mouseClick = new MouseClick();
		this.addMouseListener(mouseClick);
		this.addMouseMotionListener(mouseClick);
		this.actualColor = Color.gray;
		this.actualStringColor = null;
		this.buttonConfirmRow = new JButton("Confirm Row");
		this.buttonConfirmRow.setBounds(20, 260, 110, 30);
		this.buttonConfirmRow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	int actualRow = controller.getActualRow();
            	String [] stickValues = new String[columns];
            	int index = 0;
                if (controller.confirmRow()) {
                	for (int i = columns*2 - 1; i >= columns; i--) {
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
                	
                	yStartNeu -= 40;
                	int newButtonY = buttonConfirmRow.getY();
                	newButtonY -= 40;
                	buttonConfirmRow.setBounds(20, newButtonY, 110, 30);
                }
            }
        });
		
		this.initializeArrays();
		this.add(buttonConfirmRow);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		int x = 180, y = 280;
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				g.setColor(this.sticks[i][j]);
				g.fillOval(x, y, 10, 10);
				
				if (j == columns/2 - 1) {
					x = 180;
					y -= 20;
				} else {
					x -= 20;
				}
			}
			 x = 180;
			 y -= 20;
		}
		
		x = xStart;
		y = yStart;
		
		for (int i = 0; i < rows ; i++) {
			for (int j = columns - 1; j >= 0; j--) {
				g.setColor(this.colors[i][j]);
				g.fillOval(x, y, 20, 20);
				x += 30;
			}
			x = xStart;
			y -= 40;
		}
	}
	
	public void setColor(int x, int y) {
		int actualRow = this.controller.getActualRow();
		if (x >= xStart && x <= xStart + 20 && y >= yStartNeu && y <= yStartNeu + 20) {
			this.actualColor = getNextColor();
			this.colors[actualRow][columns-1] = actualColor;
			this.controller.setValue(actualRow, columns-1, this.actualStringColor);
		} else if (x >= xStart + 30 && x <= xStart + 50 && y >= yStartNeu && y <= yStartNeu + 20) {
			this.actualColor = getNextColor();
			this.colors[actualRow][columns-2] = actualColor;
			this.controller.setValue(actualRow, columns-2, this.actualStringColor);
		} else if (x >= xStart + 60 && x <= xStart + 80 && y >= yStartNeu && y <= yStartNeu + 20) {
			this.actualColor = getNextColor();
			this.colors[actualRow][columns-3] = actualColor;
			this.controller.setValue(actualRow, columns-3, this.actualStringColor);
		} else if (x >= xStart + 90 && x <= xStart + 110 && y >= yStartNeu && y <= yStartNeu + 20) {
			this.actualColor = getNextColor();
			this.colors[actualRow][columns-4] = actualColor;
			this.controller.setValue(actualRow, columns-4, this.actualStringColor);
		}
		
		//repaint();
	}
	
	public Color getNextColor() {
		
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
	}
	
	public Color getStickColor(String stickColor) {
		if (stickColor.equals("bk")) {
			return Color.black;
		} else {
			return Color.white;
		}
	}
	
	public void setStandard() {
		this.buttonConfirmRow.setBounds(20, 260, 110, 30);
		this.yStartNeu = 265;
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
}
