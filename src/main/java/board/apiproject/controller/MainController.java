package board.apiproject.controller;

import board.apiproject.SessionConst;
import board.apiproject.dto.Contents;
import board.apiproject.dto.Member;
import board.apiproject.dto.valid.ContentsForm;
import board.apiproject.dto.valid.MemberForm;
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
        model.addAttribute("content", byContentNum);
        return "contents/contentsDetail";
    }


    @GetMapping("/list/add")
    public String addList(@ModelAttribute("contentsForm") ContentsForm contentsForm) {
        return "contents/addlist";
    }

    @PostMapping("/list/add")
    public String addListForm(@Validated @ModelAttribute("contentsForm") ContentsForm contentsForm
    , BindingResult bindingResult, HttpServletRequest request) {

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
