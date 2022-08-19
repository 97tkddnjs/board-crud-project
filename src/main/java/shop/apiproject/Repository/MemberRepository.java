package shop.apiproject.Repository;

import shop.apiproject.dto.Member;

import java.util.List;

public interface MemberRepository {
    public Member save(Member member);

    public Member findById(Long id);

    public List<Member> findAll(); // 모든 회원 찾기
}
