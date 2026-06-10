package vn.edu.fpt.sba.workshop.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import vn.edu.fpt.sba.workshop.dto.BookDTO;
import vn.edu.fpt.sba.workshop.entity.Book;
import vn.edu.fpt.sba.workshop.service.IBookService;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final IBookService bookService;

    public BookController(IBookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    private List<BookDTO> getAll() {
        return bookService.getAll().stream().map(Book::toBookDTO).toList();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    private BookDTO get(@PathVariable Integer id) {
        return bookService.get(id).toBookDTO();
    }
}
