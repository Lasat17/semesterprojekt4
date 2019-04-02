package dk.sdu.mmmi.cbse.common.events;

import java.io.Serializable;

/**
 *
 * @author Mads
 */
public class Event implements Serializable{
    private final Object source;

    public Event(Object source) {
        this.source = source;
    }

    public Object getSource() {
        return source;
    }
}
