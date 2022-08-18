package shop.dto;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class Member {

    private int num;

    @NotEmpty
    private Long id; // 사용자 id

    @NotEmpty
    private String pass; // 사용자 비번

    @NotEmpty
    private String name; //사용자 이름

    private int age;

    private String email;

    private String phone;

}