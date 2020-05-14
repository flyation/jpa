package com.example.jpa.controller;

import com.example.jpa.entity.Student;
import com.example.jpa.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jpa")
public class StudentHandler {
    @Autowired
    private StudentRepository studentRepository;

    /**
     * 查询所有
     * @return
     */
    @GetMapping("/all")
    public List<Student> findAll() {
        List<Student> studentList = studentRepository.findAll();
        return studentList;
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @GetMapping("id/{id}")
    public Student findById(@PathVariable("id") int id) {
        Student student = studentRepository.findById(id).get();
        return student;
    }

    /**
     * 根据字段名查询
     * @param name
     * @return
     */
    @GetMapping("/name/{name}")
    public Student findByName(@PathVariable("name") String name) {
        Student student = studentRepository.findByName(name);
        return student;
    }

    /**
     * 模糊查询
     * @param name
     * @return
     */
    @GetMapping("/like/{name}")
    public List<Student> findLikeName(@PathVariable("name") String name) {
        List<Student> studentList = studentRepository.findByNameLike("%"+name+"%");
        return studentList;
    }

    /**
     * 插入/更新
     * 根据有无主键执行插入或更新
     * @param student
     * @return
     */
    @PostMapping("/save")
    public String save(@RequestBody Student student) {
        studentRepository.save(student);
        return "save ok";
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable("id") int id) {
        studentRepository.deleteById(id);
        return "delete ok";
    }
}
