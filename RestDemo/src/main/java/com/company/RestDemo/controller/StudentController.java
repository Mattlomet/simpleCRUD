package com.company.RestDemo.controller;

import java.util.List;

import com.company.RestDemo.model.Student;
import com.company.RestDemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping(value="/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudentPost(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @GetMapping(value="/info/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Student retrieveStudentGet(@PathVariable int id) {
        return studentService.getStudentById(id);
    }

    @GetMapping(value="/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Student> retrieveStudentRoster() {
        return studentService.getAllStudents();
    }

    @PutMapping(value="/update")
    @ResponseStatus(HttpStatus.OK)
    public void updateStudentPut(@RequestBody Student student) {
        studentService.updateStudent(student);
    }

    @DeleteMapping("/terminateStudent/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteStudentDeleteById(@PathVariable int id){
        studentService.deleteStudentById(id);
    }


}