package com.code2000.makeamiracle.repository;

import com.code2000.makeamiracle.model.Scholarship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ScholarshipRepository extends JpaRepository<Scholarship, Long> {

//    @Query(
////            value = "SELECT s.name , c.name,i.name FROM scholarship sh \n" +
////                    "INNER JOIN sponsor s ON sh.sponsor_id = s.id \n" +
////                    "INNER JOIN career c  ON sh.career_id = c.id \n" +
////                    "INNER JOIN institute i ON c.institute_id = i.id ",nativeQuery = true
////    )
////    Collection<Scholarship> findDetailScholarShip();

}
