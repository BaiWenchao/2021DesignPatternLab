package ecs.state.concreteState;

import ecs.ElevatorController;
import ecs.state.ElevatorState;

import static ecs.util.Config.INIT_DST;
import static ecs.util.States.*;

public class IdleState extends ElevatorState {
    @Override
    public void Handle(ElevatorController controller) {
        if (controller.getCrtFloor() < controller.getDstFloor() && controller.getDstFloor() != INIT_DST) {
            controller.setStateMsg("UP STATE:");
            controller.setState(upState);
            controller.execute();
        } else if (controller.getCrtFloor() > controller.getDstFloor() && controller.getDstFloor() != INIT_DST) {
            controller.setStateMsg("DOWN STATE");
            controller.setState(downState);
            controller.execute();
        } else {
            controller.setStateMsg("IDLE STATE");
            controller.setState(idleState);
            controller.setFloorReached(true);
        }
    }
}
