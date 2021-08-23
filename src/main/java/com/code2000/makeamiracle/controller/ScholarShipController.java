package com.code2000.makeamiracle.controller;

import com.code2000.makeamiracle.model.Scholarship;
import com.code2000.makeamiracle.service.ScholarshipService;
import com.code2000.makeamiracle.utils.ScholarShipDto;
import com.code2000.makeamiracle.utils.IScholarShipDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/scholarship")
@CrossOrigin
public class ScholarShipController {


    private final IScholarShipDto scholarShipDto;
    @Autowired
    ScholarshipService service;


    @GetMapping
    public ResponseEntity<List<ScholarShipDto>> findByNameInstiteAndCarrerAndSponsor() {
        return ResponseEntity.ok(scholarShipDto.toScholarShipDts(service.findAll()));
    }

    @PostMapping
    public ResponseEntity<?> addScholarShip(@RequestBody Scholarship scholarship) {
        return ResponseEntity.ok().body(service.addScholarship(scholarship));
    }


    @PutMapping
    public ResponseEntity<?> updateScholarShip(@RequestBody Scholarship scholarship, @PathVariable Long id) {

        Map<String, Object> response = new HashMap<>();
        try {
            response.put("scholarship", service.updateScholarShip(id, scholarship));
            response.put("menssage", "succees");

        } catch (Exception e) {
            response.put("menssage", "fail");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
