package ccrm.dao;

import ccrm.model.Course;
import java.util.*;

public class CourseRepository {
    private final Map<String, Course> courseDatabase;

    public CourseRepository() {
        this.courseDatabase = new HashMap<>();
    }

    public void save(Course course) {
        if (course == null) {
            throw new IllegalArgumentException("Course cannot be null");
        }
        courseDatabase.put(course.getCourseCode(), course);
    }

    public Course findByCode(String courseCode) {
        return courseDatabase.get(courseCode);
    }

    public Collection<Course> findAll() {
        return courseDatabase.values();
    }

    public void remove(String courseCode) {
        courseDatabase.remove(courseCode);
    }

    public boolean exists(String courseCode) {
        return courseDatabase.containsKey(courseCode);
    }
}
