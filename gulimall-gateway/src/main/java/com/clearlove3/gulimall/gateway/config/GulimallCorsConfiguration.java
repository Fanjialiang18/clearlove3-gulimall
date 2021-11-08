package com.clearlove3.gulimall.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

/**
 * @author clearlove3
 * @date 2021/11/8 16:21
 */
@Configuration
public class GulimallCorsConfiguration {
    /**
     * 配置跨域请求过滤器
     */
    @Bean
    public CorsWebFilter corsWebFilter(){
        UrlBasedCorsConfigurationSource source=new UrlBasedCorsConfigurationSource();
        CorsConfiguration configuration=new CorsConfiguration();
        //1.配置跨域
        configuration.addAllowedHeader("*");
        configuration.addAllowedMethod("*");
//        configuration.addAllowedOrigin("*");
        configuration.addAllowedOriginPattern("*");
        configuration.setAllowCredentials(true);

        source.registerCorsConfiguration("/**",configuration);
        return new CorsWebFilter(source);
    }
}
