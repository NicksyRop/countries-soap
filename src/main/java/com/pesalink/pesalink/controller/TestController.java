package com.pesalink.pesalink.controller;

import com.pesalink.pesalink.service.PesaLinkService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pesalink")
public class TestController {
    private  final  PesaLinkService pesaLinkService;

    public TestController(PesaLinkService pesaLinkService) {
        this.pesaLinkService = pesaLinkService;
    }

    @GetMapping("test")
    public String invokeMashaller(){
      return pesaLinkService.testXml();
    }
}
