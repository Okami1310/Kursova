package com.example.scheduleproj.controllers;

import com.example.scheduleproj.dao.TeacherRepository;
import com.example.scheduleproj.entities.Teacher;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class TeacherController {

    private TeacherRepository teacherRepository;

    @GetMapping("/returnT")
    public String homeT(){
        return"index";
    }

    @GetMapping("/teacher")
    public String showTeacher(Model model){

        List<Teacher> teachers = teacherRepository.findAll();
        model.addAttribute("teacher", teachers);
        return "teacher";
    }

    @PostMapping("/addteacher")
    public String addTeacher(@RequestParam String name, @RequestParam String mail, @RequestParam int phone){
        Teacher teacher = new Teacher();
        teacher.setName(name);
        teacher.setMail(mail);
        teacher.setPhone(phone);
        teacherRepository.save(teacher);
        return "redirect:/teacher";
    }

    @GetMapping("/delete_teacher")
    public String deleteTeacher(@RequestParam int id) {
        teacherRepository.deleteById(id);
        return "redirect:/teacher";
    }

    @GetMapping("/teacher_discipline")
    public String showDiscipline(@RequestParam int id, Model model){
       Optional<Teacher> optionalTeacher = teacherRepository.findById(id);
       if(optionalTeacher.isPresent()){
           model.addAttribute("teacher", optionalTeacher.get());
           return "discipline_by_teacher";
       }
       else{
           return "redirect:/teacher";
       }
    }

    @GetMapping("/teacher_edit")
    public String teacherEdit(@RequestParam int id, Model model){
        Optional<Teacher> optionalTeacher = teacherRepository.findById(id);
        if(optionalTeacher.isEmpty()){
            return "redirect:/teacher";
        }
        model.addAttribute("teacher",optionalTeacher.get());
        return "teacher_edit";
    }

   @PostMapping("/update")
    public String teacherUpdate(@RequestParam int id,@RequestParam String name, @RequestParam String mail, @RequestParam int phone) {
        Optional<Teacher> optionalTeacher = teacherRepository.findById(id);
        optionalTeacher.ifPresent(t -> {
            t.setName(name);
            t.setMail(mail);
            t.setPhone(phone);
            teacherRepository.save(t);
        });
        return "redirect:/teacher";
    }

}
