package com.app.jatin2;
public class TestApp {
    public static void main(String[] args) {

        CodeXPrasoon cxp = new CodeXPrasoon();

        // Inject dependency
        // cxp.setCourse(new Java());
         cxp.setCourse(new SpringBootCourse());

        Boolean status = cxp.buyTheCourse(4000.5);

        if (status) {
            System.out.println("Course Enrolled Successfully");
        } else {
            System.out.println("Failed to enroll for the Course");
        }
    }
}