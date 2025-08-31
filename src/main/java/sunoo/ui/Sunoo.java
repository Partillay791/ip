package sunoo.ui;

import java.io.IOException;

import sunoo.command.Command;

import sunoo.exception.SunooException;

import sunoo.parser.Parser;

import sunoo.storage.Storage;

import sunoo.task.TaskList;

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
