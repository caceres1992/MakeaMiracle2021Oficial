package com.code2000.makeamiracle.controller;

import com.code2000.makeamiracle.model.Student;
import com.code2000.makeamiracle.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentCotroller {


    @Autowired
    StudentService service;

    @GetMapping
    public ResponseEntity<?> findAll() {
        return service.findAll();
    }

    @GetMapping("/count")
    public ResponseEntity<?> countAllStudent() {
        return service.countAllStudent();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) throws Throwable {
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<?> addStudent(@RequestBody Student student) {
        return service.addStudent(student);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable Long id, @RequestBody Student student) throws Exception {
        return service.updateStudent(id, student);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> isActive(@PathVariable Long id) throws Exception {
        return service.isActive(id);
    }


}
