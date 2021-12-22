package ee.gromet;

import ee.gromet.listener.ModuleWithOneListener;
import ee.gromet.listener.ModuleWithTwoListeners;
import ee.gromet.producer.EventProducer;

public class Main {

    public static void main(String[] args) {

        final var listener1 = new ModuleWithOneListener();
        final var listener2 = new ModuleWithTwoListeners();

        EventProducer eventProducer = new EventProducer();

        eventProducer.produceListenableEvent();
        eventProducer.produceGreetingEvent();
    }
}
