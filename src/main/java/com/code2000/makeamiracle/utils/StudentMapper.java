package com.code2000.makeamiracle.utils;

import com.code2000.makeamiracle.model.Student;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Mapper
@Component
public class StudentMapper {


    public StudentDto toStudentDto(Student student) {

        if (student == null)
            return null;

        StudentDto studentDto = new StudentDto();

        studentDto.setName(student.getName());
        studentDto.setLastname(student.getLastName());
        studentDto.setId(student.getId());
        studentDto.setDni(student.getNrDocument());

        return studentDto;
    }

    public List<StudentDto> toStudentDts(List<Student> students) {

        if (students == null) {
            return null;
        }
        List<StudentDto> list = new ArrayList<>();

        for (Student student : students) {
            list.add(toStudentDto(student));
        }

        return list;
    }

}
