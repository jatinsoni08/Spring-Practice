package com.app.repo;

import org.springframework.stereotype.Component;

@Component
public class MySQLRepository implements MyRepository {

    public String getData() {
        return "Data from MySQL";
    }
}