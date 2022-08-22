package shop.apiproject.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Comments {

    private int commentidx;

    private int contentnum; //fk

    private String id;      //fk

    private String comments;

    private LocalDateTime date;

    private int comments_empathy;

}
