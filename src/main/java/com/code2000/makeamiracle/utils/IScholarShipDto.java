package com.code2000.makeamiracle.utils;

import com.code2000.makeamiracle.model.Scholarship;

import org.mapstruct.Mapper;

import java.util.List;


@Mapper
public interface IScholarShipDto {
  ScholarShipDto toScholarshipDto(Scholarship scholarship);
  List<ScholarShipDto> toScholarShipDts(List<Scholarship> scholarships);
  ScholarShipDto  toScholarShipDtsDetail(Scholarship scholarship);

}
