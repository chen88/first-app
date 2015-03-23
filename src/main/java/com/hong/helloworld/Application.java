package com.hong.helloworld;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.hong.converter.DateMapperConfig;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;


@SpringBootApplication
@ComponentScan(basePackages = "com.hong")
public class Application {

  public static void main(String[] args) {
    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
    ctx.register(DateMapperConfig.class);
//    ctx.refresh();

    SpringApplication.run(Application.class, args);
  }

//  @Bean
//  @Autowired
//  MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter(ObjectMapper objectMapper) {
//    MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
//    objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
//    jsonConverter.setObjectMapper(objectMapper);
//    return jsonConverter;
//  }

}
