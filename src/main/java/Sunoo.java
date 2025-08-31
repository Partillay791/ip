import java.io.IOException;

public class Sunoo {
    private static boolean isExit = false;
    private static TaskList tasks = new TaskList();

    public static void main(String[] args) throws IOException {
        tasks = Storage.loadTasks();
        Ui.greetUser();
        while (!isExit) {
            try {
                Command c = Parser.parse(Ui.readCommand());
                c.execute(tasks);
                isExit = c.isExit();
            } catch (SunooException e) {
                Ui.showErrorMessage(e.getMessage());
            } finally {
                Storage.updateTaskListInTxt(tasks);
            }
        }
    }
}
