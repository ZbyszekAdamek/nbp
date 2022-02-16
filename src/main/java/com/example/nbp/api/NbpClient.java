package com.example.nbp.api;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class NbpClient {

    private final RestTemplate restTemplate = new RestTemplate();
    private static final String currencyValue = "http://api.nbp.pl/api/exchangerates/rates/a/";
    private static final String average = "http://api.nbp.pl/api/cenyzlota/";

    public String getCurrency(String currency){
        return restTemplate.getForObject(currencyValue + "{currency}", String.class, currency);
    }

    public String getAverage(){
        return restTemplate.getForObject(average, String.class);
    }

}
