package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.constants.Placeholders;
import net.engineeringdigest.journalApp.api.response.WeatherResponse;
import net.engineeringdigest.journalApp.appCache.AppCache;
import net.engineeringdigest.journalApp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    @Value("${weather.api.key}")
//    @Value("${weather_api_key}")
    private String apiKey;

//    private static final String API = "https://api.weatherstack.com/current?access_key=API_KEY&query=CITY";

    @Autowired
    private AppCache appCache;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RedisService redisService;

    public WeatherResponse getWeather(String city) {
        WeatherResponse weatherResponse = redisService.get("weather_of_" + city, WeatherResponse.class);
        if (weatherResponse != null) {
            return weatherResponse;
        } else {
            String finalAPI = appCache.appCache.get(AppCache.keys.WEATHER_API.toString()).replace(Placeholders.CITY, city).replace(Placeholders.API_KEY, apiKey);
            ResponseEntity<WeatherResponse> response = restTemplate.exchange(finalAPI, HttpMethod.GET, null, WeatherResponse.class);
            WeatherResponse body = response.getBody();
            if(body != null) {
                redisService.set("weather_of_" + city, body, 300l);
            }
            return body;
        }

    }

    public WeatherResponse post(String city) {
        String finalAPI = appCache.appCache.get(AppCache.keys.WEATHER_API.toString()).replace("CITY", city).replace("API_KEY", apiKey);

        String requestBody = "{\n" +
                "    \"userName\": \"vipul\",\n" +
                "    \"password\": \"vipul\"\n" +
                "}";
        HttpEntity<String> httpEntity1 = new HttpEntity<>(requestBody);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("key", "value");
        User user = User.builder().userName("vipul").password("vipul").build();
        HttpEntity<User> httpEntity = new HttpEntity<>(user, httpHeaders);

        ResponseEntity<WeatherResponse> response = restTemplate.exchange(finalAPI, HttpMethod.GET, httpEntity, WeatherResponse.class);
        WeatherResponse body = response.getBody();
        return body;
    }


}
