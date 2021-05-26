package ecs.util;

import ecs.state.concreteState.BrakeState;
import ecs.state.concreteState.DownState;
import ecs.state.concreteState.IdleState;
import ecs.state.concreteState.UpState;

public class States {
    public static DownState downState = new DownState();
    public static IdleState idleState = new IdleState();
    public static UpState upState = new UpState();
    public static BrakeState brakeState = new BrakeState();
}
