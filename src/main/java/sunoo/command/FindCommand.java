package sunoo.command;

import sunoo.task.Task;
import sunoo.task.TaskList;

import sunoo.ui.Ui;

public class FindCommand extends Command {
    private final String keyword;

    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

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

    @Override
    public boolean isExit() {
        return false;
    }
}
