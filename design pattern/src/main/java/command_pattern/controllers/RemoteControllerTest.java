package command_pattern.controllers;

import command_pattern.commands.GarageDoorUpCommand;
import command_pattern.commands.LightOnCommand;
import command_pattern.objects.GarageDoor;
import command_pattern.objects.Light;

public class RemoteControllerTest {

    public static void main(String[] args) {
        SimpleRemoteController remote = new SimpleRemoteController();
        Light light = new Light("");
        GarageDoor garageDoor = new GarageDoor("");
        LightOnCommand lightOnCommand = new LightOnCommand(light);
        GarageDoorUpCommand garageDoorOnCommand = new GarageDoorUpCommand(garageDoor);

        remote.setCommand(lightOnCommand);
        remote.buttonWasPressed();
        remote.setCommand(garageDoorOnCommand);
        remote.buttonWasPressed();
    }

}
