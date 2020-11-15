package org.zdjavapol12.springcourse.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.zdjavapol12.springcourse.model.Personnel;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Scope("singleton")
public class PersonnelServiceInMemoryImpl implements PersonnelService {

    private final Map<Long, Personnel> personnelMap = new HashMap<>();
    private Long nextId = 1L;

    @PostConstruct
    public void init() {
        personnelMap.put(nextId, Personnel.builder()
                .id(nextId)
                .firstName("Wlasciciel")
                .lastName("Hotelu")
                .hireDate(LocalDate.parse("1800-01-01"))
                .position("Wlasciciel")
                .salary(0.0)
                .sickLeave(false)
                .build());
        nextId++;
    }

    @Override
    public Personnel getPersonnelById(Long id) {
        return personnelMap.getOrDefault(id, null);
    }

    @Override
    public List<Personnel> getAllPersonnel() {
        return null;
    }

    @Override
    public boolean removePersonnelById(Long id) {
        return false;
    }

    @Override
    public Personnel createNewPersonnel(Personnel personnel) {
        return null;
    }

    @Override
    public Personnel updatePersonnelById(Long id, Personnel personnel) {
        return null;
    }
}
