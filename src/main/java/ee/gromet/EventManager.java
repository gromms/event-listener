package ee.gromet;

import ee.gromet.event.Event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class EventManager {

    private static final EventManager INSTANCE = new EventManager();

    private static final Map<Class<? extends Event>, List<Consumer<Event>>> consumers = new HashMap<>();

    private EventManager() {

    }

    public static EventManager getInstance() {
        return INSTANCE;
    }

    public void subscribe(Class<? extends Event> clazz, Consumer<Event> listener) {
        consumers.computeIfAbsent(clazz, k -> new ArrayList<>())
                 .add(listener);
    }

    public <T extends Event> void trigger(T event) {
        consumers.computeIfAbsent(event.getClass(), k -> new ArrayList<>())
                 .forEach(consumer -> consumer.accept(event));
    }
}
