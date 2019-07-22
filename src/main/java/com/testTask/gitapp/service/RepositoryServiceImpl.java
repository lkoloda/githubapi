//package com.testTask.gitapp.service;
//
//import com.testTask.gitapp.domain.dto.RepositoryDto;
//import com.testTask.gitapp.domain.dto.mapper.RepositoryMapper;
//import com.testTask.gitapp.repository.IGitRepoRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class RepositoryServiceImpl implements IRepositoryService {
//    private final IGitRepoRepository repository;
//    private final RepositoryMapper mapper;
//
//    @Autowired
//    public RepositoryServiceImpl(IGitRepoRepository repository, RepositoryMapper mapper){
//        this.repository = repository;
//        this.mapper = mapper;
//    }
//
//    @Override
//    public RepositoryDto save(RepositoryDto dto){
//        return mapper.toDto(repository.save(mapper.toEntity(dto)));
//    }
//
//    @Override
//    public RepositoryDto get(Long id){
//        return mapper.toDto(repository.findById(id).get());
//    }
//}
