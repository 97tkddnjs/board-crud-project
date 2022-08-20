package shop.apiproject.service;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.apiproject.Repository.MemberRepository;
import shop.apiproject.dto.Member;


@Transactional
@Service
//@RequiredArgsConstructor
public class MemberService {

   private final MemberRepository memberRepository;

   //외부에서 메모리를 가져오는 것 DI(Dependency Injection)

    @Autowired
   public MemberService(MemberRepository memberRepository){
       this.memberRepository = memberRepository;
   }

    /**
     *  회원가입
     */
    public void create(Member member){

        this.memberRepository.save(member);
    }



}
