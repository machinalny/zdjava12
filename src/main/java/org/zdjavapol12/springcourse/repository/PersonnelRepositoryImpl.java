package org.zdjavapol12.springcourse.repository;

import org.springframework.stereotype.Repository;
import org.zdjavapol12.springcourse.model.Personnel;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
public class PersonnelRepositoryImpl implements PersonnelRepository {

    private final EntityManager entityManager;

    public PersonnelRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Personnel create(Personnel personnel) {
        entityManager.persist(personnel);
        return personnel;
    }

    @Override
    public Optional<Personnel> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Personnel> findAll() {
        return null;
    }

    @Override
    public Personnel update(Personnel personnel) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
