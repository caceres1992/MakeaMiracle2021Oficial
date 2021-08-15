package com.code2000.makeamiracle.controller;


import com.code2000.makeamiracle.model.TypeDocument;
import com.code2000.makeamiracle.service.TypeDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/dtype")
@CrossOrigin
public class TypeDocumentController {


    @Autowired
    TypeDocumentService service;


    @GetMapping
    public Collection<TypeDocument> getAll() {
        return service.getTypeDocument();
    }
}
