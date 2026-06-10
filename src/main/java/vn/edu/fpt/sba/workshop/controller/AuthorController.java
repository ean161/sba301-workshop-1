package vn.edu.fpt.sba.workshop.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import vn.edu.fpt.sba.workshop.dto.AuthorDTO;
import vn.edu.fpt.sba.workshop.dto.BookDTO;
import vn.edu.fpt.sba.workshop.dto.request.CreateAuthorReq;
import vn.edu.fpt.sba.workshop.dto.response.AuthorStatsRes;
import vn.edu.fpt.sba.workshop.entity.Author;
import vn.edu.fpt.sba.workshop.entity.Book;
import vn.edu.fpt.sba.workshop.service.IAuthorService;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    private final IAuthorService authorService;

    public AuthorController(IAuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AuthorDTO> getAll() {
        return authorService.getAll().stream().map(Author::toAuthorDTO).toList();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    private AuthorDTO get(@PathVariable Integer id) {
        return authorService.get(id).toAuthorDTO();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private AuthorDTO create(@RequestBody CreateAuthorReq req) {
        return authorService.create(req).toAuthorDTO();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void delete(@PathVariable Integer id) {
        authorService.delete(id);
    }

    @GetMapping("/{id}/books")
    @ResponseStatus(HttpStatus.OK)
    public List<BookDTO> getAuthorBooks(@PathVariable Integer id) {
        Author author = authorService.get(id);
        return author.getBooks().stream().map(Book::toBookDTO).toList();
    }

    @GetMapping("/{id}/stats")
    @ResponseStatus(HttpStatus.OK)
    private AuthorStatsRes stats(@PathVariable Integer id) {
        return authorService.stats(id);
    }
}
