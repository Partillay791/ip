package sunoo.parser;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import sunoo.command.AddCommand;
import sunoo.command.ByeCommand;
import sunoo.command.Command;
import sunoo.command.DeleteCommand;
import sunoo.command.FindCommand;
import sunoo.command.IncorrectCommand;
import sunoo.command.ListCommand;
import sunoo.command.MarkCommand;
import sunoo.command.UnmarkCommand;

import sunoo.exception.SunooException;

import sunoo.task.Deadline;
import sunoo.task.Event;
import sunoo.task.ToDo;

/**
 * Parses user's input.
 */
public class Parser {

    /**
     * Parses the user's input into a command to be executed.
     *
     * @param userInput User's input.
     * @return Command that corresponds to user's input.
     */
    public static Command parse(String userInput) {
        userInput = userInput.trim();
        String[] parts = userInput.split("\\s+", 2);
        String command = parts[0];
        int taskIndex;
        switch (command) {

        case "bye":
            return new ByeCommand();

        case "list":
            return new ListCommand();

        case "find":
            String keyword;
            try {
                keyword = parts[1];
            } catch (IndexOutOfBoundsException e) {
                throw new SunooException("ENGENE, give me a keyword so I can find tasks!");
            }
            return new FindCommand(keyword);

        case "mark":
            try {
                taskIndex = Integer.parseInt(parts[1]);
            } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                throw new SunooException("ENGENE, I need a number to mark!");
            }
            return new MarkCommand(taskIndex);

        case "unmark":
            try {
                taskIndex = Integer.parseInt(parts[1]);
            } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                throw new SunooException("ENGENE, I need a number to unmark!");
            }
            return new UnmarkCommand(taskIndex);

        case "delete":
            try {
                taskIndex = Integer.parseInt(parts[1]);
            } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                throw new SunooException("ENGENE, I need a number to delete!");
            }
            return new DeleteCommand(taskIndex);

        case "todo":
            String todoDescription;
            try {
                todoDescription = parts[1];
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new SunooException("Sorry ENGENE, you don't have a todo description!");
            }
            return new AddCommand(new ToDo(false, todoDescription));

        case "deadline":
            String deadlineDescription;
            try {
                deadlineDescription = parts[1];
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new SunooException("Sorry ENGENE, your deadline task is empty!");
            }
            String[] splitResult = deadlineDescription.split("\\s+/by\\s+");
            if (splitResult.length < 2) {
                throw new SunooException("""                      
                        ENGENE, there seems to be a problem!
                        1. Remember to include the " /by " keyword between your task description and deadline!
                        2. Your description and deadline cannot be empty!""");
            }
            String deadlineTaskDescription = splitResult[0];
            LocalDateTime deadline;
            try {
                deadline = localDateTimeParser(splitResult[1]);
            } catch (DateTimeParseException e) {
                throw new SunooException("ENGENE, I need a date time format of \"yyyy-MM-dd HH:mm\"!");
            }
            return new AddCommand(new Deadline(false, deadlineTaskDescription, deadline));

        case "event":
            String eventDescription;
            try {
                eventDescription = parts[1];
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new SunooException("Sorry ENGENE, your event task is empty!");
            }
            String[] fromSplit = eventDescription.split("\\s+/from\\s+");
            if (fromSplit.length < 2) {
                throw new SunooException("""                      
                        ENGENE, there seems to be a problem!
                        1. Remember to include the " /from " keyword between your event description and start time!
                        2. Remember to include the " /to " keyword between your event start time and event end time!
                        3. Your description, event start time and event end time cannot be empty!""");
            }
            String[] toSplit = fromSplit[1].split("\\s+/to\\s+");
            if (toSplit.length < 2) {
                throw new SunooException("""                        
                        ENGENE, there seems to be a problem!
                        1. Remember to include the " /from " keyword between your event description and start time!
                        2. Remember to include the " /to " keyword between your event start time and event end time!
                        3. Your description, event start time and event end time cannot be empty!""");
            }
            String taskDescription = fromSplit[0];
            LocalDateTime startTime, endTime;
            try {
                startTime = localDateTimeParser(toSplit[0]);
                endTime = localDateTimeParser(toSplit[1]);
            } catch (DateTimeParseException e) {
                throw new SunooException("ENGENE, I need a date time format of \"yyyy-MM-dd HH:mm\"!");
            }
            return new AddCommand(new Event(false, taskDescription, startTime, endTime));

        default:
            return new IncorrectCommand("Sorry! Ddeonu doesn't know what you mean ToT");
        }
    }

    /**
     * Parses a string and returns a LocalDateTime object.
     *
     * @param input Input to be parsed.
     * @return LocalDateTime object that represents date time.
     */
    private static LocalDateTime localDateTimeParser(String input) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return LocalDateTime.parse(input, formatter);
    }

}
