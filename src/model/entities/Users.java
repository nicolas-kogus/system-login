package model.entities;

import model.Exceptions.PasswordVeryLong;
import model.Exceptions.UsernameUnavailable;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
        String line;

        System.out.println();
        System.out.print("Username: ");
        String username = input.nextLine();
        String usernameFile = "/home/nicolas-kogus/IdeaProjects/system-login/src/usernames.txt";

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(usernameFile, true));
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(usernameFile));

                    line = bufferedReader.readLine();

                    if (!usernameValidate(username)) {
                        if (line != null) {
                            bufferedReader.readLine();
                        }

                        bufferedWriter.write(username);
                        bufferedWriter.newLine();
                        this.username = username;
                    } else {
                        throw new UsernameUnavailable("Error: This username is already in use.");
                    }

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
        String stringHash = "";

        try (Scanner input = new Scanner(System.in)) {

            System.out.print("Password: ");
            password = input.next();

            if (password.length() > 15) {
                throw new PasswordVeryLong("Error: The password must be a maximum of 15 characters long.");
            }

            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(password.getBytes());
            stringHash = new String(messageDigest.digest());
        }

        catch (NoSuchAlgorithmException e) {
            System.out.println("Error " + e.getMessage());
        }

        String passwordFile = "/home/nicolas-kogus/IdeaProjects/system-login/src/passwords.txt";

        try {
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(passwordFile, true))) {
                bufferedWriter.write(stringHash);
                bufferedWriter.newLine();
                this.password = stringHash;
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
