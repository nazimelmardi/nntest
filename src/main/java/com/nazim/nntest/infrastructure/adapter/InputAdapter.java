package com.nazim.nntest.infrastructure.adapter;

import com.nazim.nntest.infrastructure.adapter.mapper.OkResponseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InputAdapter {

    private final OkResponseMapper okResponseMapper;

}
