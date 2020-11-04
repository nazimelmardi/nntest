package com.nazim.nntest.infrastructure.service.parser.impl;

import com.nazim.nntest.domain.persistence.OutpayHeaderRepository;
import com.nazim.nntest.infrastructure.service.parser.FileInputParser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OutHeaderParser implements FileInputParser {

    private final OutpayHeaderRepository outpayHeaderRepository;

    @Override
    public String getType() {
        return "OUTHEADER";
    }

    @Override
    public Integer parseStringToInteger(String textFileContent) {
        return null;
    }
}
