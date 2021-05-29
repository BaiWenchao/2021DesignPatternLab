package ecs;

import ecs.util.Config;
import junit.framework.TestCase;

import static ecs.util.States.ELEVATOR_IDLE;

/**
 * Note that:
 * since testing cannot be easily performed
 * in a single thread, the more test case can
 * be performed using gui (print the log info
 * is a solution, but it's not user friendly)
 * */

public class TestElevatorState extends TestCase {
    public void testInitialState() {
        ElevatorController controller = new ElevatorController(ELEVATOR_IDLE);
        controller.execute();

        assertEquals(controller.getStateMsg(), "IDLE STATE");
        assertEquals(controller.getErrorMsg(), "NULL");
        assertEquals(controller.getDoorStatus(), Config.DoorStatus.CLOSED);
        assertTrue(controller.isFloorReached());
        assertEquals(controller.getCrtFloor(), 1);
        assertEquals(controller.getDstFloor(), -1);
    }

    public void testMovingUp() {
        ElevatorController controller = new ElevatorController(ELEVATOR_IDLE);
        controller.execute();

        controller.getElevatorPanel().floorButtonPressed(3);
        assertEquals(controller.getStateMsg(), "IDLE STATE");
        assertEquals(controller.getErrorMsg(), "NULL");
        assertEquals(controller.getDoorStatus(), Config.DoorStatus.OPEN);
        assertTrue(controller.isFloorReached());
        assertEquals(controller.getCrtFloor(), 3);
        assertEquals(controller.getDstFloor(), 3);
    }

    public void testMovingDown() {
        ElevatorController controller = new ElevatorController(ELEVATOR_IDLE);
        controller.execute();

        controller.getElevatorPanel().floorButtonPressed(3);

        assertEquals(controller.getStateMsg(), "IDLE STATE");
        assertEquals(controller.getErrorMsg(), "NULL");
        assertEquals(controller.getDoorStatus(), Config.DoorStatus.OPEN);
        assertTrue(controller.isFloorReached());
        assertEquals(controller.getCrtFloor(), 3);
        assertEquals(controller.getDstFloor(), 3);

        controller.getElevatorPanel().floorButtonPressed(1);

        assertEquals(controller.getStateMsg(), "IDLE STATE");
        assertEquals(controller.getErrorMsg(), "NULL");
        assertEquals(controller.getDoorStatus(), Config.DoorStatus.OPEN);
        assertTrue(controller.isFloorReached());
        assertEquals(controller.getCrtFloor(), 1);
        assertEquals(controller.getDstFloor(), 1);
    }

}
