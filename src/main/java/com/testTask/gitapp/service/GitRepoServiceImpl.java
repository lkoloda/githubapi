package com.testTask.gitapp.service;

import com.testTask.gitapp.domain.entity.RepositoryEntity;
import com.testTask.gitapp.domain.entity.StarsEntity;
import com.testTask.gitapp.domain.entity.VersionEntity;
import com.testTask.gitapp.domain.response.app.ResponseDto;
import com.testTask.gitapp.domain.response.app.StardartResponse;
import com.testTask.gitapp.domain.response.git.RepositoryResponse;
import com.testTask.gitapp.domain.response.git.StarResponse;
import com.testTask.gitapp.repository.IGitRepoRepository;
import com.testTask.gitapp.repository.IGitVersionRepository;
import com.testTask.gitapp.service.feign.IGitHubClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

@Slf4j
@Service
public class GitRepoServiceImpl implements IGitRepoService
{
    @Autowired
    IGitHubClient gitFeignClient;

    @Autowired
    private IGitRepoRepository dbService;

    @Autowired
    private IGitVersionRepository dbVersionRepo;

    private Long packageVersion;

    @Autowired
    public GitRepoServiceImpl (IGitHubClient gitFeignClient,IGitRepoRepository dbService){
        this.gitFeignClient = gitFeignClient;
        this.dbService = dbService;
    }

    private void setSetupDB(Integer since){
        setPackageVersion();

        ResponseEntity<Set<RepositoryResponse>> repos = gitFeignClient.getRepos(since);

        if (repos.getStatusCode()== HttpStatus.OK){

            if (!repos.getBody().isEmpty()){

                Set<RepositoryEntity> repositoryEntities = new HashSet<RepositoryEntity>();

                for (RepositoryResponse repo : repos.getBody()) {
                    RepositoryEntity repositoryEntity = new RepositoryEntity();

                    repositoryEntity.setGitReposOwner(repo.getOwnerResponse().getLogin());
                    repositoryEntity.setGitRepoId(repo.getId());
                    repositoryEntity.setGitRepoName(repo.getName());
                    repositoryEntity.setGitRepoStarsUrl(repo.getStargazersUrl());
                    repositoryEntity.setVersion(packageVersion);

                    ResponseEntity<Set<StarResponse>> starBody = getStarred(getUrlPath(repo.getStargazersUrl()));
                    repositoryEntity.setLikes(starBody.getBody().size());

                    repositoryEntity.setStars(builderStarEntity(starBody.getBody(),repositoryEntity));
                    repositoryEntities.add(repositoryEntity);

                    //log.info(String.format("Insert [%d]",repositoryEntity.getId()));
                }
                dbService.saveAll(repositoryEntities);
                log.info(String.format("Package # %d inserted {%d} finished!",packageVersion,repositoryEntities.size()));
            }
        }
    }

    private ResponseEntity<Set<StarResponse>> getStarred(String url) {
        //log.info(String.format("[get-starred] call with parameter [%s]",url));
        return gitFeignClient.getStars(url);
    }

    private Set<StarsEntity> builderStarEntity(Set<StarResponse> source,RepositoryEntity parent){
        Set<StarsEntity> starsEntities=new HashSet<StarsEntity>();
        for (StarResponse response:source) {
            StarsEntity starsEntity = new StarsEntity();
            starsEntity.setLiker(response.getLogin());
            starsEntity.setStarred_url(response.getStarredUrl());
            starsEntity.setRepository(parent);
            starsEntities.add(starsEntity);
        }
        return starsEntities;
    }

    private void setPackageVersion(){

        Set<VersionEntity> versionEntities = dbVersionRepo.findTop1ByOrderByVersionDesc();

        if (versionEntities.isEmpty()) { packageVersion=0l;}
        else{
            packageVersion = versionEntities.iterator().next().getVersion();
        }
        packageVersion+=1;
        VersionEntity versionEntity=new VersionEntity();
        versionEntity.setVersion(packageVersion);
        dbVersionRepo.save(versionEntity);
        log.info(String.format("Package # [%d]",packageVersion));

//        Long est = (versionEntities.isEmpty() ? 0: versionEntities.parallelStream().max(Comparator.comparing(VersionEntity::getVersion)).get().getVersion());
    }

    private String getUrlPath(String source){
        try {
            if(!source.isEmpty()) {
                URL url = new URL(source);
                return url.getPath();
            }else{return "";}
        }catch(MalformedURLException e) {return "";}

    }

    private Set<ResponseDto> convertEntity(Set<RepositoryEntity> source){
        Set<ResponseDto> response = new HashSet<ResponseDto>();
        for (RepositoryEntity entity:source){
            response.add(new ResponseDto(entity.getGitRepoName(),entity.getLikes(),entity.getGitReposOwner(),packageVersion));
        }
        return response;
    }

    @Override
    public StardartResponse<Set<ResponseDto>> getResult() {
        this.setSetupDB(7);

        Set<RepositoryEntity> entities = dbService.findTop10ByVersionOrderByLikesDesc(packageVersion);
        Set<ResponseDto> responseDto = convertEntity(entities);
        StardartResponse<Set<ResponseDto>> response = new StardartResponse<Set<ResponseDto>>(null,"SUCCESS",null);
        response.setResponse(responseDto);
        log.info("Done");
        return response;
    }


}
