package board.apiproject.dto;


import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;



@Data
public class Contents {

    //@NotEmpty
    private int contentnum; // pk

    //@NotEmpty
    private String id; // fk 사용자 id

    @NotNull
    @Range(min =1 ,max=100)
    private String title;

    @NotNull
    @Range(min =1 ,max=1000)
    private String contents;


    private LocalDateTime date;

    private int empathy;

}
