package com.testTask.gitapp.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RepositoryDto extends AbstractDto {
    private Integer gitRepoId;
    private String gitRepoName;
    private String gitRepoStarsUrl;
    private String gitReposOwner;
    private Integer likes;
    private Set<StarsDto> starsRepoDto;

}
