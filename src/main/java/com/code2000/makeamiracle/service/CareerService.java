package com.code2000.makeamiracle.service;

import com.code2000.makeamiracle.model.Career;
import com.code2000.makeamiracle.model.Institute;
import com.code2000.makeamiracle.repository.CareerRepository;
import com.code2000.makeamiracle.repository.InstituteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CareerService {


    @Autowired
    InstituteRepository instituteRepository;
    @Autowired
    CareerRepository careerRepository;

    public List<Career> getAllCareer() {
        return careerRepository.findAll();
    }

    public ResponseEntity<?> saveCareer(List<Career> list, String nameInstitute) {

        List<Career> nuevaLista = new ArrayList<>();
        Institute getInttute = addInstitute(nameInstitute);


        for (Career career : list) {

            career.setInstitute(getInttute);
            nuevaLista.add(career);
            careerRepository.saveAll(nuevaLista);
        }

        return null;
    }

    public Institute addInstitute(String nameinstitute) {

        Institute nuevoInstituto = new Institute();


        Institute validarInstituto;
        if (instituteRepository.existsByName(nameinstitute.toUpperCase())) {
            validarInstituto = instituteRepository.getInstituteByName(nameinstitute.toUpperCase());
        } else {
            nuevoInstituto.setName(nameinstitute.toUpperCase());
            validarInstituto = instituteRepository.save(nuevoInstituto);
        }

        return validarInstituto;


    }
}
