package com.code2000.makeamiracle.service;

import com.code2000.makeamiracle.config.ResourceNotFundException;
import com.code2000.makeamiracle.model.Career;
import com.code2000.makeamiracle.model.Institute;
import com.code2000.makeamiracle.repository.CareerRepository;
import com.code2000.makeamiracle.repository.InstituteRepository;
import com.code2000.makeamiracle.utils.InstituteDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class IntituteService {


    @Autowired
    InstituteRepository repository;
    @Autowired
    CareerRepository careerRepository;


    public ResponseEntity<?> findAllInstitute() {
        return ResponseEntity.ok(repository.findAll());

    }


    public ResponseEntity<?> addInstituteAndCareer(Institute institute) {

        return ResponseEntity.ok(repository.save(institute));
    }


    public ResponseEntity<?> addMoreCareer(InstituteDto dto) {

        try {
            Institute addInstitute = repository.save(dto.getInstitute());

            List<Career> careerList = careerRepository.saveAll(dto.getCareer());
            for (Career career : careerList) {
                career.setInstitute(addInstitute);
            }

            return ResponseEntity.ok("enviando correctamente");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al enviar ");

        }

    }

    public ResponseEntity<?> updateInstitute(Long id, Institute institute) {


            Institute updateInstitute = repository.findById(id).orElseThrow(() -> new RuntimeException("Institute does not exist with id ".concat(institute.getId().toString())));

            if (institute.getName() != null) {
                updateInstitute.setName(institute.getName());
            }
            if (institute.getTypeInstitute() != null) {
                updateInstitute.setTypeInstitute(institute.getTypeInstitute());
            }
            repository.save(updateInstitute);
            return ResponseEntity.ok("update successfully");


    }
}
