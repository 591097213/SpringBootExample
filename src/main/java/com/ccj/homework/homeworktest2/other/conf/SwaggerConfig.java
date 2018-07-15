package com.ccj.homework.homeworktest2.other.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger相关配置
 */
@Configuration
@EnableSwagger2 // 启动Swagger
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {// 类名可以是任意，返回一个Docket就行
        return new Docket(DocumentationType.SWAGGER_2)//
                .apiInfo(apiInfo())//
                .select()//
                .apis(RequestHandlerSelectors.any())// 映射所有接口
                .paths(PathSelectors.any())//
                .build();//
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()//
                .title("登录系统")// 标题
                .description("demo")// 描述
                .contact("ccj")// 作者
                .version("1.0")// 版本
                .build();//
    }
}
