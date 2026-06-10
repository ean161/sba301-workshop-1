package vn.edu.fpt.sba.workshop.service;

import vn.edu.fpt.sba.workshop.dto.request.CreateAuthorReq;
import vn.edu.fpt.sba.workshop.dto.response.AuthorStatsRes;
import vn.edu.fpt.sba.workshop.entity.Author;
import vn.edu.fpt.sba.workshop.entity.Book;

import java.util.List;

public interface IBookService {
    List<Book> getAll();
    Book get(Integer id);
}
