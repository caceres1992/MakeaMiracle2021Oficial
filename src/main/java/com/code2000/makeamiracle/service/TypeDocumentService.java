package com.code2000.makeamiracle.service;


import com.code2000.makeamiracle.model.District;
import com.code2000.makeamiracle.model.TypeDocument;
import com.code2000.makeamiracle.repository.TypeDocumentoRepositoriy;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Entity;
import java.util.Collection;


@Service
@Transactional
public class TypeDocumentService {

    @Autowired
    TypeDocumentoRepositoriy repository;


    public Collection<TypeDocument> getTypeDocument() {
        return repository.findAll();
    }

}
