package board.apiproject.service;


import board.apiproject.Repository.CommentsRepository;
import board.apiproject.dto.Comments;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentsService {

    private final CommentsRepository commentsRepository;

    public List<Comments> retrivalByContent(int num) {
        return commentsRepository.findByContents(num);
    }

}
