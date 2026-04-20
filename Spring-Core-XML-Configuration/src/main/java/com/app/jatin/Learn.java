package com.app.jatin;

// Bean
public class Learn {

    // primitive type dependency
    private int sid;
    private String name;

    public Learn() {
        super();
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Learn [sid=" + sid + ", name=" + name + "]";
    }
}