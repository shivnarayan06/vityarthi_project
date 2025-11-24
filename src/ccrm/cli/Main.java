package ccrm.cli;

import ccrm.dao.*;
import ccrm.service.*;
public class Main {
    public static void main(String[] args) {
        StudentRepository studentRepo = new StudentRepository();
        CourseRepository courseRepo = new CourseRepository();
        OfferingRepository offeringRepo = new OfferingRepository();
        EnrollmentRepository enrollmentRepo = new EnrollmentRepository();
        StudentService studentService = new StudentService(studentRepo);
        CourseService courseService = new CourseService(courseRepo, offeringRepo);
        EnrollmentService enrollmentService = new EnrollmentService(
            enrollmentRepo, studentRepo, offeringRepo
        );
        CLIController cliController = new CLIController(
            studentService, 
            courseService, 
            enrollmentService
        );
        
        cliController.start();
    }
}
