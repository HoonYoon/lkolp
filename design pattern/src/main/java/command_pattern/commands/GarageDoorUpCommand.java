package command_pattern.commands;

import command_pattern.objects.GarageDoor;

public class GarageDoorUpCommand implements Command {

    private GarageDoor garageDoor;

    public GarageDoorUpCommand(GarageDoor garageDoor) {

        this.garageDoor = garageDoor;

    }

    @Override
    public void execute() {
        garageDoor.up();
    }

    @Override
    public void undo() {

    }
}
