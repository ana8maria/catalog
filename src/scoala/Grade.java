package scoala;

import java.util.Date;

public class Grade {
    protected Pupil pupil;
    protected TaughtSubject taughtSubject;
    protected Date date;
}

class SimpleGrade extends Grade {
    protected int grade;

    @Override
    public String toString() {
        return " " +
                grade ;
    }

    public SimpleGrade() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public Pupil getPupil() {
        return pupil;
    }

    public void setPupil(Pupil pupil) {
        this.pupil = pupil;
    }

    public TaughtSubject getSubject() {
        return taughtSubject;
    }

    public void setSubject(TaughtSubject taughtSubject) {
        this.taughtSubject = taughtSubject;
    }

    public SimpleGrade(int grade, Pupil pupil, TaughtSubject taughtSubject) {
        this.grade = grade;
        this.pupil = pupil;
        this.taughtSubject = taughtSubject;
    }
}

class Thesis extends SimpleGrade {


}