package ee.gromet.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation to mark methods of {@link ee.gromet.listener.Listener} that should be registered in
 * {@link ee.gromet.producer.EventProducer} as event handlers. These methods must be subclasses of
 * {@link ee.gromet.event.Event}.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Subscribe {

}
