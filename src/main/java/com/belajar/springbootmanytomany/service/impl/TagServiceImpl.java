package com.belajar.springbootmanytomany.service.impl;

import com.belajar.springbootmanytomany.entity.Tag;
import com.belajar.springbootmanytomany.model.CreateTagRequest;
import com.belajar.springbootmanytomany.repository.TagRepository;
import com.belajar.springbootmanytomany.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

}
