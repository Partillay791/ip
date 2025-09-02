package sunoo.task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task {
    private final LocalDateTime by;

    public Deadline(boolean isDone, String description, LocalDateTime by) {
        super(isDone, description);
        this.by = by;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o instanceof Deadline other) {
            return (this.isDone == other.isDone && this.by.equals(other.by)
                    && this.description.equals(other.description));
        }
        return false;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: "
                + by.format(DateTimeFormatter.ofPattern("EEEE, MMMM d yyyy h:mma")) + ")";
    }

    @Override
    public String getTxtRepresentation() {
        return "D" + super.getTxtRepresentation() + " | " + by;
    }
}
