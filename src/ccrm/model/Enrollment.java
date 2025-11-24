package ccrm.model;

public class Enrollment{
    private String enrollmentId;
    private Student enrolledStudent;
    private Offering courseOffering;
    private String letterGrade;

    public Enrollment(String enrollmentId, Student enrolledStudent, Offering courseOffering) {
        this.enrollmentId = enrollmentId;
        this.enrolledStudent = enrolledStudent;
        this.courseOffering = courseOffering;
        this.letterGrade = null;
    }

    public String getEnrollmentId(){ 
        return enrollmentId; 
    }

    public Student getEnrolledStudent() { 
        return enrolledStudent; 
    }
    public Offering getCourseOffering(){ 
        return courseOffering; 
    }

    public String getLetterGrade() { 
        return letterGrade; 
    }

    public void assignGrade(String letterGrade) { 
        this.letterGrade = letterGrade; 
    }
    @Override
    public String toString() {
        String gradeInfo = (letterGrade != null) ? " | Grade: " + letterGrade : " | Grade: NA";
        return String.format("Enrollment %s -> Student: %s | Offering: %s%s", 
                           enrollmentId, enrolledStudent.getStudentId(), 
                           courseOffering.getOfferingId(), gradeInfo);
    }
}
