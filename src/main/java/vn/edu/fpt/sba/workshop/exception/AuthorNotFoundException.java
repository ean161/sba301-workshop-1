package vn.edu.fpt.sba.workshop.exception;

public class AuthorNotFoundException extends RuntimeException {
    public AuthorNotFoundException(Integer id) {
        super("Author not found with id: " + id);
    }
}
