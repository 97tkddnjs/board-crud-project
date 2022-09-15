package board.apiproject.controller;

import board.apiproject.dto.Member;
import board.apiproject.dto.valid.MemberForm;
import board.apiproject.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;


@Controller
@Slf4j
@RequiredArgsConstructor
public class MainController {
    private final MemberService memberService;
    @GetMapping("/")
    public String index(){
        return "index";
    }

    @PostMapping("/")
    public String login() {

        return "index";
    }

    @GetMapping("/list")
    public String list(){
        return "contents/list";
    }


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
