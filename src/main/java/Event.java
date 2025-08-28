public class Event extends Task {
    private final String from;
    private final String to;

    public Event(boolean isDone, String description, String from, String to) {
        super(isDone, description);
        this.from = from;
        this.to = to;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + from + " to: " + to + ")";
    }

    @Override
    public String getTxtRepresentation() {
        return "E" + super.getTxtRepresentation() + " | " + from + " | " + to;
    }
}
