package vn.edu.fpt.sba.workshop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookDTO {
    private Integer bookId;
    private String title;
    private Double price;
    private Integer publishYear;
    private AuthorDTO author;
}
