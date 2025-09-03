package sunoo.command;

import sunoo.task.TaskList;

import sunoo.ui.Ui;

/**
 * Represents an executable command that tells the user that their input is invalid.
 */
public class IncorrectCommand extends Command {

    /** Message to be shown by Ui as instructed */
    private final String incorrectMessage;

    /**
     * Creates an IncorrectCommand with the message to be shown by Ui.
     *
     * @param incorrectMessage Message to be shown.
     */
    public IncorrectCommand(String incorrectMessage) {
        this.incorrectMessage = incorrectMessage;
    }

    /**
     * Compares two IncorrectCommand instances.
     *
     * @param o Object to be compared.
     * @return true If the other object is an instance of IncorrectCommand.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        return o instanceof IncorrectCommand;
    }

    /**
     * {@inheritDoc}
     * Tells the user that their input is invalid.
     *
     * @param tasks The list of current tasks.
     */
    @Override
    public void execute(TaskList tasks) {
        Ui.showLine();
        Ui.showMessage(incorrectMessage);
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
