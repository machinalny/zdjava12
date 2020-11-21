package org.zdjavapol12.springcourse.repository;

import org.springframework.stereotype.Repository;
import org.zdjavapol12.springcourse.model.Personnel;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

// Repository powinnismy oznaczac klasy obslugujace dostep do danych
// Przy wykorzystaniu baz danych powinnismy oznaczyc klase badz metody(Klasa zalecana) jako transactional
// Chyba ze chcemy zarzadzac tranzakcjami wlasnorecznie.
@Repository
@Transactional
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
        return Optional.ofNullable(entityManager.find(Personnel.class, id));
    }

    @Override
    public List<Personnel> findAll() {
        return entityManager.createQuery("SELECT p from personnel p", Personnel.class).getResultList();
    }

    @Override
    public Personnel update(Personnel personnel) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
