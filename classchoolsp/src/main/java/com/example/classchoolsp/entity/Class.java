package com.example.classchoolsp.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Class {
    @Id
    private Integer classid;
    private String classnum;
    private String classname;
    private String classtime;
    private String manager;
    private String assignment;
}
