import java.util.ArrayList;
import java.util.Scanner;

public class Sunoo {
    private static final String HORIZONTAL_LINE = "_".repeat(50);
    private static final ArrayList<Task> taskList = new ArrayList<>();

    public static void main(String[] args) {
        String logo = """
                 ____  _   _ _   _  ____  ____
                / ___|| | | | \\ | ||  _ \\|  _ \\
                \\___ \\| | | |  \\| || | | | | | |
                 ___) | |_| | |\\  || |_| | |_| |
                |____/ \\___/|_| \\_||____/|____/
                """;
        System.out.println(HORIZONTAL_LINE);
        System.out.println("Hello, this is Sunoo from ENHYPEN!\n" + logo);
        System.out.println("I'm glad to help you, let's talk!");
        System.out.println(HORIZONTAL_LINE);

        Scanner sc = new Scanner(System.in);

        while (true) {
            String userInput = sc.nextLine();
            userInput = userInput.trim();
            try {
                if (userInput.equals("bye")) {
                    exit();
                    break;
                } else if (userInput.equals("list")) {
                    listTasks();
                } else if (userInput.startsWith("mark")) {
                    if (userInput.equals("mark")) {
                        throw new SunooException("ENGENE, ddeonu does not know what to mark!");
                    }
                    int taskIndex;
                    try {
                        taskIndex = Integer.parseInt(userInput.substring("mark ".length()));
                    } catch (NumberFormatException e) {
                        throw new SunooException("ENGENE, I need a number to mark!");
                    }
                    markTask(taskIndex);
                } else if (userInput.startsWith("unmark")) {
                    if (userInput.equals("unmark")) {
                        throw new SunooException("ENGENE, ddeonu does not know what to unmark!");
                    }
                    int taskIndex;
                    try {
                        taskIndex = Integer.parseInt(userInput.substring("unmark ".length()));
                    } catch (NumberFormatException e) {
                        throw new SunooException("ENGENE, I need a number to mark!");
                    }
                    unmarkTask(taskIndex);
                } else if (userInput.startsWith("todo")) {
                    addTask(userInput, 1);
                } else if (userInput.startsWith("deadline")) {
                    addTask(userInput, 2);
                } else if (userInput.startsWith("event")) {
                    addTask(userInput, 3);
                } else {
                    throw new SunooException("Sorry! Ddeonu doesn't know what you mean ToT");
                }
            } catch (SunooException e) {
                System.out.println(HORIZONTAL_LINE + "\n" + e.getMessage() + "\n" + HORIZONTAL_LINE);
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
        userInput = userInput.trim();
        if (taskType == 1) { // ToDo
            if (userInput.equals("todo")) {
                throw new SunooException("Sorry ENGENE, you don't have a todo description!");
            }
            taskList.add(new ToDo(userInput.substring(5)));
        } else if (taskType == 2) { // Deadline
            if (userInput.equals("deadline")) {
                throw new SunooException("Sorry ENGENE, your deadline task is empty!");
            }
            userInput = userInput.substring(9);
            String[] splitResult = userInput.split(" /by ");
            if (splitResult.length < 2) {
                throw new SunooException("""                      
                        ENGENE, there seems to be a problem!
                        1. Remember to include the " /by " keyword between your task description and deadline so I can know when it is due!
                        2. Your description and deadline cannot be empty!""");
            }
            String taskDescription = splitResult[0];
            String deadline = splitResult[1];
            taskList.add(new Deadline(taskDescription, deadline));
        } else if (taskType == 3) { // Event
            if (userInput.equals("event")) {
                throw new SunooException("Sorry ENGENE, your event task is empty!");
            }
            userInput = userInput.substring(6);
            String[] fromSplit = userInput.split(" /from ");
            if (fromSplit.length < 2) {
                throw new SunooException("""                      
                        ENGENE, there seems to be a problem!
                        1. Remember to include the " /from " keyword between your event description and event start time!
                        2. Remember to include the " /to " keyword between your event start time and event end time!
                        3. Your description, event start time and event end time cannot be empty!""");
            }
            String[] toSplit = fromSplit[1].split(" /to ");
            if (toSplit.length < 2) {
                throw new SunooException("""                        
                        ENGENE, there seems to be a problem!
                        1. Remember to include the " /from " keyword between your event description and event start time!
                        2. Remember to include the " /to " keyword between your event start time and event end time!
                        3. Your description, event start time and event end time cannot be empty!""");
            }
            String taskDescription = fromSplit[0];
            String startTime = toSplit[0];
            String endTime = toSplit[1];
            taskList.add(new Event(taskDescription, startTime, endTime));
        }
        System.out.println(HORIZONTAL_LINE);
        System.out.println("Got it! Ddeonu has added this task for you:");
        System.out.println(taskList.get(taskList.size() - 1));
        System.out.println("Now you have " + taskList.size() + " task(s) in the list, hwaiting!");
        System.out.println(HORIZONTAL_LINE);
    }

    private static void markTask(int taskIndex) {
        if (taskIndex <= 0) {
            throw new SunooException("Sorry ENGENE, that's not a valid task index!");
        }
        if (taskIndex > taskList.size()) {
            throw new SunooException("Sorry ENGENE, you don't have that many tasks!");
        }
        System.out.println(HORIZONTAL_LINE);
        System.out.println("Nice job, ENGENE! I've marked this task as done:");
        taskList.get(taskIndex - 1).markAsDone();
        System.out.println(taskList.get(taskIndex - 1));
        System.out.println(HORIZONTAL_LINE);
    }

    private static void unmarkTask(int taskIndex) {
        if (taskIndex <= 0) {
            throw new SunooException("Sorry ENGENE, that's not a valid task index!");
        }
        if (taskIndex > taskList.size()) {
            throw new SunooException("Sorry ENGENE, you don't have that many tasks!");
        }
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
