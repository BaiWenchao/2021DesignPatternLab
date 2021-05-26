package ecs.state.concreteState;

import ecs.ElevatorController;
import ecs.state.ElevatorState;

import static ecs.util.States.*;

public class UpState extends ElevatorState {
    @Override
    public void Handle(ElevatorController controller) {
        if (controller.getCrtFloor() < controller.getDstFloor()) {
            controller.setStateMsg("UP STATE");
            controller.setState(upState);
            controller.getElevatorMotor().goUp(controller);
            controller.execute();
        } else {
            controller.getDoorMotor().goBrake(controller);
            controller.getElevatorMotor().goBrake(controller);
            controller.setStateMsg("BRAKE STATE");
            controller.setState(brakeState);
            controller.execute();
        }
    }
}
