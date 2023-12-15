package com.belajar.springbootmanytomany.controller;

import com.belajar.springbootmanytomany.model.CreateTagRequest;
import com.belajar.springbootmanytomany.model.GetTagListResponse;
import com.belajar.springbootmanytomany.model.Response;
import com.belajar.springbootmanytomany.service.TagService;
import com.belajar.springbootmanytomany.util.ResponseUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/tags")
@RequiredArgsConstructor
public class TagController {

    private final TagService tagService;

    @PostMapping
    public ResponseEntity<Response<Void>> create(@Valid @RequestBody CreateTagRequest request) {
        tagService.create(request);

        Response<Void> response = ResponseUtil.build(null, null, null, HttpStatus.CREATED);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Response<List<GetTagListResponse>>> getList() {
        List<GetTagListResponse> getTagListResponseList = tagService.getList();

        Response<List<GetTagListResponse>> response = ResponseUtil.build(getTagListResponseList, null, null, HttpStatus.OK);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
