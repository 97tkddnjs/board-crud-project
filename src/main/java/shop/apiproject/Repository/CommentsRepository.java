package shop.apiproject.Repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import shop.apiproject.dto.Comments;
import shop.apiproject.dto.Contents;


import javax.sql.DataSource;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class CommentsRepository {

    /*
    * 여기서는 자동 생성자로 한번 해봄~
    * CRUD에 충실하게 제작할 것
    *  */
    private final JdbcTemplate jdbcTemplate;

    private final DataSource dataSource;

    /*
    * insert 부분부터 충실하게게
    * Generation key가 진짜 편하긴 한 데 다른 방법도 찾아보기 한번
    * */
    public Comments save(Comments contents) {
        return null;
    }

    // retrival
    /*
    *  all 조회,
    * */
    public List<Comments> findAll() {

        return null;
    }

    public List<Comments> findByContents(int num){
        return null;
    }

    //update
    /*
    *  댓글 수정기능
    * */

    public void update(Comments comments) {

    }
}
