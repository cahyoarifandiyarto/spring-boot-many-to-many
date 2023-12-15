package com.belajar.springbootmanytomany.service;

import com.belajar.springbootmanytomany.model.CreateTutorialRequest;
import com.belajar.springbootmanytomany.model.GetTutorialByIdResponse;
import com.belajar.springbootmanytomany.model.GetTutorialListResponse;

import java.util.List;

public interface TutorialService {

    void create(CreateTutorialRequest request);

    List<GetTutorialListResponse> getList();

    GetTutorialByIdResponse getById(Long id);

}
