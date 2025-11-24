package ccrm.service;

import ccrm.dao.CourseRepository;
import ccrm.dao.OfferingRepository;
import ccrm.model.Course;
import ccrm.model.Offering;
import java.util.Collection;

public class CourseService {
    private final CourseRepository courseRepo;
    private final OfferingRepository offeringRepo;

    public CourseService(CourseRepository courseRepo, OfferingRepository offeringRepo) {
        this.courseRepo = courseRepo;
        this.offeringRepo = offeringRepo;
    }

    public void registerCourse(String courseCode, String courseName, int creditHours) {
        Course newCourse = new Course(courseCode, courseName, creditHours);
        courseRepo.save(newCourse);
    }

    public void createCourseOffering(String offeringId, String courseCode, String academicSemester, 
                                    String facultyName, int maxEnrollment) {
        Course foundCourse = courseRepo.findByCode(courseCode);

        if (foundCourse == null) {
            throw new IllegalArgumentException("Cannot find course with code: " + courseCode);
        }

        Offering newOffering = new Offering(offeringId, foundCourse, academicSemester, 
                                           facultyName, maxEnrollment);
        offeringRepo.save(newOffering);
    }

    public Collection<Course> retrieveAllCourses() {
        return courseRepo.findAll();
    }

    public Collection<Offering> retrieveAllOfferings() {
        return offeringRepo.findAll();
    }
}
