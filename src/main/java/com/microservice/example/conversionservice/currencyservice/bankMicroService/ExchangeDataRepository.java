package com.microservice.example.conversionservice.currencyservice.bankMicroService;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeDataRepository extends
        JpaRepository<ExchangeData, Long> {
    ExchangeData findByFromAndTo(String curFrom, String curTO);
}

