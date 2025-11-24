package ccrm.util;


public class GPAUtil {
    public static double gradeToPoints(String grade) {
        if (grade == null || grade.isEmpty()) {
            return 0.0;
        }
        String gradeUpper = grade.toUpperCase().trim();
        switch (gradeUpper) {
            case "O":
            case "A+":
                return 10.0;
            case "A":
                return 9.0;
            case "B+":
                return 8.0;
            case "B":
                return 7.0;
            case "C+":
                return 6.0;
            case "C":
                return 5.0;
            case "D":
                return 4.0;
            case "F":
            case "E":
                return 0.0;
            default:
                System.err.println("Warning: Wrong grade '" + grade + "', treating as 0.0");
                return 0.0;
        }
    }
}
