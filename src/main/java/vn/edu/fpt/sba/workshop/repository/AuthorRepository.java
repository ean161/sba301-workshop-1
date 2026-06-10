package vn.edu.fpt.sba.workshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.fpt.sba.workshop.entity.Author;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
    List<Author> findAll();
    Optional<Author> findById(Integer id);
    void deleteById(Integer id);
}
