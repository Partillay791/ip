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
            } else if (userInput.startsWith("todo ")) {
                addTask(userInput, 1);
            } else if (userInput.startsWith("deadline ")) {
                addTask(userInput, 2);
            } else if (userInput.startsWith("event ")) {
                addTask(userInput, 3);
            }
        }

        sc.close();
    }

    private static void exit() {
        System.out.println(HORIZONTAL_LINE);
        System.out.println("Bye bye, ENGENE!");
        System.out.println(HORIZONTAL_LINE);
    }

    private static void addTask(String userInput, int taskType) {
        System.out.println(HORIZONTAL_LINE);
        if (taskType == 1) { // ToDo
            taskList.add(new ToDo(userInput.substring(5)));
        } else if (taskType == 2) { // Deadline
            String[] splitResult = userInput.split(" /by ");
            String taskDescription = splitResult[0];
            String deadline = splitResult[1];
            taskList.add(new Deadline(taskDescription, deadline));
        } else if (taskType == 3) { // Event
            String[] fromSplit = userInput.split(" /from ");
            String[] toSplit = fromSplit[1].split(" /to ");
            String taskDescription = fromSplit[0];
            String startTime = toSplit[0];
            String endTime = toSplit[1];
            taskList.add(new Event(taskDescription, startTime, endTime));
        }
        System.out.println("Got it! Sunoo has added this task for you: ");
        System.out.println(taskList.get(taskList.size() - 1));
        System.out.println("Now you have " + taskList.size() + " task(s) in the list, hwaiting!");
        System.out.println(HORIZONTAL_LINE);
    }

    private static void markTask(int taskIndex) {
        System.out.println(HORIZONTAL_LINE);
        System.out.println("Nice job, ENGENE! I've marked this task as done:");
        taskList.get(taskIndex - 1).markAsDone();
        System.out.println(taskList.get(taskIndex - 1));
        System.out.println(HORIZONTAL_LINE);
    }

    private static void unmarkTask(int taskIndex) {
        System.out.println(HORIZONTAL_LINE);
        System.out.println("Ok, ENGENE! I've marked this task as not done yet:");
        taskList.get(taskIndex - 1).markAsNotDone();
        System.out.println(taskList.get(taskIndex - 1));
        System.out.println(HORIZONTAL_LINE);
    }

    private static void listTasks() {
        System.out.println(HORIZONTAL_LINE);
        System.out.println("ENGENE, here are the tasks recorded by ddeonu:");
        for (int i = 1; i <= taskList.size(); i++) {
            System.out.println(i + ". " + taskList.get(i - 1));
        }
        System.out.println(HORIZONTAL_LINE);
    }
}
