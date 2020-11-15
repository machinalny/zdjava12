package org.zdjavapol12.springcourse.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.zdjavapol12.springcourse.model.Personnel;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Controller
@ResponseBody
@Slf4j
public class TestController {
    @RequestMapping(method = RequestMethod.GET, path = "/hotel/personnel")
    public List<Personnel> getAllPersonnel(@RequestParam(value = "id", required = false, defaultValue = "100") Long id) {
        if (Objects.nonNull(id)) {
            return Collections.singletonList(new Personnel(id, "Jacek", "Warzycha", "Parkingowy",
                    LocalDate.parse("2000-11-13"), 3500.0, false));
        }
        return Collections.singletonList(new Personnel(5L, "Jacek", "Warzycha", "Parkingowy",
                LocalDate.parse("2000-11-13"), 3500.0, false));
    }

    @RequestMapping(method = RequestMethod.POST, path = "/hotel/personnel")
    public ResponseEntity<?> createNewPersonnel(@RequestBody Personnel personnel) {
        personnel.setId(1000L);
        return ResponseEntity.status(HttpStatus.CREATED).body(personnel);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/hotel/personnel/{id}")
    public Personnel updatePersonnel(@PathVariable Long id, @RequestBody Personnel personnel) {
        if (id.equals(50000L)) {
            log.info(personnel.toString());
            personnel.setId(personnel.getId() + 1L);
            return personnel;
        }
        return null;
    }
}
