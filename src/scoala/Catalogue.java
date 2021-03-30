package scoala;

;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

/*
    Catalogue este clasa Serviciu, care modifica datele despre note, elevi, contacte etc
 */
public class Catalogue {
    @Override
    public String toString() {
        return "Catalog: " +
                "Elevi: " + pupils +
                "\nMaterii: " + taughtTaughtSubjects +
                "\nProfesori: " + subjectsProfessor +
                "\nAbsente: " + absences +
                "\nNote: " + grades +
                "\nContact parinti: " + pupilsContacts +
                ' ';
    }

    public Catalogue(ArrayList<Pupil> pupils, HashMap<Pupil, ArrayList<Contact>> pupilsContacts, HashSet<TaughtSubject> taughtTaughtSubjects, HashMap<TaughtSubject, Professor> subjectsProfessor, ArrayList<Absence> absences, ArrayList<Grade> grades) {
        this.pupils = pupils;
        this.pupilsContacts = pupilsContacts;
        this.taughtTaughtSubjects = taughtTaughtSubjects;
        this.subjectsProfessor = subjectsProfessor;
        this.absences = absences;
        this.grades = grades;
    }

    public ArrayList<Pupil> getPupils() {
        return pupils;
    }

    public void setPupils(ArrayList<Pupil> pupils) {
        this.pupils = pupils;
    }

    public HashMap<Pupil, ArrayList<Contact>> getPupilsContacts() {
        return pupilsContacts;
    }

    public void setPupilsContacts(HashMap<Pupil, ArrayList<Contact>> pupilsContacts) {
        this.pupilsContacts = pupilsContacts;
    }

    public HashSet<TaughtSubject> getTaughtSubjects() {
        return taughtTaughtSubjects;
    }

    public void setTaughtSubjects(HashSet<TaughtSubject> taughtTaughtSubjects) {
        this.taughtTaughtSubjects = taughtTaughtSubjects;
    }

    public HashMap<TaughtSubject, Professor> getSubjectsProfessor() {
        return subjectsProfessor;
    }

    public void setSubjectsProfessor(HashMap<TaughtSubject, Professor> subjectsProfessor) {
        this.subjectsProfessor = subjectsProfessor;
    }

    public ArrayList<Absence> getAbsences() {
        return absences;
    }

    public void setAbsences(ArrayList<Absence> absences) {
        this.absences = absences;
    }

    public ArrayList<Grade> getGrades() {
        return grades;
    }

    public void setGrades(ArrayList<Grade> grades) {
        this.grades = grades;
    }

    private ArrayList<Pupil> pupils;

    // in the catalogue, each pupil has a list of contacts (parents, guardians)
    private HashMap<Pupil, ArrayList<Contact>> pupilsContacts;

    // Let's say an Subject also has data about a professor who teaches it, his contact
    private HashSet<TaughtSubject> taughtTaughtSubjects;

    // For each Subject we have a Professor
    private HashMap<TaughtSubject, Professor> subjectsProfessor;

    // We al have a list of absence
    private ArrayList<Absence> absences; // each absence has data about the pupil, the subject, the data
    // We also have a list of grades
    private ArrayList<Grade> grades; // the grades have data about pupil, subject

    // Each pupil has MeanGPA object (data)


    /*

        1. add grade to student
        2. add absence to student
        3. remove grade
        4. remove absence
        5. remove grade for a pupil and a date
        6. remove absence for a pupil and a date
        7. update contacts for a pupil
        8. add pupils
        9. remove pupils
        10. add professor to subject

     */

    //    1. add grade to student
    public void gradePupil(Grade grade) {
        grades.add(grade);
    }

    public void gradePupil(Pupil pupil, TaughtSubject subject, int grade) {
        grades.add(
                new SimpleGrade(grade, pupil, subject)
        );
    }

    // 2. add absence to student
    public void add(Absence absence) {
        absences.add(absence);
    }

    public void add(Pupil pupil, TaughtSubject subject, Date date) {
        absences.add(
                new Absence(date, pupil, subject)
        );
    }

    // 3. remove grade
    public void remove(Grade grade) {
        grades.remove(grade);
    }

    // 4. remove absence
    public void remove(Absence absence) {
        grades.remove(absence);
    }

    // 5. remove grade for a pupil and a date
    public void removeGrades(Pupil pupil, Date date) {
        for (var grade : grades) {
            if (grade instanceof SimpleGrade) {
                SimpleGrade sg = (SimpleGrade) grade;
                if (sg.getDate().equals(date) && sg.getPupil().equals(pupil)) {
                    grades.remove(grade);
                }
            }
        }
    }

    // 6. remove absence for a pupil and a date
    public void removeAbsences(Pupil pupil, Date date) {
        for (var absence : absences) {
            if (absence.getDate().equals(date) && absence.getPupil().equals(pupil)) {
                absences.remove(absence);
            }
        }
    }

    // 7. update contacts for a pupil
    public void update(Pupil pupil, ArrayList<Contact> contacts) {
        if (contacts.size() > 2) {
            System.out.println("Elevul poate avea contacte doar pt mama si tata.");
            return;
        }
        if (contacts.size() == 0) {
            System.out.println("Nu ati introdus niciun contact nou.");
            return;
        }
        int numFathers = 0, numMothers = 0;
        for (var contact : contacts) {
            if (contact instanceof MotherContact) {
                numMothers++;
            } else if (contact instanceof FatherContact) {
                numFathers++;
            } else {
                System.out.println("Contactele copilululi pot fi de mama sau de tata");
                return;
            }
        }
        if (numFathers > 1 || numMothers > 1) {
            System.out.println("Ati introdus mai mult decat un contact de mama/tata");
            return;
        }
        pupilsContacts.put(pupil, contacts);
    }

    public void update(Pupil pupil, MotherContact mother, FatherContact father) {
        var newContacts = new ArrayList<Contact>();
        newContacts.add(mother);
        newContacts.add(father);
        pupilsContacts.put(pupil, newContacts);
    }

    // 8    add pupils
    public void add(Pupil pupil) {
        pupils.add(pupil);
    }
    public void add(String name, int grade) {
        pupils.add(new Pupil(name, grade));
    }
    public void add(Pupil pupil, int grade) {
        pupils.add(new Pupil(pupil.getName(), grade));
    }

    // 9    remove pupils
    public void remove(Pupil pupil) {
        pupils.remove(pupil);
    }
    public void remove(String name) {
        for (var pupil : pupils) {
            if (pupil.getName().equals(name)) {
                pupils.remove(pupil);
            }
        }
    }

    // 10   add professor to subject
    public void update(Professor professor, TaughtSubject subject) {
        if (subjectsProfessor.containsKey(subject)) {
            subjectsProfessor.put(subject, professor);
        }
    }

}
