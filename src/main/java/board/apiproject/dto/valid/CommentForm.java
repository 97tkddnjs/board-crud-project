package board.apiproject.dto.valid;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

@Data
public class CommentForm {


    @NotNull
    @Range(min=1 , max =100)
    private String comments;


}
