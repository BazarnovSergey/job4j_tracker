package ru.job4j.inheritance;

public class Builder extends Engineer {
    private int rank;

    public Builder() {
    }

    public Builder(String name, String surname, String education, String birthday,
                   String specialization, int rank) {
        super(name, surname, education, birthday, specialization);
        this.rank = rank;
    }

    public int getRank() {
        return rank;
    }

    public House buildHouse(Project project) {
        return new House();
    }
}
