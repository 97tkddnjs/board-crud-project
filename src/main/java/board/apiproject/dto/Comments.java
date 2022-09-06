package board.apiproject.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class Comments {

    @NotEmpty
    private int commentidx;

    @NotNull
    private int contentnum; //fk

    @NotNull
    private String id;      //fk

    @NotNull
    @Range(min=1 , max =100)
    private String comments;

    @NotNull
    private LocalDateTime date;

    private int comments_empathy;

}
