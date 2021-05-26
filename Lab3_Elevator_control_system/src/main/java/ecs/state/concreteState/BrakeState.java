package ecs.state.concreteState;

import ecs.ElevatorController;
import ecs.state.ElevatorState;
import ecs.util.Config;

import static ecs.util.States.idleState;

public class BrakeState extends ElevatorState {
    @Override
    public void Handle(ElevatorController controller) {
        if (!controller.getDoorStatus().equals(Config.DoorStatus.BRAKE)) {
            controller.setStateMsg("IDLE STATE");
            controller.setState(idleState);
        }
    }
}
