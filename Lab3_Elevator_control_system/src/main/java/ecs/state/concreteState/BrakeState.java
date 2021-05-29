package ecs.state.concreteState;

import ecs.ElevatorController;
import ecs.state.ElevatorState;
import ecs.util.Tools;

import javax.swing.*;

import static ecs.util.Config.wait_sec;
import static ecs.util.States.ELEVATOR_IDLE;

public class BrakeState extends ElevatorState {
    @Override
    public void Handle(ElevatorController controller) {
        controller.setStateMsg("IDLE STATE");
        controller.setState(ELEVATOR_IDLE);
        controller.getDoorMotor().goOpen(controller);
        controller.execute();
    }

    public void Handle(ElevatorController controller, JLabel crtFloor, JLabel dstFloor, JLabel elevatorState, JLabel doorState) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                controller.setStateMsg("IDLE STATE");
                controller.setState(ELEVATOR_IDLE);
                controller.getDoorMotor().goOpen(controller);

                Tools.setValue(controller, crtFloor, dstFloor, elevatorState, doorState);
                Tools.sleep(wait_sec);

                controller.execute(crtFloor, dstFloor, elevatorState, doorState);
            }
        }).start();
    }
}
