package command_pattern.objects;

public class Light {

    private String place;

    public Light(String place) {
        this.place = place;
    }

    public void on() {
        lightOn();
    }

    public void off() {
        lightOff();
    }

    public void lightOn() {
        System.out.println("Light is on");
    }

    public void lightOff() {
        System.out.println("Light is off");
    }

}
