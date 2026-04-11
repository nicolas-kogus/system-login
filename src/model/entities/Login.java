package model.entities;

public class Login extends Users{
    public Login(String username, String password) {
        super(username, password);
    }

    public Login() {
    }

    public void userLogin(String username) {
        if (usernameValidate(username)) {
            System.out.println();
            System.out.println("User logged in successfully!");
        } else {
            System.out.println();
            System.out.println("User does not exist!");
        }
    }
}
