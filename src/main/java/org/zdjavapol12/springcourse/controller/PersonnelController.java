package org.zdjavapol12.springcourse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("/personnel/add")
    public String showPersonnelAdd(ModelMap modelMap){
        modelMap.addAttribute("personnel", new Personnel());
        return "personnel-add";
    }

    @PostMapping("/personnel/add")
    public String addPersonnel(@Valid @ModelAttribute("personnel") Personnel personnel,
                               final Errors errors){
        if (errors.hasErrors()){
            return "personnel-add";
        }
        personnelService.createNewPersonnel(personnel);
        return "redirect:/";
    }

}
