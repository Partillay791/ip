import java.util.ArrayList;

public class TaskList {
    private static final ArrayList<Task> tasks = new ArrayList<>();

    public static Task addTask(Task task) {
        tasks.add(task);
        return task;
    }

    public static Task deleteTask(int taskIndex) { //indexing starts from 1
        if (taskIndex <= 0) {
            throw new SunooException("Sorry ENGENE, that's not a valid task index!");
        }
        if (taskIndex > tasks.size()) {
            throw new SunooException("Sorry ENGENE, you don't have that many tasks!");
        }
        return tasks.remove(taskIndex - 1);
    }

    public static void markTask(int taskIndex) { //indexing starts from 1
        if (taskIndex <= 0) {
            throw new SunooException("Sorry ENGENE, that's not a valid task index!");
        }
        if (taskIndex > tasks.size()) {
            throw new SunooException("Sorry ENGENE, you don't have that many tasks!");
        }
        tasks.get(taskIndex - 1).markAsDone();
    }

    public static void unmarkTask(int taskIndex) { //indexing starts from 1
        if (taskIndex <= 0) {
            throw new SunooException("Sorry ENGENE, that's not a valid task index!");
        }
        if (taskIndex > tasks.size()) {
            throw new SunooException("Sorry ENGENE, you don't have that many tasks!");
        }
        tasks.get(taskIndex - 1).markAsNotDone();
    }

    public static ArrayList<Task> getTasks() {
        return tasks;
    }

    public static Task getTask(int index) { //indexing starts from 1
        return tasks.get(index - 1);
    }

    public static int getNumTasks() {
        return tasks.size();
    }
}
