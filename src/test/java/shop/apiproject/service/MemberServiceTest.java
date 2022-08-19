package shop.apiproject.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import shop.apiproject.Repository.MemberRepository;
import shop.apiproject.dto.Member;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class MemberServiceTest {

//    @Autowired
//    private MemberRepository memberRepository;

    @Autowired
    private MemberService memberService;

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
}