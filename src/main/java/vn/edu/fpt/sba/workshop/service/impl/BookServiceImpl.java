package vn.edu.fpt.sba.workshop.service.impl;

import org.springframework.stereotype.Service;
import vn.edu.fpt.sba.workshop.entity.Book;
import vn.edu.fpt.sba.workshop.exception.BookNotFoundException;
import vn.edu.fpt.sba.workshop.repository.BookRepository;
import vn.edu.fpt.sba.workshop.service.IBookService;

import java.util.List;

@Service
public class BookServiceImpl implements IBookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book get(Integer id) {
        return bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
    }
}
