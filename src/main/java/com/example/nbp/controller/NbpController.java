package com.example.nbp.controller;

import com.example.nbp.api.NbpClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class NbpController {

    private final NbpClient nbpClient;

    @GetMapping("/")
    public String initAddFom() {
        return "home";
    }

    @GetMapping("api/exchange-rates/{currencyCode}")
    @ResponseBody
    public String showCurrency(@PathVariable String currencyCode){
        return nbpClient.getCurrency(currencyCode);
    }

    @GetMapping(" /average")
    public String showAverage(){
        return nbpClient.getAverage();
    }

}
