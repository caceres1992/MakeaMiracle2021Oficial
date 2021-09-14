package com.code2000.makeamiracle.repository;

import com.code2000.makeamiracle.model.Scholarship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ScholarshipRepository extends JpaRepository<Scholarship, Long> {

}
