package sunoo.command;

import sunoo.task.Task;
import sunoo.task.TaskList;

import sunoo.ui.Ui;

import java.util.ArrayList;

public class ListCommand extends Command {
    @Override
    public void execute(TaskList tasks) {
        Ui.showLine();
        Ui.showMessage("ENGENE, here are the tasks recorded by ddeonu:");
        ArrayList<Task> taskList = tasks.getTasks();
        for (int i = 1; i <= taskList.size(); i++) {
            System.out.println(i + ". " + taskList.get(i - 1));
        }
        Ui.showLine();
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
