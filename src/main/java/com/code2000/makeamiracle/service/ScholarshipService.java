package com.code2000.makeamiracle.service;

import com.code2000.makeamiracle.repository.ScholarshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ScholarshipService {

    @Autowired
    ScholarshipRepository repository;

}
