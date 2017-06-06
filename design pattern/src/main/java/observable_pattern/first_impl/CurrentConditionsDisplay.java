package observable_pattern.first_impl;

public class CurrentConditionsDisplay implements Observer, DisplayElement {

    private int humidity;
    private int temperature;
    private Subject weatherData;

    public CurrentConditionsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(int temperature, int humidity) {
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    }

    @Override
    public void display() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "CurrentConditionsDisplay{" +
                "humidity=" + humidity +
                ", temperature=" + temperature +
                '}';
    }
}
