package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServices {


    @Autowired
    private StudentRepository studentRepository;



    public  List<Student> getAllSubject(){

        List<Student> students = new ArrayList<>();

        studentRepository.findAll().forEach(students::add);

        return students;

    }


    public void post_student(Student student){
        System.out.println(student);

        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());

        if (studentOptional.isPresent()){
            throw new IllegalStateException("Email is found");
        }

        studentRepository.save(student);

    }


    public void delete_student(Long id) {

        boolean exist = studentRepository.existsById(id);

        if (exist == false){
            throw new IllegalStateException("Student not found  "+id+" in our DB");

        }else{
            studentRepository.deleteStudentById(id);

        }

    }
}
