package vn.edu.fpt.sba.workshop.entity;

import jakarta.persistence.*;
import lombok.Data;
import vn.edu.fpt.sba.workshop.dto.BookDTO;

@Entity
@Data
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private Double price;

    @Column(name = "publish_year")
    private Integer publishYear;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    public BookDTO toBookDTO() {
        return new BookDTO(id, title, price, publishYear, author.toAuthorDTO());
    }
}
