package sunoo.task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Event extends Task {
    private final LocalDateTime from;
    private final LocalDateTime to;

    public Event(boolean isDone, String description, LocalDateTime from, LocalDateTime to) {
        super(isDone, description);
        this.from = from;
        this.to = to;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: "
                + from.format(DateTimeFormatter.ofPattern("EEEE, MMMM d yyyy h:mma")) + "; to: "
                + to.format(DateTimeFormatter.ofPattern("EEEE, MMMM d yyyy h:mma")) + ")";
    }

    @Override
    public String getTxtRepresentation() {
        return "E" + super.getTxtRepresentation() + " | " + from + " | " + to;
    }
}
