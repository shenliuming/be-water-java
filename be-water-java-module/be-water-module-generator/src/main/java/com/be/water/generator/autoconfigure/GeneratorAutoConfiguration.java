package com.be.water.generator.autoconfigure;

import lombok.AllArgsConstructor;
import com.be.water.generator.config.template.GeneratorConfig;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * spring boot starter AutoConfiguration
 *
 */
@Configuration
@AllArgsConstructor
@ComponentScan(basePackages = {"com.be.water.generator"})
@EnableConfigurationProperties(GeneratorProperties.class)
public class GeneratorAutoConfiguration {
    private final GeneratorProperties properties;

    @Bean
    GeneratorConfig generatorConfig() {
        return new GeneratorConfig(properties.getTemplate());
    }

}