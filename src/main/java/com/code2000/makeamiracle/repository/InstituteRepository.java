package com.code2000.makeamiracle.repository;

import com.code2000.makeamiracle.model.Institute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstituteRepository extends JpaRepository<Institute, Long> {


    boolean existsByName(String name);
    boolean existsById(Long id);
    Institute getInstituteByName(String name);


}
