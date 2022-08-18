package shop.Repository;

import shop.dto.Member;

import java.util.List;

public interface MemberRepository {
    public Member save(Member member);

    public Member findById(Long id);

    public List<Member> findAll();
}
