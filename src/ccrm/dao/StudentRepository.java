package ccrm.dao;

import ccrm.model.Student;
import java.util.*;

public class StudentRepository {
    private final Map<String, Student> studentDatabase;

    public StudentRepository() {
        this.studentDatabase = new HashMap<>();
    }

    public void save(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Student cannot be null");
        }
        studentDatabase.put(student.getStudentId(), student);
    }

    public Student findById(String studentId) {
        return studentDatabase.get(studentId);
    }

    public Collection<Student> findAll() {
        return studentDatabase.values();
    }

    public void remove(String studentId) {
        studentDatabase.remove(studentId);
    }

    public boolean exists(String studentId) {
        return studentDatabase.containsKey(studentId);
    }
}
