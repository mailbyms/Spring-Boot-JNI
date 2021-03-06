package com.gyjian.algorithm.config;

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
 * @program:swagger2-demo
 * @description:swagger配置类
 */

@Configuration
@EnableSwagger2
public class Swagger2Config {
    @Bean
    public Docket baseRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("admin")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.gyjian.algorithm"))
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("API接口文档")
                .description("API接口文档Swagger版")
                .termsOfServiceUrl("http://www.gyjian.com/")
                .contact(new Contact("","#", ""))
                .version("1.0")
                .build();
    }
}