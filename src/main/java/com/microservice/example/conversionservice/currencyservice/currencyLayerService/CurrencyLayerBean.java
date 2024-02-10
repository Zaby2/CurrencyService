package com.microservice.example.conversionservice.currencyservice.currencyLayerService;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@Setter
public class CurrencyLayerBean {
    private String from;
    private String to;
    private BigDecimal conversionIndex;
    public CurrencyLayerBean(){}
}
