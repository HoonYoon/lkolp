package command_pattern;

import command_pattern.commands.*;
import command_pattern.controllers.RemoteController;
import command_pattern.objects.CeilingFan;
import command_pattern.objects.GarageDoor;
import command_pattern.objects.Light;
import command_pattern.objects.Stereo;

public class RemoteLoader {

    public static void main(String[] args) {

        RemoteController remoteController = new RemoteController();

        Light livingRoomLight = new Light("Living room");
        Light kitchenLight = new Light("Kitchen");
        CeilingFan ceilingFan = new CeilingFan("Living room");
        GarageDoor garageDoor = new GarageDoor("");
        Stereo stereo = new Stereo("Living room");

        LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
        LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);
        LightOnCommand kitchenLightOn = new LightOnCommand(kitchenLight);
        LightOffCommand kitchenLightOff = new LightOffCommand(kitchenLight);
        CeilingFanOnCommand ceilingFanOn = new CeilingFanOnCommand(ceilingFan);
        CeilingFanOffCommand ceilingFanOff = new CeilingFanOffCommand(ceilingFan);
        GarageDoorUpCommand garageDoorUp = new GarageDoorUpCommand(garageDoor);
        GarageDoorDownCommand garageDoorDown = new GarageDoorDownCommand(garageDoor);
        StereoOnWithCDCommand stereoOnWithCD = new StereoOnWithCDCommand(stereo);
        StereoOffCommand stereoOff = new StereoOffCommand(stereo);

        remoteController.setCommand(0, livingRoomLightOn, livingRoomLightOff);
        remoteController.setCommand(1, kitchenLightOn, kitchenLightOff);
        remoteController.setCommand(2, ceilingFanOn, ceilingFanOff);
        remoteController.setCommand(3, garageDoorUp, garageDoorDown);
        remoteController.setCommand(4, stereoOnWithCD, stereoOff);

        System.out.println(remoteController);

        remoteController.onButtonWasPushed(0);
        remoteController.offButtonWasPushed(0);
        remoteController.onButtonWasPushed(1);
        remoteController.offButtonWasPushed(1);
        remoteController.onButtonWasPushed(2);
        remoteController.offButtonWasPushed(2);
        remoteController.onButtonWasPushed(3);
        remoteController.offButtonWasPushed(3);


    }

}
