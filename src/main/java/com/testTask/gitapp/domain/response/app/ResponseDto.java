package com.testTask.gitapp.domain.response.app;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto {
    private String repoName;
    private Integer amountOfStars;
    private String repoOwner;
    private Long packageVersion;
}
