package sunoo.command;

import sunoo.exception.SunooException;

import sunoo.task.TaskList;

import sunoo.ui.Ui;

public class DeleteCommand extends Command {
    private final int indexToDelete;

    public DeleteCommand(int indexToDelete) {
        this.indexToDelete = indexToDelete;
    }

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

    @Override
    public boolean isExit() {
        return false;
    }
}
