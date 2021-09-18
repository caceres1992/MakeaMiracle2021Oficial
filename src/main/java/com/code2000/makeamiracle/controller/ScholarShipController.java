package com.code2000.makeamiracle.controller;

import com.code2000.makeamiracle.config.ResourceNotFundException;
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
@RequestMapping("/scholarships")
@CrossOrigin
public class ScholarShipController {


    private final IScholarShipDto scholarShipDto;
    @Autowired
    ScholarshipService service;


    @GetMapping
    public ResponseEntity<List<ScholarShipDto>> findByNameInstiteAndCarrerAndSponsor() {
        return ResponseEntity.ok(scholarShipDto.toScholarShipDts(service.findAll()));
    }

    @GetMapping("/{pageNo}/{pageSize}")
    public ResponseEntity<List<ScholarShipDto>> paginatorScholarShipList(@PathVariable int pageNo, @PathVariable int pageSize) {
        return ResponseEntity.ok(service.findAll2(pageNo, pageSize));
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<ScholarShipDto> findDetailById(@PathVariable Long id) throws ResourceNotFundException {
        return service.findDetailById(id);
    }

    @GetMapping("/count")
    public ResponseEntity<?> countScholarShip() {
        return ResponseEntity.ok().body(service.countScholarShip());
    }

    @PostMapping
    public ResponseEntity<?> addScholarShip(@RequestBody Scholarship scholarship) {
        return ResponseEntity.ok().body(service.addScholarship(scholarship));
    }


    @PutMapping("/{id}")
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

    @PatchMapping("/status/{id}")
    public ResponseEntity<Scholarship> updateStatusSandObservationScholarShip(@PathVariable Long id, @RequestBody Scholarship status) throws ResourceNotFundException {
        return service.updateStatusSandObservationScholarShip(id, status);

    }
}
