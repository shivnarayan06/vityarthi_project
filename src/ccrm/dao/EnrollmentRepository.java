package ccrm.dao;

import ccrm.model.Enrollment;
import ccrm.model.Student;
import ccrm.model.Offering;
import java.util.*;

public class EnrollmentRepository {
    private final Map<String, Enrollment> enrollmentDatabase;

    public EnrollmentRepository() {
        this.enrollmentDatabase = new HashMap<>();
    }

    public void save(Enrollment enrollment) {
        if (enrollment == null) {
            throw new IllegalArgumentException("Enrollment cannot be null");
        }
        enrollmentDatabase.put(enrollment.getEnrollmentId(), enrollment);
    }

    public Enrollment findById(String enrollmentId) {
        return enrollmentDatabase.get(enrollmentId);
    }

    public Collection<Enrollment> findAll() {
        return enrollmentDatabase.values();
    }

    public List<Enrollment> findByStudent(Student student) {
        List<Enrollment> results = new ArrayList<>();
        for (Enrollment enrollment : enrollmentDatabase.values()) {
            if (enrollment.getEnrolledStudent().equals(student)) {
                results.add(enrollment);
            }
        }
        return results;
    }

    public List<Enrollment> findByOffering(Offering offering) {
        List<Enrollment> results = new ArrayList<>();
        for (Enrollment enrollment : enrollmentDatabase.values()) {
            if (enrollment.getCourseOffering().equals(offering)) {
                results.add(enrollment);
            }
        }
        return results;
    }

    public void remove(String enrollmentId) {
        enrollmentDatabase.remove(enrollmentId);
    }

    public boolean exists(String enrollmentId) {
        return enrollmentDatabase.containsKey(enrollmentId);
    }
}
