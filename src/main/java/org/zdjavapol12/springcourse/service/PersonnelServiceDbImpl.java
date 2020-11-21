package org.zdjavapol12.springcourse.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.zdjavapol12.springcourse.model.Personnel;
import org.zdjavapol12.springcourse.repository.PersonnelRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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
        personnelRepository.deleteById(id);
        return true;
    }

    @Override
    public Personnel createNewPersonnel(Personnel personnel) {
        log.info("Tworze nowy personel");
        return personnelRepository.save(personnel);
    }

    @Override
    public List<Personnel> createBatchOfPersonnel(List<Personnel> personnels) {
        List<Personnel> personnels1 = new ArrayList<>();
        personnelRepository.saveAll(personnels).forEach(personnels1::add);
        return personnels1;
    }

    @Override
    public Personnel updatePersonnelById(Long id, Personnel personnel) {
        return null;
    }
}
