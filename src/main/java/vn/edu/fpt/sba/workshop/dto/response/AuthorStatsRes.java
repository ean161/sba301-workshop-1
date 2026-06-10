package vn.edu.fpt.sba.workshop.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthorStatsRes {
    private Integer authorId;
    private String authorName;
    private Integer bookCount;
    private Double totalValue, averagePrice;
}
