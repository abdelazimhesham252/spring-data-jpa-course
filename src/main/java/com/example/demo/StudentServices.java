package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServices {


    @Autowired
    private StudentRepository studentRepository;

public void post_student(Student student){

    studentRepository.save(student);
}

    public List<Student> get_students(){

        List<Student> students = new ArrayList<>();
        studentRepository.findAll();
//                .forEach(subjects::add);

        return students;

    }

    public  List<Student> getAllSubject(){

        List<Student> students = new ArrayList<>();

        studentRepository.findAll().forEach(students::add);

        return students;

    }


}
