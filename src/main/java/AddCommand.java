public class AddCommand extends Command {
    private final Task taskToAdd;

    AddCommand(Task taskToAdd) {
        this.taskToAdd = taskToAdd;
    }

    @Override
    public void execute(TaskList tasks) {
        Ui.showLine();
        Ui.showMessage("Got it! Ddeonu has added this task for you:");
        Ui.showMessage(tasks.addTask(taskToAdd).toString());
        Ui.showMessage("Now you have " + tasks.getNumTasks()
                + " task(s) in the list, hwaiting!");
        Ui.showLine();
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
