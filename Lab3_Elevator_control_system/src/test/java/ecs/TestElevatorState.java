package ecs;

import static ecs.util.States.idleState;

import ecs.util.Config;
import junit.framework.TestCase;

/**
 * Note that:
 * since testing cannot be easily performed
 * in a single thread, the more test case can
 * be performed using gui (print the log info
 * is a solution, but it's not user friendly)
 * */

public class TestElevatorState extends TestCase {
    public void testInitialState() {
        ElevatorController controller = new ElevatorController(idleState);
        controller.execute();
        assertEquals(controller.getStateMsg(), "IDLE STATE");
        assertEquals(controller.getErrorMsg(), "NULL");
        assertEquals(controller.getDoorStatus(), Config.DoorStatus.CLOSED);
        assertTrue(controller.isFloorReached());
        assertEquals(controller.getCrtFloor(), 1);
        assertEquals(controller.getDstFloor(), -1);
    }

    public void testMovingUp() {
        ElevatorController controller = new ElevatorController(idleState);
        controller.execute();

        controller.getElevatorPanel().floorButtonPressed(3);
        controller.execute();
        assertEquals(controller.getStateMsg(), "IDLE STATE");
        assertEquals(controller.getErrorMsg(), "NULL");
        assertEquals(controller.getDoorStatus(), Config.DoorStatus.OPEN);
        assertTrue(controller.isFloorReached());
        assertEquals(controller.getCrtFloor(), 3);
        assertEquals(controller.getDstFloor(), 3);
    }

    public void testMovingDown() {
        ElevatorController controller = new ElevatorController(idleState);
        controller.execute();

        controller.getElevatorPanel().floorButtonPressed(3);
        controller.execute();
        assertEquals(controller.getStateMsg(), "IDLE STATE");
        assertEquals(controller.getErrorMsg(), "NULL");
        assertEquals(controller.getDoorStatus(), Config.DoorStatus.OPEN);
        assertTrue(controller.isFloorReached());
        assertEquals(controller.getCrtFloor(), 3);
        assertEquals(controller.getDstFloor(), 3);

        controller.getElevatorPanel().floorButtonPressed(1);
        controller.execute();
        assertEquals(controller.getStateMsg(), "IDLE STATE");
        assertEquals(controller.getErrorMsg(), "NULL");
        assertEquals(controller.getDoorStatus(), Config.DoorStatus.OPEN);
        assertTrue(controller.isFloorReached());
        assertEquals(controller.getCrtFloor(), 1);
        assertEquals(controller.getDstFloor(), 1);
    }

}
