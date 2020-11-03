package com.nazim.nntest.infrastructure.controller;

import com.nazim.nntest.infrastructure.adapter.InputAdapter;
import com.nazim.nntest.infrastructure.api.NnApi;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class NnTestFileManageController implements NnApi {

    private final InputAdapter inputAdapter;
}
