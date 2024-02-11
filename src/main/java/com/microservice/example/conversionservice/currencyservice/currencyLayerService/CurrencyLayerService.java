package com.microservice.example.conversionservice.currencyservice.currencyLayerService;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CurrencyLayerService {

    @Value("${currency.data.url.api}")
    private String currencyDataUrl;

    @Value("${currency.data.api.token}")
    private String currencyDataToken;

    @Autowired
    RestTemplate restTemplate;

    @SneakyThrows
    public List<CurrencyLayerBean> getCurrencyData() {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity( currencyDataUrl + currencyDataToken,String.class);
        ObjectMapper mapper = new ObjectMapper();
        List<String> data = new ArrayList<>();
        Map<String, String> dataSet = new HashMap<>();
        JsonFactory factory = new JsonFactory();
        JsonParser jsonParser = null;
        jsonParser = factory.createParser(responseEntity.getBody());
        while (!jsonParser.isClosed()) {
            if (jsonParser.nextToken() == JsonToken.FIELD_NAME) {
                data.add((jsonParser.getCurrentName()));
            }
        }
        JsonNode node = mapper.readTree(responseEntity.getBody());
        for(int i = 1; i <data.size(); i++) {
            dataSet.put(data.get(i), String.valueOf(node.at("/data/" + data.get(i))));
        }
        List<CurrencyLayerBean> result = new ArrayList<>();
        for(int i = 1; i < data.size(); i++) {
            for(int j = 1; j < data.size();j++) {
                CurrencyLayerBean promBean = new CurrencyLayerBean();
                promBean.setFrom(data.get(i));
                if(i != j) {
                    promBean.setTo(data.get(j));
                    Double mulIndex = Double.parseDouble(dataSet.get(data.get(j))) / Double.parseDouble(dataSet.get(data.get(i)));
                    promBean.setConversionIndex(BigDecimal.valueOf(mulIndex)); // need to fix
                }
                result.add(promBean);
            }
        }
        return result;
    }
}