package sunoo.command;

import sunoo.task.Task;
import sunoo.task.TaskList;

import sunoo.ui.Ui;

/**
 * Represents an executable command to find tasks that has a description containing a keyword.
 */
public class FindCommand extends Command {

    /** Keyword to search */
    private final String keyword;

    /**
     * Creates a FindCommand with the keyword.
     *
     * @param keyword Keyword to search for.
     */
    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    /**
     * {@inheritDoc}
     * Instructs Ui to show tasks that has a description containing the keyword.
     *
     * @param tasks The list of current tasks.
     */
    @Override
    public void execute(TaskList tasks) {
        Ui.showLine();
        Ui.showMessage("ENGENE, here are the matching tasks for " + keyword + ":");
        int i = 1;
        for (Task task : tasks.getTasks()) {
            if (task.descriptionContainsKeyword(keyword)) {
                Ui.showMessage(i + ". " + task);
                i++;
            }
        }
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
