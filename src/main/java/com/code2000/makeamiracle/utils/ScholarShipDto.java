package com.code2000.makeamiracle.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ScholarShipDto {
    Long id;
    String studentFullName;
    String sponsorFullName;
    String instituteName;
    String studentCode;
    String careerName;
    String createAt;
    String status;


    public ScholarShipDto() {

    }
}
