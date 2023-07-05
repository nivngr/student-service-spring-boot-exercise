package com.example.newdemo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.newdemo.exception.StudentNotFoundException;
import com.example.newdemo.model.Student;
import com.example.newdemo.service.StudentService;

@RestController
@RequestMapping("/api/v1/")
public class StudentController {
    
    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents() {
        return new ResponseEntity<List<Student>>(studentService.allStudents(),HttpStatus.OK);
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<Optional<Student>> getSingleStudent(@PathVariable String id) throws StudentNotFoundException {
        return new ResponseEntity<Optional<Student>>(studentService.singleStudent(id), HttpStatus.OK);
    }

    @PostMapping("/student/add")
    public ResponseEntity<Student> addStudent(@RequestBody @Valid Student newStudent) {
        return new ResponseEntity<Student>(studentService.createStudent(newStudent), HttpStatus.CREATED);
    }

    @DeleteMapping("/student/delete/{id}")
    public ResponseEntity<Optional<Student>> deleteStudent(@PathVariable String id) {
        return new ResponseEntity<Optional<Student>>(studentService.removeStudent(id), HttpStatus.NO_CONTENT);
    }

}
