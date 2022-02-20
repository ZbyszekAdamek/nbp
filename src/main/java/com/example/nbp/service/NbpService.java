package com.example.nbp.service;

import java.time.LocalDate;


public interface NbpService {

    String getCurrencyForFiveBusinessDays(String currency);
    String getAverage();
    LocalDate subtractDaysAvoidWeekends(LocalDate date, int days);

}
