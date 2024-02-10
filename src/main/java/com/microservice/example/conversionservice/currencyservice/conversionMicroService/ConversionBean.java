package com.microservice.example.conversionservice.currencyservice.conversionMicroService;

import java.math.BigDecimal;

public class ConversionBean {
    private Long id;
    private String from;
    private String to;
    private BigDecimal conversionIndex;
    private BigDecimal quantity;
    private BigDecimal totalAmount;
    private int port;

    public ConversionBean() {}

    public int getPort() {
        return port;
    }

    public ConversionBean(Long id, String from, String to, BigDecimal convM, BigDecimal quantity, BigDecimal totalAmount, int port) {
        super();
        this.conversionIndex = convM;
        this.from = from;
        this.to = to;
        this.id = id;
        this.quantity = quantity;
        this.totalAmount = totalAmount;
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

    public BigDecimal getQuantity() {
        return quantity;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }
}
