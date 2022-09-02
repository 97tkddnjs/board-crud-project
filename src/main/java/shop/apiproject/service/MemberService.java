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
     *  생성 로그인
     */
    public void create(Member member){
        this.memberRepository.save(member);
    }

    // 만약 없음 null 세션을 주려면 정보로 줘야되지 않나?
    public Member login(String id, String pass){
        try{
            if( memberRepository.findById(id).getPass().equals(pass)){
                return memberRepository.findById(id);
            }
        }catch(Exception e){

        }
        return null;
    }

}
