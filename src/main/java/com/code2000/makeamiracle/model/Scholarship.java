package com.code2000.makeamiracle.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class Scholarship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate creteAt ;
    private LocalDate finishAt;
    private String observation;
    private String studentCode;

    //    foreing keys
    @ManyToOne
    private Career career;
    @ManyToOne
    private Student student;
    @ManyToOne
    private Sponsor sponsor;
    @ManyToOne
    private Employee employee;
    private String status;




}
