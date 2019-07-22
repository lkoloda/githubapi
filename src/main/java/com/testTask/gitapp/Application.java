package com.testTask.gitapp;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import java.util.Arrays;

@Slf4j
@SpringBootApplication
@EnableFeignClients//basePackages = {"com.testTask.gitapp.controller", "com.testTask.gitapp.service"}
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Application.class,args);

        Environment env = run.getEnvironment();
        log.info("\n----------------------------------------------------------\n\t" +
                "Application '{}' is running! Access URLs:\n\t" +
                "Local: \t\thttp://127.0.0.1:{}\n\t" +
                "Swagger: \thttp://127.0.0.1:{}/swagger-ui.html\n\t" +
                "External: \thttp://{}:{}\n\t" +
                "----------------------------------------------------------",
                env.getProperty("spring.application.name"),
                env.getProperty("server.port") + (env.getProperty("server.servlet.contextPath")== null? "":env.getProperty("server.servlet.contextPath")),
                env.getProperty("server.port")+ (env.getProperty("server.servlet.contextPath")== null? "":env.getProperty("server.servlet.contextPath")),
                env.getProperty("server.port")+ (env.getProperty("server.servlet.contextPath")== null? "":env.getProperty("server.servlet.contextPath"))
                );
        log.info("Running with Spring profile(s) : {}", Arrays.toString(env.getActiveProfiles()));

    }

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration()
        .setMatchingStrategy(MatchingStrategies.STRICT)
        .setFieldMatchingEnabled(true)
        .setSkipNullEnabled(true)
        .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
        return mapper;
    }
}
