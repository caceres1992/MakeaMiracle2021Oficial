package com.code2000.makeamiracle.service;

import com.code2000.makeamiracle.config.ResourceNotFundException;
import com.code2000.makeamiracle.model.Scholarship;
import com.code2000.makeamiracle.repository.ScholarshipRepository;
import com.code2000.makeamiracle.utils.MapStructMapperImpl;
import com.code2000.makeamiracle.utils.ScholarShipDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ScholarshipService {

    @Autowired
    ScholarshipRepository repository;
    @Autowired
    MapStructMapperImpl mapperScholarShip;


    public List<Scholarship> findAll() {
        return repository.findAll();
    }


    public int countScholarShip() {
        return repository.findAll().size();
    }

    public ResponseEntity<ScholarShipDto> findDetailById(Long id) throws ResourceNotFundException {

        Scholarship scholarship = repository.findById(id).orElseThrow(() -> new ResourceNotFundException("ScholarShip Not found"));
        return new ResponseEntity<>(mapperScholarShip.toScholarShipDtsDetail(scholarship), HttpStatus.OK);
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
