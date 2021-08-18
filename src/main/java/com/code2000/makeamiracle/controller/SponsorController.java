package com.code2000.makeamiracle.controller;

import com.code2000.makeamiracle.model.Sponsor;
import com.code2000.makeamiracle.model.Student;
import com.code2000.makeamiracle.service.SponsorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sponsor")
@CrossOrigin
public class SponsorController {


    @Autowired
    SponsorService service;



    @GetMapping
    public ResponseEntity<?> findAll() {
        return service.findAll();
    }

    @GetMapping("/count")
    public ResponseEntity<?> countAllSponsor() {
        return service.countAllSponsor();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) throws Throwable {
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<?> addSponsor(@RequestBody Sponsor sponsor) {
        return service.addSponsor(sponsor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateSponsor(@PathVariable Long id, @RequestBody Sponsor sponsor) throws Exception {
        return service.updateSponsor(id, sponsor);
    }


}
