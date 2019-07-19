package com.testTask.gitapp.repository;

import com.testTask.gitapp.domain.entity.RepositoryEntity;
import com.testTask.gitapp.domain.entity.VersionEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Set;

public interface IGitVersionRepository extends CrudRepository<VersionEntity,Long> {
    Set<VersionEntity> findAllById(Long id);
    Set<VersionEntity> findAll();
    Set<VersionEntity> findAllByOrderByVersionDesc();
    Set<VersionEntity> findTop1ByOrderByVersionDesc();
}
