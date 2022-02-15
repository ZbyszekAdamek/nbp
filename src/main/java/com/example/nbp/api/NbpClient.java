package com.example.nbp.api;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class NbpClient {

    private final RestTemplate restTemplate = new RestTemplate();
    private static final String currency = "http://api.nbp.pl/api/";
    private static final String average = "http://api.nbp.pl/api/";

    public String getCurrency(String currency){
        return restTemplate.getForObject(currency + "{currencyCode}", String.class, currency);
    }

    public String getAverage(){
        return restTemplate.getForObject(average + "gold-price/average", String.class);
    }

}
