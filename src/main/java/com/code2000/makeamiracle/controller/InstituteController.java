package com.code2000.makeamiracle.controller;

import com.code2000.makeamiracle.config.ResourceNotFundException;
import com.code2000.makeamiracle.model.Career;
import com.code2000.makeamiracle.model.Institute;
import com.code2000.makeamiracle.service.IntituteService;
import com.code2000.makeamiracle.utils.InstituteDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/institute")
@CrossOrigin
public class InstituteController {


    @Autowired
    IntituteService service;

    @GetMapping
    public ResponseEntity<?> findAll() {

        return service.findAllInstitute();

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateInstitute(@PathVariable Long id, @RequestBody Institute institute) {
        return service.updateInstitute(id, institute);
    }

    @PostMapping("/dto")
    public ResponseEntity<?> addMoreCareer(@RequestBody InstituteDto institute) {
        return service.addMoreCareer(institute);
    }
}
