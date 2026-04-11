package application;

import model.entities.Login;
import model.entities.Users;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Escolha o que deseja fazer: ");
        System.out.println();
        System.out.println("[1] LOGIN");
        System.out.println("[2] REGISTER");
        System.out.println();
        System.out.print(": ");
        int escolha = input.nextInt();
        input.nextLine();
        System.out.println();

        if (escolha == 1) {
            System.out.print("Username: ");
            String  username = input.nextLine();

            System.out.print("Password: ");
            String password = input.next();

            Login login = new Login();
            login.userLogin(username);
        }

        else if (escolha == 2) {
            System.out.print("Username: ");
            String  username = input.nextLine();

            System.out.print("Password: ");
            String password = input.next();

            Users users = new Users(username, password);
            users.setUsername(username);
            users.setPassword(password);
        }
    }
}