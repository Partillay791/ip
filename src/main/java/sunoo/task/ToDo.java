package sunoo.task;

public class ToDo extends Task {
    public ToDo(boolean isDone, String description) {
        super(isDone, description);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o instanceof ToDo) {
            return (isDone == ((ToDo) o).isDone && description.equals(((ToDo) o).description));
        }
        return false;
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
