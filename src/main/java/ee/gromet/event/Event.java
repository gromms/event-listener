package ee.gromet.event;

import java.time.LocalDateTime;

public abstract class Event {

    private final LocalDateTime createdAt = LocalDateTime.now();

    public final LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
