package com.testTask.gitapp.service;

import com.testTask.gitapp.domain.response.app.ResponseDto;
import com.testTask.gitapp.domain.response.app.StardartResponse;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public interface IGitRepoService {
    //abstract Set<RepositoryResponse> getRepos(Integer since);
    public StardartResponse<Set<ResponseDto>> getResult();
}
