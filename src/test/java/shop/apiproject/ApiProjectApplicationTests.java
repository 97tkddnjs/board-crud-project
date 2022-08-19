package shop.apiproject;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import shop.Repository.MemberRepository;
import shop.Repository.MemberRepositoryImpl;
import shop.dto.Member;

@SpringBootTest
@Transactional
class ApiProjectApplicationTests {


	@Autowired
	private MemberRepository memberRepository;
	@Test
	void save() {

		Member member = new Member();
		member.setId("97tkddnjs");
		member.setPass("12345");
		member.setName("lee");
		member.setAge(27);
		member.setEmail("97tkddnjse@naver.com");
		member.setPhone("01012341234");
//        System.out.println("ojk");
		System.out.println("member = " + member);
		memberRepository.save(member);
	}

	@Test
	void contextLoads() {



	}

}
