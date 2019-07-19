package com.testTask.gitapp.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StarsDto extends AbstractDto {
    private String liker;
    private String starred_url;
    private Long repositoryDtoId;

}
