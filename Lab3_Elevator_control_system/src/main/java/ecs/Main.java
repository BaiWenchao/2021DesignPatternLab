package ecs;

import static ecs.util.States.ELEVATOR_IDLE;

public class Main {
    public static void main(String[] args) {
        ElevatorController controller = new ElevatorController(ELEVATOR_IDLE);
        controller.execute();
        log(controller);

        controller.getElevatorPanel().floorButtonPressed(2);
        controller.execute();
        log(controller);
    }
    public static void log(ElevatorController controller) {
        System.out.println("--------------------LOG--------------------");
        System.out.println("STATE MSG: " + controller.getStateMsg());
        System.out.println("ERROR MSG: " + controller.getErrorMsg());
        System.out.println("DOOR STATUS: " + controller.getDoorStatus());
        System.out.println("IS FLOOR REACHED: " + controller.isFloorReached());
        System.out.println("CRT FLOOR: " + controller.getCrtFloor());
        System.out.println("DET FLOOR: " + controller.getDstFloor());
        System.out.println("===========================================");
    }
}
