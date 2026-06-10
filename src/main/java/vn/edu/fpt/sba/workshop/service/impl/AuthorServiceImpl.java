package vn.edu.fpt.sba.workshop.service.impl;

import org.springframework.stereotype.Service;
import vn.edu.fpt.sba.workshop.dto.request.CreateAuthorReq;
import vn.edu.fpt.sba.workshop.dto.response.AuthorStatsRes;
import vn.edu.fpt.sba.workshop.entity.Author;
import vn.edu.fpt.sba.workshop.entity.Book;
import vn.edu.fpt.sba.workshop.exception.AuthorNotFoundException;
import vn.edu.fpt.sba.workshop.repository.AuthorRepository;
import vn.edu.fpt.sba.workshop.service.IAuthorService;

import java.util.List;

@Service
public class AuthorServiceImpl implements IAuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> getAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author get(Integer id) {
        return authorRepository.findById(id).orElseThrow(() -> new AuthorNotFoundException(id));
    }

    @Override
    public Author create(CreateAuthorReq req) {
        Author author = new Author(req.getName(), req.getNationality(), req.getBirthYear());
        return authorRepository.save(author);
    }

    @Override
    public void delete(Integer id) {
        authorRepository.deleteById(id);
    }

    @Override
    public AuthorStatsRes stats(Integer id) {
        Author author = get(id);
        List<Book> books = author.getBooks();
        Integer bookCount = books.size();
        Double totalVal = 0.0, average = 0.0;
        for (Book book : books) {
            totalVal += book.getPrice();
        }
        average = totalVal / bookCount;
        return new AuthorStatsRes(author.getId(), author.getName(), bookCount, totalVal, average);
    }
}
