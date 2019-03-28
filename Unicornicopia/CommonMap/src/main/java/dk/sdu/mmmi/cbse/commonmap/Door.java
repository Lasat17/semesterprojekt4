package dk.sdu.mmmi.cbse.commonmap;

import dk.sdu.mmmi.cbse.common.data.Entity;

public class Door extends Entity {
    private DoorDirection doorDirection;
    private boolean lockedStatus;


    public Door(boolean lockedStatus, DoorDirection doorDirection){
        this.lockedStatus = lockedStatus;
        this.doorDirection = doorDirection;
    }

    public Door createDoorNorth(){
        return new Door(false, DoorDirection.DOOR_DIRECTION_NORTH);

    }

    public Door createDoorSouth(){
        return new Door(false, DoorDirection.DOOR_DIRECTION_SOUTH);

    }

    public Door createDoorWest(){
        return new Door(false, DoorDirection.DOOR_DIRECTION_WEST);

    }

    public Door createDoorEast(){
        return new Door(false, DoorDirection.DOOR_DIRECTION_EAST);

    }




}


