package com.code2000.makeamiracle.service;


import com.code2000.makeamiracle.model.District;
import com.code2000.makeamiracle.repository.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@Transactional
public class DistrictService {

    @Autowired
    DistrictRepository repository;

    public Collection<District> getDistrict() {
        return repository.findAll();
    }
}
