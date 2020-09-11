package client;

import utils.Request;
import utils.Step;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Layouts {
    private final SocketClient2 socketClient2;
    private final LayoutNavigation layoutNavigation;

    public Layouts(SocketClient2 socketClient2, LayoutNavigation layoutNavigation) {
        this.socketClient2 = socketClient2;
        this.layoutNavigation = layoutNavigation;
    }

    public JPanel stepZeroLayout() {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BorderLayout());

        JButton connectBtn = new JButton("Connect");
        connectBtn.addActionListener(actionEvent -> {
            try {
                Step nextStep = socketClient2.connect();
                layoutNavigation.moveTo(nextStep);
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        });

        jPanel.add(connectBtn, BorderLayout.CENTER);

        return jPanel;
    }

    public JPanel stepOneLayout() {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));
        jPanel.setBorder(
                BorderFactory.createEmptyBorder(20, 20, 20, 20));


        JLabel toyCodeInputLabel = new JLabel("Insert Toy Code");
        toyCodeInputLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextField toyCodeTxt = new JTextField();
        toyCodeTxt.setAlignmentX(Component.CENTER_ALIGNMENT);
        toyCodeTxt.setPreferredSize(new Dimension(400, 20));


        JLabel toyNameInputLabel = new JLabel("Insert Toy Name");
        toyNameInputLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextField toyNameTxt = new JTextField();
        toyNameTxt.setAlignmentX(Component.CENTER_ALIGNMENT);
        toyNameTxt.setPreferredSize(new Dimension(400, 20));


        JButton submitBtn = new JButton("Submit");
        submitBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        submitBtn.addActionListener(actionEvent -> {
            String input = toyCodeTxt.getText() + "," + toyNameTxt.getText();
            try {
                Step nextStep = socketClient2.makeRequest(new Request(input));
                System.out.println("NextStep: " + nextStep.name());
                layoutNavigation.moveTo(nextStep);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        jPanel.add(toyCodeInputLabel);
        jPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        jPanel.add(toyCodeTxt);
        jPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        jPanel.add(toyNameInputLabel);
        jPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        jPanel.add(toyNameTxt);
        jPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        jPanel.add(submitBtn);

        return jPanel;
    }

    public JPanel stepTwoLayout() {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));
        jPanel.setBorder(
                BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel inputLabel = new JLabel("Insert commar separated values for the toy's description, price, date of manufacture and batch number");
        inputLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextField inputField = new JTextField();
        inputField.setAlignmentX(Component.CENTER_ALIGNMENT);
        inputField.setPreferredSize(new Dimension(400, 20));

        JButton submitBtn = new JButton("Submit");
        submitBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        submitBtn.addActionListener(actionEvent -> {
            String input = inputField.getText();
            try {
                Step nextStep = socketClient2.makeRequest(new Request(input));
                layoutNavigation.moveTo(nextStep);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        jPanel.add(inputLabel);
        jPanel.add(Box.createRigidArea(new Dimension(0, 30)));
        jPanel.add(inputField);
        jPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        jPanel.add(submitBtn);

        return jPanel;
    }
}
