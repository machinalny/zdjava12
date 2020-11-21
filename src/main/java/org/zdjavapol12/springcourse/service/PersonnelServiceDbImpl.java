package org.zdjavapol12.springcourse.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.zdjavapol12.springcourse.model.Personnel;
import org.zdjavapol12.springcourse.repository.PersonnelRepository;

import java.util.List;

@Profile("!old")
@Service
@Scope("prototype")
@Slf4j
public class PersonnelServiceDbImpl implements PersonnelService {

    private final PersonnelRepository personnelRepository;

    public PersonnelServiceDbImpl(PersonnelRepository personnelRepository) {
        this.personnelRepository = personnelRepository;
    }

    @Override
    public Personnel getPersonnelById(Long id) {
        return personnelRepository.findById(id).orElse(null);
    }

    @Override
    public List<Personnel> getAllPersonnel() {
        return personnelRepository.findAll();
    }

    @Override
    public boolean removePersonnelById(Long id) {
        return false;
    }

    @Override
    public Personnel createNewPersonnel(Personnel personnel) {
        log.info("Tworze nowy personel");
        return personnelRepository.create(personnel);
    }

    @Override
    public List<Personnel> createBatchOfPersonnel(List<Personnel> personnels) {
        return null;
    }

    @Override
    public Personnel updatePersonnelById(Long id, Personnel personnel) {
        return null;
    }
}
