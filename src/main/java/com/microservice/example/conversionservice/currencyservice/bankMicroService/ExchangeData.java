package com.microservice.example.conversionservice.currencyservice.bankMicroService;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Generated;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Setter
public class ExchangeData {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name="cur_from")
    private String from;
    @Column(name="cur_to")
    private String to;

    private BigDecimal conversionIndex;
    private int port;


    public ExchangeData() {}
    public ExchangeData(Long id, String curFrom, String curTO,BigDecimal conversionIndex ) {
        super();
        this.id = id;
        this.from = curFrom;
        this.to = curTO;
        this.conversionIndex = conversionIndex;

    }

    public void setPort(int port) {
        this.port = port;
    }

    public Long getId() {
        return id;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public BigDecimal getConversionIndex() {
        return conversionIndex;
    }

    public int getPort() {
        return port;
    }
}
