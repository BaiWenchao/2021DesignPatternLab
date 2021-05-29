package ecs.state.concreteState;

import ecs.ElevatorController;
import ecs.state.ElevatorState;
import ecs.util.Config;
import ecs.util.Tools;

import javax.swing.*;

import static ecs.util.Config.INIT_DST;
import static ecs.util.Config.wait_sec;
import static ecs.util.States.*;

public class IdleState extends ElevatorState {
    @Override
    public void Handle(ElevatorController controller) {
        if (controller.getCrtFloor() < controller.getDstFloor() && controller.getDstFloor() != INIT_DST) {
            controller.setStateMsg("UP STATE:");
            controller.setState(ELEVATOR_UP);
            controller.execute();
        } else if (controller.getCrtFloor() > controller.getDstFloor() && controller.getDstFloor() != INIT_DST) {
            controller.setStateMsg("DOWN STATE");
            controller.setState(ELEVATOR_DOWN);
            controller.execute();
        } else {
            controller.setStateMsg("IDLE STATE");
            controller.setState(ELEVATOR_IDLE);
            controller.setFloorReached(true);
        }
    }

    public void Handle(ElevatorController controller, JLabel crtFloor, JLabel dstFloor, JLabel elevatorState, JLabel doorState) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                if (controller.getCrtFloor() < controller.getDstFloor() && controller.getDstFloor() != INIT_DST) {
                    controller.setStateMsg("UP STATE:");
                    controller.setState(ELEVATOR_UP);

                    Tools.setValue(controller, crtFloor, dstFloor, elevatorState, doorState);
                    Tools.sleep(wait_sec);

                    controller.execute(crtFloor, dstFloor, elevatorState, doorState);
                } else if (controller.getCrtFloor() > controller.getDstFloor() && controller.getDstFloor() != INIT_DST) {
                    controller.setStateMsg("DOWN STATE");
                    controller.setState(ELEVATOR_DOWN);

                    Tools.setValue(controller, crtFloor, dstFloor, elevatorState, doorState);
                    Tools.sleep(wait_sec);

                    controller.execute(crtFloor, dstFloor, elevatorState, doorState);
                } else {
                    controller.setStateMsg("IDLE STATE");
                    controller.setState(ELEVATOR_IDLE);
                    controller.setFloorReached(true);

                    Tools.setValue(controller, crtFloor, dstFloor, elevatorState, doorState);
                }
            }
        }).start();
    }
}
