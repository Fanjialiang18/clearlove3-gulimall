package com.clearlove3.gulimall.product.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author clearlove3
 * @date 2022/2/25 13:53
 */
@Configuration
@EnableTransactionManagement
@MapperScan("com.clearlove3.gulimall.product.dao")
public class MyBatisConfig {
    //引入分页插件
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        PaginationInterceptor paginationInterceptor=new PaginationInterceptor();
        //设置请求的页面大于最大页的操作，true返回首页，false继续请求，默认为false
        paginationInterceptor.setOverflow(true);
        //设置最大单页限制数量，默认500，-1表示不限制
        paginationInterceptor.setLimit(1000);
        return paginationInterceptor;
    }
}
