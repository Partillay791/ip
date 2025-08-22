import java.util.Scanner;

public class Sunoo {
    private static final String HORIZONTAL_LINE = "_".repeat(40);

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
            }
            echo(userInput);
        }

        sc.close();
    }

    public static void exit() {
        System.out.println(HORIZONTAL_LINE);
        System.out.println("Bye bye, ENGENE!");
        System.out.println(HORIZONTAL_LINE);
    }

    public static void echo(String userInput) {
        System.out.println(HORIZONTAL_LINE);
        System.out.println(userInput);
        System.out.println(HORIZONTAL_LINE);
    }
}
