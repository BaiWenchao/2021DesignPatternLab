package ecs.ui;

import ecs.ElevatorController;
import ecs.listener.impl.ElevatorPanel;
import ecs.util.Config;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static ecs.util.States.ELEVATOR_IDLE;

public class PanelUI extends JFrame {
    private JPanel mainPanel;
    private JButton openButton;
    private JButton fourthFloorButton;
    private JButton firstFloorButton;
    private JButton secondFloorButton;
    private JButton thirdFloorButton;
    private JButton fifthFloorButton;
    private JButton sixthFloorButton;
    private JButton closeButton;
    private JLabel crtFloorLabel;
    private JLabel elevatorStateLabel;
    private JLabel doorStateLabel;
    private JLabel crtFloorValueLabel;
    private JLabel dstFloorValueLabel;
    private JLabel elevatorStateValueLabel;
    private JLabel doorStateValueLabel;
    private JLabel panelTitle;

    private ElevatorPanel elevatorPanel;
    private ElevatorController controller;

    public PanelUI(String title) {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // get the size of the screen
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;

        // set frame location to the center of the screen
        setSize(screenWidth/2, screenHeight/2);
        setLocation(screenWidth/4, screenHeight/4);

        // set the default value
        this.crtFloorValueLabel.setText("1");
        this.dstFloorValueLabel.setText("-1");
        this.doorStateValueLabel.setText(Config.DoorStatus.CLOSED.toString());
        this.elevatorStateValueLabel.setText("IDLE STATE");
        this.controller = new ElevatorController(ELEVATOR_IDLE);
        this.elevatorPanel = new ElevatorPanel(this.controller);

        // init
        controller.execute();

        this.setContentPane(mainPanel);

        firstFloorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                elevatorPanel.floorButtonPressed(1, mainPanel, crtFloorValueLabel, dstFloorValueLabel, elevatorStateValueLabel, doorStateValueLabel);
            }
        });
        secondFloorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                elevatorPanel.floorButtonPressed(2, mainPanel, crtFloorValueLabel, dstFloorValueLabel, elevatorStateValueLabel, doorStateValueLabel);
            }
        });
        thirdFloorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                elevatorPanel.floorButtonPressed(3, mainPanel, crtFloorValueLabel, dstFloorValueLabel, elevatorStateValueLabel, doorStateValueLabel);
            }
        });
        fourthFloorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                elevatorPanel.floorButtonPressed(4, mainPanel, crtFloorValueLabel, dstFloorValueLabel, elevatorStateValueLabel, doorStateValueLabel);
            }
        });
        fifthFloorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                elevatorPanel.floorButtonPressed(5, mainPanel, crtFloorValueLabel, dstFloorValueLabel, elevatorStateValueLabel, doorStateValueLabel);
            }
        });
        sixthFloorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                elevatorPanel.floorButtonPressed(6, mainPanel, crtFloorValueLabel, dstFloorValueLabel, elevatorStateValueLabel, doorStateValueLabel);
            }
        });
        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                elevatorPanel.openButtonPressed(mainPanel, crtFloorValueLabel, dstFloorValueLabel, elevatorStateValueLabel, doorStateValueLabel);
            }
        });

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                elevatorPanel.closedButtonPressed(mainPanel, crtFloorValueLabel, dstFloorValueLabel, elevatorStateValueLabel, doorStateValueLabel);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new PanelUI("Elevator Control System");
        frame.setVisible(true);
    }
}
