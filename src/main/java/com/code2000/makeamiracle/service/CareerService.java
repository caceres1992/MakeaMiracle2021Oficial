package com.code2000.makeamiracle.service;

import com.code2000.makeamiracle.config.ResourceNotFundException;
import com.code2000.makeamiracle.model.Career;
import com.code2000.makeamiracle.model.Institute;
import com.code2000.makeamiracle.repository.CareerRepository;
import com.code2000.makeamiracle.repository.InstituteRepository;
import com.code2000.makeamiracle.utils.CareerDto;
import com.code2000.makeamiracle.utils.CareerDtoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
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

    public ResponseEntity<List<CareerDto>> getCareerByInstitute(Long id) {

        CareerDtoImpl careerDto = new CareerDtoImpl();
        List<CareerDto> careerDtoList = careerDto.toCareerDtos(careerRepository.findByInstituteId(id));
        if (careerDtoList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(careerDtoList, HttpStatus.OK);
    }


    public ResponseEntity<CareerDto> dtoResponseEntity(Long id, Career career) throws ResourceNotFundException {
        Career updateCareer = careerRepository.findById(id).orElseThrow(
                () -> new ResourceNotFundException("not found career with id " + id)
        );

        if (career.getName() != null) {
            updateCareer.setName(career.getName());
            careerRepository.save(updateCareer);
        }
        CareerDto dto = new CareerDto();
        dto.setNameCareer(updateCareer.getName());
        dto.setId(id);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);

    }

}
