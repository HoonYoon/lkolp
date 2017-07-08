package command_pattern.objects;

public class Stereo {

    private String place;

    public Stereo(String place) {
        this.place = place;
    }

    public void on() {
        System.out.println("Stereo is on");
    }

    public void off() {
        System.out.println("Stereo is off");
    }

    public void setCd() {
        System.out.println("Setting Cd on Stereo");
    }

    public void setDvd() {

    }

    public void setRadio() {

    }

    public void setVolume(int i) {
        System.out.println("Stereo is a volume " + i);
    }
}
