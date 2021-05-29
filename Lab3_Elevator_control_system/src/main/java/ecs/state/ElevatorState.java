package ecs.state;

import ecs.ElevatorController;

import javax.swing.*;

public abstract class ElevatorState {
    public abstract void Handle(ElevatorController controller);

    public abstract void Handle(ElevatorController controller, JLabel crtFloor, JLabel dstFloor, JLabel elevatorState, JLabel doorState);
}
