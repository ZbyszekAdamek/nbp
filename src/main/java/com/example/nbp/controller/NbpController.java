package com.example.nbp.controller;

import com.example.nbp.api.NbpClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Controller
@RequiredArgsConstructor
public class NbpController {

    private final NbpClient nbpClient;

    @GetMapping("/")
    public String initAddFom() {
        return "home";
    }

    @GetMapping("/{currency}")
    public String getCurrency(@PathVariable String currency){
        return nbpClient.getCurrencyForFiveBusinessDays(currency);
    }

    @GetMapping("/api/exchange-rates/{currencyCode}")
    public String getCurrencyForFiveBusinessDays(@PathVariable String currencyCode){
        return nbpClient.getCurrency(currencyCode);
    }

    @GetMapping(" /api/gold-price/avarage")
    public String getGold(){
        return nbpClient.getGold();
    }

}
