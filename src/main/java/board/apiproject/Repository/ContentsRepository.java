package board.apiproject.Repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import board.apiproject.dto.Contents;

import javax.sql.DataSource;
import java.time.Clock;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    private final RowMapper<Contents> contentsRowMapper = (resultSet, rowNum) -> {
        Contents find_contents = new Contents();
        find_contents.setContentnum(resultSet.getInt("contentnum"));
        find_contents.setId(resultSet.getString("id"));
        find_contents.setTitle(resultSet.getString("title"));
        find_contents.setContents(resultSet.getString("content"));
        // jdbc templates에서 mysql의 LocalDateTime 을 java의 DateTime 으로 바꾸는 방법
        find_contents.setDate(resultSet.getTimestamp("contentdate").toLocalDateTime());
        find_contents.setEmpathy(resultSet.getInt("contentempathy"));

        return find_contents;
    };

    // 저장 create
    public Contents save(Contents contents) {

        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);

        System.out.println("Repository contents = " + contents);

        jdbcInsert.withTableName("contents").usingGeneratedKeyColumns("contentnum");


        Clock clock;
        DateTimeFormatter DB_TIME_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String nowtime = LocalDateTime.now().format(DB_TIME_FORMAT);

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("id", contents.getId());
        parameters.put("title", contents.getTitle());
        parameters.put("content", contents.getContents());
        parameters.put("contentdate", nowtime);
        parameters.put("contentempathy", contents.getEmpathy());

        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource(parameters);
        System.out.println("mapSqlParameterSource = " + mapSqlParameterSource);
        Number num = jdbcInsert.executeAndReturnKey(mapSqlParameterSource);
        System.out.println("num = " + num);
        contents.setContentnum(num.intValue());
        return contents;
    }

    /*
     *  retrival 영역
     *  조회는 전부 조회, id로 조회, 제목으로 조회. 콘텐츠로 조회가 있다~
     */
    // 모두 조회~
    public List<Contents> findAll() {
        String SQL = "select * from contents";

        return this.jdbcTemplate.query(SQL,contentsRowMapper);
    }


    // 회원 ID로 조회~~
    public Contents findById(String id) {
        String SQL = "select * from contents where id =?";
        Contents contents = jdbcTemplate.queryForObject(SQL, contentsRowMapper, id);
        return contents;
    }
    // title로 조회~
    public List<Contents> findByTitle(String title) {
        String SQL = "select * from contents where title like ?";
        return this.jdbcTemplate.query(SQL, contentsRowMapper, "%"+title+"%");
    }

    //contents에 잇는 내용 중 문자열로 검색~
    public List<Contents> findByContents(String contetnts) {
        String SQL = "select * from contents where contents like ?";
        return this.jdbcTemplate.query(SQL, contentsRowMapper, "%"+contetnts+"%");
    }

    /*
    *  update 부분 수정을 위한 부분이랄까나 ^.^
    * */
    // 수정시 날짜도 바꾸는 게 맞나? 인데 맞지~
    public void update(Contents contents){
        // mysql DB의 DateTime과 자바의 localdatetime은 다름 따라서 다음과 같은 형식으로 변환이 필요
        Clock clock;
        DateTimeFormatter DB_TIME_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String SQL = " UPDATE contents " +
                "SET title = ?" +
                "contents = ?" +
                "date = ?";

        String nowtime = LocalDateTime.now().format(DB_TIME_FORMAT);
        this.jdbcTemplate.update(SQL,
                contents.getTitle(),
                contents.getContents(),
                nowtime
        );
    }

    /*
     * Delete
     *
     */
    public void delete(int num) {
        String SQL ="DELETE FROM contents WHERE contentnum = ?";
        this.jdbcTemplate.update(SQL, num);
    }

}
