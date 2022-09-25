package board.apiproject.service;

import board.apiproject.dto.Contents;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.AbstractDocument;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
//@Transactional
public class ContentsServiceTest {

    @Autowired
    private MemberService memberService;

    @Autowired
    private ContentsService contentsService;

    //호호 성공~
    @Test
    public void createtest() {

        Contents contents = new Contents();
        contents.setId("97tkddnjs");
        contents.setTitle("hello world");
        contents.setContents("이것은 굉장히 간단한 출력문 예제입니다.");

        contentsService.create(contents);
        List<Contents> contents1 = contentsService.retrivalAll();
        for (Contents contents2 : contents1) {
            System.out.println("contents2 = " + contents2);
        }
//        assertThat()
    }

    @Test
    public void check() {
        List<Contents> contents = contentsService.retrivalAll();
        for (Contents content : contents) {
            System.out.println("content = " + content);
        }
    }
}
