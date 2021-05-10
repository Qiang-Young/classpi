package com.example.classchoolsp.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Users {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String password;
    private String classnum;
    private String username;
    private String number;
    private String school;
    private String court;
    private String speciality;
    private String myclass;
    private String grade;
    private String ktpnum;
    private String role;
    private String phone;
    private String email;
    private String wechat;
}
