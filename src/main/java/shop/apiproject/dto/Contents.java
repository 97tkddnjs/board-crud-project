package shop.apiproject.dto;


import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class Contents {

    @NotNull
    private int contentnum; // pk

    @NotEmpty
    private String id; // fk 사용자 id

    private String title;

    private String contents;

    private LocalDateTime date;

    private int empathy;

}
