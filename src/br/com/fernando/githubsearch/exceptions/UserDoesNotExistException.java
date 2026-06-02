package br.com.fernando.githubsearch.exceptions;

public class UserDoesNotExistException extends RuntimeException {
    private String message;

    public UserDoesNotExistException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
