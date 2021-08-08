package com.code2000.makeamiracle.repository;

import com.code2000.makeamiracle.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRespository  extends JpaRepository<Country,Long> {
}
