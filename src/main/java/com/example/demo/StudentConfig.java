package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            Student maria = new Student(
                    "Maria",
                    "Jones",
                    "maria.joneszzzz@amigoscode.edu",
                    21
            );

            Student ahmed = new Student(
                    "Abdelazim",
                    "Hesham",
                    "Abdelazim.Hesham@amigoscode.edu",
                     30
            );

            System.out.println("Adding maria and Abdelazim");

            studentRepository.saveAll(List.of(maria, ahmed));

            System.out.print("Number of students: ");

            System.out.println(studentRepository.count());

            studentRepository
                    .findById(2L)
                    .ifPresentOrElse(
                            System.out::println,
                            () -> System.out.println("Student with ID 2 not found"));

            studentRepository
                    .findById(3L)
                    .ifPresentOrElse(
                            System.out::println,
                            () -> System.out.println("Student with ID 3 not found"));

            System.out.println("Select all students");
            List<Student> students = studentRepository.findAll();
            students.forEach(System.out::println);

            System.out.println("Delete maria");
            studentRepository.deleteById(1L);

            System.out.print("Number of students: ");
            System.out.println(studentRepository.count());
        };
    }


}
