package ecs.state.concreteState;

import ecs.ElevatorController;
import ecs.state.ElevatorState;

import static ecs.util.States.idleState;

public class BrakeState extends ElevatorState {
    @Override
    public void Handle(ElevatorController controller) {
        controller.setStateMsg("IDLE STATE");
        controller.setState(idleState);
        controller.getDoorMotor().goOpen(controller);
        controller.execute();
    }
}
