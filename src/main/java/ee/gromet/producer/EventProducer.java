package ee.gromet.producer;

import ee.gromet.event.GreetingEvent;
import ee.gromet.event.PingEvent;

public class EventProducer extends Producer {

    public void produceListenableEvent() {
        produceEvent(new PingEvent());
    }

    public void produceGreetingEvent() {
        var event = new GreetingEvent("Hello World!");
        produceEvent(event);
    }
}
