package ee.gromet.listener;

import ee.gromet.annotation.Subscribe;
import ee.gromet.event.GreetingEvent;
import ee.gromet.event.PingEvent;

public class ModuleWithTwoListeners extends Listener {

    public ModuleWithTwoListeners() {

    }

    @Subscribe
    public void handleListenableEvent(PingEvent event) {
        System.out.println("ModuleWithTwoListeners: Received a PingEvent created at " + event.getCreatedAt());
    }

    @Subscribe
    public void handleGreetingEvent(GreetingEvent event) {
        System.out.println("ModuleWithTwoListeners: Received a GreetingEvent with message {"
                           + event.getGreeting()
                           + "} created at "
                           + event.getCreatedAt());
    }
}
