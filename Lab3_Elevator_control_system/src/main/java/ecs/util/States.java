package ecs.util;

import ecs.state.concreteState.BrakeState;
import ecs.state.concreteState.DownState;
import ecs.state.concreteState.IdleState;
import ecs.state.concreteState.UpState;

public class States {
    public static DownState ELEVATOR_DOWN = new DownState();
    public static IdleState ELEVATOR_IDLE = new IdleState();
    public static UpState ELEVATOR_UP = new UpState();
    public static BrakeState ELEVATOR_BRAKE = new BrakeState();
}
