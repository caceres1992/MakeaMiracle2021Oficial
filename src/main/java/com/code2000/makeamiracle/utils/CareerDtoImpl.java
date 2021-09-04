package com.code2000.makeamiracle.utils;

import com.code2000.makeamiracle.model.Career;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CareerDtoImpl implements ICareerDto {
    @Override
    public CareerDto toCareerDto(Career career) {

        CareerDto careerDto = new CareerDto();
        careerDto.setId(career.getId());
        careerDto.setNameCareer(career.getName());

        return careerDto;
    }

    @Override
    public List<CareerDto> toCareerDtos(List<Career> careers) {
        List<CareerDto> listdto = new ArrayList<>();


        for (Career career : careers) {
            listdto.add(toCareerDto(career));
        }
        return listdto;
    }
}
