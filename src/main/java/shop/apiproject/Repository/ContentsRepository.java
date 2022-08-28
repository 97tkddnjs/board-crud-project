package shop.apiproject.Repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import shop.apiproject.dto.Contents;
import shop.apiproject.dto.Member;

import javax.sql.DataSource;

@Repository
public class ContentsRepository {
    /*
    *  모든 정보 조회 후에 num , title , 작성자, 시간으로 보여주기~
    *  먼저 보여주기 위한 all 조회 함수
    *  title로 조회하기 위한 것 하나~
    *  ID로 조회하는 것 하나
    *  날짜로 조히하기 위한 함수 하나~
    * */
    private final JdbcTemplate jdbcTemplate;
    private final DataSource dataSource;

    //    @Autowired
    public ContentsRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.dataSource = dataSource;
    }

    // 저장은 해야지 ㅜㅜ
    public Contents save(Contents contents) {

        return null;
    }
    // 모두 조회~

    // 회원 ID로 조회~~

    // title로 조회~

    //날짜로 조회~~

    //contents에 잇는 내용 중 문자열로 검색~



}
