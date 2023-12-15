package com.belajar.springbootmanytomany.service;

import com.belajar.springbootmanytomany.model.CreateTagRequest;
import com.belajar.springbootmanytomany.model.GetTagListResponse;

import java.util.List;

public interface TagService {

    void create(CreateTagRequest request);

    List<GetTagListResponse> getList();

}
