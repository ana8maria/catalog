package scoala;

public class TaughtSubject {
    private String name;
    private Professor professor;
    private Contact professorContact;

    @Override
    public String toString() {
        return " " +
                name
                //' ' + professor +
                //' ' + professorContact +
        ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Contact getProfessorContact() {
        return professorContact;
    }

    public void setProfessorContact(Contact professorContact) {
        this.professorContact = professorContact;
    }

    public TaughtSubject(String name, Professor professor, Contact professorContact) {
        this.name = name;
        this.professor = professor;
        this.professorContact = professorContact;
    }
}
