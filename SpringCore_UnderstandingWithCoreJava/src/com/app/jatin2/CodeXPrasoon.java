package com.app.jatin2;
public class CodeXPrasoon {
    private Course course;   // dependency
    // Setter Injection
    public void setCourse(Course course) {
        this.course = course;
    }
//    //Constructor Injection 
//    public CodeXPrasoon(Course course) {
//        this.course = course;
//    }

    public Boolean buyTheCourse(Double amount) {
        return course.getTheCourse(amount);
    }
}