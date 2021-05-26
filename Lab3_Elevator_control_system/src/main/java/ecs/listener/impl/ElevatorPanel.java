package ecs.listener.impl;

import ecs.ElevatorController;
import ecs.listener.ElevatorPanelListener;
import ecs.util.Config;

import static ecs.util.Config.FLOOR_HB;
import static ecs.util.Config.FLOOR_LB;

public class ElevatorPanel implements ElevatorPanelListener {
    ElevatorController controller;

    public ElevatorPanel(ElevatorController controller) {
        this.controller = controller;
    }

    @Override
    public void floorButtonPressed(int floor) {
        // check whether input is legal
        if (floor < FLOOR_LB || floor > FLOOR_HB) {
            controller.setErrorMsg("INVALID FLOOR: PRESS FLOOR BETWEEN "+ FLOOR_LB + " AND " + FLOOR_HB + " !");
        } else if (floor == controller.getCrtFloor()) {
            controller.setErrorMsg("INVALID FLOOR: DO NOT PRESS CURRENT FLOOR!");
        } else {
            controller.setErrorMsg("NULL");
            controller.setDstFloor(floor);
        }
        // make sure that the door is closed
        controller.setDoorStatus(Config.DoorStatus.CLOSED);
    }

    @Override
    public void openButtonPressed() {
        // check whether open-button can be pressed
        if (!controller.isFloorReached()) {
            controller.setErrorMsg("DOOR CANNOT BE OPENED UNTIL FLOOR REACHED!");
        } else {
            controller.setErrorMsg("NULL");
            controller.getDoorMotor().goOpen(controller);
        }
    }

    @Override
    public void closedButtonPressed() {
        // check whether close-button can be pressed
        if (!controller.isFloorReached()) {
            controller.setErrorMsg("DOOR CANNOT BE CLOSED UNTIL FLOOR REACHED!");
        } else {
            controller.setErrorMsg("NULL");
            controller.getDoorMotor().goClose(controller);
        }
    }
}
