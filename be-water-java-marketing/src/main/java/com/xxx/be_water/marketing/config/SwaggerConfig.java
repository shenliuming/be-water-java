package com.xxx.be_water.marketing.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Data:2024/3/21 20:00
 * @Author: shenliuming
 * Description:
 */
@Configuration
public class SwaggerConfig {
  @Bean
  public GroupedOpenApi userApi() {
    String[] paths = {"/**"};
    String[] packagedToMatch = {"com.xxxx.bewater.marketing"};
    return GroupedOpenApi.builder().group("营销")
        .pathsToMatch(paths)
        .packagesToScan(packagedToMatch).build();
  }

  @Bean
  public OpenAPI customOpenAPI() {
    Contact contact = new Contact();
    contact.setName("bewater");
    return new OpenAPI().info(new Info()
        .title("营销")
        .description("")
        .contact(contact)
        .version("1.0")
        .termsOfService("https://xxx.xxx.net")
        .license(new License().name("MIT")
            .url("https://xxx.xx.com")));
  }

}
