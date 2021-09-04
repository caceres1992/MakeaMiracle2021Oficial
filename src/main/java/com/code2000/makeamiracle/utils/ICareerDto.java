package com.code2000.makeamiracle.utils;

import com.code2000.makeamiracle.model.Career;
import com.code2000.makeamiracle.model.Institute;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ICareerDto {

    CareerDto toCareerDto(Career careers);
    List<CareerDto> toCareerDtos( List<Career> careers);

}
