package board.apiproject.controller;

import board.apiproject.SessionConst;
import board.apiproject.dto.Comments;
import board.apiproject.dto.Contents;
import board.apiproject.dto.Member;
import board.apiproject.dto.valid.CommentForm;
import board.apiproject.dto.valid.ContentsForm;
import board.apiproject.dto.valid.MemberForm;
import board.apiproject.service.CommentsService;
import board.apiproject.service.ContentsService;
import board.apiproject.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;


@Controller
@Slf4j
@RequiredArgsConstructor
public class MainController {
    private final MemberService memberService;
    private final ContentsService contentsService;

    private final CommentsService commentsService;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @PostMapping("/")
    public String hello() {

        return "index";
    }

    // 게시판 관련!
    @GetMapping("/list")
    public String list(Model model){
        List<Contents> contents = contentsService.retrivalAll();
        model.addAttribute("contents", contents);
        return "contents/list";
    }


    @GetMapping("/list/{contentNum}")
    public String contentdetail(@PathVariable int contentNum,  Model model){
        Contents byContentNum = contentsService.findByContentNum(contentNum);
        List<Comments> comments = commentsService.retrivalByContent(contentNum);

        CommentForm commentForm = new CommentForm();
        model.addAttribute("content", byContentNum);
        model.addAttribute("comments", comments);
        model.addAttribute("commentForm", commentForm);

        return "contents/contentsDetail";
    }


    @GetMapping("/list/{contentNum}/edit")
    public String contentedit( @PathVariable int contentNum, Model model){
        Contents byContentNum = contentsService.findByContentNum(contentNum);
        model.addAttribute("content", byContentNum);
        return "contents/editContents";
    }

//    @PostMapping("/list/{contentNum}/edit")
//    public String addComments(@ModelAttribute("commentForm")CommentForm commentForm, @PathVariable int contentNum, Model model){
//        Contents byContentNum = contentsService.findByContentNum(contentNum);
//        model.addAttribute("content", byContentNum);
//        return "contents/editContents";
//    }


    @GetMapping("/list/add")
    public String addList(@ModelAttribute("contentsForm") ContentsForm contentsForm) {
        return "contents/addlist";
    }

    @PostMapping("/list/add")
    public String addListForm(@Validated @ModelAttribute("contentsForm") ContentsForm contentsForm
    , BindingResult bindingResult, HttpServletRequest request) {

        if (bindingResult.hasErrors()) {
            log.info("errors={}", bindingResult);
            return "contents/addlist";
        }

        // 세션 객체를 하나 만들고
        HttpSession session = request.getSession();
        // 세션 정보를 가져오고!
        Member loginId = (Member)session.getAttribute(SessionConst.LOGIN_MEMBER);

        Contents contents = new Contents();
        contents.setContents(contentsForm.getContents());
        contents.setId(loginId.getId());
        contents.setTitle(contentsForm.getTitle());
        contentsService.create(contents);
        return "redirect:/list";
    }

    // 회원 가입 쪽
    @GetMapping("/signup")
    public String sign(@ModelAttribute("member") MemberForm member){
        return "signup";
    }

    @PostMapping("/signup")
    public String save(@Valid @ModelAttribute("member") MemberForm memberForm,
                       BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "signup";
        }

        Member member = new Member();

        member.setId(memberForm.getId());
        member.setPass(memberForm.getPass());
        member.setName(memberForm.getName());
        member.setEmail(memberForm.getEmail());
        member.setPhone(memberForm.getPhone());
        member.setAge(memberForm.getAge());

        memberService.create(member);

        return "redirect:/";
    }

}
