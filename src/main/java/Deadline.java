public class Deadline extends Task {
    private final String by;

    public Deadline(boolean isDone, String description, String by) {
        super(isDone, description);
        this.by = by;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }

    @Override
    public String getTxtRepresentation() {
        return "D" + super.getTxtRepresentation() + " | " + by;
    }
}
