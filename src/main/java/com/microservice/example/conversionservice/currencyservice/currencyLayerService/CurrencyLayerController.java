package com.microservice.example.conversionservice.currencyservice.currencyLayerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CurrencyLayerController {
    @Autowired
    CurrencyLayerService currencyLayerService;

    @GetMapping("/cur-data/live/{live}")
    public List<CurrencyLayerBean> currencyData(@PathVariable String live) {
        return currencyLayerService.getCurrencyData();
    }
}