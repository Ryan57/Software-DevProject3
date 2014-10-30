

public class EventManager{

    private Event event[] = new Event[]{
            new CanJamEvent(),
            new CornHoleEvent(),
            new HorseShoesEvent(),
            new LadderBallEvent(),
            new StickGameEvent(),
            new WashoosEvent()
    };

    public Event[] getEvent() {
        return event;
    }

}// end EventManager