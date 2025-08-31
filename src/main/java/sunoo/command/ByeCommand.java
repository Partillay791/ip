package sunoo.command;

import sunoo.task.TaskList;

import sunoo.ui.Ui;

public class ByeCommand extends Command {
    @Override
    public void execute(TaskList tasks) {
        Ui.showExitMessage();
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
