package com.code2000.makeamiracle.controller;


import com.code2000.makeamiracle.config.ResourceNotFundException;
import com.code2000.makeamiracle.model.Career;
import com.code2000.makeamiracle.service.CareerService;
import com.code2000.makeamiracle.utils.CareerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/career")
@CrossOrigin
public class CareerController {


    @Autowired
    CareerService service;

    @GetMapping
    public List<Career> getAllCareer() {
        return service.getAllCareer();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCareerByInstitute(@PathVariable Long id) {
        return service.getCareerByInstitute(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CareerDto> updateCareer(@PathVariable Long id, @RequestBody Career career) throws ResourceNotFundException {
        return service.dtoResponseEntity(id, career);
    }

}
