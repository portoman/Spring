package com.portoman.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties("limits")
public class LimitsProperties {
    
    
    private int min;//Estos valores min y max, los coge Spring de application.properties
    private int max;

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public LimitsProperties() {
    }

    public LimitsProperties(int min, int max) {
        this.min = min;
        this.max = max;
    }
    
    
    
}
