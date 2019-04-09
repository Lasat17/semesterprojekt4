package dk.sdu.mmmi.cbse.common.events;

import dk.sdu.mmmi.cbse.common.data.Entity;

public class MapChangeEvent extends Event {

    public MapChangeEvent(Object source) {
        super((Entity) source);
    }
}
