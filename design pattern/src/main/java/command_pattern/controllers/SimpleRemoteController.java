package command_pattern.controllers;

import command_pattern.commands.Command;

public class SimpleRemoteController {

    private Command slot;

    public SimpleRemoteController() {
    }

    public void setCommand(Command command) {
        this.slot = command;
    }

    public void buttonWasPressed(){
        slot.execute();
    }
}
