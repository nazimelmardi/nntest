package com.nazim.nntest.infrastructure.adapter;

import com.nazim.nntest.infrastructure.adapter.mapper.OkResponseMapper;
import com.nazim.nntest.infrastructure.api.model.OkResponse;
import com.nazim.nntest.infrastructure.service.FileStorageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Service
@RequiredArgsConstructor
public class InputAdapter {

    private final OkResponseMapper okResponseMapper;
    private final FileStorageService fileStorageService;

    public OkResponse consumeUploadedFile(MultipartFile file){

        return okResponseMapper.toModel(fileStorageService.processFile(file));
    }

}
