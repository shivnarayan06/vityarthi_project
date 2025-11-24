package ccrm.model;

public class Student {
    private String studentId;
    private String fullName;
    private String emailAddress;
    private String academicProgram;
    private int currentYear;

    public Student(String studentId, String fullName, String emailAddress, 
                   String academicProgram, int currentYear) {
        this.studentId = studentId;
        this.fullName = fullName;
        this.emailAddress = emailAddress;
        this.academicProgram = academicProgram;
        this.currentYear = currentYear;
    }

    public String getStudentId() { 
        return studentId; 
    }
    public String getFullName(){ 
        return fullName; 
    }

    public String getEmailAddress() { 
        return emailAddress; 
    }

    public String getAcademicProgram(){ 
        return academicProgram; 
    }

    public int getCurrentYear(){ 
        return currentYear; 
    }

    public void updateFullName(String fullName){ 
        this.fullName = fullName; 
    }

    public void updateEmailAddress(String emailAddress){ 
        this.emailAddress = emailAddress; 
    }

    public void updateAcademicProgram(String academicProgram) { 
        this.academicProgram = academicProgram; 
    }

    public void updateCurrentYear(int currentYear) { 
        this.currentYear = currentYear; 
    }

    @Override
    public String toString(){
        return String.format("[%s] %s | %s Year %d", 
                           studentId, fullName, academicProgram, currentYear);
    }
}
