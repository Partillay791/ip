import java.io.IOException;

public class Sunoo {
    private static boolean isExit = false;

    public static void main(String[] args) throws IOException {
        Storage.loadTasks();
        Ui.greetUser();
        while (!isExit) {
            try {
                Parser.parse(Ui.readCommand());
            } catch (SunooException e) {
                Ui.showErrorMessage(e.getMessage());
            } finally {
                Storage.updateTaskListInTxt();
            }
        }
    }

    public static void performExitNext() {
        isExit = true;
    }
}
