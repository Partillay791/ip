package sunoo.command;

import sunoo.exception.SunooException;
import sunoo.task.TaskList;
import sunoo.ui.Ui;

/**
 * Represents an executable command that deletes a task from the current tasklist.
 */
public class DeleteCommand extends Command {

    /** Index of the task to delete */
    private final int indexToDelete;

    /**
     * Creates a new DeleteCommand with the index of the task to delete.
     *
     * @param indexToDelete Index of the task to delete.
     */
    public DeleteCommand(int indexToDelete) {
        this.indexToDelete = indexToDelete;
    }

    /**
     * {@inheritDoc}
     * Deletes the task corresponding to the index given.
     *
     * @param tasks The list of current tasks.
     * @throws SunooException If index is invalid.
     */
    @Override
    public void execute(TaskList tasks) {
        if (indexToDelete <= 0) {
            throw new SunooException("Sorry ENGENE, that's not a valid task index!");
        }
        if (indexToDelete > tasks.getNumTasks()) {
            throw new SunooException("Sorry ENGENE, you don't have that many tasks!");
        }
        Ui.showLine();
        Ui.showMessage("Ok, ENGENE! I've removed this task:");
        Ui.showMessage(tasks.deleteTask(indexToDelete).toString());
        Ui.showMessage("Now you have " + tasks.getNumTasks()
                + " task(s) in the list left, hwaiting!");
        Ui.showLine();
    }

    /**
     * {@inheritDoc}
     *
     * @return false.
     */
    @Override
    public boolean shouldExit() {
        return false;
    }
}
