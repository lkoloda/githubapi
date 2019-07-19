package com.testTask.gitapp.controller;

import com.testTask.gitapp.domain.response.app.ResponseDto;
import com.testTask.gitapp.domain.response.app.StardartResponse;
import com.testTask.gitapp.service.IGitRepoService;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@Slf4j
@RestController
public class GitController
{
    @Autowired
    private IGitRepoService gitRepoService;

    @Autowired
    public GitController (IGitRepoService gitRepoService)
    {
        this.gitRepoService = gitRepoService;
    }

    @GetMapping("/top10")
    public StardartResponse<Set<ResponseDto>> getRepos() {
        try {
            return gitRepoService.getResult();


        } catch (FeignException e) {
            log.info(e.toString());
            return new StardartResponse<Set<ResponseDto>>("FAIL","SERVER ISSUE",null);
        }
    }

    //public



}
