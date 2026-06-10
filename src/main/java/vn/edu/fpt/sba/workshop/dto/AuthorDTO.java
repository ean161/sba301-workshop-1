package vn.edu.fpt.sba.workshop.dto;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthorDTO {
    private Integer authorId;
    private String name, nationality;
    private Integer birthYear;
}
