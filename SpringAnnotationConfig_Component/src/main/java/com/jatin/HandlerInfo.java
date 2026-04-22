package com.jatin;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("hob")   // yeh class Spring container me bean ban jayegi

public class HandlerInfo {

    @Value("data")   // simple value inject ho rahi hai
    private String resolverCode;

    @Value("temp")   // dusri value inject ho rahi hai
    private String pathToStore;

    public HandlerInfo() {
        super();
        // constructor call hote hi object create hoga
    }

    @Override
    public String toString() {
        // object print karne ke liye override kiya hai
        return "HandlerInfo [resolverCode=" + resolverCode +
               ", pathToStore=" + pathToStore + "]";
    }
}