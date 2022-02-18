package com.example.nbp.controller;

import com.example.nbp.api.NbpClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Controller
@RequiredArgsConstructor
public class NbpController {

    private final NbpClient nbpClient;

    @GetMapping("/api/exchange-rates/{currencyCode}")
    public String getCurrencyForFiveBusinessDays(@PathVariable String currencyCode){
        return nbpClient.getCurrencyForFiveBusinessDays(currencyCode);
    }

    @GetMapping("/api/gold-price/avarage")
    public String getTest(){
        return nbpClient.getAverage();
    }
}
