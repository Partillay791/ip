package sunoo.ui;

import java.util.Scanner;

/**
 * Represents a user interface that interacts with the user.
 */
public class Ui {

    /** Scanner to read user input */
    private static final Scanner SC = new Scanner(System.in);

    /** Horizontal line used as a visual separator */
    private static final String HORIZONTAL_LINE = "_".repeat(120);

    /** ASCII art logo displayed when the program starts */
    private static final String LOGO = """
                 ____  _   _ _   _  ____  ____
                / ___|| | | | \\ | ||  _ \\|  _ \\
                \\___ \\| | | |  \\| || | | | | | |
                 ___) | |_| | |\\  || |_| | |_| |
                |____/ \\___/|_| \\_||____/|____/
                """;

    /**
     * Reads a command (or input) by the user.
     *
     * @return Command as a string.
     */
    public static String readCommand() {
        return SC.nextLine();
    }

    /**
     * Prints a horizontal line as a visual separator.
     */
    public static void showLine() {
        System.out.println(HORIZONTAL_LINE);
    }

    /**
     * Displays a greeting message along with the ASCII art logo.
     */
    public static void greetUser() {
        showLine();
        System.out.println("Hello, this is sunoo.ui.Sunoo from ENHYPEN!\n" + LOGO);
        System.out.println("I'm glad to help you, let's talk!");
        showLine();
    }

    /**
     * Displays the exit message when the program ends.
     */
    public static void showExitMessage() {
        showLine();
        System.out.println("Bye bye, ENGENE!");
        showLine();
    }

    /**
     * Displays an error message.
     *
     * @param errorMessage Error message to be displayed.
     */
    public static void showErrorMessage(String errorMessage) {
        showLine();
        System.out.println(errorMessage);
        showLine();
    }

    /**
     * Displays a custom message to the user.
     *
     * @param message Message to be displayed.
     */
    public static void showMessage(String message) {
        System.out.println(message);
    }
}
