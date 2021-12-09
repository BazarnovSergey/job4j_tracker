package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("Active: " + active);
        System.out.println("Status: " + status);
        System.out.println("Message: " + message);
    }

    public static void main(String[] args) {
        Error error = new Error();
        Error memoryError = new Error(true, 1, "OutOfMemoryError");
        Error fileError = new Error(true, 2, "FileNotFoundException");
        Error arrayError = new Error(false, 3, "ArrayIndexOutOfBoundsException");
        error.printInfo();
        memoryError.printInfo();
        fileError.printInfo();
        arrayError.printInfo();
    }
}
