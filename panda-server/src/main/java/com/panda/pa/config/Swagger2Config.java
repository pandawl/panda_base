package com.panda.pa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Auther: wl
 * @Date: 2020/2/20 18:10
 * @Description: Swagger2配置
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()// 选择那些路径和api会生成document
                .apis(RequestHandlerSelectors.basePackage("com.panda.pa.module.controller"))// 对com.panda.pa包进行监控
                .paths(PathSelectors.any())// 对所有路径进行监控
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("系统 API 文档")
                .contact(new Contact("panda ", "http://www.wangleihh.cn/#/", ""))
                .version("1.0")
                .description("系统接口文档")
                .build();
    }
}
