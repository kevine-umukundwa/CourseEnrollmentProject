package com.university.repository;

import com.university.model.Student;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class StudentRepository {
    private Map<Integer, Student> studentDatabase = new HashMap<>();

    public Student save(Student student) {
        studentDatabase.put(student.getId(), student);
        return student;
    }

    public Optional<Student> findById(int id) {
        return Optional.ofNullable(studentDatabase.get(id));
    }

    public List<Student> findAll() {
        return new ArrayList<>(studentDatabase.values());
    }

    public boolean existsById(int id) {
        return studentDatabase.containsKey(id);
    }
}