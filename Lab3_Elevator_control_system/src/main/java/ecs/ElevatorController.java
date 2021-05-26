package ecs;

import ecs.listener.impl.DoorSensor;
import ecs.listener.impl.ElevatorPanel;
import ecs.listener.impl.FloorSensor;
import ecs.motor.DoorMotor;
import ecs.motor.ElevatorMotor;
import ecs.state.ElevatorState;
import ecs.util.Config;

import static ecs.util.Config.INIT_DST;

public class ElevatorController {
    // sensors and motors
    private DoorSensor doorSensor;
    private ElevatorPanel elevatorPanel;
    private FloorSensor floorSensor;
    private DoorMotor doorMotor;
    private ElevatorMotor elevatorMotor;

    // parameters about the elevator
    private Config.DoorStatus doorStatus;
    private boolean floorReached;
    private int crtFloor, dstFloor;
    private String stateMsg, errorMsg;

    // state
    private ElevatorState state;

    public void execute() {
        state.Handle(this);
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    // constructor
    public ElevatorController(ElevatorState state) {
        this.state = state;

        this.doorSensor = new DoorSensor(this);
        this.elevatorPanel = new ElevatorPanel(this);
        this.floorSensor = new FloorSensor(this);
        this.doorMotor = new DoorMotor();
        this.elevatorMotor = new ElevatorMotor();

        this.doorStatus = Config.DoorStatus.CLOSED;
        this.floorReached = true;
        this.crtFloor = 1;
        this.dstFloor = INIT_DST;
        this.errorMsg = "NULL";
    }

    // getter and setter
    public DoorSensor getDoorSensor() {
        return doorSensor;
    }

    public void setDoorSensor(DoorSensor doorSensor) {
        this.doorSensor = doorSensor;
    }

    public ElevatorPanel getElevatorPanel() {
        return elevatorPanel;
    }

    public void setElevatorPanel(ElevatorPanel elevatorPanel) {
        this.elevatorPanel = elevatorPanel;
    }

    public FloorSensor getFloorSensor() {
        return floorSensor;
    }

    public void setFloorSensor(FloorSensor floorSensor) {
        this.floorSensor = floorSensor;
    }

    public DoorMotor getDoorMotor() {
        return doorMotor;
    }

    public void setDoorMotor(DoorMotor doorMotor) {
        this.doorMotor = doorMotor;
    }

    public ElevatorMotor getElevatorMotor() {
        return elevatorMotor;
    }

    public void setElevatorMotor(ElevatorMotor elevatorMotor) {
        this.elevatorMotor = elevatorMotor;
    }

    public Config.DoorStatus getDoorStatus() {
        return doorStatus;
    }

    public void setDoorStatus(Config.DoorStatus doorStatus) {
        this.doorStatus = doorStatus;
    }

    public boolean isFloorReached() {
        return floorReached;
    }

    public void setFloorReached(boolean floorReached) {
        this.floorReached = floorReached;
    }

    public int getCrtFloor() {
        return crtFloor;
    }

    public void setCrtFloor(int crtFloor) {
        this.crtFloor = crtFloor;
    }

    public int getDstFloor() {
        return dstFloor;
    }

    public void setDstFloor(int dstFloor) {
        this.dstFloor = dstFloor;
    }

    public ElevatorState getState() {
        return state;
    }

    public void setState(ElevatorState state) {
        this.state = state;
    }

    public String getStateMsg() {
        return stateMsg;
    }

    public void setStateMsg(String stateMsg) {
        this.stateMsg = stateMsg;
    }
}
