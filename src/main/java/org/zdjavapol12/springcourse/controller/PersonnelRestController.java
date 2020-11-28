package org.zdjavapol12.springcourse.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.zdjavapol12.springcourse.model.Personnel;
import org.zdjavapol12.springcourse.service.PersonnelService;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(path = "/hotel/personnel")
@Slf4j
public class PersonnelRestController {

    private final PersonnelService personnelService;

    // Tu wstrzykujemy potrzebny serwis.
    public PersonnelRestController(PersonnelService personnelService) {
        this.personnelService = personnelService;
    }

    // Metoda adnotowana jako GetMapping zostanie wywolana na zadanie: localhost:<PORT>/hotel/personnel/<id>, gdzie id to numer pracownika
    @GetMapping("/{id}")
    public ResponseEntity<?> getPersonnelById(@PathVariable Long id) {
        Personnel personnel = personnelService.getPersonnelById(id);
        // Jezeli znalazlo pracownika to zwroc go.
        if (Objects.nonNull(personnel)) {
            return ResponseEntity.ok(personnel);
        }
        // W innym przypadku powiedz ze nie znaleziono
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Personnel>> getPersonnel(@RequestParam(required = false) Integer page,
                                                        @RequestParam(required = false) Integer size) {
        return ResponseEntity.ok(personnelService.getAllPersonnel(page, size));
    }

    // DeleteMapping powinien sluzyc do usuwania zasobow z serwisu. W tym przypadku jesli sie uda to 202 jesli nie to 400
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePersonnel(@PathVariable Long id) {
        if (personnelService.removePersonnelById(id)) {
            return ResponseEntity.accepted().build();
        }
        return ResponseEntity.badRequest().build();

    }

    // PostMapping powinien sluzyc do tworzenia nowych zasobow. Jedna z metod z ktora mozemy wyslac body.
    @PostMapping("/batch")
    public ResponseEntity<?> createNewPersonnel(@RequestBody List<Personnel> personnels) {
        return ResponseEntity.status(HttpStatus.CREATED).body(personnelService.createBatchOfPersonnel(personnels));
    }

    @PostMapping
    public ResponseEntity<?> createOneNewPersonnel(@Valid @RequestBody Personnel personnel) {
        return ResponseEntity.status(HttpStatus.CREATED).body(personnelService.createNewPersonnel(personnel));
    }

    @GetMapping("/sick/{sickLeave}")
    public ResponseEntity<?> getPersonnelBySickLeave(@PathVariable Boolean sickLeave) {
        return ResponseEntity.ok(personnelService.getPersonnelBySickLeave(sickLeave));

    }

    @GetMapping("/position")
    public ResponseEntity<?> getPersonnelByPosition(@RequestParam("position") String position) {
        return ResponseEntity.ok(personnelService.getPersonnelByPosition(position));
    }

    @GetMapping("/cure")
    public void cureAllPersonnel() {
        personnelService.cureAllPersonnel();
    }

}
