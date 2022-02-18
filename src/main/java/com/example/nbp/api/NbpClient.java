package com.example.nbp.api;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@Component
public class NbpClient {

    private final RestTemplate restTemplate = new RestTemplate();
    private static final String currencyValue = "http://api.nbp.pl/api/exchangerates/rates/a/";
    private static final String average = "http://api.nbp.pl/api/cenyzlota/";

    public String getCurrency(String currency){
        return restTemplate.getForObject(currencyValue + "{currency}", String.class, currency);
    }

    public String getCurrencyForFiveBusinessDays(String currency){
        LocalDate now = LocalDate.now();
        LocalDate minusFive = now.minusDays(6);
        return restTemplate.getForObject(currencyValue
        + "{currency}" + "/" + minusFive + "/" + now, String.class, currency);
    }

    public String getAverage(){
        LocalDate now = LocalDate.now();
        LocalDate minusFourteen = now.minusDays(15);
        return restTemplate.getForObject(average + minusFourteen + "/" + now, String.class);
    }
}
