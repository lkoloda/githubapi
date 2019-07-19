package com.testTask.gitapp.service.feign;

import com.testTask.gitapp.domain.response.git.RepositoryResponse;
import com.testTask.gitapp.domain.response.git.StarResponse;
import com.testTask.gitapp.service.feign.configuration.GitHubConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Set;


@FeignClient(url="https://api.github.com", name = "git-hub",configuration = GitHubConfiguration.class)
public interface IGitHubClient
{
    //@Headers("Authorization: Bearer 4f1f8599f3561869c8e6cb3a161a26cbd1e22e8f")
    @RequestMapping(value = "/repositories?since={sinceInt}", method = RequestMethod.GET, produces="application/json")
    ResponseEntity<Set<RepositoryResponse>> getRepos(@PathVariable("sinceInt") int sinceInt);

//    @RequestMapping(value = "/repositories?since={sinceInt}", method = RequestMethod.GET, produces="application/json")
//    String getRateLimit(@RequestParam("X-RateLimit-Limit") String rateLimit);

    //@Headers("Authorization: Bearer 4f1f8599f3561869c8e6cb3a161a26cbd1e22e8f")
    @RequestMapping(value = "{starUrl}", method = RequestMethod.GET)
    ResponseEntity<Set<StarResponse>> getStars(@PathVariable("starUrl") String starUrl);

}
