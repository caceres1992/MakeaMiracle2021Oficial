package com.code2000.makeamiracle.controller;

import com.code2000.makeamiracle.model.District;
import com.code2000.makeamiracle.model.TypeDocument;
import com.code2000.makeamiracle.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/district")
public class DistrictController {


    @Autowired
    DistrictService service;

    @GetMapping
    public Collection<District> getAll() {
        return service.getDistrict();
    }
}
