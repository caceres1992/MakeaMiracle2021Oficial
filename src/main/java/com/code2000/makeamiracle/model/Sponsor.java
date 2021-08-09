package com.code2000.makeamiracle.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Sponsor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    private String address;
    private String phone;
    private String email;
    @ManyToOne
    private Country country;
}
