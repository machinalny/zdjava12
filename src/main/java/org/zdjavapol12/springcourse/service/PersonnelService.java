package org.zdjavapol12.springcourse.service;

import org.zdjavapol12.springcourse.model.Personnel;

import java.util.List;

public interface PersonnelService {

    Personnel getPersonnelById(Long id);

    List<Personnel> getAllPersonnel();

    boolean removePersonnelById(Long id);

    Personnel createNewPersonnel(Personnel personnel);

    Personnel updatePersonnelById(Long id, Personnel personnel);

}
