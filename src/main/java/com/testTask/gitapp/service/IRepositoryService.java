package com.testTask.gitapp.service;

import com.testTask.gitapp.domain.dto.RepositoryDto;
import org.springframework.stereotype.Component;

//@Component
public interface IRepositoryService {
    RepositoryDto save(RepositoryDto dto);
    RepositoryDto get(Long id);
}
