package ccrm.service;

import ccrm.dao.EnrollmentRepository;
import ccrm.dao.OfferingRepository;
import ccrm.dao.StudentRepository;
import ccrm.model.Enrollment;
import ccrm.model.Offering;
import ccrm.model.Student;
import ccrm.util.GPAUtil;
import java.util.List;

public class EnrollmentService {
    private final EnrollmentRepository enrollmentRepo;
    private final StudentRepository studentRepo;
    private final OfferingRepository offeringRepo;

    public EnrollmentService(EnrollmentRepository enrollmentRepo,
                           StudentRepository studentRepo,
                           OfferingRepository offeringRepo) {
        this.enrollmentRepo = enrollmentRepo;
        this.studentRepo = studentRepo;
        this.offeringRepo = offeringRepo;
    }

    public void registerStudentInOffering(String enrollmentId, String studentId, String offeringId) {
        Student targetStudent = studentRepo.findById(studentId);
        validateStudentExists(targetStudent, studentId);

        Offering targetOffering = offeringRepo.findById(offeringId);
        validateOfferingExists(targetOffering, offeringId);

        checkOfferingCapacity(targetOffering);

        Enrollment newEnrollment = new Enrollment(enrollmentId, targetStudent, targetOffering);
        enrollmentRepo.save(newEnrollment);
    }

    private void validateStudentExists(Student student, String studentId) {
        if (student == null) {
            throw new IllegalArgumentException("No student found with ID: " + studentId);
        }
    }

    private void validateOfferingExists(Offering offering, String offeringId) {
        if (offering == null) {
            throw new IllegalArgumentException("No offering found with ID: " + offeringId);
        }
    }

    private void checkOfferingCapacity(Offering offering) {
        List<Enrollment> currentEnrollments = enrollmentRepo.findByOffering(offering);

        if (currentEnrollments.size() >= offering.getMaxEnrollment()) {
            throw new IllegalStateException("Offering has reached maximum capacity");
        }
    }

    public void recordGrade(String enrollmentId, String letterGrade) {
        Enrollment targetEnrollment = findEnrollmentById(enrollmentId);
        targetEnrollment.assignGrade(letterGrade);
    }

    private Enrollment findEnrollmentById(String enrollmentId) {
        for (Enrollment enrollment : enrollmentRepo.findAll()) {
            if (enrollment.getEnrollmentId().equals(enrollmentId)) {
                return enrollment;
            }
        }
        throw new IllegalArgumentException("Enrollment not found with ID: " + enrollmentId);
    }

    public double calculateStudentGPA(String studentId) {
        Student targetStudent = studentRepo.findById(studentId);
        validateStudentExists(targetStudent, studentId);

        List<Enrollment> studentEnrollments = enrollmentRepo.findByStudent(targetStudent);
        return computeGPAFromEnrollments(studentEnrollments);
    }

    private double computeGPAFromEnrollments(List<Enrollment> enrollments) {
        double accumulatedPoints = 0.0;
        int accumulatedCredits = 0;

        for (Enrollment enrollment : enrollments) {
            String grade = enrollment.getLetterGrade();
            if (grade == null) {
                continue;
            }

            int courseCredits = enrollment.getCourseOffering().getAssociatedCourse().getCreditHours();
            accumulatedCredits += courseCredits;
            accumulatedPoints += GPAUtil.gradeToPoints(grade) * courseCredits;
        }

        return (accumulatedCredits == 0) ? 0.0 : (accumulatedPoints / accumulatedCredits);
    }

    public java.util.List<Enrollment> retrieveStudentEnrollments(String studentId) {
        Student targetStudent = studentRepo.findById(studentId);
        validateStudentExists(targetStudent, studentId);
        return enrollmentRepo.findByStudent(targetStudent);
    }
}
