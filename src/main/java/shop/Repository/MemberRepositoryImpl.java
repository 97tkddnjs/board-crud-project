package shop.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import shop.dto.Member;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

@Repository("MemberRepository")//하나뿐인 생성자를 자동 의존 주입하므로 Test 시 확인해보겠음
public class MemberRepositoryImpl implements MemberRepository{

    private final JdbcTemplate jdbcTemplate;
    private final DataSource dataSource;

    @Autowired
    public MemberRepositoryImpl(DataSource dataSource) {
        System.out.println("conse");
        jdbcTemplate = new JdbcTemplate(dataSource);
        this.dataSource = dataSource;
    }

    @Override
    public Member save(Member member) {
        System.out.println("here");
//        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
//        jdbcInsert.withTableName("member").usingGeneratedKeyColumns("num");
//
//        Map<String, Object> parameters = new HashMap<>();
//        parameters.put("id", member.getId());
//        parameters.put("pass", member.getPass());
//        parameters.put("name", member.getName());
//        parameters.put("age", member.getAge());
//        parameters.put("email", member.getEmail());
//        parameters.put("phone", member.getPhone());
//
//        Number num = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
//        System.out.println("num = " + num);
//        member.setNum(num.intValue());
        return member;

        //return null;
    }

    @Override
    public Member findById(Long id) {
        return null;
    }

    @Override
    public List<Member> findAll() {
        return null;
    }
}
