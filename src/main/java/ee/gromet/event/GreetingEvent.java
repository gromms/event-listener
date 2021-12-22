package ee.gromet.event;

public class GreetingEvent extends Event {

    private String greeting;

    public GreetingEvent(String greeting) {
        this.greeting = greeting;
    }

    public String getGreeting() {
        return greeting;
    }
}
