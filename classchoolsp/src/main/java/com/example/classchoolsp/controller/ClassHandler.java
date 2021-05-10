package com.example.classchoolsp.controller;

import com.example.classchoolsp.entity.Class;
import com.example.classchoolsp.entity.Users;
import com.example.classchoolsp.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/class")
public class ClassHandler {
    @Autowired
    private ClassRepository classRepository;

    @GetMapping("/findall")
    public List<Class> findAll(){
        return classRepository.findAll();
    }
    @GetMapping("/findById/{id}")
    public Class findById(@PathVariable("id") Integer id){
        return classRepository.findById(id).get();
    }

}
