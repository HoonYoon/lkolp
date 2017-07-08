package command_pattern.commands;

public interface Command {

    void execute();

    void undo();
}
