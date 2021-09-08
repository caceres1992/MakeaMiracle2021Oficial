package com.code2000.makeamiracle.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@AllArgsConstructor
@Data
public class ScholarShipDto {
  private  Long id;
  private  String studentFullName;
  private  String sponsorFullName;
  private  String instituteName;
  private  String studentCode;
  private  String careerName;
  private  LocalDate createAt;
  private  LocalDate finishAt;
  private  String description;
  private  String status;


    public ScholarShipDto() {

    }
}
