package ee.gromet.producer;

import ee.gromet.EventManager;
import ee.gromet.event.Event;

public abstract class Producer {

    private final EventManager eventManager;

    protected Producer() {
        this.eventManager = EventManager.getInstance();
    }

    protected <T extends Event> void produceEvent(T event) {
        eventManager.trigger(event);
    }
}
