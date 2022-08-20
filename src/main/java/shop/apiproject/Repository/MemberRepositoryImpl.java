package shop.apiproject.Repository;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import shop.apiproject.dto.Member;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@Component //하나뿐인 생성자를 자동 의존 주입하므로 Test 시 확인해보겠음
@Repository
public class MemberRepositoryImpl implements MemberRepository{

    private final JdbcTemplate jdbcTemplate;
    private final DataSource dataSource;

//    @Autowired
    public MemberRepositoryImpl(DataSource dataSource) {
        System.out.println("conse");
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.dataSource = dataSource;
    }

    @Override
    public Member save(Member member) {

        System.out.println("here");

        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);

        jdbcInsert.withTableName("member").usingGeneratedKeyColumns("num");

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("id", member.getId());
        parameters.put("pass", member.getPass());
        parameters.put("name", member.getName());
        parameters.put("age", member.getAge());
        parameters.put("email", member.getEmail());
        parameters.put("phone", member.getPhone());

        Number num = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
        System.out.println("num = " + num);
        member.setNum(num.intValue());

        return member;

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
