package ecs.listener.impl;

import ecs.ElevatorController;
import ecs.listener.ElevatorPanelListener;
import ecs.util.Config;

import javax.swing.*;

import static ecs.util.Config.FLOOR_HB;
import static ecs.util.Config.FLOOR_LB;

public class ElevatorPanel implements ElevatorPanelListener {
    ElevatorController controller;

    public ElevatorPanel(ElevatorController controller) {
        this.controller = controller;
    }

    @Override
    public void floorButtonPressed(int floor) {
        // check if is in brake state
        if (controller.getStateMsg().equals("BRAKE STATE")) {
            controller.setErrorMsg("INVALID OPERATION: ELEVATOR IS IN BRAKE STATE!");
        } else {
            // check whether input is legal
            if (floor < FLOOR_LB || floor > FLOOR_HB) {
                controller.setErrorMsg("INVALID FLOOR: PRESS FLOOR BETWEEN "+ FLOOR_LB + " AND " + FLOOR_HB + " !");
            } else if (floor == controller.getCrtFloor()) {
                controller.setErrorMsg("INVALID FLOOR: DO NOT PRESS CURRENT FLOOR!");
            } else {
                controller.setErrorMsg("NULL");
                controller.setDstFloor(floor);
                // mark the reached flag as false
                controller.setFloorReached(false);
            }
        }
        // make sure that the door is closed
        controller.setDoorStatus(Config.DoorStatus.CLOSED);
        controller.execute();
    }

    @Override
    public void openButtonPressed() {
        // check whether open-button can be pressed
        if (!controller.isFloorReached()) {
            controller.setErrorMsg("INVALID OPERATION: DOOR CANNOT BE OPENED UNTIL FLOOR REACHED!");
        } else {
            controller.setErrorMsg("NULL");
            controller.getDoorMotor().goOpen(controller);
        }
        controller.execute();
    }

    @Override
    public void closedButtonPressed() {
        // check whether close-button can be pressed
        if (!controller.isFloorReached()) {
            controller.setErrorMsg("INVALID OPERATION: DOOR CANNOT BE CLOSED UNTIL FLOOR REACHED!");
        } else {
            controller.setErrorMsg("NULL");
            controller.getDoorMotor().goClose(controller);
        }
        controller.execute();
    }

    public void floorButtonPressed(int floor, JPanel mainPanel, JLabel crtFloor, JLabel dstFloor, JLabel elevatorState, JLabel doorState) {
        // check if is in brake state
        if (controller.getStateMsg().equals("BRAKE STATE")) {
            controller.setErrorMsg("INVALID OPERATION: ELEVATOR IS IN BRAKE STATE!");
            JOptionPane.showMessageDialog(mainPanel, controller.getErrorMsg(), "Oops",JOptionPane.WARNING_MESSAGE);
        } else {
            // check whether input is legal
            if (floor < FLOOR_LB || floor > FLOOR_HB) {
                controller.setErrorMsg("INVALID FLOOR: PRESS FLOOR BETWEEN "+ FLOOR_LB + " AND " + FLOOR_HB + " !");
                JOptionPane.showMessageDialog(mainPanel, controller.getErrorMsg(), "Oops",JOptionPane.WARNING_MESSAGE);
            } else if (floor == controller.getCrtFloor()) {
                controller.setErrorMsg("INVALID FLOOR: DO NOT PRESS CURRENT FLOOR!");
                JOptionPane.showMessageDialog(mainPanel, controller.getErrorMsg(), "Oops",JOptionPane.WARNING_MESSAGE);
            } else {
                controller.setErrorMsg("NULL");
                controller.setDstFloor(floor);
                // mark the reached flag as false
                controller.setFloorReached(false);
            }
        }
        // make sure that the door is closed
        controller.setDoorStatus(Config.DoorStatus.CLOSED);
        controller.execute(crtFloor, dstFloor, elevatorState, doorState);
    }

    public void openButtonPressed(JPanel mainPanel, JLabel crtFloor, JLabel dstFloor, JLabel elevatorState, JLabel doorState) {
        // check whether open-button can be pressed
        if (!controller.isFloorReached()) {
            controller.setErrorMsg("INVALID OPERATION: DOOR CANNOT BE OPENED UNTIL FLOOR REACHED!");
            JOptionPane.showMessageDialog(mainPanel, controller.getErrorMsg(), "Oops",JOptionPane.WARNING_MESSAGE);
        } else {
            controller.setErrorMsg("NULL");
            controller.getDoorMotor().goOpen(controller);
        }
        controller.execute(crtFloor, dstFloor, elevatorState, doorState);
    }

    public void closedButtonPressed(JPanel mainPanel, JLabel crtFloor, JLabel dstFloor, JLabel elevatorState, JLabel doorState) {
        // check whether close-button can be pressed
        if (!controller.isFloorReached()) {
            controller.setErrorMsg("INVALID OPERATION: DOOR CANNOT BE CLOSED UNTIL FLOOR REACHED!");
            JOptionPane.showMessageDialog(mainPanel, controller.getErrorMsg(), "Oops",JOptionPane.WARNING_MESSAGE);
        } else {
            controller.setErrorMsg("NULL");
            controller.getDoorMotor().goClose(controller);
        }
        controller.execute(crtFloor, dstFloor, elevatorState, doorState);
    }



}
