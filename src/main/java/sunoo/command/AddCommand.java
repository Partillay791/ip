package sunoo.command;

import sunoo.task.Task;
import sunoo.task.TaskList;

import sunoo.ui.Ui;

/**
 * Represents an executable command that adds a task to the tasklist.
 */
public class AddCommand extends Command {

    /** Task to be added */
    private final Task taskToAdd;

    /**
     * Creats an AddCommand with the task to be added.
     *
     * @param taskToAdd Task to be added.
     */
    public AddCommand(Task taskToAdd) {
        this.taskToAdd = taskToAdd;
    }

    /**
     * {@inheritDoc}
     * Adds the task to the tasklist.
     *
     * @param tasks The list of current tasks.
     */
    @Override
    public void execute(TaskList tasks) {
        Ui.showLine();
        Ui.showMessage("Got it! Ddeonu has added this task for you:");
        Ui.showMessage(tasks.addTask(taskToAdd).toString());
        Ui.showMessage("Now you have " + tasks.getNumTasks()
                + " task(s) in the list, hwaiting!");
        Ui.showLine();
    }

    /**
     * {@inheritDoc}
     *
     * @return false.
     */
    @Override
    public boolean isExit() {
        return false;
    }
}
