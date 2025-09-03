package sunoo.command;

import sunoo.exception.SunooException;

import sunoo.task.TaskList;

import sunoo.ui.Ui;

/**
 * Represents an executable command that marks a command as not done.
 */
public class UnmarkCommand extends Command {

    /** Index of the task to mark as not done */
    private final int indexToUnmark;

    /**
     * Creates a new UnmarkCommand with the index of the task to mark as not done.
     *
     * @param indexToUnmark Index of the task to mark as not done.
     */
    public UnmarkCommand(int indexToUnmark) {
        this.indexToUnmark = indexToUnmark;
    }

    /**
     * {@inheritDoc}
     * Marks the task corresponding to the index given as not done.
     *
     * @param tasks The list of current tasks.
     * @throws SunooException If index is invalid.
     */
    @Override
    public void execute(TaskList tasks) {
        if (indexToUnmark <= 0) {
            throw new SunooException("Sorry ENGENE, that's not a valid task index!");
        }
        if (indexToUnmark > tasks.getNumTasks()) {
            throw new SunooException("Sorry ENGENE, you don't have that many tasks!");
        }
        Ui.showLine();
        tasks.unmarkTask(indexToUnmark);
        Ui.showMessage("Ok, ENGENE! I've marked this task as not done yet:");
        Ui.showMessage(tasks.getTask(indexToUnmark).toString());
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
