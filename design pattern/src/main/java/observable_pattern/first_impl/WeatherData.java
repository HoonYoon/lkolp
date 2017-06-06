package observable_pattern.first_impl;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject {

    private List<Observer> observerList;
    private int temperature;
    private int humidity;
    private int pressure;

    public WeatherData(int temperature, int humidity, int pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        this.observerList = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        observerList.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        int i = observerList.indexOf(o);

        if (i >= 0)
            observerList.remove(i);

    }

    @Override
    public void notifyObserver() {
        observerList.forEach(observer -> observer.update(temperature, humidity));
    }

    public void measurementChanged() {
        notifyObserver();
    }

    public void setMeasurements(int temperature, int humidity, int pressure) {
        this.pressure = pressure;
        this.temperature = temperature;
        this.humidity = humidity;
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
