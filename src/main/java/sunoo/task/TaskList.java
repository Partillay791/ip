package sunoo.task;

import java.util.ArrayList;

public class TaskList {
    private final ArrayList<Task> tasks = new ArrayList<>();

    public Task addTask(Task task) {
        this.tasks.add(task);
        return task;
    }

    public Task deleteTask(int taskIndex) { //indexing starts from 1
        return tasks.remove(taskIndex - 1);
    }

    public void markTask(int taskIndex) { //indexing starts from 1
        tasks.get(taskIndex - 1).markAsDone();
    }

    public void unmarkTask(int taskIndex) { //indexing starts from 1
        tasks.get(taskIndex - 1).markAsNotDone();
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public Task getTask(int index) { //indexing starts from 1
        return tasks.get(index - 1);
    }

    public int getNumTasks() {
        return tasks.size();
    }
}
