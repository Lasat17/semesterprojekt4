package dk.sdu.mmmi.cbse.commonmap;

import dk.sdu.mmmi.cbse.common.data.Entity;

public class Door extends Entity {
    private DoorDirection doorDirection;
    private boolean lockedStatus;


    public Door(boolean lockedStatus, DoorDirection doorDirection){
        this.lockedStatus = lockedStatus;
        this.doorDirection = doorDirection;
    }

}


