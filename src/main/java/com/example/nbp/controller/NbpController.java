package com.example.nbp.controller;

import com.example.nbp.api.NbpClient;
import com.example.nbp.service.NbpService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class NbpController {

    private final NbpService nbpService;
    private final NbpClient nbpClient;



}
