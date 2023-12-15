package com.belajar.springbootmanytomany.service.impl;

import com.belajar.springbootmanytomany.entity.Tag;
import com.belajar.springbootmanytomany.entity.Tutorial;
import com.belajar.springbootmanytomany.exception.ErrorException;
import com.belajar.springbootmanytomany.model.CreateTutorialRequest;
import com.belajar.springbootmanytomany.model.GetTutorialListResponse;
import com.belajar.springbootmanytomany.repository.TagRepository;
import com.belajar.springbootmanytomany.repository.TutorialRepository;
import com.belajar.springbootmanytomany.service.TutorialService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TutorialServiceImpl implements TutorialService {

    private final TagRepository tagRepository;

    private final TutorialRepository tutorialRepository;

    @Override
    @Transactional
    public void create(CreateTutorialRequest request) {
        Set<Tag> tags = new HashSet<>();

        for (CreateTutorialRequest.Tag tagRequest : request.getTags()) {
            Tag tag = tagRepository.findById(tagRequest.getId())
                    .orElseThrow(() -> new ErrorException(null, null, HttpStatus.NOT_FOUND));

            tags.add(tag);
        }

        Tutorial tutorial = Tutorial.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .published(request.getPublished())
                .tags(tags)
                .build();

        tutorialRepository.save(tutorial);
    }

    @Override
    public List<GetTutorialListResponse> getList() {
        return tutorialRepository.findAllJoinTag().stream()
                .map(tutorial -> GetTutorialListResponse.builder()
                        .id(tutorial.getId())
                        .title(tutorial.getTitle())
                        .description(tutorial.getDescription())
                        .published(tutorial.getPublished())
                        .tags(tutorial.getTags().stream()
                                .map(tag -> GetTutorialListResponse.Tag.builder()
                                        .id(tag.getId())
                                        .name(tag.getName())
                                        .build())
                                .toList())
                        .build())
                .toList();
    }

}
