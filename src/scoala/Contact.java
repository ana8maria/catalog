package scoala;

public class Contact {

    @Override
    public String toString() {
        return name +
                ' ' + number +
                ' ' + email +
                ' ';
    }

    private String name;
    private String number;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Contact() {
        this.name = "";
        this.number = "";
        this.email = "";
    }

    public Contact(String name, String number, String email) {
        this.name = name;
        this.number = number;
        this.email = email;
    }
}

class ProfessorContact extends Contact      {
    private Professor professor;

    @Override
    public String toString() {
        return "\nContact profesor: "
                + super.toString()
                //+ professor
                + ' ';
    }

    public ProfessorContact(String name, String number, String email) {
        super(name, number, email);
        professor = new Professor(name);
    }
}

class FatherContact extends Contact {

    public FatherContact(String name, String number, String email) {
        super(name, number, email);
    }
}
class MotherContact extends Contact {

    public MotherContact(String name, String number, String email) {
        super(name, number, email);
    }
}