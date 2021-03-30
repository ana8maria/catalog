package scoala;


import java.util.Date;
import java.util.Objects;


public class Absence {
    public Absence(Date date, Pupil pupil, TaughtSubject taughtSubject) {
        this.date = date;
        this.pupil = pupil;
        this.taughtSubject = taughtSubject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Absence absence = (Absence) o;
        return Objects.equals(date, absence.date) && Objects.equals(pupil, absence.pupil) && Objects.equals(taughtSubject, absence.taughtSubject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, pupil, taughtSubject);
    }

    @Override
    public String toString() {
            return " " +
                    pupil +
                    ' ' + date +
                    ' ' + taughtSubject +
                    ' ';
    }

    private Date date;
    private Pupil pupil;
    private TaughtSubject taughtSubject;


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Pupil getPupil() {
        return pupil;
    }

    public void setPupil(Pupil pupil) {
        this.pupil = pupil;
    }

    public TaughtSubject getTaughtSubject() {
        return taughtSubject;
    }

    public void setTaughtSubject(TaughtSubject taughtSubject) {
        this.taughtSubject = taughtSubject;
    }
}
