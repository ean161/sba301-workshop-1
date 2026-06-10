package vn.edu.fpt.sba.workshop.service;

import vn.edu.fpt.sba.workshop.dto.AuthorDTO;
import vn.edu.fpt.sba.workshop.dto.request.CreateAuthorReq;
import vn.edu.fpt.sba.workshop.dto.response.AuthorStatsRes;
import vn.edu.fpt.sba.workshop.entity.Author;

import java.util.List;

public interface IAuthorService {
    List<Author> getAll();
    Author get(Integer id);
    Author create(CreateAuthorReq req);
    void delete(Integer id);
    AuthorStatsRes stats(Integer id);
}
