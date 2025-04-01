package kr.co.greenuniv.Interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.co.greenuniv.config.AppInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


@RequiredArgsConstructor
public class AppInfoInterceptor implements HandlerInterceptor {

    private final AppInfo appInfo;

    /*
        Interceptor
         - 클라이언트의 요청과 컨트롤러 사이에서 특정 작업을 수행하기 위한 컴포넌트
         - HTTP 요청을 가로채서 요청을 컨트롤러 수행 전과 수행 후에 특정 작업을 수행
         - 모든 컨트롤러에서 공통의 작업을 처리하는 사용

     */


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 컨트롤러 수행 전 실행
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // 컨트롤러 수행 후 실행
        if(modelAndView != null){
            // 모든 컨트롤러 요청 후 appInfo 모델 참조
            modelAndView.addObject(appInfo);
        }
    }
}
