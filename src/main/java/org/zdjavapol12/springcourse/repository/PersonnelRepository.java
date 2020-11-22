package org.zdjavapol12.springcourse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.zdjavapol12.springcourse.model.Personnel;

import java.util.List;

@Repository
public interface PersonnelRepository extends JpaRepository<Personnel, Long> {

    List<Personnel> findPersonnelsBySickLeaveEquals(Boolean sickLeave);
}
