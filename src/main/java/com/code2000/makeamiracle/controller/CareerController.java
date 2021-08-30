package com.code2000.makeamiracle.controller;


import com.code2000.makeamiracle.model.Career;
import com.code2000.makeamiracle.service.CareerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@CrossOrigin
public class CareerController {


    @Autowired
    CareerService service;

    @GetMapping
    public List<Career> getAllCareer() {
        return service.getAllCareer();
    }

    @PostMapping
    public ResponseEntity<?> saveCareer(@RequestBody List<Career> careers,@PathVariable String string) {
        return service.saveCareer(careers,string);
    }
}
