package com.testTask.gitapp.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="repository_starred")
//@EqualsAndHashCode(name="id")//callSuper = false
@Setter
@Getter
//@AllArgsConstructor
//@NoArgsConstructor
public class StarsEntity //extends AbstractEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    @Column(name = "created", updatable = false)
    LocalDateTime created;
    @Column(name = "updated", insertable = false)
    LocalDateTime updated;
    @Column(name= "gitlogin")
    private String liker;
    @Column(name= "git_starred_url")
    private String starred_url;
    @ManyToOne()//,cascade = CascadeType.ALL,fetch = FetchType.LAZY
    @JoinColumn(name= "fk_repo_id",nullable = false)
    private RepositoryEntity repository;

    @PrePersist
    public void toCreate(){
        setCreated(LocalDateTime.now());
    }

    @PreUpdate
    public void toUpdtate(){
        setUpdated(LocalDateTime.now());
    }
//    @Override
//    public String toString() {
//        return String.format("StarResponse [id= %d, liker= '%s', star_url= '%s']",this.id,this.liker,this.starred_url);
//    }
}
