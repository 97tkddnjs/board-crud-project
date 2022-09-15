package board.apiproject.controller;

import board.apiproject.SessionConst;
import board.apiproject.dto.Member;
import board.apiproject.dto.valid.LoginForm;
import board.apiproject.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Slf4j
@RequiredArgsConstructor
@Controller
public class LoginController {

    private final MemberService memberService;
    @GetMapping("/login")
    public String loginForm(@ModelAttribute("loginForm") LoginForm loginForm) {
        return "login/loginForm";
    }
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute LoginForm form, BindingResult bindingResult,
                          @RequestParam(defaultValue = "/") String redirectURL,
                          HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            return "login/loginForm";
        }
        Member login = memberService.login(form.getId(), form.getPass());

        if (login == null) {
            // 특정한 오류가 아니므로
            bindingResult.reject("loginFail", " 아이디 또는 비밀번호가 맞지 않아요");
            return "login/loginForm";
        }
        // 로그인 성공처리 로직 HttpSession을 통해서 세션 관리를 해주도록 한다!!!!
        HttpSession session = request.getSession(true);// 세션을 고유한 uuid 같은 것을 하나 만들어주고
        session.setAttribute(SessionConst.LOGIN_MEMBER, login);

        return "redirect:"+redirectURL;
    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/";

    }
}
