package com.testTask.gitapp.service.feign.inteceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class GitHubAuthInterceptor implements RequestInterceptor {
    private static final String AUTH_ATTR="Authorization";
    private static final String AUTH_TYPE="Bearer";
    //private SecurityContextHolder securityContextHolder;

    @Autowired
    public GitHubAuthInterceptor()
    {

    }

    private void applyAuthorizationToken(RequestTemplate template, String token) {
        if (!template.headers().containsKey(AUTH_ATTR)) {
            template.header(AUTH_ATTR, String.format("%s %s",AUTH_TYPE,token));
        }
    }

    @Override
    public void apply(RequestTemplate template) {
        applyAuthorizationToken(template, "4f1f8599f3561869c8e6cb3a161a26cbd1e22e8f");
    }
}
