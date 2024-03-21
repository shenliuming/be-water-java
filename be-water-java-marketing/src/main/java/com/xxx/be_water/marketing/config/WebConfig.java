package com.xxx.be_water.marketing.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.ResourceHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.support.AllEncompassingFormHttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;
import java.util.List;
import java.util.TimeZone;

/**
 * @Data:2024/3/21 20:02
 * @Author: shenliuming
 * Description:
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

//  @Resource
//  UcodeHandlerMethodArgumentResolver ucodeHandlerMethodArgumentResolver;

//  @Override
//  public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
//    argumentResolvers.add(ucodeHandlerMethodArgumentResolver);
//  }

  @Override
  public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
    converters.add(new ByteArrayHttpMessageConverter());
    converters.add(new StringHttpMessageConverter());
    converters.add(new ResourceHttpMessageConverter());
    converters.add(new AllEncompassingFormHttpMessageConverter());
    converters.add(new StringHttpMessageConverter());
    converters.add(jackson2HttpMessageConverter());
  }

  @Bean
  public MappingJackson2HttpMessageConverter jackson2HttpMessageConverter() {
    MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
    ObjectMapper mapper = new ObjectMapper();

    // 忽略未知属性
    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    // 统一日期格式转换，不建议开启
    //mapper.setDateFormat(new SimpleDateFormat(DateUtils.DATE_TIME_PATTERN));
    mapper.setTimeZone(TimeZone.getTimeZone("GMT+8"));

    converter.setObjectMapper(mapper);
    return converter;
  }

}
