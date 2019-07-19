package com.testTask.gitapp.domain.entity;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="repositories")
//@EqualsAndHashCode(callSuper = false)
@Setter
@Getter
//@AllArgsConstructor
//@NoArgsConstructor
public class RepositoryEntity //extends AbstractEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    @Column(name = "created", updatable = false)
    LocalDateTime created;
    @Column(name = "updated", insertable = false)
    LocalDateTime updated;
    @Column(name="git_repo_id")
    private Integer gitRepoId;
    @Column(name="git_repo_name")
    private String gitRepoName;
    @Column(name="git_repo_star_url")
    private String gitRepoStarsUrl;
    @Column(name="git_repo_owner")
    private String gitReposOwner;
    @Column(name="git_repo_star_count")
    private Integer likes;
    @Column(name="packege_version")
    private Long version;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "repository",cascade = CascadeType.ALL) //,cascade = CascadeType.ALL
    private Set<StarsEntity> stars;

    @PrePersist
    public void toCreate(){
        setCreated(LocalDateTime.now());
    }

    @PreUpdate
    public void toUpdtate(){
        setUpdated(LocalDateTime.now());
    }

//    public Integer getGitRepoId() {
//        return gitRepoId;
//    }
//
//    public String getGitRepoName() {
//        return gitRepoName;
//    }
//
//    public String getGitRepoStarsUrl() {
//        return gitRepoStarsUrl;
//    }
//
//    public String getGitReposOwner() {
//        return gitReposOwner;
//    }
//
//    public Integer getLikes() {
//        return likes;
//    }
//
//    public Set<StarsEntity> getStars() {
//        return stars;
//    }
//
//
//    public Long getVersion() {
//        return version;
//    }

//    public RepositoryEntity(Integer gitRepoId,
//                            String gitRepoName,
//                            String gitRepoStarsUrl,
//                            String gitReposOwner,
//                            Integer likes,
//                            Integer version
//                            ){
//        this.gitRepoId=gitRepoId;
//        this.gitRepoName=gitRepoName;
//        this.gitRepoStarsUrl=gitRepoStarsUrl;
//        this.gitReposOwner=gitReposOwner;
//        this.likes=likes;
//        this.version=version;
//    }

//    @Override
//    public String toString()
//    {
//        return String.format("GitRepo[id= %d " +
//                                   ", gitRepoId= %d " +
//                                   ", gitRepoName= '%s'" +
//                                   ", gitRepoStarsUrl= '%s'" +
//                                   ", gitReposOwner= '%s'" +
//                                   ", gitLikes= %d " +
//                                   ", version= %d]",this.id
//                                                           ,this.gitRepoId
//                                                           ,this.gitRepoName
//                                                           ,this.gitRepoStarsUrl
//                                                           ,this.gitReposOwner
//                                                           ,this.likes
//                                                           ,this.version);
//    }
}
