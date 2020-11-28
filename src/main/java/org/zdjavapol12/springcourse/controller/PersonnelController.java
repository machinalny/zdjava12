package org.zdjavapol12.springcourse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.zdjavapol12.springcourse.model.Personnel;
import org.zdjavapol12.springcourse.service.PersonnelService;

import javax.validation.Valid;

@Controller
public class PersonnelController {

    private final PersonnelService personnelService;

    public PersonnelController(PersonnelService personnelService) {
        this.personnelService = personnelService;
    }


    @GetMapping
    public String welcomePage(ModelMap modelMap){
        modelMap.addAttribute("hotelName", "HotelParadise");
        return "welcome";
    }

    @GetMapping("/personnel/{id}")
    public String personnel(ModelMap modelMap, @PathVariable Long id){
        modelMap.addAttribute("personnel", personnelService.getPersonnelById(id));
        return "one-personnel";
    }


    @GetMapping("/personnel")
    public String personnel(ModelMap modelMap){
        modelMap.addAttribute("personnelList", personnelService.getAllPersonnel(1, 100));
        return "personnel";
    }

    @GetMapping("/personnel/add")
    public String showPersonnelAdd(ModelMap modelMap){
        modelMap.addAttribute("personnel", new Personnel());
        modelMap.addAttribute("errorMsg", "Nie masz poprawnych pol");
        return "personnel-add";
    }

    @GetMapping("/personnel/update/{id}")
    public String showPersonnelAdd(ModelMap modelMap, @PathVariable Long id){
        modelMap.addAttribute("personnel", personnelService.getPersonnelById(id));
        return "personnel-update";
    }

    @PostMapping("/personnel/add")
    public String addPersonnel(@Valid @ModelAttribute("personnel") Personnel personnel,
                               final Errors errors){
        if (errors.hasErrors()){
            return "personnel-add";
        }
        if (personnel.getFirstName().equals("Bankowy")){
            throw new RuntimeException("Blad!");
        }
        personnelService.createNewPersonnel(personnel);
        return "redirect:/";
    }

    @PostMapping("/personnel/update")
    public String updatePersonnel(@Valid @ModelAttribute("personnel") Personnel personnel,
                               final Errors errors){
        if (errors.hasErrors()){
            return "personnel-update";
        }
        personnelService.updatePersonnel(personnel);
        return "redirect:/personnel/"+personnel.getId();
    }

}
