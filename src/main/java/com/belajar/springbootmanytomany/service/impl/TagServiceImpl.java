package com.belajar.springbootmanytomany.service.impl;

import com.belajar.springbootmanytomany.entity.Tag;
import com.belajar.springbootmanytomany.model.CreateTagRequest;
import com.belajar.springbootmanytomany.model.GetTagListResponse;
import com.belajar.springbootmanytomany.repository.TagRepository;
import com.belajar.springbootmanytomany.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;

    @Override
    @Transactional
    public void create(CreateTagRequest request) {
        Tag tag = Tag.builder()
                .name(request.getName())
                .build();

        tagRepository.save(tag);
    }

    @Override
    public List<GetTagListResponse> getList() {
        return tagRepository.findAllJoinTutorial().stream()
                .map(tag -> GetTagListResponse.builder()
                        .id(tag.getId())
                        .name(tag.getName())
                        .tutorials(tag.getTutorials().stream()
                                .map(tutorial -> GetTagListResponse.Tutorial.builder()
                                        .id(tutorial.getId())
                                        .title(tutorial.getTitle())
                                        .description(tutorial.getDescription())
                                        .published(tutorial.getPublished())
                                        .build())
                                .toList())
                        .build())
                .toList();
    }

}
