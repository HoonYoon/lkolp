package observable_pattern.java_impl;

import java.util.Observable;
import java.util.Observer;


public class CurrentConditionsDisplay implements Observer, DisplayElement {

    private Observable observable;
    private int temperature;
    private int pressure;

    public CurrentConditionsDisplay(Observable observable) {
        this.observable = observable;
        this.observable.addObserver(this);
    }

    @Override
    public void update(Observable observable, Object o) {
        if (observable instanceof WeatherData){
            WeatherData weatherData = (WeatherData) observable;
            this.temperature= weatherData.getTemperature();
            pressure = weatherData.getPressure();
            display();
        }
    }


    @Override
    public void display() {
        System.out.println(toString());
    }


    @Override
    public String toString() {
        return "CurrentConditionsDisplay{" +
                "temperature=" + temperature +
                ", pressure=" + pressure +
                '}';
    }
}
