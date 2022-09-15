package board.apiproject.dto.valid;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class MemberForm {

    @NotEmpty
    private String id; // pk 사용자 id

    @NotEmpty
    private String pass; // 사용자 비번

    @NotEmpty
    private String name; //사용자 이름

    private int age;

    @NotEmpty
    private String email;

    @NotEmpty
    private String phone;
}
