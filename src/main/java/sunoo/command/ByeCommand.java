package sunoo.command;

import sunoo.task.TaskList;

import sunoo.ui.Ui;

/**
 * Represents an executable command that instructs the chatbot to exit and say goodbye.
 */
public class ByeCommand extends Command {

    /**
     * {@inheritDoc}
     * Instruct Ui to show a Goodbye message.
     *
     * @param tasks The list of current tasks.
     */
    @Override
    public void execute(TaskList tasks) {
        Ui.showExitMessage();
    }

    /**
     * {@inheritDoc}
     *
     * @return true.
     */
    @Override
    public boolean isExit() {
        return true;
    }
}
