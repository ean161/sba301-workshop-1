package vn.edu.fpt.sba.workshop.utils;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import vn.edu.fpt.sba.workshop.entity.Book;
import vn.edu.fpt.sba.workshop.exception.AuthorNotFoundException;
import vn.edu.fpt.sba.workshop.exception.BookNotFoundException;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AuthorNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse authorNotFoundException(AuthorNotFoundException ex) {
        return new ErrorResponse(ex.getMessage(), LocalDateTime.now());
    }

    @ExceptionHandler(BookNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse bookNotFoundException(BookNotFoundException ex) {
        return new ErrorResponse(ex.getMessage(), LocalDateTime.now());
    }
}
