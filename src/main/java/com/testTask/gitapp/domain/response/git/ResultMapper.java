package com.testTask.gitapp.domain.response.git;

import com.testTask.gitapp.domain.dto.RepositoryDto;
import com.testTask.gitapp.domain.entity.RepositoryEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ResultMapper {
    @Autowired
    private ModelMapper mapper;

    //@Override
    public RepositoryEntity toEntity(RepositoryDto dto){
        return Objects.isNull(dto)? null:mapper.map(dto, RepositoryEntity.class);
    }

    //@Override
    public RepositoryDto toDto(RepositoryEntity entity){
        return Objects.isNull(entity)?null:mapper.map(entity,RepositoryDto.class);
    }
}
