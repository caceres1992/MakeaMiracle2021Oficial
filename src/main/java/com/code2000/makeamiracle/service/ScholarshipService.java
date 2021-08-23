package com.code2000.makeamiracle.service;

import com.code2000.makeamiracle.model.Scholarship;
import com.code2000.makeamiracle.repository.ScholarshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ScholarshipService {

    @Autowired
    ScholarshipRepository repository;




    public List<Scholarship> findAll() {
        return repository.findAll();
    }
    public List<Scholarship> findAllDetails() {
        return repository.findAll();
    }




    public ResponseEntity<Scholarship> addScholarship(Scholarship scholarship) {
        return ResponseEntity.ok(repository.save(scholarship));
    }

    public ResponseEntity<Scholarship> findById(Long id) {
        Scholarship scholarship = repository.findById(id).orElseThrow(() -> new RuntimeException("Scholarship Not found"));
        return ResponseEntity.ok().body(scholarship);
    }

    public ResponseEntity<Scholarship> updateScholarShip(Long id, Scholarship scholarship) {
        Scholarship scholarshipUpdate = repository.findById(id).orElseThrow(() -> new RuntimeException("Scholarship Not found"));
        if (scholarship.getSponsor() != null) {
            scholarshipUpdate.setSponsor(scholarship.getSponsor());
        }
        if (scholarship.getCareer() != null) {
            scholarshipUpdate.setCareer(scholarship.getCareer());
        }
        if (scholarship.getStudent() != null) {
            scholarshipUpdate.setStudent(scholarship.getStudent());
        }
        if (scholarship.getStudentCode() != null) {
            scholarshipUpdate.setStudentCode(scholarship.getStudentCode());
        }
        return ResponseEntity.ok().body(repository.save(scholarshipUpdate));
    }


    ;


}
