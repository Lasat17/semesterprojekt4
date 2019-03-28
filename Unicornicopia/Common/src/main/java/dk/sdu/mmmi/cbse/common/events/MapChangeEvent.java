package dk.sdu.mmmi.cbse.common.events;

import dk.sdu.mmmi.cbse.common.data.Entity;

import java.io.Serializable;

public class MapChangeEvent implements Serializable {
    private final Entity source;

    public MapChangeEvent(Entity source) {
        this.source = source;
    }

    public Entity getSource() {
        return source;
    }
}
