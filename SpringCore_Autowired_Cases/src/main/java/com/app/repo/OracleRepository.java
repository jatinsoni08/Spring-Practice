package com.app.repo;

import org.springframework.stereotype.Component;

@Component
public class OracleRepository implements MyRepository {

    public String getData() {
        return "Data from Oracle";
    }
}