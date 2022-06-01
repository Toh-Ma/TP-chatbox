package fr.ensim.interop.introrest.model.weather;

import java.util.List;

public class Forecast {
    private String city;
    private Main main;
    private List<model.apoen.weather.Weather> weather;
    private Wind wind;

    public Forecast() {
    }

    @Override
    public String toString() {
        return "Today weather in " + city + " :\n\n" +
                "-Weather : " + weather.get(0).getDescription() +
                "\n-Temperature : " + main.getTemp() + "°C" +
                "\n-Minimum temperature : " + main.getTemp_min() + "°C" +
                "\n-Maximum  : " + main.getTemp_max() + "°C" +
                "\n-Humidity : " + main.getHumidity() + "%" +
                "\n-Wind : " + wind.getSpeed() + " m/s at " + wind.getDeg() + "°";
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public List<model.apoen.weather.Weather> getWeather() {
        return weather;
    }

    public void setWeeather(List<model.apoen.weather.Weather> weather) {
        this.weather = weather;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
