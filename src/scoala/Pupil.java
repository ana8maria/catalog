package scoala;

import java.util.Objects;

public class Pupil {
    private String name;
    private int grade; // clasa...

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pupil pupil = (Pupil) o;
        return grade == pupil.grade && Objects.equals(name, pupil.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, grade);
    }

    @Override
    public String toString() {
        return " " +
                name
                //' ' + grade
        ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public Pupil(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }
}
