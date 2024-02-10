package com.microservice.example.conversionservice.currencyservice.bankMicroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    Environment environment;

    @Autowired
    private ExchangeDataRepository rep;

    @Autowired
    private ExchangeDataService exchangeDataService;

    @GetMapping("/cur-ex/from/{curFrom}/to/{curTO}")
    public ExchangeData retrieveExchangeValue
            (@PathVariable String curFrom, @PathVariable String curTO){

        return exchangeDataService.findByFromAndTo(curFrom, curTO);
    }
}
