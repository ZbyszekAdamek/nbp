package com.example.nbp.service;

import java.time.LocalDate;


public interface NbpService {

    String getCurrencyForFiveBusinessDays(String currency);
    String getAverage();
    LocalDate subtractDaysSkippingWeekends(LocalDate date, int days);

}
