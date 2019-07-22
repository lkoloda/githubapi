package com.testTask.gitapp.service.feign.configuration;

import com.testTask.gitapp.service.feign.inteceptor.GitHubAuthInterceptor;
import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

public class GitHubConfiguration {

    @Autowired
    public GitHubConfiguration(){}

    @Bean
    public RequestInterceptor authenticationInterceptor()
    {
        return new GitHubAuthInterceptor();
    }

}
