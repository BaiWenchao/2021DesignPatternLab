package ecs.motor;

import ecs.ElevatorController;
import ecs.util.Config;

public class DoorMotor {
    public void goOpen(ElevatorController controller) {
        controller.setDoorStatus(Config.DoorStatus.OPEN);
    }

    public void goClose(ElevatorController controller) {
        controller.setDoorStatus(Config.DoorStatus.CLOSED);
    }

    public void goBrake(ElevatorController controller) {
        controller.setDoorStatus(Config.DoorStatus.BRAKE);
    }
}
