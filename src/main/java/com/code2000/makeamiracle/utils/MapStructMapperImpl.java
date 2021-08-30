package com.code2000.makeamiracle.utils;

import com.code2000.makeamiracle.model.Scholarship;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


@Component
public class MapStructMapperImpl implements IScholarShipDto {
    @Override
    public ScholarShipDto toScholarshipDto(Scholarship scholarship) {
        if (scholarship == null) {
            return null;
        }


        ScholarShipDto dto = new ScholarShipDto();
        String nameStudent = scholarship.getStudent().getName();
        String lastnameStudent = scholarship.getStudent().getLastName();

        String[] nameParts = nameStudent.split(" ");
        String[] lastNameParts = lastnameStudent.split(" ");
        String firstNameStudent = nameParts[0];
        String firstLastnameStudent = lastNameParts[0];

        dto.setId(scholarship.getId());
        dto.setCareerName(scholarship.getCareer().getName());
        dto.setSponsorFullName(scholarship.getSponsor().getName().concat(" ").concat(scholarship.getSponsor().getLastName()));
        dto.setStudentFullName(firstNameStudent.concat(" ").concat(firstLastnameStudent));
        dto.setInstituteName(scholarship.getCareer().getInstitute().getName());
        dto.setStudentCode(scholarship.getStudentCode());
        dto.setCreateAt(scholarship.getCreteAt());
        dto.setStatus(scholarship.getStatus());


        return dto;
    }

    @Override
    public List<ScholarShipDto> toScholarShipDts(List<Scholarship> scholarships) {
        if (scholarships == null) {
            return null;
        }
        List<ScholarShipDto> list = new ArrayList<>(scholarships.size());
        for (Scholarship scholarship : scholarships) {
            list.add(toScholarshipDto(scholarship));
        }
        return list;
    }


}
