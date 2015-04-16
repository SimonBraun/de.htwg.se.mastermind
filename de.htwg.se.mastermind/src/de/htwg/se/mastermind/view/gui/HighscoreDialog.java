package de.htwg.se.mastermind.view.gui;

import de.htwg.se.mastermind.controller.IController;

import javax.swing.*;
import java.awt.*;

public class HighscoreDialog extends JDialog {
    private JPanel mainPanel;
    private MastermindFrame mastermindFrame;
    private IController controller;
    private String [][] dataRow;
    private String [] columnNames = {"Position", "Name", "Tries", "Date"};
    private Object [][] data;

    public HighscoreDialog(IController controller, MastermindFrame frame) {
        this.controller = controller;
        this.mastermindFrame = frame;
        this.dataRow = controller.getAllGrids();
        this.data = new Object[dataRow.length][columnNames.length];

        for (int i = 0; i < dataRow.length; i++) {
            data[i][0] = i + 1;
            data[i][1] = this.dataRow[i][0] != null? this.dataRow[i][0] : "(No username)";
            data[i][2] = this.dataRow[i][1];
            data[i][3] = this.dataRow[i][2] != null? this.dataRow[i][2] : "(No date)";
        }

        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.setPreferredSize(new Dimension(500, 220));

        JLabel label = new JLabel("Top ten highsores");

        JTable table = new JTable(data, columnNames);

        JScrollPane pane = new JScrollPane(table);
        table.setFillsViewportHeight(true);

        mainPanel.add(label);
        mainPanel.add(pane);
        this.setLocationRelativeTo(this.mastermindFrame);
        this.setContentPane(mainPanel);
        this.setResizable(false);
        this.setTitle("Highscores");
        this.pack();
        this.setVisible(true);
    }

}
