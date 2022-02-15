package com.example.nbp.service;

import com.example.nbp.api.NbpClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class NbpService {

    private final NbpClient nbpClient;

    public String getCurrency(String currency){
        return nbpClient.getCurrency(currency);
    }

    public String getAverage(){
        return nbpClient.getAverage();
    }

}
