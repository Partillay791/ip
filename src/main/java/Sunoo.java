import java.util.ArrayList;
import java.util.Scanner;

public class Sunoo {
    private static final String HORIZONTAL_LINE = "_".repeat(50);
    private static final ArrayList<Task> taskList = new ArrayList<>();

    public static void main(String[] args) {
        String logo = " ____  _   _ _   _  ____  ____  \n"
                + "/ ___|| | | | \\ | ||  _ \\|  _ \\ \n"
                + "\\___ \\| | | |  \\| || | | | | | |\n"
                + " ___) | |_| | |\\  || |_| | |_| |\n"
                + "|____/ \\___/|_| \\_||____/|____/ \n";
        System.out.println(HORIZONTAL_LINE);
        System.out.println("Hello, this is Sunoo from ENHYPEN!\n" + logo);
        System.out.println("I'm glad to help you, let's talk!");
        System.out.println(HORIZONTAL_LINE);

        Scanner sc = new Scanner(System.in);

        while (true) {
            String userInput = sc.nextLine();
            if (userInput.equals("bye")) {
                exit();
                break;
            } else if (userInput.equals("list")) {
                listTasks();
            } else if (userInput.startsWith("mark ")) {
                int taskIndex = Integer.parseInt(userInput.substring("mark ".length()));
                markTask(taskIndex);
            } else if (userInput.startsWith("unmark ")) {
                int taskIndex = Integer.parseInt(userInput.substring("unmark ".length()));
                unmarkTask(taskIndex);
            } else {
                addTask(userInput);
            }
        }

        sc.close();
    }

    private static void exit() {
        System.out.println(HORIZONTAL_LINE);
        System.out.println("Bye bye, ENGENE!");
        System.out.println(HORIZONTAL_LINE);
    }

    private static void addTask(String userInput) {
        taskList.add(new Task(userInput));
        System.out.println(HORIZONTAL_LINE);
        System.out.println("added: " + userInput);
        System.out.println(HORIZONTAL_LINE);
    }

    private static void markTask(int taskIndex) {
        System.out.println(HORIZONTAL_LINE);
        System.out.println("Nice job, ENGENE! I've marked this task as done:");
        taskList.get(taskIndex - 1).markAsDone();
        System.out.println(taskList.get(taskIndex - 1).getFullDescription());
        System.out.println(HORIZONTAL_LINE);
    }

    private static void unmarkTask(int taskIndex) {
        System.out.println(HORIZONTAL_LINE);
        System.out.println("Ok, ENGENE! I've marked this task as not done yet:");
        taskList.get(taskIndex - 1).markAsNotDone();
        System.out.println(taskList.get(taskIndex - 1).getFullDescription());
        System.out.println(HORIZONTAL_LINE);
    }

    private static void listTasks() {
        System.out.println(HORIZONTAL_LINE);
        System.out.println("ENGENE, here are the tasks recorded by ddeonu:");
        for (int i = 1; i <= taskList.size(); i++) {
            System.out.println(i + ". " + taskList.get(i - 1).getFullDescription());
        }
        System.out.println(HORIZONTAL_LINE);
    }
}
