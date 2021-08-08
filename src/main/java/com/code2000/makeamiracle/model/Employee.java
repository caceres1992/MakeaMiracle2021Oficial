package com.code2000.makeamiracle.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    private Boolean isActive;
    @OneToOne
    private User user;
}
