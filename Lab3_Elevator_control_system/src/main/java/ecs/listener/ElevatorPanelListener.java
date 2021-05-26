package ecs.listener;

public interface ElevatorPanelListener {
    void floorButtonPressed(int floor);
    void openButtonPressed();
    void closedButtonPressed();
}
