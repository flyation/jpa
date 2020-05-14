package com.example.jpa.repository;

import com.example.jpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    StudentRepository studentRepository;

    @Test
    void test() {
        List<Student> all = studentRepository.findAll();
        all.stream()
                .forEach(System.out::println);
    }
}