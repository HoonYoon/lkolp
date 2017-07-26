package command_pattern.objects;

import command_pattern.commands.Command;

public class NoCommand implements Command {
    @Override
    public void execute() {

    }

    @Override
    public void undo() {

    }
}
