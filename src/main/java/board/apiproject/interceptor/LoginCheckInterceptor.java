package board.apiproject.interceptor;


import board.apiproject.SessionConst;
import board.apiproject.dto.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *  로그인을 위한 체크 인가되지 않은 사용자는 진입을 불가하게 해야 한다~~ 그게 편해...
 *
 */

@Slf4j
public class LoginCheckInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String requestURI = request.getRequestURI();

        log.info("인증 체크 인터셉터 실행 {}", requestURI);

        HttpSession session = request.getSession();

        Object attribute = session.getAttribute(SessionConst.LOGIN_MEMBER);
        if (session == null || attribute == null) {
            log.info("미인증 사용자 요청");
            //로그인으로 redirect;

            response.sendRedirect("/login?redirectURL=" + requestURI);
            return false;
        }
        Member attribute1 = (Member) attribute;
        log.info("login session 정보 입니다 1~ {}", session);
        log.info("login session 정보 입니다 2~ {}", attribute1.getId());
        return true;
    }
}
