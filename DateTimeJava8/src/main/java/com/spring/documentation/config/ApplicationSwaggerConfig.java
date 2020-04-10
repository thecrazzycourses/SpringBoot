package com.spring.documentation.config;

import org.springframework.context.annotation.*;
import springfox.bean.validators.configuration.*;
import springfox.documentation.builders.*;
import springfox.documentation.service.*;
import springfox.documentation.spi.*;
import springfox.documentation.spring.data.rest.configuration.*;
import springfox.documentation.spring.web.plugins.*;
import springfox.documentation.swagger2.annotations.*;

@Configuration
@EnableSwagger2WebMvc
@Import({SpringDataRestConfiguration.class, BeanValidatorPluginsConfiguration.class})
public class ApplicationSwaggerConfig {

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(getApiInfo());
    }

    private ApiInfo getApiInfo() {
        return new ApiInfoBuilder()
                .title("Rest Api")
                .version("1.0")
                .description("Api for managing Project")
                .contact(new Contact("Rahul Choudhary", "http://thecrazzyrahul.com", "thecrazzyrahul@gmail.com"))
                .license("Apache Licence Version 2.0")
                .build();
    }


}
