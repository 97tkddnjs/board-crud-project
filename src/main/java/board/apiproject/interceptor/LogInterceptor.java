package board.apiproject.interceptor;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * log를 통해 정보를 디버깅 하는 것은 중요함
 * soutv 같은 System 클래스 내의 함수가 아닌 log로 debug를 해야함
 * Interceptor는 filter와 다른 방식
 *
 */
@Slf4j // 로그를 위한 것~
public class LogInterceptor implements HandlerInterceptor {

    public static final String LOG_ID = "logId";

    //  디스패쳐핸들러 매핑 부분에서 사용
    //  간단하게 컨트롤러 호출 전에 호출됨
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        String uuid = UUID.randomUUID().toString();

        request.setAttribute(LOG_ID,uuid);

        //@RequestMapping : HandlerMethod
        // 정적 리소스 : ResourceHttpRequestHandler
        if (handler instanceof HandlerMethod) {
            HandlerMethod hm = (HandlerMethod) handler; // 호출할 컨트롤러 메서드의 모든 정보가 포함되어 있다.
        }

        log.info("REQUEST [{}] [{}] [{}]", uuid, requestURI, handler);
        return true; // true면 다음 로직 false면 로직 진행이 안됨
    }

    // post handler에서 반환된 다음에 사용되는 친구~
    // 컨트롤러 호출 후에 호출됨
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("postHandle [{}]", modelAndView);
    }

    // 뷰가 rendring 된 후 호출 그럼 뭐냐 html 보인 후에는 거의 계속 보일 예정~
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        String requestURI = request.getRequestURI();
        Object logId = (String)request.getAttribute(LOG_ID);

        log.info("RESPONSE [{}] [{}] [{}]", logId, requestURI, handler);
        if (ex != null) {
            log.error("afterCompletion error!", ex);
        }

    }
}
