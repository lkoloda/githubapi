package com.testTask.gitapp.domain.result;

import java.util.Comparator;

public class ReposResultResponse implements Comparator<ReposResultResponse>
{
    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }

    public ReposResultResponse(String repoName, String starRepo, String ownerRepo, Integer star, Integer repoId) {
        this.repoName = repoName;
        this.starRepo = starRepo;
        this.ownerRepo = ownerRepo;
        this.star = star;
        this.repoId = repoId;
    }

    String repoName;
    String starRepo;
    Integer star;
    Integer repoId;

    public Integer getRepoId() {
        return repoId;
    }

    public void setRepoId(Integer repoId) {
        this.repoId = repoId;
    }

    public ReposResultResponse() {
    }

    public String getRepoName() {
        return repoName;
    }

    public void setRepoName(String repoName) {
        this.repoName = repoName;
    }

    public String getStarRepo() {
        return starRepo;
    }

    public void setStarRepo(String starRepo) {
        this.starRepo = starRepo;
    }

    public String getOwnerRepo() {
        return ownerRepo;
    }

    public void setOwnerRepo(String ownerRepo) {
        this.ownerRepo = ownerRepo;
    }

    String ownerRepo;

    public int compare(ReposResultResponse one, ReposResultResponse two) {
        return two.getStar() - one.getStar();
    }

}
