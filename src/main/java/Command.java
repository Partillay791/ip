abstract class Command {
    abstract void execute(TaskList tasks);

    abstract boolean isExit();
}
