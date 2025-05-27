package com.rikkei.ss12.controller;

import com.rikkei.ss12.dto.StudentDTO;
import com.rikkei.ss12.model.Student;
import com.rikkei.ss12.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public String showStudents(Model model) {
        List<Student> students = studentService.find_all();
        model.addAttribute("students", students);
        return "list";
    }

    @GetMapping("/add")
    public String addStudentForm(Model model) {
        model.addAttribute("studentDTO", new StudentDTO());
        return "addStudent";
    }

    @PostMapping("/add")
    public String addStudent(@ModelAttribute("studentDTO") @Valid StudentDTO studentDTO,
                             BindingResult result,
                             Model model) {
        if (result.hasErrors()) {
            return "addStudent";
        }

        Student student = new Student();
        student.setName(studentDTO.getName());
        student.setEmail(studentDTO.getEmail());
        student.setDob(studentDTO.getDob());
        studentService.save(student);
        return "redirect:/students";
    }
    @GetMapping("/edit/{id}")
    public String editStudentForm(@PathVariable int id, Model model) {
        Student student = studentService.find_ById(id);
        if (student == null) {
            return "redirect:/students";
        }
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(student.getId());
        studentDTO.setName(student.getName());
        studentDTO.setEmail(student.getEmail());
        studentDTO.setDob(student.getDob());
        model.addAttribute("studentDTO", studentDTO);
        return "editStudent";
    }

    @PostMapping("/edit")
    public String editStudent(@ModelAttribute("studentDTO") @Valid StudentDTO studentDTO,
                              BindingResult result,
                              Model model) {
        if (result.hasErrors()) {
            return "editStudent";
        }
        Student student = new Student();
        student.setId(studentDTO.getId());
        student.setName(studentDTO.getName());
        student.setEmail(studentDTO.getEmail());
        student.setDob(studentDTO.getDob());
        studentService.update(student);
        return "redirect:/students";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable int id) {
        studentService.delete(id);
        return "redirect:/students";
    }

}
