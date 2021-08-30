package com.code2000.makeamiracle.utils;

import com.code2000.makeamiracle.model.Career;
import com.code2000.makeamiracle.model.Institute;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface IInstiteDto {

    List<InstituteDto> toInstituteDto(Institute institute,Career careers);
    List<Career> toCareerDto(Institute institute, List<Career> careers);

}
