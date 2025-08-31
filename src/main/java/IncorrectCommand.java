public class IncorrectCommand extends Command {
    private final String incorrectMessage;

    IncorrectCommand(String incorrectMessage) {
        this.incorrectMessage = incorrectMessage;
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
