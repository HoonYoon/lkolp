package command_pattern.objects;

public class GarageDoor {

    private String place;

    public GarageDoor(String place) {
        this.place = place;
    }

    public void up() {
        System.out.println("Garage door is open");
    }

    public void down() {
        System.out.println("Garage door is down");
    }

    public void stop() {

    }

    public void lightOn() {

    }

    public void lightOff() {

    }

}
