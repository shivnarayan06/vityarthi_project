package ccrm.cli;

import ccrm.dao.* ;
import ccrm.service.*;
import ccrm.model.*;
import java.util.Scanner;
import java.util.Collection;
import java.util.List;
public class CLIController {
    private Scanner inputScanner;
    private boolean isRunning;
    private StudentService studentService;
    private CourseService courseService;
    private EnrollmentService enrollmentService;

    public CLIController(StudentService studentService, 
                        CourseService courseService, 
                        EnrollmentService enrollmentService) {
        this.inputScanner = new Scanner(System.in);
        this.isRunning = true;
        this.studentService = studentService;
        this.courseService = courseService;
        this.enrollmentService = enrollmentService;
    }
    public void start() {
        displayWelcomeMessage();
        while(isRunning) {
            displayMainMenu();
            String userChoice = getUserInput("Enter your choice");
            processUserChoice(userChoice.trim());
            System.out.println();
        }
    }

    private void displayWelcomeMessage() {
        System.out.println("========================================");
        System.out.println("  Campus Course & Records Manager");
        System.out.println("========================================\n");
    }
    private void displayMainMenu() {
        System.out.println("┌──────────────────────────────────────┐");
        System.out.println("│         MAIN MENU OPTIONS            │");
        System.out.println("├──────────────────────────────────────┤");
        System.out.println("│ [1] Register New Student             │");
        System.out.println("│ [2] Display All Students             │");
        System.out.println("│ [3] Register New Course              │");
        System.out.println("│ [4] Display All Courses              │");
        System.out.println("│ [5] Create Course Offering           │");
        System.out.println("│ [6] Display All Offerings            │");
        System.out.println("│ [7] Enroll Student in Course         │");
        System.out.println("│ [8] Record Student Grade             │");
        System.out.println("│ [9] Display Student Transcript       │");
        System.out.println("│ [0] Exit Application                 │");
        System.out.println("└──────────────────────────────────────┘");
    }
    private void processUserChoice(String choice) {
        try {
            switch (choice) {
                case "1":
                    handleStudentRegistration();
                    break;
                case "2":
                    handleDisplayStudents();
                    break;
                case "3":
                    handleCourseRegistration();
                    break;
                case "4":
                    handleDisplayCourses();
                    break;
                case "5":
                    handleOfferingCreation();
                    break;
                case "6":
                    handleDisplayOfferings();
                    break;
                case "7":
                    handleStudentEnrollment();
                    break;
                case "8":
                    handleGradeRecording();
                    break;
                case "9":
                    handleTranscriptDisplay();
                    break;
                case "0":
                    handleExit();
                    break;
                default:
                    System.out.println("Invalid option! Please select a valid menu option.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    private void handleStudentRegistration() {
        printSectionHeader("Student Registration");

        String studentId = getUserInput("Enter Student ID");
        String fullName = getUserInput("Enter Full Name");
        String email = getUserInput("Enter Email Address");
        String program = getUserInput("Enter Academic Program");
        String year = getUserInput("Enter Current Year");

        try {
            studentService.registerStudent(studentId, fullName, email, program, Integer.parseInt(year));
            System.out.println("✓ Student registered successfully: " + fullName + " (" + studentId + ")");
        } catch (NumberFormatException e) {
            System.out.println("Invalid year format. Please enter a number.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    private void handleDisplayStudents() {
        printSectionHeader("All Registered Students");

        Collection<Student> students = studentService.getAllStudents();

        if (students.isEmpty()) {
            System.out.println("No students registered yet.");
        } else {
            System.out.println("Total Students: " + students.size());
            System.out.println("─────────────────────────────────────────────────");
            for (Student student : students) {
                System.out.println(student);
            }
            System.out.println("─────────────────────────────────────────────────");
        }
    }
    private void handleCourseRegistration() {
        printSectionHeader("Course Registration");

        String courseCode = getUserInput("Enter Course Code (e.g., CS101)");
        String courseName = getUserInput("Enter Course Name");
        String credits = getUserInput("Enter Credit Hours");

        try {
            courseService.registerCourse(courseCode, courseName, Integer.parseInt(credits));
            System.out.println("✓ Course registered: " + courseCode + " - " + courseName);
        } catch (NumberFormatException e) {
            System.out.println("Invalid credit hours. Please enter a number.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    private void handleDisplayCourses() {
        printSectionHeader("Course Catalog");

        Collection<Course> courses = courseService.retrieveAllCourses();

        if (courses.isEmpty()) {
            System.out.println("No courses registered yet.");
        } else {
            System.out.println("Total Courses: " + courses.size());
            System.out.println("─────────────────────────────────────────────────");
            for (Course course : courses) {
                System.out.println(course);
            }
            System.out.println("─────────────────────────────────────────────────");
        }
    }
    private void handleOfferingCreation() {
        printSectionHeader("Create Course Offering");

        String offeringId = getUserInput("Enter Offering ID (e.g., CS101-F25)");
        String courseCode = getUserInput("Enter Course Code");
        String semester = getUserInput("Enter Semester (e.g., Fall 2025)");
        String instructor = getUserInput("Enter Instructor Name");
        String capacity = getUserInput("Enter Maximum Capacity");
        try {
            courseService.createCourseOffering(offeringId, courseCode, semester, instructor, Integer.parseInt(capacity));
            System.out.println("✓ Course offering created: " + offeringId + " for " + courseCode);
        } catch (NumberFormatException e) {
            System.out.println("Invalid capacity. Please enter a number.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void handleDisplayOfferings() {
        printSectionHeader("Available Course Offerings");

        Collection<Offering> offerings = courseService.retrieveAllOfferings();

        if (offerings.isEmpty()) {
            System.out.println("No course offerings available yet.");
        } else {
            System.out.println("Total Offerings: " + offerings.size());
            System.out.println("─────────────────────────────────────────────────");
            for (Offering offering : offerings) {
                System.out.println(offering);
            }
            System.out.println("─────────────────────────────────────────────────");
        }
    }
    private void handleStudentEnrollment() {
        printSectionHeader("Student Enrollment");

        String enrollmentId = getUserInput("Enter Enrollment ID");
        String studentId = getUserInput("Enter Student ID");
        String offeringId = getUserInput("Enter Offering ID");

        try {
            enrollmentService.registerStudentInOffering(enrollmentId, studentId, offeringId);
            System.out.println("✓ Student " + studentId + " enrolled in " + offeringId);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    private void handleGradeRecording() {
        printSectionHeader("Grade Recording");

        String enrollmentId = getUserInput("Enter Enrollment ID");
        String grade = getUserInput("Enter Letter Grade (e.g., O, A+, A, B+, B, C, F)");

        try {
            enrollmentService.recordGrade(enrollmentId, grade);
            System.out.println("✓ Grade " + grade + " recorded for enrollment " + enrollmentId);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    private void handleTranscriptDisplay() {
        printSectionHeader("Student Transcript");

        String studentId = getUserInput("Enter Student ID");

        try {
            Student student = studentService.findStudentById(studentId);
            if (student == null) {
                System.out.println("Student not found: " + studentId);
                return;
            }

            List<Enrollment> enrollments = enrollmentService.retrieveStudentEnrollments(studentId);
            double gpa = enrollmentService.calculateStudentGPA(studentId);

            System.out.println("\nStudent: " + student.getFullName() + " (" + studentId + ")");
            System.out.println("Program: " + student.getAcademicProgram() + " - Year " + student.getCurrentYear());
            System.out.println("\n═════════════════════════════════════════════════════════════");
            System.out.println("  ACADEMIC TRANSCRIPT");
            System.out.println("═════════════════════════════════════════════════════════════");

            if (enrollments.isEmpty()) {
                System.out.println("No enrollments found for this student.");
            } else {
                System.out.printf("%-15s %-20s %-10s %-10s%n", "Course Code", "Semester", "Credits", "Grade");
                System.out.println("─────────────────────────────────────────────────────────────");

                for (Enrollment enrollment : enrollments) {
                    Course course = enrollment.getCourseOffering().getAssociatedCourse();
                    String semester = enrollment.getCourseOffering().getAcademicSemester();
                    String grade = enrollment.getLetterGrade() != null ? enrollment.getLetterGrade() : "Not Assigned";

                    System.out.printf("%-15s %-20s %-10d %-10s%n", 
                        course.getCourseCode(), 
                        semester, 
                        course.getCreditHours(), 
                        grade);
                }

                System.out.println("─────────────────────────────────────────────────────────────");
                System.out.printf("\nCumulative GPA: %.2f / 10.0%n", gpa);
            }
            System.out.println("═════════════════════════════════════════════════════════════");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void handleExit() {
        System.out.println("\n========================================");
        System.out.println("  Thank you for using CCRM!");
        System.out.println(" Goodbye!");
        System.out.println("========================================");
        isRunning = false;
        inputScanner.close();
    }
    private String getUserInput(String prompt) {
        System.out.print(prompt + ": ");
        return inputScanner.nextLine();
    }
    private void printSectionHeader(String title) {
        System.out.println("\n╔═══════════════════════════════════════╗");
        System.out.println("  " + title);
        System.out.println("╚═══════════════════════════════════════╝");
    }
}
