package com.code2000.makeamiracle.model;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    private String address;
    private String phone;
    private String email;
    private String nrDocument;
    private LocalDate dateOfBirth;
    private String gender;
    private LocalDate createAt;
    private Boolean isActive;

    //    foreing keys
    @ManyToOne
    private TypeDocument typeDocument;
    @ManyToOne
    private District district;

    @PrePersist
    void Prepersit (){
        createAt = LocalDate.now();
        isActive = true;

    }
}
