package kr.co.greenuniv.config;

import kr.co.greenuniv.interceptor.AppInfoInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@RequiredArgsConstructor
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    private final AppInfo appInfo;

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AppInfoInterceptor(appInfo));
    }
}
