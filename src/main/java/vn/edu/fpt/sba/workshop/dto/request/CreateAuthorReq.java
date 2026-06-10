package vn.edu.fpt.sba.workshop.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateAuthorReq {

    private String name, nationality;

    private Integer birthYear;
}
