package com.belajar.springbootmanytomany.model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CreateTutorialRequest {

    @NotBlank
    private String title;

    @NotBlank
    private String description;

    @NotNull
    private Boolean published;

    @NotNull
    @NotEmpty
    private List<Tag> tags;

    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    @Builder
    public static class Tag {

        @NotNull
        @Positive
        @Min(1)
        private Long id;

    }

}
