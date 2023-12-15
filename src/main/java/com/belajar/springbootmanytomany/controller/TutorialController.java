package com.belajar.springbootmanytomany.controller;

import com.belajar.springbootmanytomany.model.CreateTutorialRequest;
import com.belajar.springbootmanytomany.model.GetTutorialListResponse;
import com.belajar.springbootmanytomany.model.Response;
import com.belajar.springbootmanytomany.service.TutorialService;
import com.belajar.springbootmanytomany.util.ResponseUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/tutorials")
@RequiredArgsConstructor
public class TutorialController {

    private final TutorialService tutorialService;

    @PostMapping
    public ResponseEntity<Response<Void>> create(@Valid @RequestBody CreateTutorialRequest request) {
        tutorialService.create(request);

        Response<Void> response = ResponseUtil.build(null, null, null, HttpStatus.CREATED);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Response<List<GetTutorialListResponse>>> getList() {
        List<GetTutorialListResponse> getTutorialListResponseList = tutorialService.getList();

        Response<List<GetTutorialListResponse>> response = ResponseUtil.build(getTutorialListResponseList, null, null, HttpStatus.OK);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
