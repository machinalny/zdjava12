package org.zdjavapol12.springcourse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.zdjavapol12.springcourse.model.Personnel;

import java.util.List;

@Repository
public interface PersonnelRepository extends JpaRepository<Personnel, Long> {

    List<Personnel> findPersonnelsBySickLeaveEquals(Boolean sickLeave);

    List<Personnel> findPersonnelsByPositionEquals(String position);

    @Query(value = "SELECT p FROM personnel p where p.position = :position", nativeQuery = false)
    List<Personnel> selectAllPersonnelWithPositionEqualTo(@Param("position") String position);
}
