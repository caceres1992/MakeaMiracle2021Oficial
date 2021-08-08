package com.code2000.makeamiracle.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Institute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    private TypeInstitute typeInstitute;


}
