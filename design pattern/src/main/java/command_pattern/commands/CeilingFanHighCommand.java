package command_pattern.commands;

import command_pattern.objects.CeilingFan;

public class CeilingFanHighCommand implements Command {

    private CeilingFan ceilingFan;
    private int prevSpeed;

    public CeilingFanHighCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void execute() {
        ceilingFan.high();
    }

    @Override
    public void undo() {

    }
}
