package com.example.Student_New1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Student_New1.Model.Student;
import com.example.Student_New1.Repository.StudentRepository;

@Service
public class StudentService2 {
    @Autowired
    private StudentRepository repo;

    public Student createStudent(Student student) {
        return repo.save(student);
    }

    public Student getStudentById(String id) {
        Optional<Student> student = repo.findById(id);
        return student.orElse(null);
    }

    public List<Student> getAllStudent() {
        return repo.findAll();
    }

    public Student updateStudent(String id, Student student) {
        if (repo.existsById(id)) {
            student.setId(id);
            return repo.save(student);
        }
        return null;
    }

    public void deleteStudent(String id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        }
    }
    // Get students by year of enrollment
    public List<Student> getStudentsByYearOfEnrollment(int year) {
        return repo.findByYearOfEnrollment(year);
    }

    // Get department of a student by student ID
    public String getDepartmentByStudentId(String id) {
        return repo.findDepartmentByStudentId(id);
    }

    // Delete students by year of enrollment
    public void deleteStudentsByYearOfEnrollment(int year) {
        repo.deleteByYearOfEnrollment(year);
    }
}
