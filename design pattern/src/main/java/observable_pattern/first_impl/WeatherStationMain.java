package observable_pattern.first_impl;


public class WeatherStationMain {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData(10,20,58);
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);

        weatherData.setMeasurements(60,10,84);
        weatherData.setMeasurements(10,54,74);
        weatherData.setMeasurements(15,12,63);
    }

}
