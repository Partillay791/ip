package sunoo.ui;

import java.util.List;

/**
 * Represents a user interface that interacts with the user.
 */
public class Ui {

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
     * Wraps a message with horizontal lines above and below.
     *
     * @param message String to be wrapped with horizontal lines.
     * @return String that has been wrapped.
     */
    public static String wrapWithHorizontalLines(String message) {
        return joinLines(HORIZONTAL_LINE, message, HORIZONTAL_LINE);
    }

    public static String joinLines(String... messages) {
        return String.join("\n", messages);
    }

    public static String joinLines(List<String> messages) {
        return String.join("\n", messages);
    }

    public static String getExitMessage() {
        return wrapWithHorizontalLines("Bye bye, ENGENE!");
    }

    public static String getGreetingMessage() {
        String response = joinLines(
                "Hello, this is Sunoo from ENHYPEN!\n" + LOGO,
                "I'm glad to help you, let's talk!");
        return wrapWithHorizontalLines(response);
    }
}
