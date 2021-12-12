package ru.job4j.inheritance;

public class Doctor extends Profession {
    private String academicDegree;

    public Doctor() {
    }

    public Doctor(String name, String surname, String education, String birthday,
                  String academicDegree) {
        super(name, surname, education, birthday);
        this.academicDegree = academicDegree;
    }

    public String getAcademicDegree() {
        return academicDegree;
    }

    public Diagnosis heal(Pacient pacient) {
        return new Diagnosis();
    }
}
