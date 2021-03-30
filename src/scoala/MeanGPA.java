package scoala;

import java.util.HashMap;

public class MeanGPA {
    @Override
    public String toString() {
        return "\nMedia: " +
                grades +
                ' ';
    }

    private HashMap<TaughtSubject, SimpleGrade> grades;

    public HashMap<TaughtSubject, SimpleGrade> getGrades() {
        return grades;
    }

    public void setGrades(HashMap<TaughtSubject, SimpleGrade> grades) {
        this.grades = grades;
    }

    public MeanGPA(HashMap<TaughtSubject, SimpleGrade> grades) {
        this.grades = grades;
    }
}
