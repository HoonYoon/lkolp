package observable_pattern.java_impl;

import java.util.Observable;

public class WeatherData extends Observable{

    private int temperature;
    private int humidity;
    private int pressure;

    public WeatherData(int temperature, int humidity, int pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
    }

    public void measurementChanged() {
        setChanged();
        notifyObservers();
    }

    public void setMeasurement(int temperature, int humidity, int pressure) {

        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementChanged();

    }

    public int getTemperature() {
        return temperature;
    }

    public int getHumidity() {
        return humidity;
    }

    public int getPressure() {
        return pressure;
    }
}
