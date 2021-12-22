package ee.gromet.listener;

import ee.gromet.annotation.Subscribe;
import ee.gromet.event.PingEvent;

public class ModuleWithOneListener extends Listener {

    public ModuleWithOneListener() {

    }

    @Subscribe
    public void handleListenableEvent(PingEvent event) {
        System.out.println("ModuleWithOneListener: Received a ping event created at " + event.getCreatedAt());
    }
}
