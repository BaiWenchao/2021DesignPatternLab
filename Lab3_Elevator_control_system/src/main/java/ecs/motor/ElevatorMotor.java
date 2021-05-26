package ecs.motor;

import ecs.ElevatorController;

public class ElevatorMotor {
    public void goUp(ElevatorController controller) {
        controller.setCrtFloor(controller.getCrtFloor()+1);
    }
    public void goDown(ElevatorController controller) {
        controller.setCrtFloor(controller.getCrtFloor()-1);
    }
    public void goBrake(ElevatorController controller) {
        controller.getDoorSensor().doorBlocked();
    }
}
