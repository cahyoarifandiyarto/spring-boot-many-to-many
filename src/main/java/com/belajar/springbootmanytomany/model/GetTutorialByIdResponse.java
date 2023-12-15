package com.belajar.springbootmanytomany.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class GetTutorialByIdResponse {

    private Long id;

    private String title;

    private String description;

    private Boolean published;

    private List<GetTutorialByIdResponse.Tag> tags;

    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    @Builder
    public static class Tag {

        private Long id;

        private String name;

    }

}
