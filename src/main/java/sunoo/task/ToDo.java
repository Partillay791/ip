package sunoo.task;

public class ToDo extends Task {
    public ToDo(boolean isDone, String description) {
        super(isDone, description);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

    @Override
    public String getTxtRepresentation() {
        return "T" + super.getTxtRepresentation();
    }
}
