package ecs.state.concreteState;

import ecs.ElevatorController;
import ecs.state.ElevatorState;
import ecs.util.Tools;

import javax.swing.*;

import static ecs.util.Config.wait_sec;
import static ecs.util.States.*;

public class UpState extends ElevatorState {
    @Override
    public void Handle(ElevatorController controller) {
        if (controller.getCrtFloor() < controller.getDstFloor()) {
            controller.setStateMsg("UP STATE");
            controller.setState(ELEVATOR_UP);
            controller.getElevatorMotor().goUp(controller);
            controller.execute();
        } else {
            controller.getDoorMotor().goBrake(controller);
            controller.setStateMsg("BRAKE STATE");
            controller.setState(ELEVATOR_BRAKE);
            controller.execute();
        }
    }

    public void Handle(ElevatorController controller, JLabel crtFloor, JLabel dstFloor, JLabel elevatorState, JLabel doorState) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                if (controller.getCrtFloor() < controller.getDstFloor()) {
                    controller.setStateMsg("UP STATE");
                    controller.setState(ELEVATOR_UP);
                    controller.getElevatorMotor().goUp(controller);

                    Tools.setValue(controller, crtFloor, dstFloor, elevatorState, doorState);
                    Tools.sleep(wait_sec);

                    controller.execute(crtFloor, dstFloor, elevatorState, doorState);
                } else {
                    controller.getDoorMotor().goBrake(controller);
                    controller.setStateMsg("BRAKE STATE");
                    controller.setState(ELEVATOR_BRAKE);

                    Tools.setValue(controller, crtFloor, dstFloor, elevatorState, doorState);
                    Tools.sleep(wait_sec);

                    controller.execute(crtFloor, dstFloor, elevatorState, doorState);
                }
            }
        }).start();
    }
}
