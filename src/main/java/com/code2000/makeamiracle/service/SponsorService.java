package com.code2000.makeamiracle.service;

import com.code2000.makeamiracle.model.Sponsor;
import com.code2000.makeamiracle.model.Student;
import com.code2000.makeamiracle.repository.SponsorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SponsorService {

    @Autowired
    SponsorRepository repository;


    public ResponseEntity<?> findAll() {
        if (repository.findAll().size() == 0) {
            return ResponseEntity.ok().body("no hay nada que mostrar");
        } else
            return ResponseEntity.ok().body(repository.findAll());
    }

    public ResponseEntity<Integer> countAllSponsor() {

        return ResponseEntity.ok(repository.findAll().size());
    }


    public ResponseEntity<?> addSponsor(Sponsor sponsor) {
        repository.save(sponsor);
        return ResponseEntity.ok().body("sponsor " + sponsor.getName().concat(" ").concat(sponsor.getLastName()) + " successfully");
    }

    public ResponseEntity<?> findById(Long id) throws Throwable {
        Sponsor sponsor = repository.findById(id).orElseThrow(() -> new Exception("Sponsor not found with id : " + id));
        return ResponseEntity.ok().body(sponsor);
    }


    public ResponseEntity<?> updateSponsor(Long id, Sponsor sponsorUpdate) throws Exception {
        Sponsor sponsor = repository.findById(id).orElseThrow(() -> new Exception("Sponsor not found with id : " + id));

        if (repository.existsById(id)) {
            sponsor.setName(sponsorUpdate.getName());
            sponsor.setLastName(sponsorUpdate.getLastName());
            sponsor.setCountry(sponsorUpdate.getCountry());
            sponsor.setPhone(sponsorUpdate.getPhone());
            sponsor.setEmail(sponsorUpdate.getEmail());
            sponsor.setAddress(sponsorUpdate.getAddress());
            repository.save(sponsor);
            return ResponseEntity.ok().body("Data updated successfully");
        }
        return null;
    }




}
