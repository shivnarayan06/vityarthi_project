package ccrm.model;

public class Offering{
    private String offeringId;
    private Course associatedCourse;
    private String academicSemester;
    private String facultyName;
    private int maxEnrollment;

    public Offering(String offeringId, Course associatedCourse, String academicSemester, 
                   String facultyName, int maxEnrollment) {
        this.offeringId = offeringId;
        this.associatedCourse = associatedCourse;
        this.academicSemester = academicSemester;
        this.facultyName = facultyName;
        this.maxEnrollment = maxEnrollment;
    }

    public String getOfferingId() { 
        return offeringId; 
    }

    public Course getAssociatedCourse(){ 
        return associatedCourse; 
    }

    public String getAcademicSemester() { 
        return academicSemester; 
    }

    public String getFacultyName() { 
        return facultyName; 
    }

    public int getMaxEnrollment(){ 
        return maxEnrollment; 
    }

    public void updateFacultyName(String facultyName) { 
        this.facultyName = facultyName; 
    }

    public void updateMaxEnrollment(int maxEnrollment) { 
        this.maxEnrollment = maxEnrollment; 
    }
    @Override
    public String toString() {
        return String.format("%s | %s | Term: %s | Faculty: %s | Seats: %d", 
                           offeringId, associatedCourse.getCourseCode(), 
                           academicSemester, facultyName, maxEnrollment);
    }
}
