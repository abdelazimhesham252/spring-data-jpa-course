package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentServices studentServices;

    @PostMapping("/addStudent")
    public  void post_student(@RequestBody Student student){
    studentServices.post_student(student);
}

    @GetMapping("test")
    public  String get_s(){
return "Welcome Student new"  ;
    }

//    @GetMapping("/getstudents")
//    public List<Student> getstudents(){
//
//       return studentServices.get_students();
//    }


    @GetMapping("/getstudents")
    public ResponseEntity<List<Student>> getAll() {
        return new ResponseEntity<>(studentServices.getAllSubject(), HttpStatus.OK);
    }

//    public  List<Subject> getAllSubject(){
//
//        List<Subject> subjects = new ArrayList<>();
//
//        subjectRepo.findAll().forEach(subjects::add);
//
//        return subjects;
//
//    }

}
