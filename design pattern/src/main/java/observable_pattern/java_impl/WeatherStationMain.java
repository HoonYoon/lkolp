package observable_pattern.java_impl;


public class WeatherStationMain {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData(10, 20, 15);
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);

        weatherData.setMeasurement(20, 45, 10);
        weatherData.setMeasurement(14, 20, 14);
        weatherData.setMeasurement(30, 41, 10);

    }

}
