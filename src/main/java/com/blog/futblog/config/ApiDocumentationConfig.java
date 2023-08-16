package com.blog.futblog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class ApiDocumentationConfig {

    @Bean
    public OpenAPI apiDocConfig() {
        return new OpenAPI()
                .info(new Info()
                        .title("FutBlog")
                        .description("Proyecto de Blog De Futbol Lenguajes de Progrmacion ")
                        .version("0.5")
                        .contact(new Contact()
                                .name("Jeremy")
                                .email("jeremyfigueroa@unah.hn")))
                .externalDocs(new ExternalDocumentation()
                        .description("Documentation")
                        .url("https:/wiki...."));
    }

    @Bean
    public MvcConfig mvcConfig() {
        return new MvcConfig();
    }

}