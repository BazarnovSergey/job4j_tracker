package ru.job4j.inheritance;

public class Dentist extends Doctor {
    private String category;

    public Dentist(String name, String surname, String education, String birthday,
                   String academicDegree, String category) {
        super(name, surname, education, birthday, academicDegree);
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void treatTeeth() {
    }
}
