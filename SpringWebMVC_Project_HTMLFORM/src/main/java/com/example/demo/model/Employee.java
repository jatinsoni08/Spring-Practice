package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private int eid;
    private String ename;
    private double esal;
    private String epwd;
    private String edept;
    private String eaddr;
}