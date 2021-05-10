package com.example.classchoolsp.controller;

import com.example.classchoolsp.entity.Users;
import com.example.classchoolsp.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UsersHandler {
    @Autowired
    private UsersRepository usersRepository;

    @GetMapping("/findAll")
    public List<Users> findAll(){
        return usersRepository.findAll();
    }

    @GetMapping("/findById/{id}")
    public Users findById(@PathVariable("id") Integer id){ return usersRepository.findById(id).get();
    }


    @PostMapping("/save")
    public String save(@RequestBody Users users){
        Users result =  usersRepository.save(users);
        if(result != null){
            return "success";
        } else{
            return "error";
        }
    }

    @PutMapping("/update")
    public String update(@RequestBody Users users){
        Users result =  usersRepository.save(users);
        if(result != null){
            return "success";
        } else{
            return "error";
        }
    }
}
