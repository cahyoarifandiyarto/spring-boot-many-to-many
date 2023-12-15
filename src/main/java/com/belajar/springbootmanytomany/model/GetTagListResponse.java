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
public class GetTagListResponse {

    private Long id;

    private String name;

    private List<Tutorial> tutorials;

    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    @Builder
    public static class Tutorial {

        private Long id;

        private String title;

        private String description;

        private Boolean published;

    }

}
