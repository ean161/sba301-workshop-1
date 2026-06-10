package vn.edu.fpt.sba.workshop.entity;

import jakarta.persistence.*;
import lombok.Data;
import vn.edu.fpt.sba.workshop.dto.AuthorDTO;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "nationality")
    private String nationality;

    @Column(name = "birth_year")
    private Integer birthYear;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Book> books = new ArrayList<>();

    public Author() {

    }

    public Author(String name, String nationality, Integer birthYear) {
        this.name = name;
        this.nationality = nationality;
        this.birthYear = birthYear;
    }

    public AuthorDTO toAuthorDTO() {
        return new AuthorDTO(id, name, nationality, birthYear);
    }
}
