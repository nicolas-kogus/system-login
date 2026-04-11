package application;

import model.entities.Users;

public class Program {
    public static void main(String[] args) {
        Users users = new Users();

        System.out.println(users.usernameValidate("Nicolas Kogus"));
    }
}