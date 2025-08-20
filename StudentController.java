package com.example.springSecPrac.controller;

import com.example.springSecPrac.entity.Student;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class StudentController {

    private List<Student> students = new ArrayList<>(Arrays.asList(

            new Student(1,"subhajit",50),
            new Student(2,"hiru",55)
    ));
    @GetMapping("/students")
    public List<Student> getStudents(){
        return students;
    }
    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student){
        students.add(student);
        return student;

    }

    @GetMapping("/csrf_token")
    public CsrfToken getCsrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");

    }
}
