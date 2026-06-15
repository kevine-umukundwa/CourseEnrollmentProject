package com.university.repository;

import com.university.model.Enrollment;
import org.springframework.stereotype.Repository;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class EnrollmentRepository {
    private List<Enrollment> enrollmentList = new ArrayList<>();

    public void save(Enrollment enrollment) {
        enrollmentList.add(enrollment);
    }

    public List<Enrollment> findByStudentId(int studentId) {
        return enrollmentList.stream()
                .filter(e -> e.getStudentId() == studentId)
                .collect(Collectors.toList());
    }

    public List<Enrollment> findByCourseId(int courseId) {
        return enrollmentList.stream()
                .filter(e -> e.getCourseId() == courseId)
                .collect(Collectors.toList());
    }

    public List<Enrollment> findAll() {
        return new ArrayList<>(enrollmentList);
    }
}