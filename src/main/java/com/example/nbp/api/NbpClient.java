package com.example.nbp.api;

import com.example.nbp.service.NbpService;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.DayOfWeek;
import java.time.LocalDate;

@Component
public class NbpClient implements NbpService {

    private final RestTemplate restTemplate = new RestTemplate();
    private static final String currencyValue = "http://api.nbp.pl/api/exchangerates/rates/a/";
    private static final String average = "http://api.nbp.pl/api/cenyzlota/";

    public String getCurrencyForFiveBusinessDays(String currency){
        LocalDate now = LocalDate.now();
        LocalDate minusFive = subtractDaysAvoidWeekends(now, 5);
        return restTemplate.getForObject(currencyValue
        + "{currency}" + "/" + minusFive + "/" + now, String.class, currency);
    }

    public String getAverage(){
        LocalDate now = LocalDate.now();
        LocalDate minusFourteen = subtractDaysAvoidWeekends(now, 14);
        return restTemplate.getForObject(average + minusFourteen + "/" + now, String.class);
    }
    public LocalDate subtractDaysAvoidWeekends(LocalDate date, int days) {
        LocalDate result = date;
        int subtractedDays = 0;
        while (subtractedDays < days) {
            result = result.minusDays(1);
            if (!(result.getDayOfWeek() == DayOfWeek.SATURDAY || result.getDayOfWeek() == DayOfWeek.SUNDAY)) {
                ++subtractedDays;
            }
        }
        return result;
    }
}
