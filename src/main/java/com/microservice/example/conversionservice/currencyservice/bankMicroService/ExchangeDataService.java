package com.microservice.example.conversionservice.currencyservice.bankMicroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ExchangeDataService {

    @Autowired
    private ExchangeDataRepository rep;

    @Autowired
    Environment environment;


    @Scheduled(fixedRate = 130000)
    private void reStoreData() {
        rep.deleteAll();
        ResponseEntity<List<ExchangeData>> response = new RestTemplate().exchange("http://localhost:1234/cur-data/live/live" ,HttpMethod.GET, null,new ParameterizedTypeReference<List<ExchangeData>>() {}) ;
        // need to remove this hardcode
        List<ExchangeData> result = response.getBody();
        for (ExchangeData exchangeData : result) {
            rep.save(exchangeData);
        }
    }

    public ExchangeData findByFromAndTo(String curFrom, String curTO) {
        //reStoreData();
        ExchangeData exD = rep.findByFromAndTo(curFrom, curTO);
        exD.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
        return exD;
    }

}
