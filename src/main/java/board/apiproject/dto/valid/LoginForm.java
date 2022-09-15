package board.apiproject.dto.valid;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

// for loginform

@Data
public class LoginForm {

    @NotEmpty
    private String id; // pk 사용자 id

    @NotEmpty
    private String pass; // 사용자 비번
}
