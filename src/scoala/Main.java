package scoala;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        ArrayList<Pupil> pupils = new ArrayList<Pupil>();
        pupils.addAll(
                Arrays.asList(
                        new Pupil("Vlad Smaranda", 12),
                        new Pupil("Oltean Andreea", 12),
                        new Pupil("Zanoaga Stefania", 12),
                        new Pupil("Nastase Adina", 12)
                )
        );

        ArrayList<TaughtSubject> subjects = new ArrayList<>();
        subjects.add(
                new TaughtSubject(
                        "Mate", new Professor("Vrana Alina"),
                        new ProfessorContact("Vrana Alina", "0757345374", "vrana@hotmail.com")
                )
        );
        subjects.add(
                new TaughtSubject(
                        "Romana", new Professor("Roman Camelia"),
                        new ProfessorContact("Roman Camelia", "0723357153", "roman@hotmail.com")
                )
        );
        subjects.add(
                new TaughtSubject(
                        "Lb. Engleza", new Professor("Craciun Rodica"),
                        new ProfessorContact("Craciun Rodica", "0774549253", "craciun@hotmail.com")
                )
        );
        subjects.add(
                new TaughtSubject(
                        "Lb. franceza", new Professor("Aldea Nadina"),
                        new ProfessorContact("Aldea Nadina", "0767453324", "aldea@hotmail.com")
                )
        );


        // for Taught subjects
        ArrayList<Professor> professors = new ArrayList<>();
        professors.add(new Professor("Vrana Alina"));
        professors.add(new Professor("Roman Camelia"));
        professors.add(new Professor("Craciun Rodica"));
        professors.add(new Professor("Aldea Nadina"));

        HashMap<TaughtSubject, Professor> subjectsProfessor = new HashMap<>();
        subjectsProfessor.put(
                subjects.get(0),
                professors.get(0)
        );
        subjectsProfessor.put(
                subjects.get(1),
                professors.get(1)
        );
        subjectsProfessor.put(
                subjects.get(2),
                professors.get(2)
        );
        subjectsProfessor.put(
                subjects.get(3),
                professors.get(3)
        );


        ArrayList<Absence> absences = new ArrayList<>();
        absences.add(new Absence(new Date(), pupils.get(0), subjects.get(0)));
        absences.add(new Absence(new Date(2021,02,02, 12, 00), pupils.get(1), subjects.get(2)));


        ArrayList<Grade> grades = new ArrayList<>();
        grades.add(new SimpleGrade(10, pupils.get(0), subjects.get(0)));
        grades.add(new SimpleGrade(9, pupils.get(0), subjects.get(0)));
        grades.add(new SimpleGrade(10, pupils.get(1), subjects.get(1)));
        grades.add(new SimpleGrade(8, pupils.get(1), subjects.get(1)));


        Catalogue catalogue = new Catalogue(
                pupils,
                new HashMap<>(),
                new HashSet<>(subjects),
                subjectsProfessor,
                absences,
                grades
        );

        catalogue.update(pupils.get(0),
                new MotherContact("Nicoleta", "0734234271", "nicoleta@gmail.com"),
                new FatherContact("Marian", "0783316242", "emarian@gmail.com")
        );

        System.out.println(catalogue);

    }
}
