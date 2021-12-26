package ru.job4j.ex;

import java.util.Objects;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        for (User user : users) {
            if (Objects.equals(login, user.getUsername())) {
                return user;
            }
        }
        throw new UserNotFoundException("UserNotFoundException");
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (user.isValid() && user.getUsername().length() > 3) {
            return true;
        }
        throw new UserInvalidException("UserInvalidException");
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true)
        };
        User user = null;
        try {
            user = findUser(users, "Petr Arsentev");
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
        try {
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException e) {
            e.printStackTrace();
        }
    }
}
