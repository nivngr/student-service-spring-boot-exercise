package com.example.newdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.newdemo.exception.StudentNotFoundException;
import com.example.newdemo.model.Student;
import com.example.newdemo.repository.StudentRepository;

@Service
public class StudentService {
    
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> allStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> singleStudent(String id) throws StudentNotFoundException {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()) {
            return student;
        } else {
            System.out.println("Catched the Error!!");
            throw new StudentNotFoundException("student with id " + id + " not found");
        }
    }

    public Optional<Student> changeStudent(String id, Student updatedStudent) throws StudentNotFoundException {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()) {
            studentRepository.replace(id, updatedStudent);
            return student;
        } else {
            System.out.println("Catched the Error!!");
            throw new StudentNotFoundException("student with id " + id + " not found");
        }
    }

    public Student createStudent(Student newStudent) {
        return studentRepository.save(newStudent);
    }

    public Optional<Student> removeStudent(String id) {
        Optional<Student> student = studentRepository.findById(id);
        studentRepository.deleteById(id);
        return student;
    }
}
