package com.testTask.gitapp.domain.dto.mapper;

import com.testTask.gitapp.domain.dto.AbstractDto;
import com.testTask.gitapp.domain.entity.AbstractEntity;

public interface IMapper<E extends AbstractEntity, D extends AbstractDto> {
    E toEntity(D dto);
    D toDto(E entity);
}
