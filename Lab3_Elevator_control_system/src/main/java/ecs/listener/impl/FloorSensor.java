package ecs.listener.impl;

import ecs.ElevatorController;
import ecs.listener.FloorSensorListener;

public class FloorSensor implements FloorSensorListener {
    ElevatorController controller;

    public FloorSensor(ElevatorController controller) {
        this.controller = controller;
    }

    @Override
    public void floorReached() {
        controller.setFloorReached(true);
    }
}
