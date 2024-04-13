package com.be.water.framework.common.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Swagger配置
 *
 * @author shenliuming  ceekayshen@foxmail.com
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi userApi() {
        String[] paths = {"/**"};
        String[] packagedToMatch = {"com.be.water"};
        return GroupedOpenApi.builder().group("be-water")
                .pathsToMatch(paths)
                .packagesToScan(packagedToMatch).build();
    }

    @Bean
    public OpenAPI customOpenAPI() {
        Contact contact = new Contact();
        contact.setName("shenliuming ceekayshen@foxmail.com");

        return new OpenAPI().info(new Info()
                .title("be-water")
                .description("be-water")
                .contact(contact)
                .version("3.0")
                .termsOfService("https://be-water.net")
                .license(new License().name("MIT")
                        .url("https://be-water.net")));
    }

}