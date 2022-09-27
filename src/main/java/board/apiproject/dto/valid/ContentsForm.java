package board.apiproject.dto.valid;


import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class ContentsForm {
    //@NotEmpty
    private int contentnum; // pk


    @NotNull
    @Length(min =1 ,max=100)
    private String title;

    @NotNull
    @Length(min =1 ,max=1000)
    private String contents;


    private LocalDateTime date;

    private int empathy;
}
