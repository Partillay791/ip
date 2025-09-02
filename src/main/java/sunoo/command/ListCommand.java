package sunoo.command;

import sunoo.task.Task;
import sunoo.task.TaskList;

import sunoo.ui.Ui;

import java.util.ArrayList;

/**
 * Represents an executable command that lists all the tasks in the tasklist.
 */
public class ListCommand extends Command {

    /**
     * {@inheritDoc}
     * Instructs Ui to show all the tasks in the tasklist to the user.
     *
     * @param tasks The list of current tasks.
     */
    @Override
    public void execute(TaskList tasks) {
        Ui.showLine();
        Ui.showMessage("ENGENE, here are the tasks recorded by ddeonu:");
        ArrayList<Task> taskList = tasks.getTasks();
        for (int i = 1; i <= taskList.size(); i++) {
            Ui.showMessage(i + ". " + taskList.get(i - 1));
        }
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
