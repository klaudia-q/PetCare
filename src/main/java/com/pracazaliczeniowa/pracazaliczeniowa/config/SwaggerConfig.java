package com.pracazaliczeniowa.pracazaliczeniowa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.pracazaliczeniowa.pracazaliczeniowa.controllers"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Pet Hotel API",
                "API do zarządzania rezerwacjami hotelu dla zwierząt.",
                "1.0",
                "Terms of service",
                new Contact("Zespół Hotelu", "www.pethotel.com", "contact@pethotel.com"),
                "Licencja API", "API license URL", Collections.emptyList());
    }
}
