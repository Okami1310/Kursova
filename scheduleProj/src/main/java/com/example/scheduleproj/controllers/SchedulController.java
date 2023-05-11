package com.example.scheduleproj.controllers;

import com.example.scheduleproj.dao.SchedulRepository;
import com.example.scheduleproj.entities.Schedul;
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
public class SchedulController {

    private SchedulRepository schedulRepository;

    @GetMapping("/returnS")
    public String homeS(){
        return"index";
    }


    @GetMapping("/schedul")
    public String showSchedul(Model model){

        List<Schedul> scheduls = schedulRepository.findAll();
        model.addAttribute("schedul", scheduls);
        return "schedul";
    }

    @PostMapping("/addschedul")
    public String addSchedul(@RequestParam String time ,@RequestParam int group, @RequestParam String discipline, @RequestParam String teacher){
       Schedul schedul = new Schedul();
        schedul.setTime(time);
        schedul.setGroup(group);
        schedul.setDiscipline(discipline);
        schedul.setTeacher(teacher);
        schedulRepository.save(schedul);
        return "redirect:/schedul";
    }

    @GetMapping("/delete_schedul")
    public String deleteSchedul(@RequestParam int id) {
        schedulRepository.deleteById(id);
        return "redirect:/schedul";
    }


    @GetMapping("/schedul_teacher")
    public String showTeachers(@RequestParam int id, Model model){
        Optional<Schedul> optionalSchedul = schedulRepository.findById(id);
        if(optionalSchedul.isPresent()){
            model.addAttribute("schedul", optionalSchedul.get());
            return "teacher_by_schedul";
        }
        else{
            return "redirect:/schedul";
        }
    }

    @GetMapping("/schedul_edit")
    public String schedulEdit(@RequestParam int id, Model model){
        Optional<Schedul> optionalSchedul = schedulRepository.findById(id);
        if(optionalSchedul.isEmpty()){
            return "redirect:/schedul";
        }
        model.addAttribute("schedul",optionalSchedul.get());
        return "schedul_edit";
    }

    @PostMapping("/update_schedul")
    public String schedulUpdate(@RequestParam int id,@RequestParam String time, @RequestParam int group, @RequestParam String discipline,@RequestParam String teacher) {
        Optional<Schedul> optionalSchedul = schedulRepository.findById(id);
        optionalSchedul.ifPresent(s -> {
            s.setTime(time);
            s.setGroup(group);
            s.setDiscipline(discipline);
            s.setTeacher(teacher);
            schedulRepository.save(s);
        });
        return "redirect:/schedul";
    }

}
