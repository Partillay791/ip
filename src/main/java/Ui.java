import java.util.ArrayList;
import java.util.Scanner;

public class Ui {
    private static final Scanner SC = new Scanner(System.in);
    private static final String HORIZONTAL_LINE = "_".repeat(120);
    private static final String LOGO = """
                 ____  _   _ _   _  ____  ____
                / ___|| | | | \\ | ||  _ \\|  _ \\
                \\___ \\| | | |  \\| || | | | | | |
                 ___) | |_| | |\\  || |_| | |_| |
                |____/ \\___/|_| \\_||____/|____/
                """;

    public static String readCommand() {
        return SC.nextLine().trim();
    }

    private static void showLine() {
        System.out.println(HORIZONTAL_LINE);
    }

    public static void greetUser() {
        showLine();
        System.out.println("Hello, this is Sunoo from ENHYPEN!\n" + LOGO);
        System.out.println("I'm glad to help you, let's talk!");
        showLine();
    }

    public static void showAddTaskMessage(Task task) {
        showLine();
        System.out.println("Got it! Ddeonu has added this task for you:");
        System.out.println(task);
        System.out.println("Now you have " + TaskList.getNumTasks()
                + " task(s) in the list, hwaiting!");
        showLine();
    }

    public static void showDeleteTaskMessage(Task task) {
        showLine();
        System.out.println("Ok, ENGENE! I've removed this task:");
        System.out.println(task);
        System.out.println("Now you have " + TaskList.getNumTasks()
                + " task(s) in the list left, hwaiting!");
        showLine();
    }

    public static void showListTasksMessage() {
        showLine();
        System.out.println("ENGENE, here are the tasks recorded by ddeonu:");
        ArrayList<Task> taskList = TaskList.getTasks();
        for (int i = 1; i <= taskList.size(); i++) {
            System.out.println(i + ". " + taskList.get(i - 1));
        }
        showLine();
    }

    public static void showMarkTaskMessage(int index) {
        Task task = TaskList.getTask(index);
        showLine();
        System.out.println("Nice job, ENGENE! I've marked this task as done:");
        System.out.println(task);
        showLine();
    }

    public static void showUnmarkTaskMessage(int index) {
        Task task = TaskList.getTask(index);
        showLine();
        System.out.println("Ok, ENGENE! I've marked this task as not done yet:");
        System.out.println(task);
        showLine();
    }

    public static void showExitMessage() {
        showLine();
        System.out.println("Bye bye, ENGENE!");
        showLine();
    }

    public static void showErrorMessage(String errorMessage) {
        showLine();
        System.out.println(errorMessage);
        showLine();
    }
}
