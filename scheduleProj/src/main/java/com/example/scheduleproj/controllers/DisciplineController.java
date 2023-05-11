package com.example.scheduleproj.controllers;

import com.example.scheduleproj.dao.DisciplineRepository;
import com.example.scheduleproj.entities.Discipline;
import com.example.scheduleproj.entities.Teacher;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class DisciplineController {

    private DisciplineRepository disciplineRepository;

    @GetMapping("/returnD")
    public String homeD(){
        return"index";
    }

    @GetMapping("/discipline")
    public String showTeacher(Model model){

        List<Discipline> disciplines = disciplineRepository.findAll();
        model.addAttribute("discipline", disciplines);
        return "discipline";
    }

    @PostMapping("/adddiscipline")
    public String addDiscipline(@RequestParam String name){
        Discipline discipline = new Discipline();
        discipline.setName(name);
        disciplineRepository.save(discipline);
        return "redirect:/discipline";
    }

    @GetMapping("/delete_discipline")
    public String deleteDiscipline(@RequestParam int id) {
        disciplineRepository.deleteById(id);
        return "redirect:/discipline";
    }

    @GetMapping("/discipline_teacher")
    public String showTeacher(@RequestParam int id, Model model){
        Optional<Discipline> optionalDiscipline = disciplineRepository.findById(id);
        if(optionalDiscipline.isPresent()){
            model.addAttribute("discipline", optionalDiscipline.get());
            return "teacher_by_discipline";
        }
        else{
            return "redirect:/discipline";
        }
    }


    @GetMapping("/discipline_edit")
    public String disciplineEdit(@RequestParam int id, Model model){
        Optional<Discipline> optionalDiscipline = disciplineRepository.findById(id);
        if(optionalDiscipline.isEmpty()){
            return "redirect:/discipline";
        }
        model.addAttribute("discipline", optionalDiscipline.get());
        return "discipline_edit";
    }

    @PostMapping("/discipline_update")
    public String disciplineUpdate(@RequestParam int id,@RequestParam String name) {
        Optional<Discipline> optionalDiscipline = disciplineRepository.findById(id);
        optionalDiscipline.ifPresent(d -> {
            d.setName(name);

            disciplineRepository.save(d);
        });
        return "redirect:/discipline";
    }

}
