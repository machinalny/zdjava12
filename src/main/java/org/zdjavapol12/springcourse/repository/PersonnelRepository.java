package org.zdjavapol12.springcourse.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.zdjavapol12.springcourse.model.Personnel;

import java.util.Collection;
import java.util.List;

@Repository
public interface PersonnelRepository extends CrudRepository<Personnel, Long> {
    List<Personnel> findAll();
}
