package ecs.util;

import ecs.ElevatorController;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class Tools {
    public static void sleep(int sec) {
        try {
            TimeUnit.SECONDS.sleep(sec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void setValue(ElevatorController controller, JLabel crtFloor, JLabel dstFloor, JLabel elevatorState, JLabel doorState) {
        crtFloor.setText(String.valueOf(controller.getCrtFloor()));
        dstFloor.setText(String.valueOf(controller.getDstFloor()));
        elevatorState.setText(controller.getStateMsg());
        doorState.setText(controller.getDoorStatus().toString());
    }
}
