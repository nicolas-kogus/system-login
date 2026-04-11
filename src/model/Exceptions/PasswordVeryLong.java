package model.Exceptions;

public class PasswordVeryLong extends RuntimeException {
    public PasswordVeryLong(String message) {
        super(message);
    }
}
