package java1234.agriculturalsystem.config;

import java1234.agriculturalsystem.interceptor.SysInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**web项目配置类*/

@Configuration
public class WebAppConfigurer implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowCredentials(true)
                .allowedMethods("GET", "HEAD", "POST", "PUT",
                        "DELETE","OPTIONS")
                .maxAge(3600);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //当访问/image/swiper/????时候，访问file:G:\graduation project\swiperImgs\
        registry.addResourceHandler("/image/swiper/**").addResourceLocations("file:G:\\graduation project\\swiperImgs\\");
        registry.addResourceHandler("/image/bigType/**").addResourceLocations("file:G:\\graduation project\\bigTypeImgs\\");
        registry.addResourceHandler("/image/product/**").addResourceLocations("file:G:\\graduation project\\productImgs\\");
        registry.addResourceHandler("/image/productSwiperImgs/**").addResourceLocations("file:G:\\graduation project\\productSwiperImgs\\");
        registry.addResourceHandler("/image/productIntroImgs/**").addResourceLocations("file:G:\\graduation project\\productIntroImgs\\");
        registry.addResourceHandler("/image/productParaImgs/**").addResourceLocations("file:G:\\graduation project\\productParaImgs\\");

    }

    @Bean
    public SysInterceptor sysInterceptor(){
        return new SysInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String[] patterns=new String[]{"/adminLogin","/product/**","/bigType/**","/user/wxlogin","/weixinpay/**"};
        registry.addInterceptor(sysInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns(patterns);
    }
}
