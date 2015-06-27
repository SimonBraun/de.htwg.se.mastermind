package de.htwg.se.mastermind.view.gui;

import de.htwg.se.mastermind.controller.IController;

import javax.swing.*;
import java.awt.*;

public class HighscoreDialog extends JDialog {
    private String [] columnNames = {"Position", "Name", "Tries", "Date"};
    private static final int TEN = 10;
    private static final int THREE = 3;
    private static final int TWO_H_TWENTY = 220;
    private static final int FIVE_H = 500;


    public HighscoreDialog(IController ctrl, MastermindFrame frame) {
        IController controller = ctrl;
        MastermindFrame mastermindFrame = frame;
        String [][] dataRow = controller.getAllGrids();
        Object [][] data = new Object[dataRow.length][columnNames.length];

        for (int i = 0; i < dataRow.length; i++) {
            data[i][0] = i + 1;
            data[i][1] = dataRow[i][0] != null && !dataRow[i][0].equals("")? dataRow[i][0] : "(No username)";
            data[i][2] = dataRow[i][1];
            data[i][THREE] = dataRow[i][2] != null? dataRow[i][2] : "(No date)";
        }

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(TEN, TEN, TEN, TEN));
        mainPanel.setPreferredSize(new Dimension(FIVE_H, TWO_H_TWENTY));

        JLabel label = new JLabel("Top ten highsores");

        JTable table = new JTable(data, columnNames);

        JScrollPane pane = new JScrollPane(table);
        table.setFillsViewportHeight(true);

        mainPanel.add(label);
        mainPanel.add(pane);
        this.setLocationRelativeTo(mastermindFrame);
        this.setContentPane(mainPanel);
        this.setResizable(false);
        this.setTitle("Highscores");
        this.pack();
        this.setVisible(true);
    }

}
