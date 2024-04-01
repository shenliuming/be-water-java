package com.xxx.be_water.marketing.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @Data:2024/3/21 19:58
 * @Author: shenliuming
 * Description: 跨域配置
 */
@Configuration
public class CorsConfig {

  @Bean
  public CorsFilter corsFilter() {
    final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    final CorsConfiguration corsConfiguration = new CorsConfiguration();
    corsConfiguration.setAllowCredentials(true);
    corsConfiguration.addAllowedHeader("*");
    corsConfiguration.addAllowedOriginPattern("*");
    corsConfiguration.addAllowedMethod("*");
    source.registerCorsConfiguration("/**", corsConfiguration);
    return new CorsFilter(source);
  }
}