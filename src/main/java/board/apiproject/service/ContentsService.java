package board.apiproject.service;

import board.apiproject.Repository.CommentsRepository;
import board.apiproject.Repository.ContentsRepository;
import board.apiproject.dto.Contents;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ContentsService {

    private final ContentsRepository contentsRepository;

    // service로 만들어야 하는 게 생성 수정 삭제 날짜순 정렬, 공감 많은 수 정렬,

    /**
    *  Create
    * */
    public void create(Contents contents){
        System.out.println("Service contents = " + contents);
        contentsRepository.save(contents);
    }

    /**
     * retrival 부분이 제일 중요
     * all 조회,
     * */

    // 모든 게시글 조회(기본으로 최신 날짜별로)
    public List<Contents> retrivalAll(){
        List<Contents> all = contentsRepository.findAll();
        Collections.sort(all, (o1, o2)
                -> (new Integer (o2.getContentnum()).compareTo(new Integer(o1.getContentnum() ) ) ));
        return all;
    }

    // 게시글 공감수 정렬
    public List<Contents> retrivalEmpathy(){
        List<Contents> all = contentsRepository.findAll();
        Collections.sort(all, (o1, o2)
                -> (new Integer (o2.getEmpathy()).compareTo(new Integer(o1.getEmpathy() ) ) ));
        return all;
    }

    // 게시글 검색
    //1. title로 조회
    public List<Contents> titleRetrival(Contents title) {
        return null;
    }

    //2. contents 내용으로 조회
    public List<Contents> contentsRetrival(Contents contents){
        return null;
    }

    /**
     *  Update
     *  id별로 조회
     * */
    //수정
    // contents는 내용만 변경 가능~
    public void contentsUpdate(Contents contents){

    }


    // delete 하기
    public void deleteContents(Contents contents){


    }
}
