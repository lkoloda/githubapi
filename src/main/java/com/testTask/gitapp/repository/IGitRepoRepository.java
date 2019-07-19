package com.testTask.gitapp.repository;

import com.testTask.gitapp.domain.entity.RepositoryEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Set;

public interface IGitRepoRepository extends CrudRepository<RepositoryEntity,Long> {
    Set<RepositoryEntity> findByGitRepoId(List<Long> gitRepoId);
    Set<RepositoryEntity> findByVersion(Integer version);
    Set<RepositoryEntity> findAllByOrderByLikesDesc();
    Set<RepositoryEntity> findTop10ByOrderByLikesDesc();
    Set<RepositoryEntity> findAllByVersionOrderByLikesDesc(Long version);
    Set<RepositoryEntity> findTop10ByVersionOrderByLikesDesc(Long version);
    //Set<RepositoryEntity> findTop10ByVersionOrderByLikes(Integer version);
    //Set<RepositoryEntity> findTop10ByVersionEqualsOrderByLikes(Long version);
    //Set<RepositoryEntity> queryDistinctByVersionThanOrderByVersion();
}
