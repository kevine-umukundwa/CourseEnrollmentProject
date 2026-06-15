package com.university.service;

import com.university.model.Enrollment;
import com.university.repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;
    private final CourseService courseService;
    private final StudentService studentService;

    @Autowired
    public EnrollmentService(EnrollmentRepository enrollmentRepository,
                             CourseService courseService,
                             StudentService studentService) {
        this.enrollmentRepository = enrollmentRepository;
        this.courseService = courseService;
        this.studentService = studentService;
    }

    public boolean enrollStudent(int studentId, int courseId) {
        if (studentService.studentExists(studentId) && courseService.courseExists(courseId)) {
            Enrollment enrollment = new Enrollment(studentId, courseId, LocalDate.now().toString());
            enrollmentRepository.save(enrollment);
            return true;
        }
        return false;
    }

    public List<Enrollment> getEnrollmentsByStudent(int studentId) {
        return enrollmentRepository.findByStudentId(studentId);
    }

    public List<Enrollment> getEnrollmentsByCourse(int courseId) {
        return enrollmentRepository.findByCourseId(courseId);
    }

    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepository.findAll();
    }
}