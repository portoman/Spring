package com.portoman.currencyexchangeservice.controller;

import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {
    
    @Autowired
    private Environment environment;
    
    @GetMapping("/currency-exchange/from/{from}/to/{to}")//EUR USD
    public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to){
        ExchangeValue exchangeValue= new ExchangeValue(1000L, from, to, BigDecimal.valueOf(1.62));
        int port =Integer.parseInt(environment.getProperty("local.server.port"));
        exchangeValue.setPort(port);
        return exchangeValue;
    }
}
