package ccrm.service;

import ccrm.dao.StudentRepository;
import ccrm.model.Student;
import java.util.Collection;

public class StudentService {
    private final StudentRepository studentRepo;

    public StudentService(StudentRepository studentRepo) {
        this.studentRepo = studentRepo;
    }

    public void registerStudent(String studentId, String fullName, String emailAddress, 
                               String academicProgram, int currentYear) {
        Student newStudent = new Student(studentId, fullName, emailAddress, 
                                        academicProgram, currentYear);
        studentRepo.save(newStudent);
    }

    public Student findStudentById(String studentId) {
        return studentRepo.findById(studentId);
    }

    public Collection<Student> getAllStudents() {
        return studentRepo.findAll();
    }
}
