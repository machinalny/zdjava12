package org.zdjavapol12.springcourse.service;

import org.zdjavapol12.springcourse.model.Personnel;

import java.util.List;

public interface PersonnelService {

    Personnel getPersonnelById(Long id);

    List<Personnel> getAllPersonnel(Integer page, Integer size);

    boolean removePersonnelById(Long id);

    Personnel createNewPersonnel(Personnel personnel);

    List<Personnel> createBatchOfPersonnel(List<Personnel> personnels);

    Personnel updatePersonnelById(Long id, Personnel personnel);

    List<Personnel> getPersonnelBySickLeave(Boolean sickLeave);

    List<Personnel> getPersonnelByPosition(String postion);

    void cureAllPersonnel();

}
