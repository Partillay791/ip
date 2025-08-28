public class Task {
    protected boolean isDone;
    protected final String description;

    public Task(boolean isDone, String description) {
        this.isDone = isDone;
        this.description = description;
    }

    public String getStatusIcon() {
        return (isDone ? "[X]" : "[ ]"); // mark done task with X
    }

    @Override
    public String toString() {
        return getStatusIcon() + " " + description;
    }

    public String getTxtRepresentation() {
        return " | " + (isDone ? "1" : "0") + " | " + description;
    }

    public void markAsDone() {
        isDone = true;
    }

    public void markAsNotDone() {
        isDone = false;
    }
}
