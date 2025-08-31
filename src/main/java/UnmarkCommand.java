public class UnmarkCommand extends Command {
    private final int indexToUnmark;

    UnmarkCommand(int indexToUnmark) {
        this.indexToUnmark = indexToUnmark;
    }

    @Override
    public void execute(TaskList tasks) {
        if (indexToUnmark <= 0) {
            throw new SunooException("Sorry ENGENE, that's not a valid task index!");
        }
        if (indexToUnmark > tasks.getNumTasks()) {
            throw new SunooException("Sorry ENGENE, you don't have that many tasks!");
        }
        Ui.showLine();
        tasks.unmarkTask(indexToUnmark);
        Ui.showMessage("Ok, ENGENE! I've marked this task as not done yet:");
        Ui.showMessage(tasks.getTask(indexToUnmark).toString());
        Ui.showLine();
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
