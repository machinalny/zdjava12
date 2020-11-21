package org.zdjavapol12.springcourse.repository;

import org.zdjavapol12.springcourse.model.Personnel;

import java.util.List;
import java.util.Optional;

@Deprecated
public interface OldPersonnelRepository {

    Personnel create(Personnel personnel);

    Optional<Personnel> findById(Long id);

    List<Personnel> findAll();

    Personnel update(Personnel personnel);

    void delete(Long id);
}
