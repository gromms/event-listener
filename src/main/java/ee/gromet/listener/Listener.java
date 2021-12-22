package ee.gromet.listener;

import ee.gromet.EventManager;
import ee.gromet.annotation.Subscribe;
import ee.gromet.event.Event;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class Listener {

    protected Listener() {
        var methods = getClass().getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Subscribe.class)) {
                var manager = EventManager.getInstance();
                var params = method.getParameterTypes();
                if (params.length != 1) {
                    throw new RuntimeException("Expected exactly 1 parameter.");
                }

                var clazz = params[0];

                boolean correctParam = false;
                while (clazz != Object.class) {
                    if (clazz == Event.class) {
                        manager.subscribe((Class<? extends Event>) params[0], (event) -> {
                            try {
                                method.invoke(this, event);
                            } catch (IllegalAccessException | InvocationTargetException e) {
                                e.printStackTrace();
                            }
                        });
                        correctParam = true;
                        break;
                    }
                    clazz = clazz.getSuperclass();
                }

                if (!correctParam) {
                    throw new IllegalArgumentException("The parameter is not an instance of Event.");
                }
            }
        }
    }
}
