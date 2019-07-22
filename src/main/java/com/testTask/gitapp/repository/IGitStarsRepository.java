package com.testTask.gitapp.repository;

import com.testTask.gitapp.domain.entity.StarsEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Set;

public interface IGitStarsRepository extends CrudRepository<StarsEntity,Long> {
    Set<StarsEntity> findStarById(List<Long> ids);
}
