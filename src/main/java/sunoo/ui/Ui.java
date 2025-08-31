package sunoo.ui;

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

    public static void showLine() {
        System.out.println(HORIZONTAL_LINE);
    }

    public static void greetUser() {
        showLine();
        System.out.println("Hello, this is sunoo.ui.Sunoo from ENHYPEN!\n" + LOGO);
        System.out.println("I'm glad to help you, let's talk!");
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

    public static void showMessage(String message) {
        System.out.println(message);
    }
}
