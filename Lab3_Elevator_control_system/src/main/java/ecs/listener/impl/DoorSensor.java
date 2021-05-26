package ecs.listener.impl;

import ecs.ElevatorController;
import ecs.listener.DoorSensorListener;
import ecs.util.Config;

public class DoorSensor implements DoorSensorListener {
    ElevatorController controller;

    public DoorSensor(ElevatorController controller) {
        this.controller = controller;
    }

    @Override
    public void doorOpen() {
        controller.setDoorStatus(Config.DoorStatus.OPEN);
    }

    @Override
    public void doorClosed() {
        controller.setDoorStatus(Config.DoorStatus.CLOSED);
    }

    @Override
    public void doorBlocked() {
        controller.setDoorStatus(Config.DoorStatus.BRAKE);
    }
}
