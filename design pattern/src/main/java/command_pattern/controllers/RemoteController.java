package command_pattern.controllers;

import command_pattern.commands.Command;
import command_pattern.objects.NoCommand;

public class RemoteController {

    Command[] onCommands;
    Command[] offCommands;

    public RemoteController() {

        onCommands = new Command[7];
        offCommands = new Command[7];

        Command noCommand = new NoCommand();

        for (int i = 0; i < 7; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }

    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onButtonWasPushed(int slot) {
        if (onCommands[slot] != null)
            onCommands[slot].execute();
    }

    public void offButtonWasPushed(int slot) {
        if (offCommands[slot] != null)
            offCommands[slot].execute();
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("\n------ Remote control ------\n");
        for (int i = 0; i < onCommands.length; i++) {
            buffer.append("[slot " + i + "] " + onCommands[i].getClass().getSimpleName()
                    + "   " + offCommands[i].getClass().getSimpleName() + "\n");
        }

        return buffer.toString();
    }
}
