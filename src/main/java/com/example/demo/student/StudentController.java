package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(path = "/student/all")
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping(path = "/student/add")
    public void registerNewStudent (@RequestBody Student student){
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "/student/delete/{studentId}")
    public void deleteStudent (@PathVariable("studentId") Long studentId){
        studentService.deleteStudent(studentId);
    }

    @PutMapping(path = "/student/update")
    public void updateStudent (@RequestBody Student student){
        studentService.updateStudent(student);
    }
/*    @PutMapping(path = "/update/{studentId}")
    public void updateStudent (
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email){
        studentService.updateStudent(studentId, name, email);
    }*/
}
