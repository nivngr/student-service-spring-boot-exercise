package com.example.newdemo.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    
    @Id
    String id;
    @NotNull(message = "Invalid student name")
    String name;
    @Email(message = "Invalid email address")
    String email;
    @Min(0)
    @Max(100)
    int gpa;
}   
