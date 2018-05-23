package alifanov.m;

import alifanov.m.model.Client;
import alifanov.m.services.PrintService;

import javax.swing.*;
import java.awt.*;

class Main {

    public static void addComponentsToPane(Container pane) {
        PrintService printService = new PrintService();
        pane.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 1;
        constraints.gridx = 0;
        constraints.gridy = 0;
        JButton addClientButton = new JButton("Add Client");
        addClientButton.setPreferredSize(new Dimension(75, 20));
        pane.add(addClientButton, constraints);
        addClientButton.addActionListener(e -> {
            Client client = new Client();
            printService.executeOrder(client.getOrder());
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Printing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setResizable(true);
        addComponentsToPane(frame.getContentPane());
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}