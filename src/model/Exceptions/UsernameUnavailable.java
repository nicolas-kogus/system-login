package model.Exceptions;

public class UsernameUnavailable extends RuntimeException {
    public UsernameUnavailable(String message) {
        super(message);
    }
}
