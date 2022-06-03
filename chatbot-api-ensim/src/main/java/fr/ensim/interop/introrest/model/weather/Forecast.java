package fr.ensim.interop.introrest.model.weather;

import java.util.List;

public class Forecast {
    private String name;
    private Main main;
    private List<Weather> weather;
    private Wind wind;

    public Forecast() {
    }

    @Override
    public String toString() {
        return "Today's weather in " + name + " :\n\n" +
                "-Weather : " + weather.get(0).getDescription() +
                "\n-Temperature : " + main.getTemp() + "°C" +
                "\n-Minimum temperature : " + main.getTemp_min() + "°C" +
                "\n-Maximum  : " + main.getTemp_max() + "°C" +
                "\n-Humidity : " + main.getHumidity() + "%" +
                "\n-Wind : " + wind.getSpeed() + " m/s at " + wind.getDeg() + "°" +
                " http://openweathermap.org/img/wn/"+weather.get(0).getIcon()+"@4x.png";
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeeather(List<Weather> weather) {
        this.weather = weather;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
