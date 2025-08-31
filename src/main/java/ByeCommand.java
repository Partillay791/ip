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
