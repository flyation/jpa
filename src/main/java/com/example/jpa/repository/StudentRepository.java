package com.example.jpa.repository;

import com.example.jpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// extends JpaRepository<数据库映射实体类, 主键类型>
public interface StudentRepository extends JpaRepository<Student, Integer> {
    Student findByName(String name);

    List<Student> findByNameLike(String name);
}
