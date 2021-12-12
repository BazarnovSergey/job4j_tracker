package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Petrov Andrey Vladimirovich");
        student.setGroup("USV-31");
        student.setDateOfAdmission("01.09.2019");
        System.out.println("Имя студента: " + student.getName());
        System.out.println("Группа: " + student.getGroup());
        System.out.println("Дата поступления: " + student.getDateOfAdmission());
    }

}
