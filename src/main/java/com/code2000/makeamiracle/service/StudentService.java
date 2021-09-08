package com.code2000.makeamiracle.service;


import com.code2000.makeamiracle.model.Student;
import com.code2000.makeamiracle.repository.StudentRepository;
import com.code2000.makeamiracle.utils.StudentDto;
import com.code2000.makeamiracle.utils.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class StudentService {

    @Autowired
    StudentRepository repository;

    @Autowired
    StudentMapper studentMapper;

    public ResponseEntity<?> findAll() {
        if (repository.findAll().size() == 0) {
            return ResponseEntity.ok().body("no hay nada que mostrar");
        } else
            return ResponseEntity.ok().body(repository.findAll());
    }

    public ResponseEntity<Integer> countAllStudent() {
        return ResponseEntity.ok(repository.findAll().size());
    }


    public ResponseEntity<?> getStudentToSelect() {

        return ResponseEntity.ok().body(studentMapper.toStudentDts(repository.findAll()));
    }


    public ResponseEntity<?> addStudent(Student student) {
        repository.save(student);
        return ResponseEntity.ok().body("student " + student.getName().concat(" ").concat(student.getLastName()) + " successfully");
    }

    public ResponseEntity<?> findById(Long id) throws Throwable {
        Student student = repository.findById(id).orElseThrow(() -> new Exception("Student not found with id : " + id));
        return ResponseEntity.ok().body(student);
    }


    public ResponseEntity<?> updateStudent(Long id, Student studentUpdate) throws Exception {
        Student student = repository.findById(id).orElseThrow(() -> new Exception("Student not found with id : " + id));

        if (repository.existsById(id)) {
            student.setName(studentUpdate.getName());
            student.setLastName(studentUpdate.getLastName());
            student.setDistrict(studentUpdate.getDistrict());
            student.setEmail(studentUpdate.getEmail());
            student.setGender(studentUpdate.getGender());
            student.setDateOfBirth(studentUpdate.getDateOfBirth());
            student.setPhone(studentUpdate.getPhone());
            student.setAddress(studentUpdate.getAddress());
            student.setNrDocument(studentUpdate.getNrDocument());
            student.setTypeDocument(studentUpdate.getTypeDocument());
            return ResponseEntity.ok().body(repository.save(student));
        }
        return null;
    }

    public ResponseEntity<?> isActive(Long id) throws Exception {
        Student student = repository.findById(id).orElseThrow(() -> new Exception("Student not found with id : " + id));
        if (repository.existsById(id)) {
            student.setIsActive(!student.getIsActive());
        }

        return ResponseEntity.ok().body("student is " + (student.getIsActive() ? "enable " : " disable"));
    }
}
