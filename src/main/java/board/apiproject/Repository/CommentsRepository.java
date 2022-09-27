package board.apiproject.Repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import board.apiproject.dto.Comments;


import javax.sql.DataSource;
import java.time.Clock;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class CommentsRepository {

    /*
    * 여기서는 자동 생성자로 한번 해봄~
    * CRUD에 충실하게 제작할 것
    *  */
    private final JdbcTemplate jdbcTemplate;

    private final DataSource dataSource;

    private final RowMapper<Comments> commentsRowMapper = (resultSet, rowNum) -> {
        Comments find_comments = new Comments();
        find_comments.setContentnum(resultSet.getInt("commentnum"));
        find_comments.setContentnum(resultSet.getInt("contentnum"));
        find_comments.setId(resultSet.getString("id"));
        find_comments.setComments(resultSet.getString("comments"));
        // jdbc templates에서 mysql의 LocalDateTime 을 java의 DateTime 으로 바꾸는 방법
        find_comments.setDate(resultSet.getTimestamp("commentsdate").toLocalDateTime());
        find_comments.setComments_empathy(resultSet.getInt("contentempathy"));

        return find_comments;
    };

    /*
    * insert 부분부터 충실하게게
    * Generation key가 진짜 편하긴 한 데 다른 방법도 찾아보기 한번
    * */
    public Comments save(Comments comments) {

        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);

        jdbcInsert.withTableName("comments").usingGeneratedKeyColumns("commentnum");

        System.out.println("comment "+comments);
        Clock clock;
        DateTimeFormatter DB_TIME_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String nowtime = LocalDateTime.now().format(DB_TIME_FORMAT);



        Map<String, Object> parameters = new HashMap<>();

        parameters.put("contentnum", comments.getContentnum());
        parameters.put("id", comments.getId());
        parameters.put("comments", comments.getComments());
        parameters.put("commentsdate", nowtime);
        parameters.put("contentempathy", comments.getComments_empathy());

        System.out.println("afer comment "+comments);
        Number num = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
        System.out.println("last comment "+comments);
        comments.setContentnum(num.intValue());

        return comments;
    }

    // retrival
    /*
    *  all 조회,
    * */
    public List<Comments> findAll() {
        String SQL ="select * from comments";
        try{
            return this.jdbcTemplate.query(SQL,commentsRowMapper);
        }catch (Exception e){
            return null;
        }
    }

    public List<Comments> findByContents(int num){
        String SQL ="select * from comments where contentnum = ?";

        try{
            return this.jdbcTemplate.query(SQL,commentsRowMapper,num);
        }catch (Exception e){
            return null;
        }
    }

    //update
    /*
    *  댓글 수정기능
    * */

    public void update(Comments comments) {
        // mysql DB의 DateTime과 자바의 localdatetime은 다름 따라서 다음과 같은 형식으로 변환이 필요
        Clock clock;
        DateTimeFormatter DB_TIME_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String SQL = " UPDATE comments " +
                "SET comments = ?" +
                "date = ?";

        String nowtime = LocalDateTime.now().format(DB_TIME_FORMAT);
        this.jdbcTemplate.update(SQL,
                comments.getComments(),
                nowtime
        );
    }

    /*
     * Delete
     *
     */
    public void delete(int num) {
        String SQL ="DELETE FROM comments WHERE commentnum = ?";
        this.jdbcTemplate.update(SQL, num);
    }
}
