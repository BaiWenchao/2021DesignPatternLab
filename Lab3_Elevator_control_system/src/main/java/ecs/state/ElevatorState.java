package ecs.state;

import ecs.ElevatorController;

public abstract class ElevatorState {
    public abstract void Handle(ElevatorController controller);
}
