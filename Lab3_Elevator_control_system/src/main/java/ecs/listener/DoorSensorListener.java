package ecs.listener;

public interface DoorSensorListener {
    void doorOpen();
    void doorClosed();
    void doorBlocked();
}
