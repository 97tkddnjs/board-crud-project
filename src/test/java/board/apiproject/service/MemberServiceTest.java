package board.apiproject.service;

import board.apiproject.Repository.ContentsRepository;
import board.apiproject.dto.Contents;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import board.apiproject.dto.Member;

import java.util.List;

@SpringBootTest
class MemberServiceTest {

//    @Autowired
//    private MemberRepository memberRepository;

    @Autowired
    private MemberService memberService;

    @Autowired
    private ContentsService contentsService;

    @Autowired
    private ContentsRepository contentsRepository;

    @Test
    @Transactional
    void create() {
        Member member = new Member();
        member.setId("hello");
        member.setPass("12345");
        member.setName("lee");
        member.setAge(27);
        member.setEmail("97tkddnjse@naver.com");
        member.setPhone("01012341234");

        memberService.create(member);
    }


    @Test
    @Transactional
    void sortingTest() {

        Member member = new Member();
        member.setId("ok");
        member.setPass("12345");
        member.setName("lee");
        member.setAge(27);
        member.setEmail("97tkddnjse@naver.com");
        member.setPhone("01012341234");

        memberService.create(member);


        Contents contents1 = new Contents();
        contents1.setId("ok");
        contents1.setTitle("hello world");
        contents1.setContents("this is new world");

        contentsService.create(contents1);

        Contents contents2 = new Contents();
        contents2.setId("ok");
        contents2.setTitle("hello world");
        contents2.setContents("this is new world");

        contentsService.create(contents2);

        List<Contents> contents = contentsService.retrivalAll();

        for (Object o : contents) {
            System.out.println("o = " + o);
        }

    }
}