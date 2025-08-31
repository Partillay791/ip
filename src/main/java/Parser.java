import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Parser {
    public static void parse(String userInput) {
        if (userInput.equals("bye")) {
            Ui.showExitMessage();
            Sunoo.performExitNext();

        } else if (userInput.equals("list")) {
            Ui.showListTasksMessage();


        } else if (userInput.startsWith("mark")) {
            if (userInput.equals("mark")) {
                throw new SunooException("ENGENE, ddeonu does not know what to mark!");
            }
            if (!userInput.startsWith("mark ")) {
                throw new SunooException("ENGENE, leave a space after \"mark\"!");
            }
            int taskIndex;
            try {
                taskIndex = Integer.parseInt(userInput.substring("mark ".length()));
            } catch (NumberFormatException e) {
                throw new SunooException("ENGENE, I need a number to mark!");
            }
            TaskList.markTask(taskIndex);
            Ui.showMarkTaskMessage(taskIndex);


        } else if (userInput.startsWith("unmark")) {
            if (userInput.equals("unmark")) {
                throw new SunooException("ENGENE, ddeonu does not know what to unmark!");
            }
            if (!userInput.startsWith("unmark ")) {
                throw new SunooException("ENGENE, leave a space after \"unmark\"!");
            }
            int taskIndex;
            try {
                taskIndex = Integer.parseInt(userInput.substring("unmark ".length()));
            } catch (NumberFormatException e) {
                throw new SunooException("ENGENE, I need a number to unmark!");
            }
            TaskList.unmarkTask(taskIndex);
            Ui.showUnmarkTaskMessage(taskIndex);


        } else if (userInput.startsWith("delete")) {
            if (userInput.equals("delete")) {
                throw new SunooException("ENGENE, ddeonu does not know what to delete!");
            }
            if (!userInput.startsWith("delete ")) {
                throw new SunooException("ENGENE, leave a space after \"delete\"!");
            }
            int taskIndex;
            try {
                taskIndex = Integer.parseInt(userInput.substring("delete ".length()));
            } catch (NumberFormatException e) {
                throw new SunooException("ENGENE, I need a number to delete!");
            }
            Task deletedTask = TaskList.deleteTask(taskIndex);
            Ui.showDeleteTaskMessage(deletedTask);


        } else if (userInput.startsWith("todo")) {
            if (userInput.equals("todo")) {
                throw new SunooException("Sorry ENGENE, you don't have a todo description!");
            }
            if (!userInput.startsWith("todo ")) {
                throw new SunooException("ENGENE, leave a space after \"todo\"!");
            }
            Task addedTask = TaskList.addTask(new ToDo(false, userInput.substring(5)));
            Ui.showAddTaskMessage(addedTask);


        } else if (userInput.startsWith("deadline")) {
            if (userInput.equals("deadline")) {
                throw new SunooException("Sorry ENGENE, your deadline task is empty!");
            }
            if (!userInput.startsWith("deadline ")) {
                throw new SunooException("ENGENE, leave a space after \"deadline\"!");
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
            LocalDateTime deadline = localDateTimeParser(splitResult[1]);
            Task addedTask = TaskList.addTask(new Deadline(false, taskDescription, deadline));
            Ui.showAddTaskMessage(addedTask);


        } else if (userInput.startsWith("event")) {
            if (userInput.equals("event")) {
                throw new SunooException("Sorry ENGENE, your event task is empty!");
            }
            if (!userInput.startsWith("event ")) {
                throw new SunooException("ENGENE, leave a space after \"event\"!");
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
            LocalDateTime startTime = localDateTimeParser(toSplit[0]);
            LocalDateTime endTime = localDateTimeParser(toSplit[1]);
            Task addedTask = TaskList.addTask(new Event(false, taskDescription, startTime, endTime));
            Ui.showAddTaskMessage(addedTask);


        } else {
            throw new SunooException("Sorry! Ddeonu doesn't know what you mean ToT");
        }
    }

    private static LocalDateTime localDateTimeParser(String input) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return LocalDateTime.parse(input, formatter);
    }
}
