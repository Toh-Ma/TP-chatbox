package fr.ensim.interop.introrest.controller;


import fr.ensim.interop.introrest.model.weather.Forecast;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

@RestController
public class WeatherRestController {
    private static String apiUrl, apiToken;

    //récupère les variable d'environnement dans application.properties
    @Value("${open.weather.api.url}")
    public void setApiUrl(String url){apiUrl = url;}

    @Value("${open.weather.api.token}")
    public void setApiToken(String token){apiToken = token;}


    static RestTemplate restTemplate = new RestTemplate();

//    Retourne la météo d'une ville donnée en utilisant l'api OpenWeather
    @GetMapping("/weather")
    public static ResponseEntity<Forecast> getWeatherForecast(@RequestParam("city") String city){
        final String query = apiUrl + "weather?q=" + city +"&appid="+ apiToken +"&units=metric";
        try {
            Forecast forecast = restTemplate.getForObject(query, Forecast.class);
            return ResponseEntity.ok().body(forecast);
        }catch (HttpStatusCodeException exception){
            return null;
        }
    }



}
