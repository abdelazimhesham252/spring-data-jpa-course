package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentServices studentServices;

/// test connection
    @GetMapping("/Welcome")
    public  String get_string(){
return "Welcome Abdelazim"  ;
    }


/// get all students

    @GetMapping("/getstudents")
    public ResponseEntity<List<Student>> getAll() {
        return new ResponseEntity<>(studentServices.getAllSubject(), HttpStatus.OK);
    }
/// Post new student

    @PostMapping("/addStudent")
    public  void post_student(@RequestBody Student student){
        studentServices.post_student(student);
    }
/// delete student by id

    @DeleteMapping("/delete/{studentid}")
   public void delete_student(@PathVariable ("studentid") Long id){
        studentServices.delete_student(id);
   }

}
