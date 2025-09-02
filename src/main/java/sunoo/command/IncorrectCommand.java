package sunoo.command;

import sunoo.task.TaskList;

import sunoo.ui.Ui;

public class IncorrectCommand extends Command {
    private final String incorrectMessage;

    public IncorrectCommand(String incorrectMessage) {
        this.incorrectMessage = incorrectMessage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        return o instanceof IncorrectCommand;
    }

    @Override
    public void execute(TaskList tasks) {
        Ui.showLine();
        Ui.showMessage(incorrectMessage);
        Ui.showLine();
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
