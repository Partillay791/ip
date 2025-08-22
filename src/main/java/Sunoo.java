import java.util.ArrayList;
import java.util.Scanner;

public class Sunoo {
    private static final String HORIZONTAL_LINE = "_".repeat(40);
    private static final ArrayList<String> taskList = new ArrayList<>();

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
        taskList.add(userInput);
        System.out.println(HORIZONTAL_LINE);
        System.out.println("added: " + userInput);
        System.out.println(HORIZONTAL_LINE);
    }

    private static void listTasks() {
        System.out.println(HORIZONTAL_LINE);
        for (int i = 1; i <= taskList.size(); i++) {
            System.out.println(i + ". " + taskList.get(i - 1));
        }
        System.out.println(HORIZONTAL_LINE);
    }
}
