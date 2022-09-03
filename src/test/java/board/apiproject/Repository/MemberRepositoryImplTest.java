package board.apiproject.Repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import board.apiproject.dto.Member;

import java.util.List;

@SpringBootTest
@Transactional
class MemberRepositoryImplTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    void save() {

        Member member = new Member();
        member.setId("boy");
        member.setPass("123456");
        member.setName("lee");
        member.setAge(27);
        member.setEmail("lsw@naver.com");
        member.setPhone("01012341234");
//        System.out.println("ojk");
        System.out.println("member = " + member);
        Member save = memberRepository.save(member);
        System.out.println("save = " + save);
    }

    @Test
    void findId() {
        String id ="97tkddnjs";
        Member member = memberRepository.findById(id);
//        System.out.println("ojk");
        System.out.println("member = " + member);
//        memberRepository.save(member);
    }

    @Test
    void findList() {

        List<Member> all = memberRepository.findAll();
//        System.out.println("ojk");
        for(Member o: all){
            System.out.println("o = " + o);
        }
//        memberRepository.save(member);
    }
}