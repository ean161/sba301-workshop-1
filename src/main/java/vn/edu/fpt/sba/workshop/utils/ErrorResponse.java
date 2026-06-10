package vn.edu.fpt.sba.workshop.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Data
public class ErrorResponse {

    private String error;

    private LocalDateTime timestamp;

    public ErrorResponse(String error, LocalDateTime timestamp) {
        this.error = error;
        this.timestamp = timestamp;
    }
}
