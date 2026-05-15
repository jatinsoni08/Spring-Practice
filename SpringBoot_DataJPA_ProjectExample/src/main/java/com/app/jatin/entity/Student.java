package com.app.jatin.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "student_tab")
@Data
public class Student {

    @Id
    @Column(name = "sid")
    private Integer stdId;

    @Column(name = "sname")
    private String stdName;

    @Column(name = "sfee")
    private Double stdFee;
}