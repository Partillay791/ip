public class MarkCommand extends Command {
    private final int indexToMark;

    MarkCommand(int indexToMark) {
        this.indexToMark = indexToMark;
    }

    @Override
    public void execute(TaskList tasks) {
        if (indexToMark <= 0) {
            throw new SunooException("Sorry ENGENE, that's not a valid task index!");
        }
        if (indexToMark > tasks.getNumTasks()) {
            throw new SunooException("Sorry ENGENE, you don't have that many tasks!");
        }
        Ui.showLine();
        tasks.markTask(indexToMark);
        Ui.showMessage("Nice job, ENGENE! I've marked this task as done:");
        Ui.showMessage(tasks.getTask(indexToMark).toString());
        Ui.showLine();
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
