package ecs.motor;

import ecs.ElevatorController;
import jdk.jshell.spi.ExecutionControl;

public class ElevatorMotor {
    public void goUp(ElevatorController controller) {
        controller.setCrtFloor(controller.getCrtFloor()+1);
    }
    public void goDown(ElevatorController controller) {
        controller.setCrtFloor(controller.getCrtFloor()-1);
    }
    public void goBrake(ElevatorController controller) throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("elevator braking has not been implemented!");
    }
}
