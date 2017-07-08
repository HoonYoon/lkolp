package command_pattern.objects;

public class CeilingFan {

    public static final int HIGH = 3;
    public static final int MEDIUM = 2;
    public static final int LOW = 1;
    public static final int OFF = 0;
    private String location;
    int speed;

    public CeilingFan(String place) {
        this.location = place;
        speed = OFF;
    }

    public void high() {
        speed = HIGH;
    }

    public void medium() {
        speed = MEDIUM;
    }

    public void low() {
        speed = LOW;
    }

    public void offs() {
        speed = OFF;
    }

    public int getSpeed() {
        return speed;
    }

    public void on() {
        System.out.println("Ceiling fan on");
    }

    public void off() {
        System.out.println("Ceiling fan off");
    }
}
