package org.zdjavapol12.springcourse.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.zdjavapol12.springcourse.model.Personnel;
import org.zdjavapol12.springcourse.repository.OldPersonnelRepository;

import java.time.LocalDate;

@Component
@Slf4j
public class TestRunner implements CommandLineRunner {

    private final OldPersonnelRepository personnelRepository;

    public TestRunner(OldPersonnelRepository personnelRepository) {
        this.personnelRepository = personnelRepository;
    }


    @Override
    public void run(String... args) throws Exception {

//        Personnel personnel = Personnel.builder()
//                .firstName("Lukasz")
//                .lastName("Lukasz")
//                .hireDate(LocalDate.parse("2000-11-11"))
//                .position("Lezaca ustalona")
//                .salary(1000.0)
//                .sickLeave(true)
//                .build();
//        log.info("Nowy pracownik dodany do bazy danej {}", personnelRepository.create(personnel).toString());

    }
}
