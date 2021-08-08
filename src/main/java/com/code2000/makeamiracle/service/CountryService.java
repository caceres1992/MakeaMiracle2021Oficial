package com.code2000.makeamiracle.service;

import com.code2000.makeamiracle.model.Country;
import com.code2000.makeamiracle.repository.CountryRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@Transactional
public class CountryService {


    @Autowired
    CountryRespository respository;

    public Collection<Country> getAll() {
        return respository.findAll();
    }
}
