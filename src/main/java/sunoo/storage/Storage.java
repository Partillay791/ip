package sunoo.storage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.Scanner;

import sunoo.task.Deadline;
import sunoo.task.Event;
import sunoo.task.Task;
import sunoo.task.TaskList;
import sunoo.task.ToDo;

public class Storage {
    private static final String FILE_PATH = "data/sunoo.txt";

    public static TaskList loadTasks() throws IOException {
        TaskList tasks = new TaskList();
        ensureFileExists();
        Scanner s = new Scanner(new File(FILE_PATH));
        while (s.hasNextLine()) {
            String taskText = s.nextLine();
            String[] taskParts = taskText.split(" \\| ");
            boolean isDone;
            switch (taskParts[0]) {
            case "T":
                isDone = taskParts[1].equals("1");
                tasks.addTask(new ToDo(isDone, taskParts[2]));
                break;
            case "D":
                isDone = taskParts[1].equals("1");
                tasks.addTask(new Deadline(isDone, taskParts[2],
                        LocalDateTime.parse(taskParts[3], DateTimeFormatter.ISO_LOCAL_DATE_TIME)));
                break;
            case "E":
                isDone = taskParts[1].equals("1");
                tasks.addTask(new Event(isDone, taskParts[2],
                        LocalDateTime.parse(taskParts[3], DateTimeFormatter.ISO_LOCAL_DATE_TIME),
                        LocalDateTime.parse(taskParts[4], DateTimeFormatter.ISO_LOCAL_DATE_TIME)));
            }
        }
        return tasks;
    }

    public static void updateTaskListInTxt(TaskList tasks) throws IOException {
        FileWriter fw = new FileWriter(FILE_PATH);
        for (Task task : tasks.getTasks()) {
            fw.write(task.getTxtRepresentation());
            fw.write("\n");
        }
        fw.close();
    }

    private static void ensureFileExists() throws IOException {
        File file = new File(FILE_PATH);
        file.getParentFile().mkdirs();
        file.createNewFile();
    }
}
