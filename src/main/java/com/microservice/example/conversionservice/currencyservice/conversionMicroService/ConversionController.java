package com.microservice.example.conversionservice.currencyservice.conversionMicroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ConversionController {

    @Autowired
    RestTemplate restTemplate;
    @Value("${conversion.url}")
    private String url;
    @GetMapping("/conv-cur/from/{from}/to/{to}/quantity/{quantity}")
    public ConversionBean conversion(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
        Map<String, String > pathVariables = new HashMap<>();
        pathVariables.put("from", from);
        pathVariables.put("to", to);
        ResponseEntity<ConversionBean> response = restTemplate.getForEntity(url, ConversionBean.class, pathVariables );
        ConversionBean result = response.getBody();
        return new ConversionBean(result.getId(), from, to, result.getConversionIndex(), quantity, quantity.multiply(result.getConversionIndex()), result.getPort());

    }
}
