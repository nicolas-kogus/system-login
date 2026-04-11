package model.entities;

import java.io.*;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Users {
    private String username;
    private String password;

    public Users() {}

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername() {
        Scanner input = new Scanner(System.in);

        System.out.println();
        System.out.print("Username: ");
        String username = input.nextLine();
        String usernameFile = "/home/nicolas-kogus/IdeaProjects/system-login/src/usernames.txt";

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(usernameFile, true));
            try {
                bufferedWriter.write(username);
                bufferedWriter.newLine();
                this.username = username;
            } finally {
                bufferedWriter.close();
            }
        }

        catch (IOException | NoSuchElementException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void setPassword() {
        String password;

        try (Scanner input = new Scanner(System.in)) {

            System.out.print("Password: ");
            password = input.next();
        }

        String passwordFile = "/home/nicolas-kogus/IdeaProjects/system-login/src/passwords.txt";

        try {
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(passwordFile, true))) {
                bufferedWriter.write(password);
                bufferedWriter.newLine();
                this.password = password;
            }
        }

        catch (IOException | NoSuchElementException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public Boolean usernameValidate(String username) {
        String filePath = "/home/nicolas-kogus/IdeaProjects/system-login/src/usernames.txt";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))){
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                if (username.equals(line)) {
                    return true;
                }
            }
        }

        catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return false;
    }
}
