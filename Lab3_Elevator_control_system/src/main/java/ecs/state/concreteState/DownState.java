package ecs.state.concreteState;

import ecs.ElevatorController;
import ecs.state.ElevatorState;

import static ecs.util.States.*;

public class DownState extends ElevatorState {
    @Override
    public void Handle(ElevatorController controller) {
        if (controller.getCrtFloor() > controller.getDstFloor()) {
            controller.setStateMsg("DOWN STATE");
            controller.setState(downState);
            controller.getElevatorMotor().goDown(controller);
            controller.execute();
        } else {
            controller.getDoorMotor().goBrake(controller);
            controller.setStateMsg("BRAKE STATE");
            controller.setState(brakeState);
            controller.execute();
        }
    }
}
