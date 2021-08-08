package com.code2000.makeamiracle.controller;

import com.code2000.makeamiracle.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class ContryController {

    @Autowired
    CountryService services;

    @GetMapping("/country")
    public ResponseEntity<?> getAll() {
        if (services.getAll().size() > 0) {
            return ResponseEntity.ok().body(services.getAll());

        } else {
            return ResponseEntity.ok("No hay Datos para mostrar");
        }
    }

}
